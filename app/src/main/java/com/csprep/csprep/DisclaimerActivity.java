package com.csprep.csprep;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class DisclaimerActivity extends ActionBarActivity {
    String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disclaimer);

        // GET INTENT
        Intent intent = getIntent();
        this.message = intent.getStringExtra(MainMenuActivity.EXTRA_MESSAGE);

        // UPDATE TEXT HEADING
        TextView helpText = (TextView)findViewById(R.id.help_text);
        helpText.setText(this.message);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_help, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.return_to_previous_activity) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
