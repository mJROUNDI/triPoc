package com.mjroundi.poc.ui.main

/**
 * Created by mjroundi on 14/01/2019.
 *
 */
class MainPresenter: MainContract.Presenter {


    private lateinit var view: MainContract.View

    override fun attach(view: MainContract.View) {
        this.view = view
        view.showLeagueFragment()
    }


}