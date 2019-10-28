package com.example.dramaclubpointsapp;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";
    private static final String DB_NAME = "PointsSubmissions";
    private static final String TABLE_NAME = "points_table";
    private static final String COL0 = "_id";           // unique ID for each element
    private static final String COL1 = "TIME_STAMP";
    private static final String COL2 = "FIRST_NAME";
    private static final String COL3 = "LAST_NAME";
    private static final String COL4 = "GRADE";
    private static final String COL5 = "PRODUCTION";
    private static final String COL6 = "MEMES";


    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTable = "CREATE TABLE "+ TABLE_NAME + " (" + COL0 + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL1 + " TEXT, "
                + COL2 + " TEXT, "
                + COL3 + " TEXT,"
                + COL4 + " TEXT,"
                + COL5 + " TEXT,"
                + COL6 + " TEXT);";

        Log.d(TAG, "onCreate: " + createTable);

        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        // show them how picky syntax is!!!  If even one space is missing query won't work!
        onCreate(db);
    }



    public boolean addData(String timeStamp, String first,String last, String grade, String production, String memes) {
        // This will get an object tor the database
        SQLiteDatabase db = this.getWritableDatabase();

        //this will help us write to the database.  Think of put as putting this element into this colomn of db
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, timeStamp);
        contentValues.put(COL2, first);
        contentValues.put(COL3, last);
        contentValues.put(COL4, grade);
        contentValues.put(COL5, production);
        contentValues.put(COL6, memes);

        // this will display info to help us in Logcat to see where we are
        Log.d(TAG, "addData: Adding " + timeStamp + " "
                + first + " " + last +  " "
                + grade + " " + production
                + " " + memes + " " + " to " + TABLE_NAME);

        // insert value into table.  Returns -1 if not successful
        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1)
            return false;       // didn't insert correctly
        else
            return true;        // successful add to table
    }

    /**
     * Returns all the data from the database
     * @return
     */

    public Cursor getData() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    /**
     * Returns only the ID that matches the name passed in
     * @param name
     * @return
     */

    public Cursor getItemID(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        // query is essentially saying
        // "select the id from the table where the name is equal to the name passed in"

        String query = "SELECT " + COL0 + " FROM " + TABLE_NAME + " WHERE " + COL1 +
                " = '" + name + "'";
        // Note there are single quotes around the name variable inside of double quotes
        Cursor data = db.rawQuery(query, null);
        return  data;
    }

    /**
     * Updates name field for database
     * @param newName
     * @param id
     * @param oldName
     */

    public void updateName(String newName, int id, String oldName) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + COL1 +
                " = '" + newName + "' WHERE " + COL0 + " = '" + id + "'" +
                " AND " + COL1 + " = '" + oldName + "'";

        Log.d(TAG, "updateName: query " + query);
        Log.d(TAG, "updateName: Setting name to " + newName);
        db.execSQL(query);
    }

    public void deleteName(int id, String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + TABLE_NAME + " WHERE " +
                COL0 + " = '" + id + "'" + " AND " + COL1 + " = '" + name + "'";
        Log.d(TAG, "deleteName: query " + query);
        Log.d(TAG, "deleteName: Deleting " + name + " from database");
        db.execSQL(query);



    }

}
