package com.codepath.apps.mysimpletweets;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

public class MyActionBarActivity extends ActionBarActivity {
    public void displayProfile(View v) {
        Intent i = new Intent(v.getContext(), ProfileActivity.class);
        startActivity(i);
    }
}
