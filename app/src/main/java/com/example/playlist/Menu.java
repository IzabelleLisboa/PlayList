package com.example.playlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    public void  irparamusica(View v){
        Intent it = new Intent(Menu.this,MusicList.class);
        startActivity(it);
        finish();
    }
    public void  irparavideo(View v){
        Intent it = new Intent(Menu.this,Video.class);
        startActivity(it);
        finish();
    }
    public void  Sair(View v){
        finish();
    }
}