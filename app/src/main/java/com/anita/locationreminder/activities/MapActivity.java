package com.anita.locationreminder.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.anita.locationreminder.R;

public class MapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

    }

    public void btnClick(View view) {
        startActivity(new Intent(MapActivity.this,DashboardActivity.class));
    }
}
