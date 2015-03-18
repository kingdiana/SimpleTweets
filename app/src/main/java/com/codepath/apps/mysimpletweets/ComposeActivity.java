package com.codepath.apps.mysimpletweets;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;

public class ComposeActivity extends ActionBarActivity {
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    public void displayProfile(View v) {
        Intent i = new Intent(v.getContext(), ProfileActivity.class);
        startActivity(i);
    }
}
