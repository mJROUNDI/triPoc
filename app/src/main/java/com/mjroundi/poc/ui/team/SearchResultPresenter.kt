package com.mjroundi.poc.ui.team

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Handler
import android.os.Looper
import com.mjroundi.poc.api.ApiServiceInterface
import com.mjroundi.poc.models.*
import com.mjroundi.poc.util.*
import dagger.Module
import retrofit2.Response
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject


/**
 * Created by mjroundi on 14/01/2019.
 *
 */
@Module
class SearchResultPresenter
    @Inject constructor(private val api: ApiServiceInterface, private val context: Context)
    : SearchResult.Presenter {

    private lateinit var view: SearchResult.View


    private val local : String = context.getCurrentLocaleDisplayName()
    private val currency : String =  context.getCurrencyCode()

    override fun loadData(departure : String, arrival : String) {
        view.showProgress(true)
        openThread {getTrips(departure, arrival)}
    }

    private fun getTrips(departure : String, arrival : String) {
        if (validToken()){
            val token : String= context.getSharedPreferences("token_prefs", MODE_PRIVATE).getString(TOKEN, "")
            val tripsResponse : Response<Trips>  = api.getTrips(FORMAT, local , currency, departure, arrival, token).execute()
            when {
                tripsResponse.isSuccessful ->  displayTrips(tripsResponse.body())
                tripsResponse.code() == 401 -> refreshTokenThenCall(departure, arrival)
                else -> displayError("")
            }
        }else{
            refreshTokenThenCall(departure, arrival)
        }
    }

    private fun refreshTokenThenCall(departure : String, arrival : String) {
        val tokensResponse : Response<TokenResponse> = api.getToken(getRequestBody()).execute()
        if (tokensResponse.isSuccessful){
            val token :String? = saveToken(tokensResponse.body())
            val tripsResponse : Response<Trips>  = api.getTrips(FORMAT, local , currency, departure, arrival, token!!).execute()
            if(tripsResponse.isSuccessful) {
                displayTrips(tripsResponse.body())
            }else{
                displayError("")
            }
        }else{
            displayError("")
        }

    }

    private fun validToken(): Boolean {
        val preferences :SharedPreferences = context.getSharedPreferences("token_prefs", MODE_PRIVATE)
        val expirencyDate : Long = preferences.getLong(TOKEN_EXPIRENCY, 0)
        return expirencyDate != 0L && ! expired(expirencyDate)
    }

    private fun expired(expirencyDate: Long): Boolean {
        val date : Calendar = Calendar.getInstance()
        date.time.time = expirencyDate
        return date.after(Calendar.getInstance())
    }

    private fun saveToken(response: TokenResponse?) : String?{
        return if (response == null){
            null
        }else{
            val token : String = "Bearer " +response.access_token
            context.getSharedPreferences("token_prefs", MODE_PRIVATE).edit {
                setLong(TOKEN_EXPIRENCY to getDate(response.expires_in))
                setString(TOKEN to token)
            }
            token
        }
    }

    private fun getDate(expires_in: Int): Long {
        val calendar : Calendar = Calendar.getInstance()
        val expirencyInMinutes : Long  = expires_in.toLong()

        return calendar.time.time + TimeUnit.MINUTES.toMillis(expirencyInMinutes)
    }

    private fun getRequestBody(): TokenRequest {
        return TokenRequest("android-technical-tests",
                "Y1oAL3QdPfVhGOWj3UeDjo3q02Qwhvrj",
                "client_credentials",
                arrayListOf("SCOPE_TRIP_DRIVER","SCOPE_USER_MESSAGING","SCOPE_INTERNAL_CLIENT","DEFAULT"))
    }

    override fun attach(view: SearchResult.View) {
        this.view = view
        //injectDependency()
    }

    companion object {
        const val FORMAT: String = "json"
        const val TOKEN_EXPIRENCY = "TOKEN_EXPIRENCY"
        const val TOKEN = "TOKEN"
    }

    private fun openThread(controllerCall: () -> Unit) =
            Thread(Runnable {
                controllerCall()
            }).start()


    fun openUiThread(viewCall: () -> Unit) {
        Handler(Looper.getMainLooper()).post { viewCall() }
    }

    fun displayError(error: String) = openUiThread { view.showErrorMessage(error) }

    fun displayTrips(trips: Trips?) = openUiThread {
        when {
            trips == null -> view.showErrorMessage("")
            trips.trips.isEmpty() -> view.showErrorMessage("")
            else -> view.loadDataSuccess(trips.trips)
        }
    }
}
