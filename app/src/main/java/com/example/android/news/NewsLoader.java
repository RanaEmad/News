package com.example.android.news;

import android.content.Context;

import androidx.loader.content.AsyncTaskLoader;

import java.util.List;


public class NewsLoader extends AsyncTaskLoader<List<News>> {

    /** Query URL */
    private String url;


    public NewsLoader(Context context, String url) {
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