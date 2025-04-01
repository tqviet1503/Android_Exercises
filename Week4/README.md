# Student Info Collection App

## Overview

This application allows students to input their personal and academic information, perform actions like sending SMS, making calls, and taking photos, and view the entered data in another activity.

## App Structure

### Permissions
The app requires the following permissions:

- **SMS**: To send SMS messages.
- **CALL**: To make phone calls.
- **CAMERA**: To take photos.

UI Components in activity_main.xml
EditText:

Full Name
Student ID (MSSV)
Class
Phone Number
Spinner:

Year of Study Selection
CheckBox:

Major Selection
EditText:

Personal Development Plan
Buttons:

Send SMS
Make Call
Take Photo
Submit
Logic Handling in MainActivity.java
Submit: Saves student information and navigates to SecondActivity.
Send SMS: Utilizes SmsManager to send SMS.
Make Call: Uses Intent.ACTION_CALL.
Take Photo: Opens the camera for photo capture.
How to Use
Enter Student Information: Fill in all the required fields.
Select Year and Major: Use the spinner and checkbox to choose your year of study and major.
Enter Personal Development Plan: Describe your personal development goals.
Use Function Buttons:
Send SMS: Send an SMS to the entered phone number.
Make Call: Initiate a phone call.
Take Photo: Capture a photo with the device's camera.
Submit: After filling in all details, press submit to view the entered information in SecondActivity.
Technologies Used
Android Studio: Development environment.
Java: Programming language.
Android SDK: For Android app development.
