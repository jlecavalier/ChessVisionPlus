package com.jaylecavalier.chessvisionplus;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

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
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setAdjustViewBounds(true);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    // references to our images
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