package com.example.sony.railwayapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
//rating code.

public class RateUs extends AppCompatActivity {
    RatingBar ratingBar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_us);
        ratingBar = findViewById(R.id.ratingBAR);
        textView = findViewById(R.id.tex17);
    }

    public void onsubmit(View view) {

        float ratingValue = ratingBar.getRating();
        if (ratingValue < 2) {
            textView.setText("Rating:" + ratingValue + "\nIs it that Worse?");
        } else if (ratingValue <= 3 && ratingValue >= 2) {
            textView.setText("Rating:" + ratingValue + "\nWe Will Try to be Better!!");
        } else if (ratingValue > 3 && ratingValue <= 4) {
            textView.setText("Rating:" + ratingValue + "\nThat means you are having a good time here:)");
        } else if (ratingValue > 4) {
            textView.setText("Rating:" + ratingValue + "\n Wow! We will keep up the good work:)");
        }
    }
}
