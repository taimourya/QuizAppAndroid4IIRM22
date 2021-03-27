package com.example.quizv1.Entity;

import android.media.Image;

import java.util.ArrayList;

public class Question {
    private Image image;
    private String question;
    private ArrayList<String> reponses;
    private int repIndex;

    public Question(Image image, String question, ArrayList<String> reponses, int repIndex) {
        this.image = image;
        this.question = question;
        this.reponses = reponses;
        this.repIndex = repIndex;
    }

    public void addRep(String rep)
    {
        reponses.add(rep);
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public ArrayList<String> getReponses() {
        return reponses;
    }

    public void setReponses(ArrayList<String> reponses) {
        this.reponses = reponses;
    }

    public int getRepIndex() {
        return repIndex;
    }

    public void setRepIndex(int repIndex) {
        this.repIndex = repIndex;
    }
}
