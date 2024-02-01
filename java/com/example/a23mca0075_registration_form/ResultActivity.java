package com.example.a23mca0075_registration_form;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class ResultActivity extends AppCompatActivity {
    Intent intent;
    EditText ff, fl, fe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        intent = getIntent();
        ff = findViewById(R.id.ff);
        fl = findViewById(R.id.fl);
        fe = findViewById(R.id.fe);
        String fn = getIntent().getStringExtra("keyfn");
        String ln = getIntent().getStringExtra("keyln");
        String em = getIntent().getStringExtra("keyem");
        ff.setText(fn);
        fl.setText(ln);
        fe.setText(em);
    }
}