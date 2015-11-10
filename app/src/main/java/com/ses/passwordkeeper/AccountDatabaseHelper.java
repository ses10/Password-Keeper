package com.ses.passwordkeeper;


import android.content.ContentValues;
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

    private static void insertAccount(SQLiteDatabase db, String name, String login,
                                      String Password, String QUESTION_1, String QUESTION_2, String QUESTION_3, String notes){

        ContentValues accountValues = new ContentValues();
        accountValues.put("NAME", name);
        accountValues.put("LOGIN", login);
        accountValues.put("PASSWORD", Password);
        accountValues.put("QUESTION_1", QUESTION_1);
        accountValues.put("QUESTION_2", QUESTION_2);
        accountValues.put("QUESTION_3", QUESTION_3);
        accountValues.put("NOTES", notes);
        db.insert("Account", null, accountValues);
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

            //insert test rows
            insertAccount(db,"Gmail", "sesma@gmail.com", "qwert1", "question1","question1","question1","notes");
            insertAccount(db,"Facebook", "dses10@aol.com", "zewbracakes", "what?","where?","why?","dfsa asdf aefw ads");
        }
    }
}
