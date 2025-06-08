package com.example.notification_listener_service

import android.content.Context
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.EventChannel

class NotificationListenerPlugin : FlutterPlugin, EventChannel.StreamHandler {
    companion object {
        var eventSink: EventChannel.EventSink? = null
        lateinit var context: Context
    }

    override fun onAttachedToEngine(binding: FlutterPlugin.FlutterPluginBinding) {
        val eventChannel = EventChannel(binding.binaryMessenger, "notification_listener_service/events")
        eventChannel.setStreamHandler(this)
        context = binding.applicationContext
    }

    override fun onDetachedFromEngine(binding: FlutterPlugin.FlutterPluginBinding) {
        eventSink = null
    }

    override fun onListen(arguments: Any?, events: EventChannel.EventSink?) {
        eventSink = events
    }

    override fun onCancel(arguments: Any?) {
        eventSink = null
    }
}
