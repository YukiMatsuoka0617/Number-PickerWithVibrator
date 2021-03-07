package com.example.numberpicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.widget.NumberPicker;

public class MainActivity extends AppCompatActivity implements NumberPicker.OnValueChangeListener{

    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NumberPicker numberPicker = findViewById(R.id.hour);
        NumberPicker numberPicker1 = findViewById(R.id.numPicker1);
        NumberPicker numberPicker2 = findViewById(R.id.numPicker2);

        numberPicker.setMaxValue(24);
        numberPicker.setMinValue(0);

        numberPicker1.setMaxValue(5);
        numberPicker1.setMinValue(0);

        numberPicker2.setMaxValue(9);
        numberPicker2.setMinValue(0);

        numberPicker.setOnValueChangedListener(this);
        numberPicker1.setOnValueChangedListener(this);
        numberPicker2.setOnValueChangedListener(this);

        vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);
    }

    @Override
    public void onValueChange(NumberPicker numberPicker, int i, int i1) {
        Log.d("test","NumberPicker" + numberPicker.getId());
        Log.d("test","i:" + i);
        Log.d("test","i1:" + i1);
        vibrator.vibrate(50);
    }
}