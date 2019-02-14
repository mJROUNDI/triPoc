package com.mjroundi.poc.di.module

import android.app.Activity
import com.mjroundi.poc.ui.main.MainContract
import com.mjroundi.poc.ui.main.MainPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by mjroundi on 14/01/2019.
 *
 */
@Module
class ActivityModule(private var activity: Activity) {

    @Provides
    fun provideActivity(): Activity {
        return activity
    }

    @Provides
    fun providePresenter(): MainContract.Presenter {
        return MainPresenter()
    }

}