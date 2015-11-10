package com.ses.passwordkeeper;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AccountDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "accountInfo";
    private static final int DB_VERSION = 1;

    AccountDatabaseHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        updateMyDatabase(db, 0, DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateMyDatabase(db, oldVersion, newVersion);
    }


    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion){

        if(oldVersion < 1){
            //create the table
            db.execSQL("CREATE TABLE Account ("
                    + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "NAME TEXT, "
                    + "LOGIN TEXT, "
                    + "PASSWORD TEXT, "
                    + "QUESTION_1 TEXT, "
                    + "QUESTION_2 TEXT, "
                    + "QUESTION_3 TEXT, "
                    + "NOTES TEXT);");

        }
    }
}
