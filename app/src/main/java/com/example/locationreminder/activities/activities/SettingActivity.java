package com.example.locationreminder.activities.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import com.example.locationreminder.R;

public class SettingActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private CheckBox iCheckbox, iCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        iCheckbox = findViewById(R.id.iCheckbox);
        iCheck = findViewById(R.id.iCheck);

        sharedPreferences = getSharedPreferences("Location_based_alarm", MODE_PRIVATE);

        iCheckbox.setChecked(sharedPreferences.getBoolean("Vibration", false));
        iCheck.setChecked(sharedPreferences.getBoolean("Sound", false));

        iCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                sharedPreferences.edit().putBoolean("Vibration", isChecked).apply();
            }
        });

        iCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                sharedPreferences.edit().putBoolean("Sound", isChecked).apply();
            }
        });
    }

    public void goBack(View view) {
        super.onBackPressed();
    }

    public void openAlarmRangeDialog(View view) {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.layout_range);
        RadioButton iRadio = dialog.findViewById(R.id.iRadio);
        RadioButton iRadioOne = dialog.findViewById(R.id.iRadioOne);
        RadioButton iRadioTwo = dialog.findViewById(R.id.iRadioTwo);
        RadioButton iRadioThree = dialog.findViewById(R.id.iRadioThree);
        iRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                sharedPreferences.edit().putInt("radius", 200).apply();
            }
        });
        iRadioOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                sharedPreferences.edit().putInt("radius", 500).apply();
            }
        });
        iRadioTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                sharedPreferences.edit().putInt("radius", 1000).apply();
            }
        });
        iRadioThree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                sharedPreferences.edit().putInt("radius", 2000).apply();
            }
        });

        dialog.show();
    }
}
