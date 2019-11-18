package com.example.android.eggtimernotifications

import android.util.Log
import com.example.android.eggtimernotifications.util.getNotificationManager
import com.example.android.eggtimernotifications.util.sendNotification
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

private val TAG = MyFirebaseMessagingService::class.java.simpleName

class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        Log.d(TAG, "Refreshed token: $token")
        sendRegistrationToServer(token)
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        Log.d(TAG, "From: ${remoteMessage.from}")
        Log.d(TAG, "Message data payload: " + remoteMessage.data)

        remoteMessage.notification?.body?.let {
            Log.d(TAG, "Message notification body: $it")
            sendNotification(it)
        }
    }

    private fun sendNotification(messageBody: String) {
        getNotificationManager(applicationContext).sendNotification(messageBody, applicationContext)
    }

    private fun sendRegistrationToServer(@Suppress("UNUSED_PARAMETER") token: String) {
        // TODO
    }
}
