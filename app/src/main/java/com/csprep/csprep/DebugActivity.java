package com.csprep.csprep;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;


public class DebugActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
        // Get the message from the intent
        Intent intent = getIntent();
        this.message = intent.getStringArrayExtra(MainMenuActivity.EXTRA_MESSAGE);

        // Create the text view
        TextView chosenCategory = new TextView(this);
        chosenCategory.setTextSize(40);
        chosenCategory.setText(this.message[0]);  // TITLE

        // Set the text view as the activity layout
        setContentView(chosenCategory);
        */


        /*
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = new TextView(this);   // the activity will be the entire textview
        textView.setTextSize(40);
        textView.setText(message);  // TITLE
        setContentView(textView);
        */


        /*
        UserRecord userRecord = (UserRecord)getIntent().getSerializableExtra(NewAccountActivity.USER);


        TextView t = new TextView(this);
        t.setText(userRecord.getFirstName() + "\n" +
                  userRecord.getLastName() + "\n" +
                  userRecord.getEmail() + "\n" +
                  userRecord.getPassword());
        setContentView(t);
        */


        setContentView(R.layout.activity_debug);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_debug, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
