package org.hackucf.drunknights;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

public class DatabaseManager extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "drunKnights";

    public DatabaseManager(Context context){

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){

        String CREATE_TABLE_USER = "CREATE TABLE user (name TEXT, weight DOUBLE, isFemale INTEGER)";
        String CREATE_TABLE_DRINKS = "CREATE TABLE drinks(timestamp INTEGER PRIMARY KEY, name TEXT, alc_content REAL, size_oz REAL)";

        db.execSQL(CREATE_TABLE_USER);
        db.execSQL(CREATE_TABLE_DRINKS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS user");
        db.execSQL("DROP TABLE IF EXISTS drinks");

        // Create tables again
        onCreate(db);
    }

    public boolean hasUser(){

        SQLiteDatabase db = this.getReadableDatabase();

        int numEntries = db.query(false, "user", null, null, null, null, null, null, null).getCount();

        if(numEntries == 0) return false;

        return true;
    }
}
