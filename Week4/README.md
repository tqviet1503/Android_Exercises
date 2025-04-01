# Student Info Collection App

## 1. Application Structure
- **MainActivity:** Form to collect student information and functionality buttons.
- **SecondActivity:** Displays the collected information.
- **Permissions:** Requires permissions to use SMS, CALL, CAMERA.

## 2. UI Components in `activity_main.xml`
- **EditText**: Name, Student ID (MSSV), Class, Phone Number.
- **Spinner**: Select academic year.
- **CheckBox**: Select major.
- **EditText**: Enter personal development plan.
- **Button**:
  - Send SMS.
  - Make a call.
  - Take a photo.
  - Submit.

## 3. Logic Handling in `MainActivity.java`
- **Save student information** when `Submit` is pressed and pass it to `SecondActivity`.
- **Send SMS** using `SmsManager`.
- **Make a call** using `Intent.ACTION_CALL`.
- **Open Camera** to take a photo.

## 4. Required Permissions
The app requires the following permissions in `AndroidManifest.xml`:

```xml
<uses-permission android:name="android.permission.SEND_SMS"/>
<uses-permission android:name="android.permission.CALL_PHONE"/>
<uses-permission android:name="android.permission.CAMERA"/>

## 5. How to Use
- Fill in the student's information.

- Select the academic year and major.

- Enter the personal development plan.

- Use the function buttons to send an SMS, make a call, or take a photo.

- Press Submit to view the collected information in SecondActivity.

## 6. Technologies Used
- Android Studio

- Java

- Android SDK
