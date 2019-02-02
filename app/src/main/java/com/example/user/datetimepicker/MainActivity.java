package com.example.user.datetimepicker;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnDate, btnTime;
    EditText txtDate, txtTime;
    int mYr, mMnth, mDay, mHr, mMin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDate = findViewById(R.id.btnDate);
        btnTime = findViewById(R.id.btnTime);
        txtDate = findViewById(R.id.txtDate);
        txtTime = findViewById(R.id.txtTime);

        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChooseTime(view);
            }
        });

        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChooseDate(view);
            }
        });

    }

    public void ChooseDate(View view) {
        //current date
        Calendar calendar = Calendar.getInstance();
        mYr = calendar.get(Calendar.YEAR);
        mMnth = calendar.get(Calendar.MONTH);
        mDay = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int Year, int Month, int Day) {
                txtDate.setText(Day + " - " + Month + " - " + Year);
            }
        }, mYr, mMnth, mDay);
        datePickerDialog.show();

    }

    public void ChooseTime(View view) {
        Calendar calendar = Calendar.getInstance();
        mHr = calendar.get(Calendar.HOUR_OF_DAY);
        mMin = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int Hour, int Min) {
                        txtTime.setText(Hour + ":" + Min);
                    }
                }, mHr, mMin, false);
        timePickerDialog.show();
    }

}


