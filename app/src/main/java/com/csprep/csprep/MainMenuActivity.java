package com.csprep.csprep;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;


public class MainMenuActivity extends ActionBarActivity  {
    public static final String EXTRA_MESSAGE = "com.csprep.MainMenuActivity.MESSAGE";
    public static final String PACKAGE = "com.csprep.MainMenuActivity.ser";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // show the current activity
        setContentView(R.layout.activity_main_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /*
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_menu, menu);
        return true;
        */

        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main_menu, menu);
        return super.onCreateOptionsMenu(menu);         // recursively add menu items
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        /*
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startSettings();
            return true;
        }
        */
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_settings:
                startSettings();
                return true;
            case R.id.action_disclaimer:
                startDisclaimer();
                return true;
            case R.id.action_close:
                exitMenu();
                return true;

            // ADD MORE CASES IF INTENDING TO HAVE MORE MENU ITEMS
            default:
                return super.onOptionsItemSelected(item);
        }

        //return super.onOptionsItemSelected(item);
    }

    /**
     * Go to SettingsActivity menu
     */
    public void startSettings() {
        Intent intent = new Intent(this, SettingsActivity.class);
        intent.putExtra(EXTRA_MESSAGE, "SETTINGS");
        startActivity(intent);
    }

    /**
     * Go to DisclaimerActivity menu
     */
    public void startDisclaimer() {
        Intent intent = new Intent(this, DisclaimerActivity.class);
        intent.putExtra(EXTRA_MESSAGE, "DISCLAIMER");
        startActivity(intent);
    }

    /**
     * Log out of session (go back to log in screen)
     */
    public void exitMenu() {
        //Intent intent = new Intent(this, MainActivity.class);
        //intent.putExtra(EXTRA_MESSAGE, "LOGIN");
        //startActivity(intent);
        finish();
    }

    /**
     * Start a new test
     * @param view
     */
    public void startExam(View view) {
        // determine what user chose in the drop down menu
        final Spinner spin = (Spinner) findViewById((R.id.category_drop_down));

        /*
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.drop_down_menu_test_category, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
        */



        final String category = String.valueOf(spin.getSelectedItem());

        ScoreAndQuestions q = new ScoreAndQuestions();
        ArrayList<QNode> questions = new ArrayList<QNode>();

        if (category.equals("Java")) {
            q.createJava(questions);
        } else if (category.equals("C and C++")) {
            q.createCCplusplus(questions);
        } else if (category.equals("Linux")) {
            q.createLinux(questions);
        } else if (category.equals("Data Structures")) {
            q.createDataStructsAlgs(questions);
        }else if (category.equals("OOP")) {
            q.createOOP(questions);
        } else {
            // NOTHING
        }

        //Intent intent;

        // ADD THE SCORE FIRST BECAUSE IT WILL BE THE LAST THING THE USER SEES BEFORE GOING BACK

        // TO THE MAIN MENU (LIKE A STACK)
        /*
        intent = new Intent(this, ResultsActivity.class);
        intent.putExtra(EXTRA_MESSAGE, ScoreAndQuestions.class);
        startActivity(intent);
        */

        // QUESTIONS WILL BE ORDER IN REVERSE (LIKE A STACK)
        /*
        for (int i = questions.size()-1; i > 0; i--) {

            intent = new Intent(this, QuestionActivity.class);
            String[] ans = {questions.get(i).getAnswer(), questions.get(i).getFalseAnswer1(), questions.get(i).getFalseAnswer2()};
            //List<String> answers = new ArrayList<String>(Arrays.asList(ans));
            //Collections.shuffle(answers);   // shuffle answers
            String[] args = {category, questions.get(i).getQuestion(), ans[0], ans[1], ans[2]};
           // intent.putExtra(EXTRA_MESSAGE, args);


            Bundle b = new Bundle();
            Package p = new Package();
            p.addQuestionData(args);
            b.putSerializable(PACKAGE, p);
            intent.putExtras(b);
            startActivity(intent);

        }*/

        // convert QNode to string to prevent crashing
        List<String[]> questionList = new ArrayList<String[]>();
        for (QNode qn : questions) {
            String[] args = {category, qn.getQuestion(),qn.getAnswer(), qn.getFalseAnswer1(), qn.getFalseAnswer2()};
            questionList.add(args);
        }

        Intent intent = new Intent(this, QuestionActivity.class);
        Bundle b = new Bundle();
        Package p = new Package(category, questionList);
        p.getQuestion(0);   // initial question
        b.putSerializable(PACKAGE, p);
        intent.putExtras(b);
        startActivity(intent);

    }
}
