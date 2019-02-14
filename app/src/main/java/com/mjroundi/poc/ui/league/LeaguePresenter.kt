package com.mjroundi.poc.ui.league


/**
 * Created by mjroundi on 14/01/2019.
 *
 */
class LeaguePresenter : SearchContract.Presenter {

    //private val api: ApiServiceInterface = ApiServiceInterface.create()
    private lateinit var view: SearchContract.View

    override fun attach(view: SearchContract.View) {
        this.view = view
    }

    override fun doSearch(departure: String, arrival: String) {
        view.launchSearchResult(departure, arrival)
    }

}