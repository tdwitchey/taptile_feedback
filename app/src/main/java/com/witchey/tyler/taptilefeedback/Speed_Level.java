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

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.Random;

public class Speed_Level extends Activity {

    private Button panelA, panelB, panelC, panelD, panelE, panelF, panelG, panelH;
    private Button tryAgain, playAgain;
    private TextView score, display_score, score_title;
    private CountDownTimer setActive, gameTimer, startGame;
    private ConstraintLayout level_complete_layout;
    private double newEvent = 1;
    private TextView speed_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_speedmode);
        speed_text = findViewById(R.id.speed_text);
        speed_text.setText("You have " + newEvent + " second for each press.");
        startGame();
    }

    public void startGame(){
        panelA = findViewById(R.id.panelA);
        panelB = findViewById(R.id.panelB);
        panelC = findViewById(R.id.panelC);
        panelD = findViewById(R.id.panelD);
        panelE = findViewById(R.id.panelE);
        panelF = findViewById(R.id.panelF);
        panelG = findViewById(R.id.panelG);
        panelH = findViewById(R.id.panelH);

        score = findViewById(R.id.score_number);
        score.setText("0");

        panelA.setBackgroundColor(Color.LTGRAY);
        panelB.setBackgroundColor(Color.LTGRAY);
        panelC.setBackgroundColor(Color.LTGRAY);
        panelD.setBackgroundColor(Color.LTGRAY);
        panelE.setBackgroundColor(Color.LTGRAY);
        panelF.setBackgroundColor(Color.LTGRAY);
        panelG.setBackgroundColor(Color.LTGRAY);
        panelH.setBackgroundColor(Color.LTGRAY);

        panelA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(panelA.isActivated() == true){
                    haptic_feedback();
                    tapAnimation(panelA);
                    resetActive(panelA);
                    int current_score = Integer.parseInt(score.getText().toString());
                    current_score += 1;
                    score.setText(""+current_score);
                }
                else{
                    show_score();
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
                    int current_score = Integer.parseInt(score.getText().toString());
                    current_score += 1;
                    score.setText(""+current_score);
                }
                else{
                    show_score();
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
                    int current_score = Integer.parseInt(score.getText().toString());
                    current_score += 1;
                    score.setText(""+current_score);
                }
                else{
                    show_score();
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
                    int current_score = Integer.parseInt(score.getText().toString());
                    current_score += 1;
                    score.setText(""+current_score);
                }
                else{
                    show_score();
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
                    int current_score = Integer.parseInt(score.getText().toString());
                    current_score += 1;
                    score.setText(""+current_score);
                }
                else{
                    show_score();
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
                    int current_score = Integer.parseInt(score.getText().toString());
                    current_score += 1;
                    score.setText(""+current_score);
                }
                else{
                    show_score();
                }
            }
        });
        panelG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(panelG.isActivated() == true){
                    haptic_feedback();
                    tapAnimation(panelG);
                    resetActive(panelG);
                    int current_score = Integer.parseInt(score.getText().toString());
                    current_score += 1;
                    score.setText(""+current_score);
                }
                else{
                    show_score();
                }
            }
        });
        panelH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(panelH.isActivated() == true){
                    haptic_feedback();
                    tapAnimation(panelH);
                    resetActive(panelH);
                    int current_score = Integer.parseInt(score.getText().toString());
                    current_score += 1;
                    score.setText(""+current_score);
                }
                else{
                    show_score();
                }
            }
        });

        startGameTimer();
    }

    private void newActive(final Button panel){
        panel.setBackgroundColor(Color.RED);
        panel.setActivated(true);

        setActive = new CountDownTimer((long)(newEvent * 1000), (long)(newEvent * 1000)){
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                gameTimer.cancel();
                panel.setText("Fail");
                panel.setActivated(false);
                new CountDownTimer(2000, 1){
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }
                    @Override
                    public void onFinish() {
                        show_score();
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
                startActivity(new Intent(Speed_Level.this, MainActivity.class));
            }
        });
    }

    private void show_score(){
        setContentView(R.layout.activity_level_complete);

        setActive.cancel();
        gameTimer.cancel();
        startGame.cancel();

        level_complete_layout = findViewById(R.id.level_complete_layout);
        level_complete_layout.setBackgroundColor(Color.BLACK);

        score_title = findViewById(R.id.levelComplete);
        score_title.setText("Game Over");

        display_score = findViewById(R.id.display_score);
        display_score.setText("Your Score: " + score.getText());

        playAgain = findViewById(R.id.playAgain);
        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(Speed_Level.this, MainActivity.class));
            }
        });
    }

    private void gameTimer(){

        gameTimer = new CountDownTimer(15000, (long)(newEvent * 1000)){
            @Override
            public void onTick(long millisUntilFinished) {
                int choice;
                Random rand = new Random();
                choice = rand.nextInt(9) + 1;
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
                    case 7:
                        newActive(panelG);
                        break;
                    case 8:
                        newActive(panelH);
                        break;
                    default:
                        break;
                }

            }

            @Override
            public void onFinish() {
                if (newEvent > 0.5){
                    newEvent -= 0.1;
                    speed_text.setText("You have " + newEvent + " second(s) for each press.");
                    new CountDownTimer(3000, 1000){
                        @Override
                        public void onTick(long millisUntilFinished) {
                            speedAnimation();
                        }

                        @Override
                        public void onFinish() {
                            startGameTimer();
                        }
                    }.start();
                }
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
        panelG.setEnabled(false);
        panelH.setEnabled(false);

        startGame = new CountDownTimer(4000, 1000){
            @Override
            public void onTick(long millisUntilFinished) {
                panelA.setText(""+millisUntilFinished/1000);
                panelB.setText(""+millisUntilFinished/1000);
                panelC.setText(""+millisUntilFinished/1000);
                panelD.setText(""+millisUntilFinished/1000);
                panelE.setText(""+millisUntilFinished/1000);
                panelF.setText(""+millisUntilFinished/1000);
                panelG.setText(""+millisUntilFinished/1000);
                panelH.setText(""+millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                panelA.setText("");
                panelB.setText("");
                panelC.setText("");
                panelD.setText("");
                panelE.setText("");
                panelF.setText("");
                panelG.setText("");
                panelH.setText("");
                panelA.setEnabled(true);
                panelB.setEnabled(true);
                panelC.setEnabled(true);
                panelD.setEnabled(true);
                panelE.setEnabled(true);
                panelF.setEnabled(true);
                panelG.setEnabled(true);
                panelH.setEnabled(true);
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

    private void speedAnimation(){
        Animation speed = AnimationUtils.loadAnimation(this, R.anim.tap);
        speed.reset();
        speed_text.clearAnimation();
        speed_text.startAnimation(speed);
    }
}
