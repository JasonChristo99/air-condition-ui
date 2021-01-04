package com.example.airconditionui.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.airconditionui.R;
import com.example.airconditionui.views.options.OptionFanSpeedActivity;
import com.example.airconditionui.views.options.OptionSleepModeActivity;

import java.util.ArrayList;
import java.util.List;

/* This is the activity of the app in which more advanced options
 * are presented (like fan-speed etc.). Contains a recycler view */
public class OptionsActivity extends AppCompatActivity implements OptionsRecyclerViewAdapter.ItemClickListener {

    RecyclerView optionsRecyclerView;
    OptionsRecyclerViewAdapter optionsRecyclerViewAdapter;
    Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        List<String> options = new ArrayList<>();
        options.add("ΤΑΧΥΤΗΤΑ ΑΝΕΜΙΣΤΗΡΑ");
        options.add("ΧΡΟΝΟΔΙΑΚΟΠΤΗΣ");
        options.add("ΛΕΙΤΟΥΡΓΙΑ ΥΠΝΟΥ");
        options.add("ΕΞΟΙΚΟΝΟΜΗΣΗ ΕΝΕΡΓΕΙΑΣ");
        options.add("ΕΙΔΟΣ ΛΕΙΤΟΥΡΓΙΑΣ");
        options.add("ΤΟΥΡΜΠΟ");
        options.add("ΠΕΡΙΣΤΡΟΦΗ ΠΕΡΣΙΔΩΝ");

        optionsRecyclerViewAdapter = new OptionsRecyclerViewAdapter(this, options);
        optionsRecyclerView = findViewById(R.id.optionsRecView);
        backBtn = findViewById(R.id.optBackButton);

        optionsRecyclerView.setAdapter(optionsRecyclerViewAdapter);
        optionsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        optionsRecyclerViewAdapter.setClickListener(this);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    @Override
    public void onItemClick(View view, int position) {
        Intent intent = null;
        switch (position) {
            case 0:
                intent = new Intent(this, OptionFanSpeedActivity.class);
                break;
            case 1:
                // TODO remaining cases
            case 2:
                intent = new Intent(this, OptionSleepModeActivity.class);

        }
        if (intent != null)
            startActivity(intent);
    }
}
