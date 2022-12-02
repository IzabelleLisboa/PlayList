package com.example.playlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class Video extends AppCompatActivity {
    private int position =0;
    private VideoView vp;
    private MediaController mediaController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        //obter informações por parâmetro
       vp=(VideoView) findViewById(R.id.videoView);
        if (mediaController == null) {
            mediaController = new MediaController(Video.this);
            mediaController.setAnchorView(vp);
            vp.setMediaController(mediaController);
        }
        try {
            int id = getRawResIdByName("link");
            vp.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + id));
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        vp.requestFocus();
        vp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                vp.seekTo(position);
                if (position==0){
                    vp.start();
                }
                mediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i1) {
                        mediaController.setAnchorView(vp);
                    }
                });
            }
        });
    }

    private int getRawResIdByName(String resName) {
        String pkgName = this.getPackageName();
        int resID = this.getResources().getIdentifier(resName, "raw", pkgName);
        Log.i("AndroidVideoView", "Res Name: " + resName + "==> Res ID = " + resID);
        return resID;
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("CurrentPosition",vp.getCurrentPosition());
        vp.pause();
    }
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        position=savedInstanceState.getInt("CurrentPosition");
        vp.seekTo(position);

    }
    public void  Voltar(View v){
        Intent it = new Intent(Video.this,Menu.class);
        startActivity(it);
        finish();
    }
}




