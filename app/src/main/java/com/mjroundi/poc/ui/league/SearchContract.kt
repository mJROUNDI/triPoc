package com.mjroundi.poc.ui.league

import com.mjroundi.poc.base.BaseContract

/**
 * Created by mjroundi on 14/01/2019.
 *
 */
class SearchContract {

    interface View: BaseContract.View {
        fun launchSearchResult(departure :String, arrival :String)
    }

    interface Presenter: BaseContract.Presenter<View> {
        fun doSearch(departure :String, arrival :String)
    }
}