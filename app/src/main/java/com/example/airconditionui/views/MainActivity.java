package com.example.airconditionui.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.airconditionui.R;

/* This is the main activity of the AC UI application
 * from where we can increase/lower the temperature etc. */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
