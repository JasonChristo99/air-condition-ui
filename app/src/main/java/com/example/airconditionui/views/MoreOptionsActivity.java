package com.example.airconditionui.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.airconditionui.R;

/* This is the activity of the app in which more advanced options
 are presented (like fan-speed etc.). Contains a recycler view */
public class MoreOptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_options);
    }
}
