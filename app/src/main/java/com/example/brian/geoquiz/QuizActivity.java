package com.example.brian.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    //declare outside of the onCreate method
    private Button mTrueButton;
    private Button mFalseButton;

    private ImageButton mNextButton;
    private ImageButton mPrevButton;

    private TextView mQuestionTextView;

    private int mCurrentIndex = 0;

    //list of the different questions in the app and to cycle through them
    private TrueFalse[] mQuestionBank = new TrueFalse[] {
            //the true false object needs an ID and set to true or false
            //each statement has an answer
            //TrueFalse(int R.String.ID, boolean true/false)
            new TrueFalse(R.string.american_question, true),
            new TrueFalse(R.string.asia_question, true),
            new TrueFalse(R.string.mideast_question, false),
            new TrueFalse(R.string.ocean_question, true)
    };

    private void updateQuestion(){
        int question = mQuestionBank[mCurrentIndex].getQuestion();
        mQuestionTextView.setText(question);
    }

    private void checkAnswer(boolean mPressedAnswer){
        boolean answerIs = mQuestionBank[mCurrentIndex].isTrueQuestion();
        int messageResId;
        if(mPressedAnswer == answerIs){
            messageResId = R.string.correct_toast;
        }else {
            messageResId = R.string.inccorect_toast;
        }

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        //to access the textview
        mQuestionTextView = (TextView)findViewById(R.id.question_text_view);
        //to set the current position to the first one in the array
        //int question = mQuestionBank[mCurrentIndex].getQuestion();
        //to show the question in the textview
        //mQuestionTextView.setText(question);

        //to increment the question use the button the counter the list and a listener
        //access the next button
        mNextButton = (ImageButton)findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentIndex = (mCurrentIndex + 1)% mQuestionBank.length;
                updateQuestion();
            }
        });

        mPrevButton = (ImageButton)findViewById(R.id.prev_button);
        mPrevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mCurrentIndex == 0){
                    mCurrentIndex = mQuestionBank.length -1;
                    updateQuestion();
                }else {
                    mCurrentIndex = (mCurrentIndex - 1) % mQuestionBank.length;
                    updateQuestion();
                }
            }
        });

        updateQuestion();

        //access in the onCreate method
        mTrueButton = (Button)findViewById(R.id.true_button);
        //notifies you if the button has been pressed
        //new View.OnClickListener is an anonymous class and can be passed in it implementation
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*if(mQuestionBank[mCurrentIndex].isTrueQuestion()){
                    //toast sting is in resources
                    //Toast.makeText(Context context, int resID, int duration)
                    //QuizActivity.this refers to the View.OnClickListener
                    Toast.makeText(QuizActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(QuizActivity.this, R.string.inccorect_toast, Toast.LENGTH_SHORT).show();
                }*/

                checkAnswer(true);

            }
        });

        mFalseButton = (Button)findViewById(R.id.false_button);
        //notifies you if the button has been pressed
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*if(!mQuestionBank[mCurrentIndex].isTrueQuestion()){
                    //toast sting is in resources
                    //Toast.makeText(Context context, int resID, int duration)
                    //QuizActivity.this refers to the View.OnClickListener
                    Toast.makeText(QuizActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(QuizActivity.this, R.string.inccorect_toast, Toast.LENGTH_SHORT).show();
                }*/

                checkAnswer(false);

            }
        });

    }
}
