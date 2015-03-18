package com.codepath.apps.mysimpletweets;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.astuetz.PagerSlidingTabStrip;
import com.codepath.apps.mysimpletweets.fragments.HomeTimelineFragment;
import com.codepath.apps.mysimpletweets.fragments.MentionsTimelineFragment;

public class TimelineActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);

        ViewPager vpPager = (ViewPager) findViewById(R.id.viewpager);
        vpPager.setAdapter(new TweetsPagerAdapter(getSupportFragmentManager()));
        PagerSlidingTabStrip tabStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabStrip.setViewPager(vpPager);

        setUpActionBar();
        //setupScrollListener();
    }

    private void setUpActionBar() {
        ActionBar actionBar = getActionBar();
        //actionBar.get
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_timeline, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    public void onProfileView(MenuItem mi) {
        Intent i = new Intent(this, ProfileActivity.class);
        startActivity(i);
    }

    public void onComposeView(MenuItem mi) {
        Intent tweetIntent = new Intent(this, ComposeActivity.class);
        //tweetIntent.setData(Uri.parse(fileUrl));
        startActivity(tweetIntent);
    }

    // Return the order of the fragments in the view pager.
    public class TweetsPagerAdapter extends FragmentPagerAdapter {
        private String tabTitles[] = {"Home", "Mentions"};

        public TweetsPagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new HomeTimelineFragment();
            } else if (position == 1) {
                return new MentionsTimelineFragment();
            } else {
                return null;
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles[position];
        }

        @Override
        public int getCount() {
            return tabTitles.length;
        }
    }

/*
    public void setupScrollListener() {
        lvTweets.setOnScrollListener(new EndlessScrollListener() {
            @Override
            public void onLoadMore(int page, int totalItemsCount) {
                customLoadMoreDataFromApi(page);
            }

            // Append more data into the adapter
            public void customLoadMoreDataFromApi(int offset) {
                // This method probably sends out a network request and appends new data items to your adapter.
                // Use the offset value and add it as a parameter to your API request to retrieve paginated data.
                // Deserialize API response and then construct new objects to append to the adapter
                if (isNetworkAvailable()) {
                    client.getHomeTimeline(new JsonHttpResponseHandler() {
                        @Override
                        public void onSuccess(int statusCode, Header[] headers, JSONArray json) {
                            Log.d("DEBUG", json.toString());
                            Log.d(">>>>>>>>>>>>>>>>>>", Integer.toString(tweets.size()));
                            aTweets.addAll(Tweet.fromJSONArray(json));
                        }

                        @Override
                        public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                            Log.d("DEBUG", errorResponse.toString());
                        }
                    });
                } else {
                    Toast.makeText(getApplicationContext(), "Internet connection unavailable. Cannot receive more results.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
*/
    private Boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

//    public void displayProfile(View v) {
//        Intent i = new Intent(v.getContext(), ProfileActivity.class);
//        TextView tvUserName = (TextView) findViewById(R.id.tvUserName);
//        String userName = tvUserName.getText().toString();
//        String strings[] = userName.split("@");
//        i.putExtra("screen_name", "@" + strings[1]);
//        startActivity(i);
//    }
}
