package com.example.kanishkaranu.newsshare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONObject;

import java.util.List;

public class CustomAdapter extends BaseAdapter {
    List<Articles> lstArticles=null;
    final Context context;

    public CustomAdapter(Context context, List<Articles> articles) {
        this.context = context;
        this.lstArticles=articles;
    }


    @Override
    public int getCount() {
        if(lstArticles==null || lstArticles.size()==0) {
            return -1;
        }
        return lstArticles.size();
    }

    @Override
    public Object getItem(int position) {
        if(lstArticles==null || lstArticles.size()==0) {
            return null;
        }
        return lstArticles.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v=convertView;
        if(v==null)
        {
            LayoutInflater li=LayoutInflater.from(context);
            v=  li.inflate(R.layout.item_layout,parent,false);
            Articles artobj=lstArticles.get(position);

           TextView tv1=v.findViewById(R.id.author);
            tv1.setText(lstArticles.get(position).getAuthor());

           TextView tv7=v.findViewById(R.id.title);
           tv7.setText(lstArticles.get(position).getTitle());


            TextView tv3=v.findViewById(R.id.url);
            tv3.setText(lstArticles.get(position).getUrl());

            TextView tv2=v.findViewById(R.id.description);
            tv2.setText(lstArticles.get(position).getDescription());


            TextView tv4=v.findViewById(R.id.urlToImage);
            tv4.setText(lstArticles.get(position).getUrlToImage());

            TextView tv5=v.findViewById(R.id.publishedAt);
            tv5.setText(lstArticles.get(position).getPublishedAt());

            TextView tv6=v.findViewById(R.id.content);
            tv6.setText(lstArticles.get(position).getContent());




        }
        return v;
    }
}

