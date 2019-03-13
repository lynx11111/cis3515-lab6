package edu.temple.lab6;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;



public class ColorAdapter extends BaseAdapter {
    private final Context mContext;


    private String[] androidColors;
    private String[] colorNames;


    public ColorAdapter(Context context, String[] androidColors, String[] colorNames){
        this.mContext = context;
        this.androidColors = androidColors;
        this.colorNames = colorNames;
    }


    @Override
    public int getCount(){
        return colorNames.length;
    }

    @Override
    public long getItemId(int position){
        return 0;
    }

    @Override
    public Object getItem(int position){
        return null;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        TextView colorTextView = new TextView(mContext);
        colorTextView.setText(colorNames[position]);
        colorTextView.setBackgroundColor(Color.parseColor(androidColors[position]));
        return colorTextView;
    }
}