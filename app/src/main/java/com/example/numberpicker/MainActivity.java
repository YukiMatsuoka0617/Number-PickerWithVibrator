package com.example.numberpicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.widget.NumberPicker;

public class MainActivity extends AppCompatActivity implements NumberPicker.OnValueChangeListener{

    Vibrator vibrator;

    NumberPicker[] numberPickers = new NumberPicker[3];
    int[] numberPickerIds = {R.id.hour, R.id.numPicker1, R.id.numPicker2};
    int[] maxValues = {23, 5, 9};
    int minValue = 0;
    int vibrationTime = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        for (int i = 0; i < numberPickers.length; i++) {
            numberPickers[i] = findViewById(numberPickerIds[i]);
            numberPickers[i].setMaxValue(maxValues[i]);
            numberPickers[i].setMinValue(minValue);
            numberPickers[i].setOnValueChangedListener(this);
        }
    }

    @Override
    public void onValueChange(NumberPicker numberPicker, int i, int i1) {
        vibrator.vibrate(vibrationTime);
        switch (numberPicker.getId()) {
            case R.id.hour:
                break;
            case R.id.numPicker1:
                break;
            case R.id.numPicker2:
                if (i == maxValues[2] && i1 == minValue) {
                    if (numberPickers[1].getValue() == maxValues[1]) {
                        numberPickers[0].setValue(numberPickers[0].getValue() + 1);
                        numberPickers[1].setValue(minValue);
                    } else {
                        numberPickers[1].setValue(numberPickers[1].getValue() + 1);
                    }
                }

                if (i == minValue && i1 == maxValues[2]) {
                    if (numberPickers[0].getValue() != minValue &&
                            numberPickers[1].getValue() == minValue) {
                        numberPickers[0].setValue(numberPickers[0].getValue() - 1);
                        numberPickers[1].setValue(maxValues[1]);
                    } else if (numberPickers[0].getValue() == minValue &&
                            numberPickers[1].getValue() == minValue) {
                        numberPickers[0].setValue(numberPickers[0].getValue() - 1);
                        numberPickers[1].setValue(numberPickers[1].getValue() - 1);
                    } else {
                        numberPickers[1].setValue(numberPickers[1].getValue() - 1);
                    }
                }
                break;
        }
    }
}