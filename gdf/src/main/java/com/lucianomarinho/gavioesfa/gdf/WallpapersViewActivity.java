package com.lucianomarinho.gavioesfa.gdf;

import android.app.ActionBar;
import android.app.WallpaperManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;

public class WallpapersViewActivity extends ActionBarActivity {
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

    ShareActionProvider mShareActionProvider;
    private boolean fullscreen = true;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wallpapers_full_view);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Wallpapers Corinthians Fã");

        Intent i = getIntent();
        int position = i.getExtras().getInt("position");
        this.position = position;

        ImageView iv = (ImageView) findViewById(R.id.wallpapers_full_view);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleFullscreen(fullscreen);
                if(fullscreen == false) fullscreen = true;
                else fullscreen = false;
            }
        });
        Picasso.with(getApplicationContext())
                .load(wallpapersImgs[position])
                .placeholder(R.drawable.ic_placeholder)
                .error(R.drawable.ic_error)
                .fit()
                .centerCrop()
                .into(iv);
    }

    private void toggleFullscreen(boolean fullscreen){
        WindowManager.LayoutParams wm = getWindow().getAttributes();
        ActionBar actionBar = getActionBar();

        if (fullscreen) {
            wm.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
            actionBar.hide();
        } else {
            wm.flags &= ~WindowManager.LayoutParams.FLAG_FULLSCREEN;
            actionBar.show();
        }
        getWindow().setAttributes(wm);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_image_actions, menu);
        MenuItem shareItem = menu.findItem(R.id.action_share);
        mShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(shareItem);
        setShareIntent();
        return true;
    }

    private void setShareIntent(){
        Uri imageUri = Uri.parse("android.resource://" + getPackageName() + "/drawable/" + wallpapersImgs[this.position]);
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, "Compartilhando um wallpaper do Timão");
        intent.putExtra(Intent.EXTRA_STREAM, imageUri);
        mShareActionProvider.setShareIntent(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                WallpaperManager wm = WallpaperManager.getInstance(this);
                try {
                    wm.setResource(wallpapersImgs[this.position]);
                    Toast.makeText(this, "Plano de Fundo Modificado",Toast.LENGTH_SHORT).show();
                } catch(IOException e) {
                    Toast.makeText(this, "Plano de Fundo Não Alterado",Toast.LENGTH_SHORT).show();
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
