package com.mjroundi.poc.di.module

import android.app.Application
import com.mjroundi.poc.base.BaseApp
import com.mjroundi.poc.di.scope.PerApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by mjroundi on 14/01/2019.
 *
 */
@Module
class ApplicationModule(private val baseApp: BaseApp) {

    @Provides
    @Singleton
    @PerApplication
    fun provideApplication(): Application {
        return baseApp
    }
}