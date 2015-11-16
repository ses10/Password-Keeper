package com.ses.passwordkeeper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class AccountListFragment extends android.support.v4.app.ListFragment {

    private SQLiteDatabase db;
    private Cursor cursor;

    static interface AccountListListener {
        void itemClicked(long id);
    }

    private AccountListListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //create cursor and open database
        try {

            SQLiteOpenHelper accountDatabaseHelper = new AccountDatabaseHelper(inflater.getContext());
            db = accountDatabaseHelper.getReadableDatabase();

            cursor = db.query("Account", new String[]{"_id", "NAME"}, null, null, null, null, null);

            CursorAdapter listAdapter = new SimpleCursorAdapter(inflater.getContext(),
                                                                android.R.layout.simple_list_item_1,
                                                                cursor,
                                                                new String[] {"NAME"},
                                                                new int[] {android.R.id.text1}, 0);

            setListAdapter(listAdapter);

        } catch (SQLiteException e){
            Toast toast = Toast.makeText(inflater.getContext(), "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener = (AccountListListener)context;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        if (listener != null){
            listener.itemClicked(id);
        }
    }
}
