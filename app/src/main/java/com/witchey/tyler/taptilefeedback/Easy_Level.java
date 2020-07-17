package com.witchey.tyler.taptilefeedback;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.text.Layout;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Easy_Level extends Activity {

    private Button panelA, panelB, panelC, panelD;
    private Button tryAgain, playAgain;
    private TextView timer;
    private CountDownTimer setActive, gameTimer, startGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_easy);
        startGame();
    }

    public void startGame(){
        panelA = findViewById(R.id.panelA);
        panelB = findViewById(R.id.panelB);
        panelC = findViewById(R.id.panelC);
        panelD = findViewById(R.id.panelD);

        timer = findViewById(R.id.timer_number);
        timer.setText("0");

        panelA.setBackgroundColor(Color.LTGRAY);
        panelB.setBackgroundColor(Color.LTGRAY);
        panelC.setBackgroundColor(Color.LTGRAY);
        panelD.setBackgroundColor(Color.LTGRAY);

        panelA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(panelA.isActivated() == true){
                    haptic_feedback();
                    tapAnimation(panelA);
                    resetActive(panelA);
                }
                else{
                    gameOver_State();
                }
            }
        });
        panelB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(panelB.isActivated() == true){
                    haptic_feedback();
                    tapAnimation(panelB);
                    resetActive(panelB);
                }
                else{
                    gameOver_State();
                }
            }
        });
        panelC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(panelC.isActivated() == true){
                    haptic_feedback();
                    tapAnimation(panelC);
                    resetActive(panelC);
                }
                else{
                    gameOver_State();
                }
            }
        });
        panelD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(panelD.isActivated() == true){
                    haptic_feedback();
                    tapAnimation(panelD);
                    resetActive(panelD);

                }
                else{
                    gameOver_State();
                }
            }
        });

        startGameTimer();
    }

    private void newActive(final Button panel){
        panel.setBackgroundColor(Color.RED);
        panel.setActivated(true);

        setActive = new CountDownTimer(1000, 500){
            @Override
            public void onTick(long millisUntilFinished) {
                panel.setText("" + millisUntilFinished/500);
            }

            @Override
            public void onFinish() {
                panel.setText("Fail");
                panel.setActivated(false);
                gameOver_State();
            }
        }.start();

    }

    private void resetActive(Button panel){
        setActive.cancel();
        panel.setText("");
        panel.setBackgroundColor(Color.LTGRAY);
        panel.setActivated(false);
    }

    private void haptic_feedback(){
        MainActivity.vibrate.vibrate(250);
    }



    private void gameOver_State(){
        setContentView(R.layout.activity_game_over);

        setActive.cancel();
        gameTimer.cancel();
        startGame.cancel();

        tryAgain = findViewById(R.id.tryagain);
        tryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(Easy_Level.this, MainActivity.class));
            }
        });
    }

    private void levelComplete(){
        setContentView(R.layout.activity_level_complete);

        setActive.cancel();
        gameTimer.cancel();
        startGame.cancel();


        playAgain = findViewById(R.id.playAgain);
        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(Easy_Level.this, MainActivity.class));
            }
        });
    }

    private void gameTimer(){

        gameTimer = new CountDownTimer(60000, 1000){
            @Override
            public void onTick(long millisUntilFinished) {
                timer.setText("" + millisUntilFinished/1000);
                int choice;
                Random rand = new Random();
                choice = rand.nextInt(5) + 1;
                switch(choice){
                    case 1:
                        newActive(panelA);
                        break;
                    case 2:
                        newActive(panelB);
                        break;
                    case 3:
                        newActive(panelC);
                        break;
                    case 4:
                        newActive(panelD);
                        break;
                    default:
                        break;
                }

            }

            @Override
            public void onFinish() {
                levelComplete();
            }
        }.start();
    }

    private void startGameTimer(){
        panelA.setEnabled(false);
        panelB.setEnabled(false);
        panelC.setEnabled(false);
        panelD.setEnabled(false);

        startGame = new CountDownTimer(4000, 1000){
            @Override
            public void onTick(long millisUntilFinished) {
                panelA.setText(""+millisUntilFinished/1000);
                panelB.setText(""+millisUntilFinished/1000);
                panelC.setText(""+millisUntilFinished/1000);
                panelD.setText(""+millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                panelA.setText("");
                panelB.setText("");
                panelC.setText("");
                panelD.setText("");
                panelA.setEnabled(true);
                panelB.setEnabled(true);
                panelC.setEnabled(true);
                panelD.setEnabled(true);
                gameTimer();
            }
        }.start();
    }

    private void tapAnimation(Button panel){
        Animation tap = AnimationUtils.loadAnimation(this, R.anim.tap);
        tap.reset();
        panel.clearAnimation();
        panel.startAnimation(tap);
    }
}
