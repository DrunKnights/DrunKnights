package org.hackucf.drunknights;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class termsOfService extends AppCompatActivity {

    /** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_of_service);
    }

    /** Method for ToS Link */
    public void websiteToS(View view)
    {
        Intent websiteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drunknights.github.io/terms-of-service"));
        startActivity(websiteIntent);
    }

    /** Method for Privacy Link */
    public void websitePrivacy(View view)
    {
        Intent websiteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drunknights.github.io/privacy-policy"));
        startActivity(websiteIntent);
    }

    /** Method for Agree Button */
    public void agree(View view)
    {
        Intent i = new Intent(this, editUserInfo.class);
        startActivity(i);
    }
}