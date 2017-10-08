package org.hackucf.drunknights;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        DatabaseManager dbManager = new DatabaseManager(this);

        // If no user exists, start ToS Activity
        if(!dbManager.hasUser())
        {
            dbManager.close();

            Intent intent = new Intent(this, termsOfService.class);
            startActivity(intent);
        }
    }

    // Method to open user profile on click from main activityq
    public void openProfile(View view) {
        Intent i = new Intent(this, editUserInfo.class);
        startActivity(i);
    }

    // Method to open user history on click from main activity
    public void addDrink(View view) {
        Intent i = new Intent(this, addDrink.class);
        startActivity(i);
    }

    // Method to open About on click from main activity
    public void openAbout(View view) {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drunknights.github.io/"));
        startActivity(i);
    }
}