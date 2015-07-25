package com.csprep.csprep;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {
    public static final String EXTRA_MESSAGE = "com.csprep.MainActivity.MESSAGE";
    public static final String USER = "com.csprep.MainActivity.ser";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, MainMenuActivity.class);
        intent.putExtra(EXTRA_MESSAGE, "NO AUTHENTICATION");    // put user's name here instead of "Authenticated"
        startActivity(intent);
        finish();   // close this current activity because user should never use back arrow to access it again



        // save a file for testing purposes
        //Intent intent = new Intent(Intent.ACTION_VIEW);
        /*
        try {

            OutputStreamWriter out = new OutputStreamWriter(openFileOutput("TextFile.txt", MODE_APPEND));

            out.write("this is a test");
            out.write('\n');
            out.close();
            Toast.makeText(this, "The contents are saved in the file.", Toast.LENGTH_LONG).show();

        } catch (Throwable t) {

            Toast.makeText(this, "Exception: " + t.toString(), Toast.LENGTH_LONG).show();

        }*/



    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.close_app) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /** Called when the user clicks the Login button */
    public void logIn(View view) {

        Button button = (Button)view;
        String option = button.getText().toString();

        //ImageButton button = (ImageButton)view;
        //String option = button.getTransitionName();

        //if (option.compareTo("Guest") == 0) {
        if (option.compareTo("Start") == 0) {
            Intent intent = new Intent(this, MainMenuActivity.class);
            //Intent intent = new Intent(Intent.ACTION_VIEW);

            intent.putExtra(EXTRA_MESSAGE, "NO AUTHENTICATION");    // put user's name here instead of "Authenticated"
            startActivity(intent);
            finish();   // close this current activity because user should never use back arrow to access it again

            //AssetManager assetManager = getAssets();
            //InputStream input;
            //OutputStream output;
            //TextView t = (TextView)findViewById(R.id.test);

            //try {

                //File file = new File("android.resource://com.csprep.datastructure/assets/testpdf.pdf");

                /*
                if (file.isFile()) {
                    t.setText("a file");
                } else {
                    t.setText("not file");

                }*/

                /*
                String[] files = assetManager.list("");
                for (int i = 0; i < files.length;i++) {
                    if (files[i].compareTo("test.txt") == 0) {
                       // t.setText(files[i]);
                        break;
                    }
                }*/


                /*
                input = assetManager.open("testpdf.pdf");
                output = openFileOutput("testpdf.pdf", Context.MODE_PRIVATE);

                int size = input.available();
                byte[] buffer = new byte[size];
                int read = 0;
                //input.read(buffer);
                //output.write(buffer, 0, read);

                while((read = input.read(buffer)) != -1){
                    output.write(buffer, 0, read);
                }
                output.flush();
                input.close();
                output.close();
                input = null;
                output = null;


                File file = new File(getFilesDir(), "testpdf.pdf");
                file.delete();


                //if (file.isFile()) {
                //    t.setText("a file");
                //} else {
                //    t.setText("not file");
                //
                //}


                PdfRenderer renderer = new PdfRenderer(ParcelFileDescriptor.open(file, ParcelFileDescriptor.MODE_READ_ONLY));

                // let us just render all pages
                final int pageCount = renderer.getPageCount();
                Bitmap mBitmap = null;
                for (int i = 0; i < pageCount; i++) {
                    PdfRenderer.Page page = renderer.openPage(i);

                    // say we render for showing on the screen
                    page.render(mBitmap, null, null,  PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY);


                    ImageView image = (ImageView)findViewById(R.id.image);
                    image.setImageBitmap(mBitmap);


                    // close the page
                    page.close();
                }

                // close the renderer
                renderer.close();
                */



                /*
                intent.setDataAndType(
                        Uri.parse("file://" + getFilesDir() + "testpdf.pdf"),
                        "application/pdf");
                */


                /*
                intent.setDataAndType( Uri.fromFile(file), "application/pdf" );
                startActivity(intent);
                */


            //} catch (IOException e) {

            //}











        } else if (option.compareTo("Log In") == 0) {



            /*
            Intent intent = new Intent(this, DebugActivity.class);
            EditText editText = (EditText) findViewById(R.id.enter_username);
            String message = editText.getText().toString();
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
            */

        }





    }

    public void createNewAccount(View view) {
        Intent intent = new Intent(this, NewAccountActivity.class);
        intent.putExtra(EXTRA_MESSAGE, "New Account");
        startActivity(intent);
        finish();
    }
}
