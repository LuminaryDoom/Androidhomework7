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
                buttonGreen.setBackgroundResource(R.drawable.flash_green);
            }

            public void onFinish() {
                buttonGreen.setBackgroundResource(R.drawable.green_button);
            }
        }.start();
        StoreTurn.addToList("G");
    }

    public void onClickRedButton(View v) {
        soundEffectTwo.start();
        buttonRed = (Button) findViewById(R.id.red_button);
        new CountDownTimer(50, 10) {
            public void onTick(long millisUntilFinished) {
                buttonRed.setBackgroundResource(R.drawable.flash_red);
            }

            public void onFinish() {
                buttonRed.setBackgroundResource(R.drawable.red_button);
            }
        }.start();
        StoreTurn.addToList("R");
    }

    public void onClickBlueButton(View v) {
        soundEffectThree.start();
        buttonBlue = (Button) findViewById(R.id.blue_button);
        new CountDownTimer(50, 10) {
            public void onTick(long millisUntilFinished) {
                buttonBlue.setBackgroundResource(R.drawable.flash_blue);
            }

            public void onFinish() {
                buttonBlue.setBackgroundResource(R.drawable.blue_button);
            }
        }.start();
        StoreTurn.addToList("B");
    }

    public void onClickYellowButton(View v) {
        soundEffectFour.start();
        buttonYellow = (Button) findViewById(R.id.yellow_button);
        new CountDownTimer(50, 10) {
            public void onTick(long millisUntilFinished) {
                buttonYellow.setBackgroundResource(R.drawable.flash_yellow);
            }

            public void onFinish() {
                buttonYellow.setBackgroundResource(R.drawable.yellow_button);
            }
        }.start();
        StoreTurn.addToList("Y");
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
