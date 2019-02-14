package com.mjroundi.poc.base

import android.app.Application
import com.mjroundi.poc.di.component.ApplicationComponent
import com.mjroundi.poc.di.component.DaggerApplicationComponent
import com.mjroundi.poc.di.module.ApplicationModule



/**
 * Created by mjroundi on 14/01/2019.
 *
 */
class BaseApp: Application() {

    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        setup()
    }

    private fun setup() {
        component = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this)).build()
        component.inject(this)
    }

}