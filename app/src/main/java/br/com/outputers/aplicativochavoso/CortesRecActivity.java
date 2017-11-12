package br.com.outputers.aplicativochavoso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class CortesRecActivity extends AppCompatActivity {

    // Criando os fields
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<AlbumCortes> arrayList = new ArrayList<>();


    // Vetor que guarda o caminho das faixas com o corte e sua descrição
    int[] img_id = {
            R.drawable.af_curto_1,R.drawable.af_curto_2,
            R.drawable.af_curto_3,R.drawable.af_curto_4,
            R.drawable.af_curto_5
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cortes_rec);

        //Instanciando
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new GridLayoutManager(this,1);// Quantidade por coluna
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        // Populando o ArrayList
        for(int id : img_id){

            arrayList.add(new AlbumCortes(id));
        }

        adapter = new RecyclerAdapter(this, arrayList);
        recyclerView.setAdapter(adapter);

    }
}