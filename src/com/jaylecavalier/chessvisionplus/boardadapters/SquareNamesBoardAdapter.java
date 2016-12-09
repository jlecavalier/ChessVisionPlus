package com.jaylecavalier.chessvisionplus.boardadapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.util.Log;
import android.widget.TextView;

import com.jaylecavalier.chessvisionplus.R;
import com.jaylecavalier.chessvisionplus.R;
import com.jaylecavalier.chessvisionplus.SquareNamesActivity;

public class SquareNamesBoardAdapter extends BaseAdapter {
    private Context mContext;

    /**
     *
     * @param c
     */
    public SquareNamesBoardAdapter(Context c) {
        mContext = c;
    }

    /**
     *
     * @return
     */
    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    /**
     *
     * @param position
     * @return
     */
    @Override
    public Object getItem(int position) {
        return mThumbIds[position];
    }

    /**
     *
     * @param position
     * @return
     */
    public long getItemId(int position) {
        return position;
    }

    /**
     *
     * @param position
     * @return
     */
    public int getImage(int position) {
        return mThumbIds[position];
    }

    // create a new ImageView for each item referenced by the Adapter

    /**
     *
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {

            // These need to be final in order for us to use them
            // with our new OnClickListener we will potentially create
            final int f_position = position;
            final ViewGroup f_parent = parent;

            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setAdjustViewBounds(true);

            final ImageView f_imageView = imageView;

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // If we are in the default activity
                    if(mContext instanceof SquareNamesActivity){
                        // Convert the id of the tapped square into the
                        // name of the square as a string
                        String coord = itemIdToCoord(getItemId(f_position));
                        // Tell the user whether or not she guessed correctly
                        ((SquareNamesActivity) mContext).checkIfCorrect(coord, f_imageView, f_position);
                    }
                    //Log.d("Square Tapped: ", coord);
                }
            });

        // If it is recycled, then just use the view we've already created
        } else {
            imageView = (ImageView) convertView;
        }

        // Get the correct square image
        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    // The items in our adapter are the squares of the board, and
    // each square has its own algebraic coordinate. This function
    // converts the integer id of a given square into that algebraic
    // coordinate, which must be given as a string since it contains
    // both letters and numbers.

    /**
     *
     * @param id
     * @return
     */
    public String itemIdToCoord(long id) {
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
    private final Integer[] mThumbIds = {
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