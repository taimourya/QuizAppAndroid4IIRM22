package com.example.quizv1.Dao;

import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.example.quizv1.Entity.Question;
import com.example.quizv1.R;

import java.util.ArrayList;
import java.util.List;

public class QuestionRepository implements IRepository<Question> {

    ArrayList<Question> questions;

    public QuestionRepository(){
        questions = new ArrayList<>();

        ArrayList<String> reponses = new ArrayList<>();
        reponses.add("git push");
        reponses.add("git fork");
        reponses.add("git clone");
        reponses.add("git commit");

        questions.add(new Question(null, "What's the git command that downloads your repository from GitHub to your computer?",
                                    reponses, 2));


        reponses = new ArrayList<>();
        reponses.add("git push");
        reponses.add("git add");
        reponses.add("git upload");
        reponses.add("git status");

        questions.add(new Question(null, "What's the opposite of git clone, instead of downloading your code from GitHub, uploads your changes and code back to GitHub?",
                reponses, 0));

        reponses = new ArrayList<>();
        reponses.add("git check");
        reponses.add("git status");
        reponses.add("git commit");
        reponses.add("git diff");

        questions.add(new Question(null, "How do you check the state of your local git repository since your last commit?",
                reponses, 1));

        reponses = new ArrayList<>();
        reponses.add("git stage");
        reponses.add("git commit");
        reponses.add("git add");
        reponses.add("git reset");

        questions.add(new Question(null, "How do you stage files for a commit?",
                reponses, 2));

        reponses = new ArrayList<>();
        reponses.add("git commit add .");
        reponses.add("git commit .");
        reponses.add("git add .");
        reponses.add("git push -am \"Message\"");

        questions.add(new Question(null, "What's a shortcut to staging all the changes you have?",
                reponses, 2));

        reponses = new ArrayList<>();
        reponses.add("git message \"I'm coding\"");
        reponses.add("git add \"I'm coding\"");
        reponses.add("git commit \"I'm coding\"");
        reponses.add("git commit -m \"I'm coding\"");

        questions.add(new Question(null, "How do you supply a commit message to a commit?",
                reponses, 3));
    }

    @Override
    public List<Question> findAll() {
        return questions;
    }

    @Override
    public Question findOneById(int id) {
        return null;
    }

    @Override
    public void add(Question t) {

    }

}
