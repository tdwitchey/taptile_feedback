package com.witchey.tyler.taptilefeedback;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    private Button chooseEasy, chooseMedium, chooseHard;
    public static Vibrator vibrate;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        vibrate = (Vibrator) this.getSystemService(VIBRATOR_SERVICE);

        chooseEasy = findViewById(R.id.easy_level);
        chooseEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(MainActivity.this, Easy_Level.class));
            }
        });

        chooseMedium = findViewById(R.id.med_level);
        chooseMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(MainActivity.this, Medium_Level.class));
            }
        });

        chooseHard = findViewById(R.id.hard_level);
        chooseHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(MainActivity.this, Hard_Level.class));
            }
        });
    }
}


