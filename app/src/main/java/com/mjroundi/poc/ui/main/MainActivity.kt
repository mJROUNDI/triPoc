package com.mjroundi.poc.ui.main

import android.os.Bundle
import com.mjroundi.poc.R
import com.mjroundi.poc.base.BaseActivity
import com.mjroundi.poc.ui.league.SearchFragment
import com.mjroundi.poc.ui.team.SearchResultFragment
import com.mjroundi.poc.di.component.DaggerActivityComponent
import com.mjroundi.poc.di.module.ActivityModule
import javax.inject.Inject

@Suppress("UNUSED_EXPRESSION")
/**
 * Created by mjroundi on 14/01/2019.
 *
 */
class MainActivity: BaseActivity(), MainContract.View {

    @Inject lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        injectDependency()
        presenter.attach(this)
    }


    override fun showLeagueFragment() {
        supportFragmentManager.beginTransaction()
                .disallowAddToBackStack()
                .replace(R.id.frame, SearchFragment.newInstance(), SearchFragment.TAG)
                .commit()
    }

    override fun onBackPressed() {
        val fragmentManager = supportFragmentManager
        val fragment = fragmentManager.findFragmentByTag(SearchResultFragment.TAG)

        if (fragment == null) {
            super.onBackPressed()
        } else {
            supportFragmentManager.popBackStack()
        }
    }

    private fun injectDependency() {
        val activityComponent = DaggerActivityComponent.builder()
                .activityModule(ActivityModule(this))
                .build()

        activityComponent.inject(this)
    }
}