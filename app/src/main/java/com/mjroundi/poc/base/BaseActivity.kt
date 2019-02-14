package com.mjroundi.poc.base

import android.support.v7.app.AppCompatActivity

/**
 * Created by mJroundi on 15/01/2019.
 *
 */
open class BaseActivity : AppCompatActivity(), BaseContract.View {
    override fun isUiReady(): Boolean {
        return uiReady
    }

    private var uiReady : Boolean = false

    override fun onPause() {
        super.onPause()
        uiReady = false
    }

    override fun onResume() {
        super.onResume()
        uiReady = true
    }
}