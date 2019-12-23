package com.example.android.news;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;


public class Loader extends AsyncTaskLoader<List<News>> {

    /** Query URL */
    private String url;


    public Loader(Context context, String url) {
        super(context);
        this.url = url;
    }


    @Override
    protected void onStartLoading() {
        forceLoad();
    }


    /**
     * This is on a background thread.
     */
    @Override
    public List<News> loadInBackground() {
        List<News> news = QueryUtils.fetchNewsData(this.url);
        return news;
    }
}