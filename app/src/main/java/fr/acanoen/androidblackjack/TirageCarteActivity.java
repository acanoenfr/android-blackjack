package fr.acanoen.androidblackjack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;

public class TirageCarteActivity extends AppCompatActivity {

    public Button AddPoint;
    private ArrayList<Integer> carts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tirage_carte);
        carts = new ArrayList<>();
        AddPoint = findViewById(R.id.add_point);
        AddPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView score = findViewById(R.id.score);
                onBtnClick();
                score.setText(getSum().toString());
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
