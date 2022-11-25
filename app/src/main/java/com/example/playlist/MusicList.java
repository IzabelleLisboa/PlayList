package com.example.playlist;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;


public class MusicList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_list);

        ListView listaMusicas = (ListView) findViewById(R.id.lista);
        final ArrayList<Albuns> al = adicionaMusicas();
        ArrayAdapter adapter = new AlbunsAdapter(this,al);
        listaMusicas.setAdapter(adapter);
        listaMusicas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               // Toast.makeText(getBaseContext(),"Item clicado"+al.get(i).getNome(), Toast.LENGTH_LONG).show();
                //passagem de parâmetros para a activity destino
                Intent it = new Intent(MusicList.this,Reproduzir.class);
                it.putExtra("musica",al.get(i).getMusica());
                it.putExtra("Nome",al.get(i).getMusica());
                startActivity(it);
                finish();
            }
        });

    }
    private ArrayList<Albuns> adicionaMusicas(){
        ArrayList<Albuns> arr = new ArrayList<Albuns>();
        Albuns a = new Albuns("Avicii",R.drawable.avicii,"wakemeup","Tour 2013");
        arr.add(a);
        a = new Albuns("Xutos & Pontapés",R.drawable.img,"casinha","Tour 2000");
        arr.add(a);
        a = new Albuns("Meduza",R.drawable.meduza2,"badmemories","Tour 2022");
        arr.add(a);
        a = new Albuns("Vintage Culture",R.drawable.vintage,"underthesunv","Ibiza 2022");
        arr.add(a);
        return arr;
    }
}