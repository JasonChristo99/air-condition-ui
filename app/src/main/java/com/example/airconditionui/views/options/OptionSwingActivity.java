package com.example.airconditionui.views.options;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.airconditionui.R;

import com.example.airconditionui.models.OnOff;
import com.example.airconditionui.utils.ACOptionsUtil;

public class OptionSwingActivity extends AppCompatActivity {
    Button backBtn, btn1, btn2, btn3, btn4, btn5, autoBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_swing);
        backBtn = findViewById(R.id.optBackButton);
        btn1 = findViewById(R.id.Btn1);
        btn2 = findViewById(R.id.Btn2);
        btn3 = findViewById(R.id.Btn3);
        btn4 = findViewById(R.id.Btn4);
        btn5 = findViewById(R.id.Btn5);
        autoBtn = findViewById(R.id.autoBtn);
        updateButtons();
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn1Pressed();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn2Pressed();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn3Pressed();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn4Pressed();
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn5Pressed();
            }
        });
        autoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autoBtnPressed();
            }
        });


    }

    private void btn1Pressed() {
        ACOptionsUtil.getInstance(this).setSwingAuto(OnOff.OFF);
        ACOptionsUtil.getInstance(this).setSwingScale(1);
        updateButtons();
    }

    private void btn2Pressed() {
        ACOptionsUtil.getInstance(this).setSwingAuto(OnOff.OFF);
        ACOptionsUtil.getInstance(this).setSwingScale(2);
        updateButtons();
    }

    private void btn3Pressed() {
        ACOptionsUtil.getInstance(this).setSwingAuto(OnOff.OFF);
        ACOptionsUtil.getInstance(this).setSwingScale(3);
        updateButtons();
    }

    private void btn4Pressed() {
        ACOptionsUtil.getInstance(this).setSwingAuto(OnOff.OFF);
        ACOptionsUtil.getInstance(this).setSwingScale(4);
        updateButtons();
    }

    private void btn5Pressed() {
        ACOptionsUtil.getInstance(this).setSwingAuto(OnOff.OFF);
        ACOptionsUtil.getInstance(this).setSwingScale(5);
        updateButtons();
    }

    private void autoBtnPressed() {
        ACOptionsUtil.getInstance(this).setSwingAuto(OnOff.ON);
        ACOptionsUtil.getInstance(this).setSwingScale(0);
        updateButtons();
    }

    private void updateButtons() {
        if (ACOptionsUtil.getInstance(this).getSwingAuto() == OnOff.ON) {
            btn1.setBackgroundColor(0xFFFFFFFF);
            btn2.setBackgroundColor(0xFFFFFFFF);
            btn3.setBackgroundColor(0xFFFFFFFF);
            btn4.setBackgroundColor(0xFFFFFFFF);
            btn5.setBackgroundColor(0xFFFFFFFF);
            autoBtn.setBackgroundColor(0xFF03A9F4);

            btn1.setTextColor(0xFF000000);
            btn2.setTextColor(0xFF000000);
            btn3.setTextColor(0xFF000000);
            btn4.setTextColor(0xFF000000);
            btn5.setTextColor(0xFF000000);
            autoBtn.setTextColor(0xFFFFFFFF);
        } else if (ACOptionsUtil.getInstance(this).getSwingScale() == 1) {
            btn1.setBackgroundColor(0xFF03A9F4);
            btn2.setBackgroundColor(0xFFFFFFFF);
            btn3.setBackgroundColor(0xFFFFFFFF);
            btn4.setBackgroundColor(0xFFFFFFFF);
            btn5.setBackgroundColor(0xFFFFFFFF);
            autoBtn.setBackgroundColor(0xFFFFFFFF);

            btn1.setTextColor(0xFFFFFFFF);
            btn2.setTextColor(0xFF000000);
            btn3.setTextColor(0xFF000000);
            btn4.setTextColor(0xFF000000);
            btn5.setTextColor(0xFF000000);
            autoBtn.setTextColor(0xFF000000);
        } else if (ACOptionsUtil.getInstance(this).getSwingScale() == 2) {
            btn1.setBackgroundColor(0xFFFFFFFF);
            btn2.setBackgroundColor(0xFF03A9F4);
            btn3.setBackgroundColor(0xFFFFFFFF);
            btn4.setBackgroundColor(0xFFFFFFFF);
            btn5.setBackgroundColor(0xFFFFFFFF);
            autoBtn.setBackgroundColor(0xFFFFFFFF);

            btn1.setTextColor(0xFF000000);
            btn2.setTextColor(0xFFFFFFFF);
            btn3.setTextColor(0xFF000000);
            btn4.setTextColor(0xFF000000);
            btn5.setTextColor(0xFF000000);
            autoBtn.setTextColor(0xFF000000);
        } else if (ACOptionsUtil.getInstance(this).getSwingScale() == 3) {
            btn1.setBackgroundColor(0xFFFFFFFF);
            btn2.setBackgroundColor(0xFFFFFFFF);
            btn3.setBackgroundColor(0xFF03A9F4);
            btn4.setBackgroundColor(0xFFFFFFFF);
            btn5.setBackgroundColor(0xFFFFFFFF);
            autoBtn.setBackgroundColor(0xFFFFFFFF);

            btn1.setTextColor(0xFF000000);
            btn2.setTextColor(0xFF000000);
            btn3.setTextColor(0xFFFFFFFF);
            btn4.setTextColor(0xFF000000);
            btn5.setTextColor(0xFF000000);
            autoBtn.setTextColor(0xFF000000);
        } else if (ACOptionsUtil.getInstance(this).getSwingScale() == 4) {
            btn1.setBackgroundColor(0xFFFFFFFF);
            btn2.setBackgroundColor(0xFFFFFFFF);
            btn3.setBackgroundColor(0xFFFFFFFF);
            btn4.setBackgroundColor(0xFF03A9F4);
            btn5.setBackgroundColor(0xFFFFFFFF);
            autoBtn.setBackgroundColor(0xFFFFFFFF);

            btn1.setTextColor(0xFF000000);
            btn2.setTextColor(0xFF000000);
            btn3.setTextColor(0xFF000000);
            btn4.setTextColor(0xFFFFFFFF);
            btn5.setTextColor(0xFF000000);
            autoBtn.setTextColor(0xFF000000);
        } else if (ACOptionsUtil.getInstance(this).getSwingScale() == 5) {
            btn1.setBackgroundColor(0xFFFFFFFF);
            btn2.setBackgroundColor(0xFFFFFFFF);
            btn3.setBackgroundColor(0xFFFFFFFF);
            btn4.setBackgroundColor(0xFFFFFFFF);
            btn5.setBackgroundColor(0xFF03A9F4);
            autoBtn.setBackgroundColor(0xFFFFFFFF);

            btn1.setTextColor(0xFF000000);
            btn2.setTextColor(0xFF000000);
            btn3.setTextColor(0xFF000000);
            btn4.setTextColor(0xFF000000);
            btn5.setTextColor(0xFFFFFFFF);
            autoBtn.setTextColor(0xFF000000);
        }


    }
}
