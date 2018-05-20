package com.lucianomarinho.gavioesfa.gdf;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.squareup.picasso.Picasso;

import static android.widget.ImageView.ScaleType.CENTER_CROP;

public class WallpapersGridViewAdapter extends BaseAdapter {
    private Context context = null;

    public WallpapersGridViewAdapter(Context context) {
        this.context = context;
    }

    public int[] wallpapersImgs = {
            R.drawable.ic_wallpapers_01,
            R.drawable.ic_wallpapers_02,
            R.drawable.ic_wallpapers_03,
            R.drawable.ic_wallpapers_04,
            R.drawable.ic_wallpapers_05,
            R.drawable.ic_wallpapers_06,
            R.drawable.ic_wallpapers_07,
            R.drawable.ic_wallpapers_08,
            R.drawable.ic_wallpapers_09,
            R.drawable.ic_wallpapers_10,
            R.drawable.ic_wallpapers_11,
            R.drawable.ic_wallpapers_12,
            R.drawable.ic_wallpapers_13,
            R.drawable.ic_wallpapers_14,
            R.drawable.ic_wallpapers_15,
            R.drawable.ic_wallpapers_16,
            R.drawable.ic_wallpapers_17,
            R.drawable.ic_wallpapers_18,
            R.drawable.ic_wallpapers_19,
            R.drawable.ic_wallpapers_20,
            R.drawable.ic_wallpapers_21,
            R.drawable.ic_wallpapers_22,
            R.drawable.ic_wallpapers_23,
            R.drawable.ic_wallpapers_24,
            R.drawable.ic_wallpapers_25,
            R.drawable.ic_wallpapers_26,
            R.drawable.ic_wallpapers_27,
            R.drawable.ic_wallpapers_28,
            R.drawable.ic_wallpapers_29,
            R.drawable.ic_wallpapers_30,
            R.drawable.ic_wallpapers_31,
            R.drawable.ic_wallpapers_32,
            R.drawable.ic_wallpapers_33,
            R.drawable.ic_wallpapers_34,
            R.drawable.ic_wallpapers_35,
            R.drawable.ic_wallpapers_36,
            R.drawable.ic_wallpapers_37,
            R.drawable.ic_wallpapers_38,
            R.drawable.ic_wallpapers_39,
            R.drawable.ic_wallpapers_40,
            R.drawable.ic_wallpapers_41,
            R.drawable.ic_wallpapers_42,
            R.drawable.ic_wallpapers_43,
            R.drawable.ic_wallpapers_44,
            R.drawable.ic_wallpapers_45,
            R.drawable.ic_wallpapers_46,
            R.drawable.ic_wallpapers_47,
            R.drawable.ic_wallpapers_48,
            R.drawable.ic_wallpapers_49,
            R.drawable.ic_wallpapers_50
    };

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SquaredImageView view = (SquaredImageView) convertView;
        if (view == null) {
            view = new SquaredImageView(context);
            view.setScaleType(CENTER_CROP);
        }

        Picasso.with(this.context)
                .load(wallpapersImgs[position])
                .placeholder(R.drawable.ic_placeholder)
                .error(R.drawable.ic_error)
                .fit()
                .into(view);

        return view;
    }

    @Override
    public int getCount() {
        return wallpapersImgs.length;
    }

    @Override
    public Object getItem(int arg0) {
        return null;
    }

    @Override
    public long getItemId(int arg0) {
        return 0;
    }
}