package com.mjroundi.poc.ui.team

import com.mjroundi.poc.base.BaseContract
import com.mjroundi.poc.models.Trip

/**
 * Created by mjroundi on 14/01/2019.
 *
 */
class SearchResult {

    interface View: BaseContract.View {
        fun loadDataSuccess(list: List<Trip>)
        fun showProgress(show: Boolean)
        fun showErrorMessage(error: String)
    }

    interface Presenter: BaseContract.Presenter<View> {
        fun loadData(departure : String, arrival : String)
    }
}