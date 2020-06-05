package com.samoylov.lab4;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

public class MyActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.my_activity);
        DialogFragment dFragment = new DatePickerFragment();
        dFragment.show(getSupportFragmentManager(), "datePicker");
    }
}
