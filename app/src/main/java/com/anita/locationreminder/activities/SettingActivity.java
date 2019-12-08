package com.anita.locationreminder.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;

import com.anita.locationreminder.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class SettingActivity extends AppCompatActivity{

    private SharedPreferences sharedPreferences;
    private CheckBox iCheckbox, iCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        iCheckbox = findViewById(R.id.iCheckbox);
        iCheck = findViewById(R.id.iCheck);

        sharedPreferences = getSharedPreferences("Locationreminder", MODE_PRIVATE);

        iCheckbox.setChecked(sharedPreferences.getBoolean("Vibration", false));
        iCheck.setChecked(sharedPreferences.getBoolean("Sound", false));

        //for vibration function
        iCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                sharedPreferences.edit().putBoolean("Vibration", isChecked).apply();
            }
        });

        //for sound function
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

    //for gps alarm range function
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
