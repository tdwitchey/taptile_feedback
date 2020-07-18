package com.witchey.tyler.taptilefeedback;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Medium_Level extends Activity {

    private Button panelA, panelB, panelC, panelD, panelE, panelF;
    private Button tryAgain, playAgain;
    private TextView timer;
    private CountDownTimer setActive, gameTimer, startGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_medium);
        startGame();
    }

    public void startGame(){
        panelA = findViewById(R.id.panelA);
        panelB = findViewById(R.id.panelB);
        panelC = findViewById(R.id.panelC);
        panelD = findViewById(R.id.panelD);
        panelE = findViewById(R.id.panelE);
        panelF = findViewById(R.id.panelF);

        timer = findViewById(R.id.timer_number);
        timer.setText("0");

        panelA.setBackgroundColor(Color.LTGRAY);
        panelB.setBackgroundColor(Color.LTGRAY);
        panelC.setBackgroundColor(Color.LTGRAY);
        panelD.setBackgroundColor(Color.LTGRAY);
        panelE.setBackgroundColor(Color.LTGRAY);
        panelF.setBackgroundColor(Color.LTGRAY);

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
        panelE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(panelE.isActivated() == true){
                    haptic_feedback();
                    tapAnimation(panelE);
                    resetActive(panelE);
                }
                else{
                    gameOver_State();
                }
            }
        });
        panelF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(panelF.isActivated() == true){
                    haptic_feedback();
                    tapAnimation(panelF);
                    resetActive(panelF);
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

        setActive = new CountDownTimer(750, 750){
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                panel.setText("Fail");
                panel.setActivated(false);
                gameTimer.cancel();
                new CountDownTimer(2000, 1){
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        gameOver_State();
                    }
                }.start();

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
                startActivity(new Intent(Medium_Level.this, MainActivity.class));
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
                startActivity(new Intent(Medium_Level.this, MainActivity.class));
            }
        });
    }

    private void gameTimer(){

        gameTimer = new CountDownTimer(60000, 750){
            @Override
            public void onTick(long millisUntilFinished) {
                timer.setText("" + millisUntilFinished/1000);
                int choice;
                Random rand = new Random();
                choice = rand.nextInt(7) + 1;
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
                    case 5:
                        newActive(panelE);
                        break;
                    case 6:
                        newActive(panelF);
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
        panelE.setEnabled(false);
        panelF.setEnabled(false);

        startGame = new CountDownTimer(4000, 1000){
            @Override
            public void onTick(long millisUntilFinished) {
                panelA.setText(""+millisUntilFinished/1000);
                panelB.setText(""+millisUntilFinished/1000);
                panelC.setText(""+millisUntilFinished/1000);
                panelD.setText(""+millisUntilFinished/1000);
                panelE.setText(""+millisUntilFinished/1000);
                panelF.setText(""+millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                panelA.setText("");
                panelB.setText("");
                panelC.setText("");
                panelD.setText("");
                panelE.setText("");
                panelF.setText("");
                panelA.setEnabled(true);
                panelB.setEnabled(true);
                panelC.setEnabled(true);
                panelD.setEnabled(true);
                panelE.setEnabled(true);
                panelF.setEnabled(true);
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
