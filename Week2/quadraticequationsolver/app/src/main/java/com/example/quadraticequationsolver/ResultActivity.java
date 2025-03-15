package com.example.quadraticequationsolver;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        txtResult = findViewById(R.id.txtResult);
        Button btnBack = findViewById(R.id.btnBack);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            double a = bundle.getDouble("a");
            double b = bundle.getDouble("b");
            double c = bundle.getDouble("c");

            String result = solveQuadraticEquation(a, b, c);
            txtResult.setText(result);
        }

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private String solveQuadraticEquation(double a, double b, double c) {
        if (a == 0) {
            return "Không phải phương trình bậc 2!";
        }

        double delta = b * b - 4 * a * c;

        if (delta < 0) {
            return "Phương trình vô nghiệm";
        } else if (delta == 0) {
            double x = -b / (2 * a);
            return "Phương trình có nghiệm kép: x = " + x;
        } else {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            return "Phương trình có hai nghiệm:\n x1 = " + x1 + "\n x2 = " + x2;
        }
    }
}
