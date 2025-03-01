package com.s22010154.mysolotravelerslmobileapplication;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Solotravelersl.db";
    public static final String TABLE_NAME = "Login_table"; //login table in database
    public static final String TABLE_NAME_PLANNER = "Trip_planner_table";  //Trip planner table in database
    // Columns for Login_table
    public static final String COL_1 = "name";
    public static final String COL_2 = "email";
    public static final String COL_3 = "password";

    //Columns for Trip_planner_table
    public static final String Plan_COL_1 = "ID";
    public static final String Plan_COL_2 = "Trip_name";
    public static final String Plan_COL_3 = "Destination";
    public static final String Plan_COL_4 = "Start_Date";
    public static final String Plan_COL_5 = "End_Date";
    public static final String Plan_COL_6 = "Notes";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 2
        );
    }
    @Override
    public void onCreate(SQLiteDatabase MyDatabase) {
        // Create Login_table
        MyDatabase.execSQL("CREATE TABLE " + TABLE_NAME + " (name TEXT, email TEXT PRIMARY KEY, password TEXT)");

        //Create Trip_planner_table
        MyDatabase.execSQL("CREATE TABLE " + TABLE_NAME_PLANNER + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "Trip_name TEXT, Destination TEXT, Start_Date TEXT, End_Date TEXT, Notes TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase MyDatabase, int oldVersion, int newVersion) {
        MyDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        MyDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_PLANNER);
        onCreate(MyDatabase); // Recreate the table after dropping
    }
    // Methods for interacting with Login_table
    public boolean insertData(String name, String email, String password) {
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, name);
        contentValues.put(COL_2, email);
        contentValues.put(COL_3, password);
        long results = MyDatabase.insert(TABLE_NAME, null, contentValues);
        return results != -1;
    }
    public Boolean checkEmail(String email) {
        SQLiteDatabase MyDatabase = this.getReadableDatabase();
        Cursor cursor = MyDatabase.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE email = ?", new String[]{email});
        boolean exists = (cursor.getCount() > 0);
        cursor.close();
        return exists;
    }
    public Boolean checkEmailPassword(String email, String password) {
        SQLiteDatabase MyDatabase = this.getReadableDatabase();
        Cursor cursor = MyDatabase.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE email = ? AND password = ?",
                new String[]{email, password});
        boolean valid = (cursor.getCount() > 0);
        cursor.close();
        return valid;
    }
    // Methods for interacting with Trip_planner_table
    public boolean insertDetails(String Trip_name, String Destination,
                                 String Start_Date, String End_Date, String Notes ) { //Creating insertData method
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Plan_COL_2, Trip_name);
        contentValues.put(Plan_COL_3, Destination);
        contentValues.put(Plan_COL_4, Start_Date);
        contentValues.put(Plan_COL_5, End_Date);
        contentValues.put(Plan_COL_6, Notes);
        long results = MyDatabase.insert(TABLE_NAME_PLANNER, null, contentValues);
        if (results == -1)
            return false;
        else
            return true;
    }
    public Cursor getAllData() {
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor results = MyDatabase.rawQuery("select * from " + TABLE_NAME_PLANNER, null);
        return results;
    }
    public boolean updateData(String Id, String Trip_name, String Destination,
                              String Start_Date, String End_Date, String Notes) {  // Create updateData method
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Plan_COL_1, Id);
        contentValues.put(Plan_COL_2, Trip_name);
        contentValues.put(Plan_COL_3, Destination);
        contentValues.put(Plan_COL_4, Start_Date);
        contentValues.put(Plan_COL_5, End_Date);
        contentValues.put(Plan_COL_6, Notes);
        MyDatabase.update(TABLE_NAME_PLANNER, contentValues, "Id = ?", new String[]{Id});
        return true;
    }
    public Integer deleteData(String Id) {  // Create deleteData() method
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        return MyDatabase.delete(TABLE_NAME_PLANNER, "Id = ?", new String[]{Id});
    }
}
