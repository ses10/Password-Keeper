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

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
