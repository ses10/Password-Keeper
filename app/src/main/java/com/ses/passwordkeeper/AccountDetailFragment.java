package com.ses.passwordkeeper;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

public class AccountDetailFragment extends Fragment {

    private int accountId;
    private SQLiteDatabase db;
    private Cursor cursor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account_detail, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        View view = getView();

        //query database for accountId
        try {

            SQLiteOpenHelper accountDatabaseHelper = new AccountDatabaseHelper(view.getContext());
            db = accountDatabaseHelper.getReadableDatabase();

            cursor = db.query("Account",
                    new String[]{"NAME"},
                    "_id = ?",
                    new String[]{Integer.toString(accountId)},
                    null, null, null);


            cursor.moveToFirst();

        } catch (SQLiteException e){
            Toast toast = Toast.makeText(view.getContext(), "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }

        EditText loginField = (EditText) view.findViewById(R.id.loginField);
        loginField.setText(cursor.getString(0));

    }

    public void setAccountId(int id){
        this.accountId = id;
    }
}
