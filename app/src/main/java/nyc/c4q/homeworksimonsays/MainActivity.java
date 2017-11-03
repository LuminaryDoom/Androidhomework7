package nyc.c4q.homeworksimonsays;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity  {
    TextView roundCounter;
    Button buttonRed;
    Button buttonBlue;
    Button buttonGreen;
    Button buttonYellow;
    MediaPlayer soundEffectOne;
    MediaPlayer soundEffectTwo;
    MediaPlayer soundEffectThree;
    MediaPlayer soundEffectFour;

    int turncounter = 0;
    int buttonPressCounter = 0;

    ArrayList<Integer> turnList =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        roundCounter = (TextView) findViewById(R.id.roundCounter);
        buttonGreen = (Button) findViewById(R.id.green_button);
        buttonBlue = (Button) findViewById(R.id.blue_button);
        buttonRed = (Button) findViewById(R.id.red_button);
        buttonYellow = (Button) findViewById(R.id.yellow_button);
        soundEffectOne = MediaPlayer.create(MainActivity.this, R.raw.button_effect_one);
        soundEffectTwo = MediaPlayer.create(MainActivity.this, R.raw.sound_effect_two);
        soundEffectThree = MediaPlayer.create(MainActivity.this, R.raw.sound_effect_three);
        soundEffectFour = MediaPlayer.create(MainActivity.this, R.raw.sound_effect_four);
    }

    public void checkButtonPressCounter(){

    }

    public void onClickGreenButton(View v) {
        soundEffectOne.start();
        new CountDownTimer(200, 10) {
            public void onTick(long millisUntilFinished) {
                buttonGreen.setBackgroundResource(R.color.flash_greenButton);
            }

            public void onFinish() {
                buttonGreen.setBackgroundResource(R.color.greenButton);
            }
        }.start();



    }

    public void onClickBlueButton(View v) {
        soundEffectThree.start();
        new CountDownTimer(200, 10) {
            public void onTick(long millisUntilFinished) {
                buttonBlue.setBackgroundResource(R.color.flash_blueButton);
            }

            public void onFinish() {
                buttonBlue.setBackgroundResource(R.color.blueButton);
            }
        }.start();



    }

    public void onClickYellowButton(View v) {
        soundEffectFour.start();
        new CountDownTimer(200, 10) {
            public void onTick(long millisUntilFinished) {
                buttonYellow.setBackgroundResource(R.color.flash_yellowButton);
            }

            public void onFinish() {
                buttonYellow.setBackgroundResource(R.color.yellowButton);
            }
        }.start();

    }


    public void onClickRedButton(View v) {
        soundEffectTwo.start();
        new CountDownTimer(200, 10) {
            public void onTick(long millisUntilFinished) {
                buttonRed.setBackgroundResource(R.color.flash_redButton);
            }

            public void onFinish() {
                buttonRed.setBackgroundResource(R.color.redButton);
            }
        }.start();


    }


    public void playPreviousTurns(){
        int i = 0;
        Random random = new Random();
        int randomButton = random.nextInt(4)+1;
        while(i < storeTurn.list1.size()){
            int temp = storeTurn.list1.get(i);
            switch (temp) {
                case 1:
                    buttonGreen.performClick();
                    i++;
                    break;
                case 2:
                    buttonBlue.performClick();
                    i++;
                    break;
                case 3:
                    buttonYellow.performClick();
                    i++;
                    break;
                case 4:
                    buttonRed.performClick();
                    i++;
                    break;
            }
        }
    }

}
