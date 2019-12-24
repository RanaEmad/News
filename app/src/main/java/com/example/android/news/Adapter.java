package com.example.android.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Adapter extends ArrayAdapter<News> {

    public Adapter(Context context, ArrayList<News> news){
        super(context,0,news);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent,false);
        }
        News currentNews= getItem(position);
        TextView titleView= convertView.findViewById(R.id.title);
        titleView.setText(currentNews.getTitle());

        TextView sectionView= convertView.findViewById(R.id.section);
        sectionView.setText(currentNews.getSection());

        TextView authorView= convertView.findViewById(R.id.author);
        if("".equals(currentNews.getAuthor())){
            authorView.setVisibility(View.GONE);
        }
        else{
            authorView.setText(currentNews.getAuthor());
        }

        TextView datePublishedView= convertView.findViewById(R.id.datePublished);
        datePublishedView.setText(currentNews.getDatePublished());

        return convertView;
    }
}
