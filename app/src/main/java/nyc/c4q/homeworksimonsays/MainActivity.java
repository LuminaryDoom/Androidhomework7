package nyc.c4q.homeworksimonsays;

import android.content.Context;
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

public class MainActivity extends AppCompatActivity {

    Button buttonRed;
    Button buttonBlue;
    Button buttonGreen;
    Button buttonYellow;
    TextView gameStatus;
    MediaPlayer soundEffectOne;
    MediaPlayer soundEffectTwo;
    MediaPlayer soundEffectThree;
    MediaPlayer soundEffectFour;

    ArrayList<Integer> buttonPressCheck = new ArrayList<>();
    ArrayList<Integer> buttonPressList = new ArrayList<>();
    int turn;
    int buttonPresses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonGreen = (Button) findViewById(R.id.green_button);
        buttonBlue = (Button) findViewById(R.id.blue_button);
        buttonRed = (Button) findViewById(R.id.red_button);
        buttonYellow = (Button) findViewById(R.id.yellow_button);
        soundEffectOne = MediaPlayer.create(MainActivity.this, R.raw.button_effect_one);
        soundEffectTwo = MediaPlayer.create(MainActivity.this, R.raw.sound_effect_two);
        soundEffectThree = MediaPlayer.create(MainActivity.this, R.raw.sound_effect_three);
        soundEffectFour = MediaPlayer.create(MainActivity.this, R.raw.sound_effect_four);
    }


    public void onClickGreenButton(View v) {
        soundEffectOne.start();
        buttonGreen = (Button) findViewById(R.id.green_button);
        new CountDownTimer(100, 10) {
            public void onTick(long millisUntilFinished) {
                buttonGreen.setBackgroundResource(R.color.flash_greenButton);
            }

            public void onFinish() {
                buttonGreen.setBackgroundResource(R.color.greenButton);
            }
        }.start();

        buttonPressCheck.add(1);
    }

    public void onClickRedButton(View v) {
        soundEffectTwo.start();
        buttonRed = (Button) findViewById(R.id.red_button);
        new CountDownTimer(100, 10) {
            public void onTick(long millisUntilFinished) {
                buttonRed.setBackgroundResource(R.color.flash_redButton);
            }

            public void onFinish() {
                buttonRed.setBackgroundResource(R.color.redButton);
            }
        }.start();
        buttonPressCheck.add(2);
    }

    public void onClickBlueButton(View v) {
        soundEffectThree.start();
        buttonBlue = (Button) findViewById(R.id.blue_button);
        new CountDownTimer(100, 10) {
            public void onTick(long millisUntilFinished) {
                buttonBlue.setBackgroundResource(R.color.flash_blueButton);
            }

            public void onFinish() {
                buttonBlue.setBackgroundResource(R.color.blueButton);
            }
        }.start();
        buttonPressCheck.add(3);
    }

    public void onClickYellowButton(View v) {
        soundEffectFour.start();
        buttonYellow = (Button) findViewById(R.id.yellow_button);
        new CountDownTimer(100, 10) {
            public void onTick(long millisUntilFinished) {
                buttonYellow.setBackgroundResource(R.color.flash_yellowButton);
            }

            public void onFinish() {
                buttonYellow.setBackgroundResource(R.color.yellowButton);
            }
        }.start();
        buttonPressList.add(4);
        buttonPressCheck.add(4);
    }

    public void turnCounter(boolean aiTurn){
        if( aiTurn == false ){
            if(buttonPressList.contains(buttonPressCheck)){
                buttonPresses++;
                if(buttonPresses == turn){
                    buttonPresses = 0;
                    playPreviousTurns();
                }
            }else{
                System.exit(0);
            }
        }
    }

    public void playPreviousTurns(){
        turnCounter(true);
        Random random = new Random();
        int randomButton = random.nextInt(4)+1;
       buttonPressList.add(randomButton);
        for(int i = 0; i<buttonPressList.size(); i++){
            int temp = buttonPressList.get(i);
            switch (temp) {
                case 1:
                    buttonGreen.performClick();
                    break;
                case 2:
                    buttonBlue.performClick();
                    break;
                case 3:
                    buttonYellow.performClick();
                    break;
                case 4:
                    buttonRed.performClick();
                    break;
            }
        }
        buttonPresses = 0;
        turnCounter(false);
        turn++;
    }

}
