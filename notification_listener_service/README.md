# Notification Listener Service Example

This directory contains an example Flutter plugin that exposes Android
`NotificationListenerService` events to Dart using an `EventChannel`.

## Usage

1. Add the plugin to your Flutter project (see `pubspec.yaml`).
2. Register the service in your Android `AndroidManifest.xml` as shown
   in `android/src/main/AndroidManifest.xml`.
3. Listen to notification events in Dart:

```dart
import 'package:notification_listener_service/notification_listener_service.dart';

void main() {
  NotificationListenerService.notifications.listen((event) {
    print('Notification: $event');
  });
}
```

This plugin uses a platform channel to send notification data from the Android
service to the Flutter side whenever a notification is posted.
