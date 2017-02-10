package com.example.brian.geoquiz;

/**
 * Created by brian on 2/8/2017.
 */

public class TrueFalse extends Object {

    //holds the recourse Id those are always ints
    //m indicates member variables
    private int mQuestion;
    private boolean mTrueQuestion;

    //the in is a reference to the id and where it is it is always an int hence int
    //the boolean is setting whether the statement is true or false
    public TrueFalse(int question, boolean trueQuestion){
        mQuestion = question;
        mTrueQuestion = trueQuestion;
    }

    public int getQuestion(){
        return mQuestion;
    }

    public void setQuestion(int question){
        mQuestion = question;
    }

    public boolean isTrueQuestion(){
        return mTrueQuestion;
    }

    public void setTrueQuestion(boolean trueQuestion){
        mTrueQuestion = trueQuestion;
    }
}
