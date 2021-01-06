package com.example.airconditionui.views.options;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.airconditionui.R;
import com.example.airconditionui.models.ACOptions;
import com.example.airconditionui.models.OnOff;
import com.example.airconditionui.utils.ACOptionsUtil;

public class OptionTimerActivity extends AppCompatActivity {
    Button OKBtn, backBtn;
    TimePicker picker;
    int hour, minute;
    TextView setTimerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_timer);
        setTimerText = findViewById(R.id.setTimerText);
        picker=findViewById(R.id.timePicker);
        picker.setIs24HourView(true);
        OKBtn=findViewById(R.id.OKBtn);
        backBtn = findViewById(R.id.optBackButton);
        if(ACOptionsUtil.getInstance(this).getTimer().equals(OnOff.ON)){
            hour = ACOptionsUtil.getInstance(this).getTimerMin()/60;
            minute = ACOptionsUtil.getInstance(this).getTimerMin()%60;
            updateTimerText();
        }
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        OKBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hour = picker.getHour();
                minute = picker.getMinute();
                updateTimerText();
                int totalminutes = hour*60 + minute;
                setTimerMinutes(totalminutes);
            }
        });




    }

    private void updateTimerText(){
        if (hour+minute==0){
            setTimerText.setText("ΟΡΙΣΤΕ ΧΡΟΝΟΔΙΑΚΟΠΤΗ ΥΠΝΟΥ");
        }else if(hour==0){
            if(minute==1){
                setTimerText.setText("ΤΟ ΚΛΙΜΑΤΙΣΤΙΚΟ ΘΑ ΚΛΕΙΣΕΙ ΣΕ "+ minute +" ΛΕΠΤΟ");
            }else{
                setTimerText.setText("ΤΟ ΚΛΙΜΑΤΙΣΤΙΚΟ ΘΑ ΚΛΕΙΣΕΙ ΣΕ "+ minute +" ΛΕΠΤΑ");
            }
        }else if(hour==1){
            if(minute==0){
                setTimerText.setText("ΤΟ ΚΛΙΜΑΤΙΣΤΙΚΟ ΘΑ ΚΛΕΙΣΕΙ ΣΕ " + hour + " ΩΡΑ");
            }else if(minute==1){
                setTimerText.setText("ΤΟ ΚΛΙΜΑΤΙΣΤΙΚΟ ΘΑ ΚΛΕΙΣΕΙ ΣΕ " + hour + " ΩΡΑ ΚΑΙ " + minute + " ΛΕΠΤΟ");
            }else{
                setTimerText.setText("ΤΟ ΚΛΙΜΑΤΙΣΤΙΚΟ ΘΑ ΚΛΕΙΣΕΙ ΣΕ " + hour + " ΩΡΑ ΚΑΙ " + minute + " ΛΕΠΤΑ");
            }
        }else {
            if(minute==0){
                setTimerText.setText("ΤΟ ΚΛΙΜΑΤΙΣΤΙΚΟ ΘΑ ΚΛΕΙΣΕΙ ΣΕ " + hour + " ΩΡΕΣ");
            }else if(minute==1){
                setTimerText.setText("ΤΟ ΚΛΙΜΑΤΙΣΤΙΚΟ ΘΑ ΚΛΕΙΣΕΙ ΣΕ " + hour + " ΩΡΕΣ ΚΑΙ " + minute + " ΛΕΠΤΟ");
            }else{
                setTimerText.setText("ΤΟ ΚΛΙΜΑΤΙΣΤΙΚΟ ΘΑ ΚΛΕΙΣΕΙ ΣΕ " + hour + " ΩΡΕΣ ΚΑΙ " + minute + " ΛΕΠΤΑ");
            }
        }
    }

    private void setTimerMinutes(int totalminutes){
        ACOptionsUtil.getInstance(this).setTimerMin(totalminutes);
        if (totalminutes==0){
            ACOptionsUtil.getInstance(this).setTimer(OnOff.OFF);
        }else{
            ACOptionsUtil.getInstance(this).setTimer(OnOff.ON);
        }

        System.out.println(ACOptionsUtil.getInstance(this).getTimerMin());
        System.out.println(ACOptionsUtil.getInstance(this).getTimerMin());

        System.out.println(ACOptionsUtil.getInstance(this).getTimer());
        System.out.println(ACOptionsUtil.getInstance(this).getTimer());


    }
}
