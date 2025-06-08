package com.example.notification_listener_service

import android.os.Bundle
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification

class MyNotificationListenerService : NotificationListenerService() {
    override fun onNotificationPosted(sbn: StatusBarNotification) {
        val extras: Bundle = sbn.notification.extras
        val title = extras.getString("android.title") ?: ""
        val text = extras.getString("android.text") ?: ""
        val data = mapOf(
            "packageName" to sbn.packageName,
            "title" to title,
            "text" to text
        )
        NotificationListenerPlugin.eventSink?.success(data)
    }

    override fun onNotificationRemoved(sbn: StatusBarNotification) {
        // Optionally handle notification removal
    }
}
