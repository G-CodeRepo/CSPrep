package com.csprep.csprep;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class SettingsActivity extends ActionBarActivity {
    public static final String EXTRA_MESSAGE = "com.csprep.SettingsActivity.MESSAGE";
    static final String STATE_LANGUAGE = "";
    static final String STATE_DIFFICULTY = "";
    int currentLanguage;
    int currentDifficulty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Check whether we're recreating a previously destroyed instance
        if (savedInstanceState != null) {
            // Restore value of members from saved state
            this.currentLanguage = savedInstanceState.getInt(STATE_LANGUAGE);
            this.currentDifficulty = savedInstanceState.getInt(STATE_DIFFICULTY);
        } else {
            // Probably initialize members with default values for a new instance
        }
        setContentView(R.layout.activity_settings);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return true;
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
            return true;
        }
        return super.onOptionsItemSelected(item);
        */
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_main:
                exitFromSettings();
                return true;

            // ADD MORE CASES IF INTENDING TO HAVE MORE MENU ITEMS
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Log out of session (go back to log in screen)
     */
    public void exitFromSettings() {
        /*
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(EXTRA_MESSAGE, "LOGIN");
        startActivity(intent);
        finishAffinity();   // close all activity (including the parent of this child)
        */
        finish();
    }

    /**
     * Save settings
     * @param view
     */
    public void saveSettings(View view) {
        // SAVE SETTINGS HERE THEN GO BACK TO MAIN



        // CODE NOT YET IMPLEMENTED

        Toast.makeText(getApplicationContext(), "Settings Saved", Toast.LENGTH_SHORT).show();
        finish();   // close activity
    }

    /**
     * Cancel changes made in settings
     * @param view
     */
    public void cancelSettings(View view) {
        Toast.makeText(getApplicationContext(), "Settings Not Saved", Toast.LENGTH_SHORT).show();
        finish();   // close activity without doing anything
    }
}
