package com.mjroundi.poc.ui.main

import com.mjroundi.poc.base.BaseContract

/**
 * Created by mjroundi on 14/01/2019.
 *
 */
class MainContract {

    interface View: BaseContract.View {
        fun showLeagueFragment()
    }

    interface Presenter: BaseContract.Presenter<View> {

    }
}