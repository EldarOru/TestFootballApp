package com.example.testapp

import android.app.Application
import com.onesignal.OneSignal

class ApplicationClass : Application() {
    val ONESIGNAL_APP_ID = "39b9e140-dfa9-4dca-aa4a-160225e46210"
    override fun onCreate() {
        super.onCreate()
        // Logging set to help debug issues, remove before releasing your app.
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)

        // OneSignal Initialization
        OneSignal.initWithContext(this)
        OneSignal.setAppId(ONESIGNAL_APP_ID)
    }
}