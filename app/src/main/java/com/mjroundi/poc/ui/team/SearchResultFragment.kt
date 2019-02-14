package com.mjroundi.poc.ui.team

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mjroundi.poc.R
import com.mjroundi.poc.base.BaseFragment
import com.mjroundi.poc.di.component.DaggerFragmentComponent
import com.mjroundi.poc.di.module.FragmentModule
import com.mjroundi.poc.models.Trip
import kotlinx.android.synthetic.main.team_fragment_layout.*
import javax.inject.Inject

@Suppress("UNUSED_EXPRESSION")
/**
 * Created by mjroundi on 14/01/2019.
 *
 */
class SearchResultFragment : BaseFragment(), SearchResult.View {

    @Inject lateinit var presenter: SearchResult.Presenter

    private lateinit var rootView: View

    private lateinit var departure: String

    private lateinit var arrival: String

    fun newInstance(departure: String, arrival : String): SearchResultFragment {
        val args = Bundle()
        args.putString(DEPARTURE_BUNDLE_KEY, departure)
        args.putString(ARRIVAL_BUNDLE_KEY, arrival)
        val teamFragment = SearchResultFragment()
        teamFragment.arguments = args
        return teamFragment
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        departure = arguments?.get(DEPARTURE_BUNDLE_KEY) as String
        arrival = arguments?.get(ARRIVAL_BUNDLE_KEY) as String
        injectDependency()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.team_fragment_layout, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attach(this)
        initView()
    }

    override fun showProgress(show: Boolean) {
        if (show) {
            progressBar.visibility = View.VISIBLE
        } else {
            progressBar.visibility = View.GONE
        }
    }

    override fun showErrorMessage(error: String) {
        Log.e("Error", error)
    }

    override fun loadDataSuccess(list: List<Trip>) {
        val adapter = TeamAdapter(this.activity!!, list)
        recyclerView!!.layoutManager = LinearLayoutManager(activity)
        recyclerView!!.adapter = adapter
    }

    private fun injectDependency() {
        val listComponent = DaggerFragmentComponent.builder()
                .fragmentModule(FragmentModule(activity!!.baseContext))
                .build()

        listComponent.inject(this)
    }

    private fun initView() {
        presenter.loadData(departure, arrival)
    }

    companion object {
        val TAG: String = "TeamFragment"
        const val DEPARTURE_BUNDLE_KEY = "DEPARTURE_BUNDLE_KEY"
        const val ARRIVAL_BUNDLE_KEY = "ARRIVAL_BUNDLE_KEY"
    }
}