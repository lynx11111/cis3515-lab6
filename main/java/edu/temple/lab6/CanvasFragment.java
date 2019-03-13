package edu.temple.lab6;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;



public class CanvasFragment extends Fragment {

    private static final String ANDROID_COLORS = "android_colors";
    private static final String POSITION = "position";

    private String[] androidColors;
    private int position;

    public CanvasFragment() {

    }


    public static CanvasFragment newInstance(String[] androidColors, int position) {
        CanvasFragment fragment = new CanvasFragment();
        Bundle args = new Bundle();
        args.putStringArray(ANDROID_COLORS, androidColors);
        args.putInt(POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            androidColors = getArguments().getStringArray(ANDROID_COLORS);
            position = getArguments().getInt(POSITION);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_canvas, container, false);

        FrameLayout frameLayout = view.findViewById(R.id.canvas_background);
        frameLayout.setBackgroundColor(Color.parseColor(androidColors[this.position]));
        return view;
    }



    public void onColorSelected(int position){
        this.position = position;
        updateBackgroudColor();
    }


    private void updateBackgroudColor(){
        FrameLayout frameLayout = getView().findViewById(R.id.canvas_background);
        frameLayout.setBackgroundColor(Color.parseColor(androidColors[this.position]));
    }




}