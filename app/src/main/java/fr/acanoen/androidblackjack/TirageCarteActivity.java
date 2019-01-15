package fr.acanoen.androidblackjack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;

public class TirageCarteActivity extends AppCompatActivity {

    public Button AddPoint;
    public Button stop;
    private ArrayList<Integer> carts;
    private ArrayList<Integer> bank;
    public String winner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tirage_carte);
        carts = new ArrayList<>();
        bank = new ArrayList<>();
        AddPoint = findViewById(R.id.add_point);
        AddPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView score = findViewById(R.id.score);
                onBtnClick();
                score.setText(getSum().toString());
            }
        });
        stop = findViewById(R.id.stop);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int player = getSum();
                int sum = 0;
                do {
                    bank.add(RandomUtils.nextInt(1, 11));
                    for (int n : bank) {
                        sum += n;
                    }
                } while(sum <= 17);
                if (sum == player) {
                    winner = "Aucun";
                } else if (sum >= player) {
                    if (sum <= 21) {
                        winner = "Banque";
                    } else {
                        winner = "Joueur";
                    }
                } else {
                    if (player <= 21) {
                        winner = "Joueur";
                    } else {
                        winner = "Banque";
                    }
                }
                Intent intent = new Intent(TirageCarteActivity.this, ScoreActivity.class);
                intent.putExtra(".winner", winner);
                startActivity(intent);
                finish();
            }
        });
    }

    private void onBtnClick() {
        carts.add(RandomUtils.nextInt(1, 11));
    }

    private Integer getSum() {
        int sum = 0;
        for (int cart : carts) {
            sum += cart;
        }
        return sum;
    }
}
