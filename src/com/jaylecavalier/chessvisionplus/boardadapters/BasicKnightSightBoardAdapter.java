/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaylecavalier.chessvisionplus.boardadapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.jaylecavalier.chessvisionplus.BasicKnightSightActivity;
import com.jaylecavalier.chessvisionplus.R;

/**
 *
 * @author jay
 */
public class BasicKnightSightBoardAdapter extends BaseAdapter {
    private final Context mContext;
    private final LayoutInflater mInflater;
    private String[] pieces;
    
    static class ViewHolder {
        public ImageView square;
        public ImageView piece;
    }

    /**
     *
     * @param c
     * @param newPieces
     */
    public BasicKnightSightBoardAdapter(Context c, String[] newPieces) {
        mContext = c;
        mInflater = LayoutInflater.from(c);
        pieces = newPieces;
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
        View squareView;
        // check whether view is recycled or not
        if (convertView == null) {
            
            // Inflate the squareView to the square layout so
            // we can have both a background and a piece.
            squareView = mInflater.inflate(R.layout.square, null);
            
            // Now, initialize some attributes
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.square = (ImageView) squareView.findViewById(R.id.square_background);
            viewHolder.piece = (ImageView) squareView.findViewById(R.id.piece);
            viewHolder.square.setImageResource(mThumbIds[position]);
            viewHolder.square.setScaleType(ImageView.ScaleType.FIT_XY);
            viewHolder.square.setAdjustViewBounds(true);
            viewHolder.piece.setImageResource(R.drawable.whiteknight);
            viewHolder.piece.setScaleType(ImageView.ScaleType.FIT_XY);
            viewHolder.piece.setAdjustViewBounds(true);

            // These need to be final in order for us to use them
            // with our new OnClickListener we will potentially create
            final int f_position = position;
            final View f_squareView = squareView;

            // Set the OnClick Listener for the square
            squareView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // If we are in the default activity
                    if(mContext instanceof BasicKnightSightActivity){
                        // Convert the id of the tapped square into the
                        // name of the square as a string
                        String coord = itemIdToCoord(getItemId(f_position));
                        // Tell the user whether or not she guessed correctly
                        ((BasicKnightSightActivity) mContext).displayTapped(coord, f_squareView, f_position);
                    }
                }
            });

        // If it is recycled, then just use the view we've already created
        } else {
            squareView = (View) convertView;
        }
        
        return squareView;
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
