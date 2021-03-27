package com.example.quizv1.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.quizv1.Dao.IRepository;
import com.example.quizv1.Dao.QuestionRepository;
import com.example.quizv1.Entity.Question;
import com.example.quizv1.Entity.ScoreE;
import com.example.quizv1.R;

public class Quiz extends AppCompatActivity {

    private ImageView ivQuestion;
    private TextView tvQst;
    private RadioGroup rgReps;
    private Button btnNext;

    private QuestionRepository questionRepository = new QuestionRepository();

    private int currentQuestionIndex = 0;
    private Question questionCourante;
    int nbRepCorrect = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        ivQuestion = findViewById(R.id.ivQuestion);
        tvQst = findViewById(R.id.tvQst);
        rgReps = findViewById(R.id.rgReps);
        btnNext = findViewById(R.id.btnNext);

        try {
            createCurrentQuestion();
        } catch (Exception e) {
            startActivity(new Intent(Quiz.this, Login.class));
        }

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //verifier si correct
                if(rgReps.getId() == questionCourante.getRepIndex())
                    nbRepCorrect++;


                //next question
                currentQuestionIndex++;
                try {
                    createCurrentQuestion();
                } catch (Exception e) {
                    ScoreE.score = nbRepCorrect * 100 / questionRepository.size();
                    startActivity(new Intent(Quiz.this, Score.class));
                }
            }
        });
    }

    private void createCurrentQuestion() throws Exception{
        questionCourante = questionRepository.findOneById(currentQuestionIndex);
        tvQst.setText(questionCourante.getQuestion());

        rgReps.removeAllViews();
        int i = 0;
        for(String s : questionCourante.getReponses()){
            RadioButton rb = new RadioButton(this);
            rb.setText(s);
            rb.setId(i++);
            rgReps.addView(rb);
        }
    }




}