package nyc.c4q.homeworksimonsays;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button buttonRed;
    Button buttonBlue;
    Button buttonGreen;
    Button buttonYellow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonGreen = (Button) findViewById(R.id.green_button);
        buttonBlue = (Button) findViewById(R.id.blue_button);
        buttonRed = (Button) findViewById(R.id.red_button);
        buttonYellow =(Button) findViewById(R.id.yellow_button);

    }


    public void changeColorBt1(View v){
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

    public void changeColorBt2(View v){
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
    public void changeColorBt3(View v){
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
    public void changeColorBt4(View v){
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

}
