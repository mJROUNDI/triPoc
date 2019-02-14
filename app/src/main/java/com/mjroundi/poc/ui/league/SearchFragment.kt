package com.mjroundi.poc.ui.league

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mjroundi.poc.R
import com.mjroundi.poc.base.BaseFragment
import com.mjroundi.poc.di.component.DaggerFragmentComponent
import com.mjroundi.poc.di.module.FragmentModule
import com.mjroundi.poc.ui.team.SearchResultFragment
import com.mjroundi.poc.util.isEmpty
import kotlinx.android.synthetic.main.search_fragment_layout.*
import javax.inject.Inject

/**
 * Created by mjroundi on 14/01/2019.
 *
 */
class SearchFragment : BaseFragment(), SearchContract.View{


    @Inject lateinit var presenter: SearchContract.Presenter

    private lateinit var rootView: View


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependency()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.search_fragment_layout, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.attach(this)
        search_button.setOnClickListener {
            if ( ! departure.isEmpty() && ! arrival.isEmpty()){
                presenter.doSearch(departure.text.toString(), arrival.text.toString())
            }
        }
    }

    override fun launchSearchResult(departure: String, arrival: String) {
        activity?.supportFragmentManager?.beginTransaction()?.addToBackStack(null)
                ?.replace(R.id.frame, SearchResultFragment().newInstance(departure, arrival) , SearchResultFragment.TAG)
                ?.commit()

    }


    private fun injectDependency() {
        val leagueComponent = DaggerFragmentComponent.builder()
                .fragmentModule(FragmentModule(activity!!.baseContext))
                .build()

        leagueComponent.inject(this)
    }

    companion object {
        val TAG: String = "LeagueFragment"
        fun newInstance(): SearchFragment{
            return SearchFragment()
        }
    }
}