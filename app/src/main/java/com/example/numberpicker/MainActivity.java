package com.example.numberpicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.widget.NumberPicker;

public class MainActivity extends AppCompatActivity implements NumberPicker.OnValueChangeListener{

    Vibrator vibrator;

    NumberPicker numberPicker0;
    NumberPicker numberPicker1;
    NumberPicker numberPicker2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberPicker0 = findViewById(R.id.hour);
        numberPicker1 = findViewById(R.id.numPicker1);
        numberPicker2 = findViewById(R.id.numPicker2);

        numberPicker0.setMaxValue(23);
        numberPicker0.setMinValue(0);

        numberPicker1.setMaxValue(5);
        numberPicker1.setMinValue(0);

        numberPicker2.setMaxValue(9);
        numberPicker2.setMinValue(0);

        numberPicker0.setOnValueChangedListener(this);
        numberPicker1.setOnValueChangedListener(this);
        numberPicker2.setOnValueChangedListener(this);

        vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);
    }

    @Override
    public void onValueChange(NumberPicker numberPicker, int i, int i1) {
        vibrator.vibrate(50);
        switch (numberPicker.getId()) {
            case R.id.hour:
                Log.d("test", "getValue:" + numberPicker.getValue());
//                break;
            case R.id.numPicker1:
                Log.d("test", "getValue:" + numberPicker.getValue());
                break;
            case R.id.numPicker2:
                if (i == 9 && i1 == 0) {
                    if (numberPicker1.getValue() == 5) {
                        numberPicker0.setValue(numberPicker0.getValue() + 1);
                        numberPicker1.setValue(0);
                    } else {
                        numberPicker1.setValue(numberPicker1.getValue() + 1);
                    }
                }

                if (i == 0 && i1 == 9) {
                    if(numberPicker0.getValue() != 0 && numberPicker1.getValue() == 0) {
                        numberPicker0.setValue(numberPicker0.getValue() - 1);
                        numberPicker1.setValue(5);
                    }
                    else if(numberPicker0.getValue() == 0 && numberPicker1.getValue() == 0){
                        numberPicker0.setValue(numberPicker0.getValue() - 1);
                        numberPicker1.setValue(numberPicker1.getValue() - 1);
                    }
                    else {
                        numberPicker1.setValue(numberPicker1.getValue() - 1);
                    }
                }
                break;
        }
    }
}