package nyc.c4q.homeworksimonsays;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by ashleyjoachim on 11/3/17.
 */

public class NewGame extends AppCompatActivity{
    Button newGameButton;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_game);
    }

    public void onClickNewGame(View view) {
        newGameButton = (Button) findViewById(R.id.new_game_button);
        Intent game = new Intent(this, StartGame.class);
        startActivity(game);
    }
}
