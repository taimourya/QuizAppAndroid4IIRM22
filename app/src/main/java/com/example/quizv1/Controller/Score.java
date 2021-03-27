package com.example.quizv1.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.quizv1.R;

public class Score extends AppCompatActivity {

    private TextView tvScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Intent intent = getIntent();
        int score = intent.getIntExtra("score", 0);

        tvScore = findViewById(R.id.tvScore);

        tvScore.setText(score + " %");

    }
}