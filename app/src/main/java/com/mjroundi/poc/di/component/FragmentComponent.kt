package com.mjroundi.poc.di.component

import com.mjroundi.poc.ui.league.SearchFragment
import com.mjroundi.poc.ui.team.SearchResultFragment
import com.mjroundi.poc.di.module.FragmentModule
import dagger.Component

/**
 * Created by mjroundi on 14/01/2019.
 *
 */
@Component(modules = [(FragmentModule::class)])
interface FragmentComponent {

    fun inject(searchResultFragment: SearchResultFragment)

    fun inject(listFragment: SearchFragment)

}