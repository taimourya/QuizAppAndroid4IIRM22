package com.example.quizv1.Controller;

import androidx.appcompat.app.AppCompatActivity;

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
import com.example.quizv1.R;

public class Quiz extends AppCompatActivity {

    private ImageView ivQuestion;
    private TextView tvQst;
    private RadioGroup rgReps;
    private Button btnNext;

    private QuestionRepository questionRepository;

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

        createCurrentQuestion();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //verifier si correct
                if(rgReps.getId() == questionCourante.getRepIndex())
                    nbRepCorrect++;


                //next question
                currentQuestionIndex++;
                createCurrentQuestion();
            }
        });
    }

    private void createCurrentQuestion(){
        questionCourante = questionRepository.findOneById(currentQuestionIndex);

        rgReps.removeAllViews();
        int i = 0;
        for(String s : questionCourante.getReponses()){
            RadioButton rb = new RadioButton(this);
            rb.setId(i++);
            rgReps.addView(rb);
        }
    }




}