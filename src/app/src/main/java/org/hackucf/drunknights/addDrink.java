package org.hackucf.drunknights;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.List;
import org.hackucf.drunknights.LCBOAPI;
import android.util.Log;

public class addDrink extends AppCompatActivity {

    public void searchDrink(View view){

        EditText searchET = (EditText)findViewById(R.id.searchText);
        ArrayList<String> searches = new ArrayList<String>();
        searches.add(searchET.getText().toString());
        Log.d("addDrink", searches.toString());
        new LCBOAPI().execute(searches);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_drink);
    }
}
