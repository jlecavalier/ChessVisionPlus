package com.jaylecavalier.chessvisionplus;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.util.Log;

import com.jaylecavalier.chessvisionplus.R;

public class BoardAdapter extends BaseAdapter {
    private Context mContext;

    public BoardAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return mThumbIds[position];
    }

    public long getItemId(int position) {
        return position;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setAdjustViewBounds(true);
            final int p = position;
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String coord = itemIdToCoord(getItemId(p));
                    Log.d("HEY THERE:", coord);
                }
            });
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    // The items in our adapter are the squares of the board, and
    // each square has its own algebraic coordinate. This function
    // converts the integer id of a given square into that algebraic
    // coordinate, which must be given as a string since it contains
    // both letters and numbers.
    private String itemIdToCoord(long id) {
        // 97 is "a" in ascii, so we add the offset
        // to 97 to find the appropriate ascii letter for
        // the square we are looking at.
        int ascii = (int) ((id % 8) + 97);
        String letter = Character.toString((char) ascii);
        // The number of the square can be found by rounding down
        // the result of dividing by 8
        String number = Integer.toString((int) (8 - Math.floor(id / 8)));
        return letter + number;
    }

    // references to the images that make up the board, in order
    private Integer[] mThumbIds = {
            R.drawable.lightsquare, R.drawable.darksquare,
            R.drawable.lightsquare, R.drawable.darksquare,
            R.drawable.lightsquare, R.drawable.darksquare,
            R.drawable.lightsquare, R.drawable.darksquare,

            R.drawable.darksquare, R.drawable.lightsquare,
            R.drawable.darksquare, R.drawable.lightsquare,
            R.drawable.darksquare, R.drawable.lightsquare,
            R.drawable.darksquare, R.drawable.lightsquare,

            R.drawable.lightsquare, R.drawable.darksquare,
            R.drawable.lightsquare, R.drawable.darksquare,
            R.drawable.lightsquare, R.drawable.darksquare,
            R.drawable.lightsquare, R.drawable.darksquare,

            R.drawable.darksquare, R.drawable.lightsquare,
            R.drawable.darksquare, R.drawable.lightsquare,
            R.drawable.darksquare, R.drawable.lightsquare,
            R.drawable.darksquare, R.drawable.lightsquare,

            R.drawable.lightsquare, R.drawable.darksquare,
            R.drawable.lightsquare, R.drawable.darksquare,
            R.drawable.lightsquare, R.drawable.darksquare,
            R.drawable.lightsquare, R.drawable.darksquare,

            R.drawable.darksquare, R.drawable.lightsquare,
            R.drawable.darksquare, R.drawable.lightsquare,
            R.drawable.darksquare, R.drawable.lightsquare,
            R.drawable.darksquare, R.drawable.lightsquare,

            R.drawable.lightsquare, R.drawable.darksquare,
            R.drawable.lightsquare, R.drawable.darksquare,
            R.drawable.lightsquare, R.drawable.darksquare,
            R.drawable.lightsquare, R.drawable.darksquare,

            R.drawable.darksquare, R.drawable.lightsquare,
            R.drawable.darksquare, R.drawable.lightsquare,
            R.drawable.darksquare, R.drawable.lightsquare,
            R.drawable.darksquare, R.drawable.lightsquare,
    };
}