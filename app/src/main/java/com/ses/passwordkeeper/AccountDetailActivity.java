package com.ses.passwordkeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AccountDetailActivity extends AppCompatActivity {

    public static final String EXTRA_ACCOUNT_ID = "accountID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_detail);
    }

}
