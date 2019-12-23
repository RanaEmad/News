package com.example.android.news;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.app.usage.UsageEvents;
import android.os.AsyncTask;
import android.os.Bundle;
import android.service.autofill.FillEventHistory;
import android.util.EventLog;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<News>> {

    private static final String REQUEST_URL ="https://content.guardianapis.com/search?api-key=test";

    private Adapter adapter;

    private TextView emptyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView= findViewById(R.id.list);

        this.emptyView= findViewById(R.id.empty_view);

        listView.setEmptyView(this.emptyView);

        this.adapter= new Adapter(this, new ArrayList<News>());

        listView.setAdapter(this.adapter);


    }

    @Override
    public void onLoaderReset(@NonNull Loader<List<News>> loader) {

    }

    @Override
    public void onLoadFinished(@NonNull Loader<List<News>> loader, List<News> data) {

    }

    @NonNull
    @Override
    public Loader<List<News>> onCreateLoader(int id, @Nullable Bundle args) {
        return null;
    }

    private class NewsAsyncTask extends AsyncTask<String,Void,List<News>>{
        @Override
        protected List<News> doInBackground(String... urls){
            if (urls.length < 1 || urls[0] == null) {
                return null;
            }

            List<News> result = QueryUtils.fetchNewsData(urls[0]);
            return result;
        }

        @Override
        protected void onPostExecute(List<News> data){
            adapter.clear();
            if(data !=null && !data.isEmpty()){
                adapter.addAll(data);
            }
        }

    }//end NewsAsyncTask




}