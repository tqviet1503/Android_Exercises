package com.example.studentinformationcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView textViewInfo;
    private Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Initialize views
        textViewInfo = findViewById(R.id.textViewInfo);
        buttonBack = findViewById(R.id.buttonBack);

        // Retrieve the submitted information from MainActivity
        Intent intent = getIntent();
        String name = intent.getStringExtra("key_for_submitted_info");
        String mssv = intent.getStringExtra("key_for_mssv");
        String className = intent.getStringExtra("key_for_class");
        String phone = intent.getStringExtra("key_for_phone");
        String plan = intent.getStringExtra("key_for_plan");
        String year = intent.getStringExtra("key_for_year");
        String major = intent.getStringExtra("key_for_major");

        // Check if all information is present
        if (name != null && mssv != null && className != null && phone != null && plan != null && year != null && major != null) {
            // Construct the information string to display
            String info = "Họ tên SV: " + name + "\n" +
                    "MSSV: " + mssv + "\n" +
                    "Lớp: " + className + "\n" +
                    "Số điện thoại: " + phone + "\n" +
                    "Sinh viên " + year + "\n" +
                    "Chuyên ngành: " + major + "\n" +
                    "Kế hoạch: " + plan + "\n";

            textViewInfo.setText(info);
        } else {
            textViewInfo.setText("No information submitted.");
        }

        // Set OnClickListener for back button
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
