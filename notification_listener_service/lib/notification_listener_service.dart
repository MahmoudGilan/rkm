import 'dart:async';
import 'package:flutter/services.dart';

class NotificationListenerService {
  static const EventChannel _eventChannel =
      EventChannel('notification_listener_service/events');

  static Stream<Map<dynamic, dynamic>> get notifications =>
      _eventChannel.receiveBroadcastStream().map(
        (dynamic event) => Map<dynamic, dynamic>.from(event),
      );
}
