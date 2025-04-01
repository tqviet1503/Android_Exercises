package com.example.studentinformationcollection;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private static final int REQUEST_PERMISSION = 100;

    private EditText editTextName, editTextMSSV, editTextClass, editTextPhone, editTextPlan;
    private RadioGroup radioGroupYear, radioGroupMajor;
    private Button buttonSendSMS, buttonCall, buttonCamera, buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        editTextName = findViewById(R.id.etName);
        editTextMSSV = findViewById(R.id.etMSSV);
        editTextClass = findViewById(R.id.etClass);
        editTextPhone = findViewById(R.id.etPhone);
        editTextPlan = findViewById(R.id.etPlan);
        radioGroupYear = findViewById(R.id.rgYear);
        radioGroupMajor = findViewById(R.id.rgMajor);
        buttonSendSMS = findViewById(R.id.btnSendSMS);
        buttonCall = findViewById(R.id.btnCall);
        buttonCamera = findViewById(R.id.btnCamera);
        buttonSubmit = findViewById(R.id.btnSubmit);

        // Set OnClickListener for submit button
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString().trim();
                String mssv = editTextMSSV.getText().toString().trim();
                String className = editTextClass.getText().toString().trim();
                String phone = editTextPhone.getText().toString().trim();
                String plan = editTextPlan.getText().toString().trim();

                int selectedYearId = radioGroupYear.getCheckedRadioButtonId();
                String year = getYearFromId(selectedYearId);

                int selectedMajorId = radioGroupMajor.getCheckedRadioButtonId();
                String major = getMajorFromId(selectedMajorId);

                if (!name.isEmpty() && !mssv.isEmpty() && !className.isEmpty() && !phone.isEmpty() && !plan.isEmpty() && !year.isEmpty() && !major.isEmpty()) {
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("key_for_submitted_info", name);
                    intent.putExtra("key_for_mssv", mssv);
                    intent.putExtra("key_for_class", className);
                    intent.putExtra("key_for_phone", phone);
                    intent.putExtra("key_for_plan", plan);
                    intent.putExtra("key_for_year", year);
                    intent.putExtra("key_for_major", major);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Call button
        buttonCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = editTextPhone.getText().toString().trim();
                if (!phone.isEmpty()) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập số điện thoại", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Send SMS button
        buttonSendSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = editTextPhone.getText().toString().trim();
                if (!phone.isEmpty()) {
                    Intent smsIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + phone));
                    startActivity(smsIntent);
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập số điện thoại", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Camera button
        buttonCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(new String[]{Manifest.permission.CAMERA}, REQUEST_PERMISSION);
                } else {
                    Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                        startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                    }
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }
            } else {
                Toast.makeText(this, "Không có quyền truy cập camera", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
        }
    }

    private String getYearFromId(int id) {
        if (id == R.id.rbYear1) {
            return "Năm 1";
        } else if (id == R.id.rbYear2) {
            return "Năm 2";
        } else if (id == R.id.rbYear3) {
            return "Năm 3";
        } else if (id == R.id.rbYear4) {
            return "Năm 4";
        } else {
            return "";
        }
    }

    private String getMajorFromId(int id) {
        if (id == R.id.rbMajorA) {
            return "Điện tử";
        } else if (id == R.id.rbMajorB) {
            return "Máy tính - Hệ thống nhúng";
        } else if (id == R.id.rbMajorC) {
            return "Viễn thông - Mạng";
        } else {
            return "";
        }
    }
}