package com.csprep.csprep;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.Random;


public class ResultsActivity extends ActionBarActivity {
    public static final String EXTRA_MESSAGE = "com.csprep.ResultsActivity.MESSAGE";
    public static final String PACKAGE = "com.csprep.Result.par";

    private String message;
    private TextView textView;
    private Package aPackage;
    private String comment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // LAYOUT MUST BE REALIZED BEFORE MODIFYING CONTENT
        setContentView(R.layout.activity_results);



        //Intent intent = getIntent();
        //this.message = intent.getStringExtra(MainMenuActivity.EXTRA_MESSAGE);


        this.aPackage = (Package)getIntent().getSerializableExtra(QuestionActivity.PACKAGE);



        /*
        // Create the text view
        this.textView = new TextView(this);
        this.textView.setTextSize(40);
        this.textView.setText(message);
        */

        TextView category = (TextView)findViewById(R.id.category_name);
        category.setText(this.aPackage.getCategory());
        TextView correct = (TextView)findViewById(R.id.correct_answers);
        correct.setText(this.aPackage.getCorrectScore());
        TextView incorrect = (TextView)findViewById(R.id.wrong_answers);
        incorrect.setText(this.aPackage.getIncorrectScore());
        TextView accuracy = (TextView)findViewById(R.id.percentage);
        accuracy.setText(this.getAccuracy(correct, incorrect) + "%");
        TextView grade = (TextView)findViewById(R.id.letter_grade);
        grade.setText(this.getLetterGrade(this.getAccuracy(correct, incorrect)));


        TextView comment = (TextView)findViewById(R.id.comment_text);
        comment.setText(this.comment);

    }



    private String getAccuracy(TextView correct, TextView wrong) {
        double x = Double.valueOf(correct.getText().toString());
        double y = Double.valueOf(wrong.getText().toString());
        double percentage = (x/(x+y)) * 100;
        return String.valueOf(percentage);
    }

    private String getLetterGrade(String accuracy) {
        double g = Double.valueOf(accuracy);
        if (g >= 90) {
            if (g >= 100) {
                this.comment = "Congratulations, you have a perfect score!!!";
            } else {
                this.comment = "Almost a perfect. Great Job!!!";
            }
            return "A";
        } else if (g < 90 && g >= 80) {
            this.comment = "Almost there. Keep up the good work!!!";
            return "B";
        } else if (g < 80 && g >= 70) {
            this.comment = "You're on the right track. Good job!!!";
            return "C";
        } else if (g < 70 && g >= 60) {
            this.comment = "A little more studying will help";
            return "D";
        } else {
            this.comment = "Study harder in order to succeed";
            return "F";
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        // save to file here

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_results, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.exit_from_results) {
            /*
            Intent intent = new Intent(this, DisclaimerActivity.class);
            intent.putExtra(EXTRA_MESSAGE, "No Save");
            startActivity(intent);
            */

            Toast toast = Toast.makeText(this, "Score Not Saved", Toast.LENGTH_SHORT);
            TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
            if( v != null) v.setGravity(Gravity.CENTER);
            toast.show();
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void saveResults(View view) throws IOException {
        Toast toast = Toast.makeText(this, "Score is uploaded to www.csprep.org and look for your ID " + generateID(), Toast.LENGTH_LONG);
        TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
        if( v != null) v.setGravity(Gravity.CENTER);
        toast.show();

        finish();
    }

    public String generateID() {
        Random rand = new Random();
        long randomNum = 1 + (long)(Math.random() * ((1000000 - 1) + 1));
        return String.valueOf(randomNum);
    }
}
