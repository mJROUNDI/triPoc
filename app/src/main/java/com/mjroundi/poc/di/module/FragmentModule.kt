package com.mjroundi.poc.di.module

import android.content.Context
import com.mjroundi.poc.api.ApiServiceInterface
import com.mjroundi.poc.base.BaseApp
import com.mjroundi.poc.ui.league.SearchContract
import com.mjroundi.poc.ui.league.LeaguePresenter
import com.mjroundi.poc.ui.team.SearchResult
import com.mjroundi.poc.ui.team.SearchResultPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by mjroundi on 14/01/2019.
 *
 */
@Module
class FragmentModule (private val context: Context){

    @Provides
    fun provideLeaguePresenter(): SearchContract.Presenter {
        return LeaguePresenter()
    }

    @Provides
    fun provideTeamPresenter( api: ApiServiceInterface, context : Context): SearchResult.Presenter {
        return SearchResultPresenter(api,context)
    }

    @Provides
    fun provideApiService(): ApiServiceInterface {
        return ApiServiceInterface.create()
    }

    @Provides
    fun context(): Context {
        return context
    }
}