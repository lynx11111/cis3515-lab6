package edu.temple.lab6;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Spinner;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;

public class PaletteFragment extends Fragment {

    private static final String ANDROID_COLORS = "android_colors";
    private static final String COLOR_NAMES = "color_names";


    private String[] androidColors;
    private String[] colorNames;


    OnColorSelectedListener mCallback;


    public PaletteFragment() {

    }


    public static PaletteFragment newInstance(String[] androidColors, String[] colorNames) {

        PaletteFragment fragment = new PaletteFragment();
        Bundle args = new Bundle();


        args.putStringArray(ANDROID_COLORS, androidColors);
        args.putStringArray(COLOR_NAMES, colorNames);


        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {

            androidColors = getArguments().getStringArray(ANDROID_COLORS);
            colorNames = getArguments().getStringArray(COLOR_NAMES);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_palette, container, false);
        Spinner spinner = view.findViewById(R.id.spinner);

        spinner.setAdapter(new ColorAdapter(getActivity(), androidColors, colorNames));
        spinner.setSelection(0,false);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected (AdapterView<?> adapterView, View view, int position, long id){

                mCallback.onColorSelected(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView){

            }
        } );

        return view;
    }


    public interface OnColorSelectedListener {
        void onColorSelected(int position);
    }

    public void onAttach(Context context) {
        super.onAttach(context);


        try {
            mCallback = (OnColorSelectedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnColorSelectedListener");
        }
    }

}

