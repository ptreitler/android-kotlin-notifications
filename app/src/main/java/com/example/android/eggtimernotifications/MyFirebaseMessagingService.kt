package com.example.android.eggtimernotifications

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService

private val TAG = MyFirebaseMessagingService::class.java.simpleName

class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        Log.d(TAG, "Refreshed token: $token")
        sendRegistrationToServer(token)
    }

    private fun sendRegistrationToServer(@Suppress("UNUSED_PARAMETER") token: String) {
        // TODO
    }
}
