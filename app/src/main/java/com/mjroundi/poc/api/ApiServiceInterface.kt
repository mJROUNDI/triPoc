package com.mjroundi.poc.api

import com.mjroundi.poc.models.Trips
import com.mjroundi.poc.models.TokenRequest
import com.mjroundi.poc.models.TokenResponse
import com.mjroundi.poc.util.Constants
import retrofit2.Call
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

/**
 * Created by mjroundi on 14/01/2019.
 *
 */
interface ApiServiceInterface {

    @POST("token")
    fun getToken(@Body body : TokenRequest): Call<TokenResponse>

    @GET("api/v2/trips")
    fun getTrips(@Query("_format") format: String,
                 @Query("locale") locale: String,
                 @Query("cur") currency: String,
                 @Query("fn") departure: String,
                 @Query("tn") arrival: String,
                 @Header("Authorization") token : String): Call<Trips>

    companion object Factory {
        fun create(): ApiServiceInterface {
            val retrofit = retrofit2.Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(Constants.BASE_URL)
                    .build()

            return retrofit.create(ApiServiceInterface::class.java)
        }
    }
}