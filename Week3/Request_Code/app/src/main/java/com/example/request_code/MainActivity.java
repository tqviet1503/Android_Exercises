package com.example.request_code;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextInput;
    private Button buttonSubmit;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextInput = findViewById(R.id.editTextInput);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        textViewResult = findViewById(R.id.textViewResult);

        buttonSubmit.setOnClickListener(v -> {
            String inputText = editTextInput.getText().toString();
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("inputText", inputText);
            startActivityForResult(intent, 1);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            String correctedText = data.getStringExtra("correctedText");
            textViewResult.setText(correctedText);
        }
    }
}
