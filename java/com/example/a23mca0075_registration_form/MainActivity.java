package com.example.a23mca0075_registration_form;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText fname,lname,email,datetxt;
    Button datebtn,regbtn;
    RadioGroup radioGroup;
    RadioButton radioButton;
    CheckBox checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datebtn = findViewById(R.id.datebtn);
        datetxt = findViewById(R.id.datetxt);
        radioGroup = findViewById(R.id.radioGroup);
        regbtn = findViewById(R.id.regbtn);
        checkBox = findViewById(R.id.checkBox);
        fname = findViewById(R.id.firstName);
        lname = findViewById(R.id.lastName);
        email = findViewById(R.id.email);
        final Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        datebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dialog = new
                        DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                month = month+1;
                                String date= dayOfMonth+"/"+month+"/"+year;
                                datetxt.setText(date);
                            }
                        },year,month,day);
                dialog.show();
            }
        });
        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fn = fname.getText().toString();
                String ln = lname.getText().toString();
                String em = email.getText().toString();
                Intent intent = new
                        Intent(MainActivity.this,ResultActivity.class);
                intent.putExtra("keyfn",fn);
                intent.putExtra("keyln",ln);
                intent.putExtra("keyem",em);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"Successfully Registered ",Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void check(View view){
        int radioID =radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioID);
        Toast.makeText(getApplicationContext(),"Gender :- "+radioButton.getText(),Toast.LENGTH_SHORT).show();
    }
}
