package com.mjroundi.poc.di.component

import com.mjroundi.poc.base.BaseApp
import com.mjroundi.poc.di.module.ApplicationModule
import dagger.Component

/**
 * Created by mjroundi on 14/01/2019.
 *
 */
@Component(modules = [(ApplicationModule::class)])
interface ApplicationComponent {

    fun inject(application: BaseApp)

}