package fr.acanoen.androidblackjack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;

public class ScoreActivity extends AppCompatActivity {

    public TextView whowin;
    private ArrayList<Integer> bank = new ArrayList<>();
    public String winner;
    public Integer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        whowin = findViewById(R.id.whowin);
        Intent intent = getIntent();
        String score = intent.getStringExtra(".player");
        player = Integer.parseInt(score);
        int sum = 0;
        do {
            bank.add(RandomUtils.nextInt(1, 11));
            for (int n : bank) {
                sum += n;
            }
        } while(sum <= 17);
        if (sum == player) {
            whowin.setText("Egalité avec la banque ! :|");
        } else if (sum >= player) {
            if (sum <= 21) {
                whowin.setText("Vous avez perdu ! :(");
            } else {
                whowin.setText("Vous avez gagné ! :)");
            }
        } else {
            if (player <= 21) {
                whowin.setText("Vous avez gagné ! :)");
            } else {
                whowin.setText("Vous avez perdu ! :(");
            }
        }
    }
}
