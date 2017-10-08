package org.hackucf.drunknights;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.ContentValues;
import android.widget.EditText;
import android.widget.RadioButton;
import android.view.View;
import android.util.Log;

public class editUserInfo extends AppCompatActivity {

    public void editUser(View view){

        DatabaseManager dbManager = new DatabaseManager(this);
        SQLiteDatabase db = dbManager.getWritableDatabase();


        ContentValues values = new ContentValues();
        EditText nameET = (EditText)findViewById(R.id.name_field);
        EditText weightET = (EditText)findViewById(R.id.weight_field);
        RadioButton sexRB = (RadioButton)findViewById(R.id.Female);

        values.put("name", nameET.getText().toString());
        values.put("weight", Integer.parseInt(weightET.getText().toString()));
        values.put("isFemale", Boolean.parseBoolean(sexRB.getText().toString()));

        if(!dbManager.hasUser()){ db.insert("user", null, values); }

        else{

            db.update("user", values, null, null);
        }

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user_info);
    }


}