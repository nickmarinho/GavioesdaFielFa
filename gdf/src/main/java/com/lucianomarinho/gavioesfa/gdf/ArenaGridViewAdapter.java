package com.lucianomarinho.gavioesfa.gdf;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;

import com.squareup.picasso.Picasso;

import static android.widget.ImageView.ScaleType.CENTER_CROP;

public class ArenaGridViewAdapter extends BaseAdapter {
    private Context context = null;

    public ArenaGridViewAdapter(Context context) {
        this.context = context;
    }

    public int[] arenaImgs = {
            R.drawable.ic_arena_01,
            R.drawable.ic_arena_02,
            R.drawable.ic_arena_03,
            R.drawable.ic_arena_04,
            R.drawable.ic_arena_05,
            R.drawable.ic_arena_06
    };

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SquaredImageView view = (SquaredImageView) convertView;
        if (view == null) {
            view = new SquaredImageView(context);
            view.setScaleType(CENTER_CROP);
        }

        Picasso.with(this.context)
                .load(arenaImgs[position])
                .placeholder(R.drawable.ic_placeholder)
                .error(R.drawable.ic_error)
                .fit()
                .into(view);

        return view;
    }

    @Override
    public int getCount() {
        return arenaImgs.length;
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