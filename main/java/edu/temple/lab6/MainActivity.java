package edu.temple.lab6;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity
        implements PaletteFragment.OnColorSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String[] androidColors = getResources().getStringArray(R.array.android_colors_array);
        final String[] colorNames = getResources().getStringArray(R.array.colors_array);

        PaletteFragment palleteFragment = PaletteFragment.newInstance(androidColors, colorNames);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.main_layout, palleteFragment)
                .commit();
    }

    @Override
    public void onColorSelected(int position) {
        final String[] androidColors = getResources().getStringArray(R.array.android_colors_array);
        CanvasFragment canvasFragment = CanvasFragment.newInstance(androidColors, position);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_layout, canvasFragment)
                .addToBackStack(null)
                .commit();
    }
}

