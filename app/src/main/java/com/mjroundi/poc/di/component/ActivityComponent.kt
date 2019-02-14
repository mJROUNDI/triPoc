package com.mjroundi.poc.di.component

import com.mjroundi.poc.ui.main.MainActivity
import com.mjroundi.poc.di.module.ActivityModule
import dagger.Component

/**
 * Created by mjroundi on 14/01/2019.
 *
 */
@Component(modules = [(ActivityModule::class)])
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)

}