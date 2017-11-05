package nyc.c4q.homeworksimonsays;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private final Handler handler = new Handler();

    Button buttonRed;
    Button buttonBlue;
    Button buttonGreen;
    Button buttonYellow;
    TextView gameStatus;
    MediaPlayer soundEffectOne;
    MediaPlayer soundEffectTwo;
    MediaPlayer soundEffectThree;
    MediaPlayer soundEffectFour;

    ArrayList<Integer> userInputList = new ArrayList<>();
    ArrayList<Integer> buttonPressList = new ArrayList<>();

    int turn;
    int buttonPresses;
    boolean turnBoolean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gameStatus = (TextView) findViewById(R.id.textView2);

        buttonGreen = (Button) findViewById(R.id.green_button);
        buttonGreen.setOnClickListener(this);

        buttonBlue = (Button) findViewById(R.id.blue_button);
        buttonBlue.setOnClickListener(this);

        buttonRed = (Button) findViewById(R.id.red_button);
        buttonRed.setOnClickListener(this);

        buttonYellow = (Button) findViewById(R.id.yellow_button);
        buttonYellow.setOnClickListener(this);

        soundEffectOne = MediaPlayer.create(MainActivity.this, R.raw.sound_effect_one);
        soundEffectTwo = MediaPlayer.create(MainActivity.this, R.raw.sound_effect_two);
        soundEffectThree = MediaPlayer.create(MainActivity.this, R.raw.sound_effect_three);
        soundEffectFour = MediaPlayer.create(MainActivity.this, R.raw.sound_effect_four);

        simonTurn();
    }

    public void blue() {
        soundEffectThree.start();
        new CountDownTimer(900, 10) {
            public void onTick(long millisUntilFinished) {
                buttonBlue.setBackgroundResource(R.drawable.flash_blue);
            }

            public void onFinish() {
                buttonBlue.setBackgroundResource(R.drawable.blue_button);
                turnCounter(2);
            }
        }.start();
    }

    public void red() {
        soundEffectTwo.start();
        new CountDownTimer(900, 10) {
            public void onTick(long millisUntilFinished) {
                buttonRed.setBackgroundResource(R.drawable.flash_red);
            }

            public void onFinish() {
                buttonRed.setBackgroundResource(R.drawable.red_button);
                turnCounter(4);
            }
        }.start();
    }

    public void green() {
        soundEffectOne.start();
        new CountDownTimer(900, 10) {
            public void onTick(long millisUntilFinished) {
                buttonGreen.setBackgroundResource(R.drawable.flash_green);
            }

            public void onFinish() {
                buttonGreen.setBackgroundResource(R.drawable.green_button);
                turnCounter(1);
            }
        }.start();
    }

    public void yellow() {
        soundEffectFour.start();
        new CountDownTimer(900, 10) {
            public void onTick(long millisUntilFinished) {
                buttonYellow.setBackgroundResource(R.drawable.flash_yellow);
            }

            public void onFinish() {
                buttonYellow.setBackgroundResource(R.drawable.yellow_button);
                turnCounter(3);
            }
        }.start();
    }


    public void turnCounter(int button) {
        if (turnBoolean == false) {
            buttonPresses++;
            userInputList.add(button);
            if (buttonPresses == turn) {
                if (buttonPressList.equals(userInputList)) {
                    buttonPresses = 0;
                    simonTurn();
                } else if (!buttonPressList.equals(userInputList)) {
                    userInputList = new ArrayList<>();
                    buttonPressList = new ArrayList<>();
                    buttonPresses = 0;
                    turn = 0;
                    simonTurn();
                }

            }
        }
    }


    public void simonTurn() {
//        buttonGreen.setEnabled(false);
//        buttonYellow.setEnabled(false);
//        buttonRed.setEnabled(false);
//        buttonBlue.setEnabled(false);
        turnBoolean = true; // boolean to prevent turn checking
        Random random = new Random();
        int randomButton = random.nextInt(4) + 1;
        buttonPressList.add(randomButton);
        buttonPressList.add(7);

        int round=0;
        gameStatus.setText("Round "+round);

        for (int i = 0; i < buttonPressList.size(); i++) {

            int buttonPress = buttonPressList.get(i);
            switch (buttonPress) {
                case 1:
                   delayed(600,buttonGreen);
                    break;
                case 2:
                    delayed(600,buttonBlue);
                    break;
                case 3:
                    delayed(600,buttonYellow);
                    break;
                case 4:
                    delayed(600,buttonRed);
                    break;
            }
            round++;
        }
        // turnBoolean = false;
        turn++;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.red_button:
                red();
                userInputList.add(1);
                break;
            case R.id.yellow_button:
                yellow();
                userInputList.add(2);
                break;
            case R.id.green_button:
                green();
                userInputList.add(3);
                break;
            case R.id.blue_button:
                blue();
                userInputList.add(4);
                break;

        }
    }

    public void delayed(int timer, final Button click){
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                click.performClick();
            }
        }, timer);
    }
}