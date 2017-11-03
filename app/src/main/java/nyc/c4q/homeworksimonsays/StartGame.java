package nyc.c4q.homeworksimonsays;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by ashleyjoachim on 11/3/17.
 */

public class StartGame extends AppCompatActivity {
    Button startButton;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_game);
    }

    public void onClickStart(View view) {
        startButton = (Button) findViewById(R.id.start_button);
        Intent start = new Intent(this,MainActivity.class);
        startActivity(start);
    }
}
