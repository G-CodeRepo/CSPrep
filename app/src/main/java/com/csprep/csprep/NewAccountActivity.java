package com.csprep.csprep;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class NewAccountActivity extends ActionBarActivity {
    public static final String EXTRA_MESSAGE = "com.csprep.NewAccountActivity.MESSAGE";
    public static final String USER = "com.csprep.NewAccountActivity.ser";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_account);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_account, menu);
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

    public void backToSignInScreen(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(EXTRA_MESSAGE, "Login");
        startActivity(intent);
        finish();   // close current activity
    }

    public void enterMainMenu(View view) {
        EditText firstName          = (EditText) findViewById(R.id.first_name_text_edit);
        EditText lastName           = (EditText) findViewById(R.id.last_name_text_edit);
        EditText email              = (EditText) findViewById(R.id.email_text_edit);
        EditText password           = (EditText) findViewById(R.id.password_text_edit);
        EditText passwordConfirm    = (EditText) findViewById(R.id.confirm_password_text_edit);


        // check if password matches here




        // create new record
        UserRecord userRecord = new UserRecord(firstName.getText().toString(),
                                               lastName.getText().toString(),
                                               email.getText().toString(),
                                               password.getText().toString());

        Intent intent = new Intent(this, DebugActivity.class);
        Bundle b = new Bundle();
        b.putSerializable(USER, userRecord);
        intent.putExtras(b);
        startActivity(intent);


        /*
        Intent intent = new Intent(this, MainMenuActivity.class);
        intent.putExtra(EXTRA_MESSAGE, "Main Menu");
        startActivity(intent);
        */


        finish();   // close current activity
    }
}
