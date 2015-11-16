package com.ses.passwordkeeper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements AccountListFragment.AccountListListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //implement AccountListListener.itemClicked
    @Override
    public void itemClicked(long id) {
        Intent intent = new Intent(this, AccountDetailActivity.class);
        intent.putExtra(AccountDetailActivity.EXTRA_ACCOUNT_ID, (int)id);
        startActivity(intent);
    }
}
