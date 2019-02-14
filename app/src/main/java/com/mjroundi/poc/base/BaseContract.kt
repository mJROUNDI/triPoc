package com.mjroundi.poc.base

/**
 * Created by mjroundi on 14/01/2019.
 *
 */
class BaseContract {

    interface Presenter<in T> {
        fun attach(view: T)
    }

    interface View {
        fun isUiReady() : Boolean
    }
}