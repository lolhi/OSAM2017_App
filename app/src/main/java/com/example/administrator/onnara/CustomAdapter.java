package com.example.administrator.onnara;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Article>
{
    private Context context;
    private int layoutResourceId;
    private ArrayList<Article> articleData;

    public CustomAdapter(Context context, int layoutResourceId, ArrayList<Article> articleData) {
        super(context, layoutResourceId, articleData);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.articleData = articleData;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        View row = convertView;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId,parent,false);
        }
        TextView tvTitle = (TextView)row.findViewById(R.id.custom_row_textView1);
        TextView tvContent = (TextView)row.findViewById(R.id.custom_row_textView2);

        tvTitle.setText(articleData.get(position).getTitle());
        tvContent.setText(articleData.get(position).getWriter());

        return row;
    }


}
