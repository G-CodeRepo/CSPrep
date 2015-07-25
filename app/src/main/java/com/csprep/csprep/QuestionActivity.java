package com.csprep.csprep;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.transition.TransitionManager;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class QuestionActivity extends ActionBarActivity {
    public static final String EXTRA_MESSAGE = "com.csprep.QuestionActivity.MESSAGE";
    public static final String PACKAGE = "com.csprep.QuestionActivity.par";

    private TextView chosenCategory, theQuestion;
    private String[] message;
    private RadioButton rb1, rb2, rb3;
    private String answer;
    private Package aPackage;
    private int currentIndex;

    private ViewGroup questionBefore;
    private ViewGroup questionAfter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // THE LAYOUT MUST BE REALIZED BEFORE ANY CHANGES TO TEXT
        setContentView(R.layout.activity_question);

        /*
        Intent intent = getIntent();
        this.message = intent.getStringArrayExtra(MainMenuActivity.EXTRA_MESSAGE);

        // Extract Category title
        this.chosenCategory = (TextView)findViewById(R.id.category);
        this.chosenCategory.setText(this.message[0]);

        // Extract QuestionActivity
        this.theQuestion = (TextView) findViewById(R.id.question_text);
        this.theQuestion.setText(this.message[1]);

        // Extract Correct Answer
        this.answer = this.message[2];

        // Extract And Randomize Choices
        String[] ans = {this.message[2], this.message[3], this.message[4]};
        List<String> choices = new ArrayList<String>(Arrays.asList(ans));
        Collections.shuffle(choices);   // shuffle answers

        this.rb1 =(RadioButton)findViewById(R.id.radio_button_choice1);
        this.rb1.setText(choices.get(0));
        this.rb2 =(RadioButton)findViewById(R.id.radio_button_choice2);
        this.rb2.setText(choices.get(1));
        this.rb3 =(RadioButton)findViewById(R.id.radio_button_choice3);
        this.rb3.setText(choices.get(2));
        */




        /*
        //this.aPackage = (Package)getIntent().getParcelableExtra(MainMenuActivity.PACKAGE);
        this.aPackage = (Package)getIntent().getSerializableExtra(MainMenuActivity.PACKAGE);

        // Extract Category title
        this.chosenCategory = (TextView)findViewById(R.id.category);
        this.chosenCategory.setText(this.aPackage.getCategory());

        // Extract QuestionActivity
        this.theQuestion = (TextView) findViewById(R.id.question_text);
        this.theQuestion.setText(this.aPackage.getQuestion());

        // Extract Correct And Wrong Answers
        this.answer = aPackage.getCorrectAnswer();
        String[] wrongAnswers = aPackage.getIncorrectAnswers();
        String[] ans = {this.answer, wrongAnswers[0], wrongAnswers[1]};

        // Randomize Choices
        List<String> choices = new ArrayList<String>(Arrays.asList(ans));
        Collections.shuffle(choices);   // shuffle answers

        this.rb1 =(RadioButton)findViewById(R.id.radio_button_choice1);
        this.rb1.setText(choices.get(0));
        this.rb1.setChecked(false);
        this.rb2 =(RadioButton)findViewById(R.id.radio_button_choice2);
        this.rb2.setText(choices.get(1));
        this.rb2.setChecked(false);
        this.rb3 =(RadioButton)findViewById(R.id.radio_button_choice3);
        this.rb3.setText(choices.get(2));
        this.rb3.setChecked(false);
        */
        this.createLayout();
    }

    private void createLayout() {
        //this.aPackage = (Package)getIntent().getParcelableExtra(MainMenuActivity.PACKAGE);
        this.aPackage = (Package)getIntent().getSerializableExtra(MainMenuActivity.PACKAGE);

        // Extract Category title
        this.chosenCategory = (TextView)findViewById(R.id.category);
        this.chosenCategory.setText(this.aPackage.getCategory());

        // Extract QuestionActivity
        this.theQuestion = (TextView) findViewById(R.id.question_text);
        this.theQuestion.setText(this.aPackage.getQuestion());

        // Extract Correct And Wrong Answers
        this.answer = aPackage.getCorrectAnswer();
        String[] wrongAnswers = aPackage.getIncorrectAnswers();
        String[] ans = {this.answer, wrongAnswers[0], wrongAnswers[1]};

        // Randomize Choices
        List<String> choices = new ArrayList<String>(Arrays.asList(ans));
        Collections.shuffle(choices);   // shuffle answers

        this.rb1 =(RadioButton)findViewById(R.id.radio_button_choice1);
        this.rb1.setText(choices.get(0));
        this.rb1.setChecked(false);
        this.rb2 =(RadioButton)findViewById(R.id.radio_button_choice2);
        this.rb2.setText(choices.get(1));
        this.rb2.setChecked(false);
        this.rb3 =(RadioButton)findViewById(R.id.radio_button_choice3);
        this.rb3.setText(choices.get(2));
        this.rb3.setChecked(false);


        // Determine the current question number and the max number of questions
        TextView currentQuestion = (TextView)findViewById(R.id.question_number);
        currentQuestion.setText(this.aPackage.getCurrentQuestionNumber() + " of " + this.aPackage.getMaxQuestions());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_question, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.back_to_main_menu) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void nextQuestion(View view) {
        Button b =(Button)findViewById(R.id.confirm_button);

        //if (b.getText().toString().compareTo("Confirm") == 0) {
        if (b.getId() == R.id.confirm_button) {
            // UPDATE SCORE HERE THEN TERMINATE WINDOW
            if ((this.rb1.isChecked())) {
                this.checkAnswer(this.rb1);
            } else if (this.rb2.isChecked()) {
                this.checkAnswer(this.rb2);
            } else if (this.rb3.isChecked()) {
                this.checkAnswer(this.rb3);
            } else {
                // do nothing
            }
        }
    }

    private void getNextQuestion() {
        this.currentIndex = this.aPackage.getCurrentIndex();
        this.currentIndex++;
        this.aPackage.getQuestion(this.currentIndex++);
    }

    private void getResults() {
        Intent intent = new Intent(this, ResultsActivity.class);
        Bundle b = new Bundle();
        b.putSerializable(PACKAGE, this.aPackage);
        intent.putExtras(b);
        startActivity(intent);

        // terminate this current activity
        finish();
    }

    /*
    @Override
    public void recreate() {
        super.recreate();
        this.getNextQuestion();
        this.createLayout();
    }
    */

    public void checkAnswer(View view) {
        RadioButton checked = ((RadioButton)view);
        String choice = checked.getText().toString();
        if (choice.equals(this.answer)) {
            this.aPackage.increaseCorrectScore();
            String currentScore = this.aPackage.getCorrectScore();
            String currentIncorrectScore = this.aPackage.getIncorrectScore();

            // Popup menu
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Correct!!!")
                    .setCancelable(false)
                    .setPositiveButton("Next", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // animate
                            ViewGroup layout = (ViewGroup)findViewById(R.id.question_layout);
                            TransitionManager.beginDelayedTransition(layout);

                            // check if anymore questions
                            if (! aPackage.done()) {
                                getNextQuestion();
                                createLayout();
                            } else {
                                getResults();
                            }
                        }
                    });
            AlertDialog popup = builder.create();
            popup.show();


            // Center text
            TextView messageView = (TextView)popup.findViewById(android.R.id.message);
            messageView.setGravity(Gravity.CENTER);

        } else {
            String currentScore = this.aPackage.getCorrectScore();
            this.aPackage.increaseIncorrectScore();
            String currentIncorrectScore = this.aPackage.getIncorrectScore();

            // Popup menu
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Sorry. The correct answer is:\n" + answer)
                    .setCancelable(false)
                    .setPositiveButton("Next", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                            // animate
                            ViewGroup layout = (ViewGroup)findViewById(R.id.question_layout);
                            TransitionManager.beginDelayedTransition(layout);

                            // check if any more questions
                            if (! aPackage.done()) {
                                getNextQuestion();
                                createLayout();
                            } else {
                                getResults();
                            }
                        }
                    });
            AlertDialog popup = builder.create();
            popup.show();

            // Center text
            TextView messageView = (TextView)popup.findViewById(android.R.id.message);
            messageView.setGravity(Gravity.CENTER);

        }

    }

    public void radioButtonClick(View view) {
        // Check which radio button was clicked
        RadioButton button = (RadioButton)view;
        boolean checked = button.isChecked();
        int id = button.getId();


        if (id == R.id.radio_button_choice1 ) {

           if (checked) {
               this.rb2.setChecked(false);
               this.rb3.setChecked(false);
           }

        } else if (id == R.id.radio_button_choice2 ) {

            if (checked) {
                this.rb1.setChecked(false);
                this.rb3.setChecked(false);
            }
        } else if (id == R.id.radio_button_choice3 ) {

            if (checked) {
                this.rb1.setChecked(false);
                this.rb2.setChecked(false);
            }

        } else {
            // DO NOTHING
        }

    }
}
