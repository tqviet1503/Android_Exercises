package com.example.quadraticequationsolver;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText edtA, edtB, edtC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        edtC = findViewById(R.id.edtC);
        Button btnSolve = findViewById(R.id.btnSolve);

        btnSolve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInput()) {
                    double a = Double.parseDouble(edtA.getText().toString());
                    double b = Double.parseDouble(edtB.getText().toString());
                    double c = Double.parseDouble(edtC.getText().toString());

                    // Chuyển dữ liệu sang ResultActivity
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    intent.putExtra("a", a);
                    intent.putExtra("b", b);
                    intent.putExtra("c", c);
                    startActivity(intent);
                }
            }
        });
    }

    private boolean validateInput() {
        String strA = edtA.getText().toString().trim();
        String strB = edtB.getText().toString().trim();
        String strC = edtC.getText().toString().trim();

        if (strA.isEmpty() || strB.isEmpty() || strC.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ a, b, c", Toast.LENGTH_SHORT).show();
            return false;
        }

        try {
            double a = Double.parseDouble(strA);
            if (a == 0) {
                edtA.setError("a phải khác 0");
                return false;
            }
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Giá trị nhập không hợp lệ", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}

