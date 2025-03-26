package com.example.request_code;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    private EditText editTextCorrection;
    private Button buttonCorrect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editTextCorrection = findViewById(R.id.editTextCorrection);
        buttonCorrect = findViewById(R.id.buttonCorrect);

        String inputText = getIntent().getStringExtra("inputText");
        editTextCorrection.setText(inputText);

        buttonCorrect.setOnClickListener(v -> {
            String correctedText = editTextCorrection.getText().toString();
            SpannableString spannableString = new SpannableString(correctedText);

            String[] inputWords = inputText.split(" ");
            String[] correctedWords = correctedText.split(" ");

            for (int i = 0; i < Math.min(inputWords.length, correctedWords.length); i++) {
                if (!inputWords[i].equals(correctedWords[i])) {
                    int startIndex = correctedText.indexOf(correctedWords[i]);
                    if (startIndex >= 0) {
                        spannableString.setSpan(new ForegroundColorSpan(0xFFFF0000), startIndex, startIndex + correctedWords[i].length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    }
                }
            }

            Intent resultIntent = new Intent();
            resultIntent.putExtra("correctedText", spannableString.toString());
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}
