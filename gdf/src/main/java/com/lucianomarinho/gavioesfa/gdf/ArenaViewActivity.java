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

public class ArenaViewActivity extends ActionBarActivity {
    public int[] arenaImgs = {
            R.drawable.ic_arena_01,
            R.drawable.ic_arena_02,
            R.drawable.ic_arena_03,
            R.drawable.ic_arena_04,
            R.drawable.ic_arena_05,
            R.drawable.ic_arena_06
    };

    ShareActionProvider mShareActionProvider;
    private boolean fullscreen = true;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.arena_full_view);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Arena Corinthians Fã");

        Intent i = getIntent();
        int position = i.getExtras().getInt("position");

        ImageView iv = (ImageView) findViewById(R.id.arena_full_view);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleFullscreen(fullscreen);
                if(fullscreen == false) fullscreen = true;
                else fullscreen = false;
            }
        });
        Picasso.with(getApplicationContext())
                .load(arenaImgs[position])
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
        Uri imageUri = Uri.parse("android.resource://" + getPackageName() + "/drawable/" + arenaImgs[this.position]);
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, "Compartilhando uma arena do Timão");
        intent.putExtra(Intent.EXTRA_STREAM, imageUri);
        mShareActionProvider.setShareIntent(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                WallpaperManager wm = WallpaperManager.getInstance(this);
                try {
                    wm.setResource(arenaImgs[this.position]);
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
