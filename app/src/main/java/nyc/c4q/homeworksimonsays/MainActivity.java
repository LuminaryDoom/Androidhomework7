package nyc.c4q.homeworksimonsays;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonRed;
    Button buttonBlue;
    Button buttonGreen;
    Button buttonYellow;
    MediaPlayer soundEffectOne;
    MediaPlayer soundEffectTwo;
    MediaPlayer soundEffectThree;
    MediaPlayer soundEffectFour;

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
        new CountDownTimer(50, 10) {
            public void onTick(long millisUntilFinished) {
                buttonGreen.setBackgroundResource(R.color.flash_greenButton);
            }

            public void onFinish() {
                buttonGreen.setBackgroundResource(R.color.greenButton);
            }
        }.start();
        storeTurn.addToList("G");
    }

    public void onClickRedButton(View v) {
        soundEffectTwo.start();
        buttonRed = (Button) findViewById(R.id.red_button);
        new CountDownTimer(50, 10) {
            public void onTick(long millisUntilFinished) {
                buttonRed.setBackgroundResource(R.color.flash_redButton);
            }

            public void onFinish() {
                buttonRed.setBackgroundResource(R.color.redButton);
            }
        }.start();
        storeTurn.addToList("R");
    }

    public void onClickBlueButton(View v) {
        soundEffectThree.start();
        buttonBlue = (Button) findViewById(R.id.blue_button);
        new CountDownTimer(50, 10) {
            public void onTick(long millisUntilFinished) {
                buttonBlue.setBackgroundResource(R.color.flash_blueButton);
            }

            public void onFinish() {
                buttonBlue.setBackgroundResource(R.color.blueButton);
            }
        }.start();
        storeTurn.addToList("B");
    }

    public void onClickYellowButton(View v) {
        soundEffectFour.start();
        buttonYellow = (Button) findViewById(R.id.yellow_button);
        new CountDownTimer(50, 10) {
            public void onTick(long millisUntilFinished) {
                buttonYellow.setBackgroundResource(R.color.flash_yellowButton);
            }

            public void onFinish() {
                buttonYellow.setBackgroundResource(R.color.yellowButton);
            }
        }.start();
        storeTurn.addToList("Y");
    }

    @Override
    public void onClick(View v) {
        CharSequence text = "Simon's turn";
        int duration = Toast.LENGTH_LONG;
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            int randomButton = random.nextInt(4) + 1;
            switch (randomButton) {
                default:
                    onClickBlueButton(v);
                    break;
                case 1:
                    onClickGreenButton(v);
                    break;
                case 2:
                    onClickYellowButton(v);
                    break;
                case 3:
                    onClickRedButton(v);
                    break;
            }
        }
    }

    public void simonTurn() {

    }
}
