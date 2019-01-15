package fr.acanoen.androidblackjack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    public TextView whowin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        Intent intent = getIntent();
        String winner = intent.getStringExtra(".winner");
        whowin = findViewById(R.id.whowin);
        if (winner.equalsIgnoreCase("Joueur")) {
            whowin.setText("Vous avez gagné ! :)");
        } else if (winner.equalsIgnoreCase("Banque")) {
            whowin.setText("Vous avez perdu ! :(");
        } else {
            whowin.setText("Egalité avec la banque ! :|");
        }
    }
}
