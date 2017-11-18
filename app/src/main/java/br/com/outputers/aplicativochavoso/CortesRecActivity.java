package br.com.outputers.aplicativochavoso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class CortesRecActivity extends AppCompatActivity {

    // Criando os fields
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<AlbumCortes> arrayList = new ArrayList<>();


    String mTipoRosto = Tab1TRosto.getTipoRosto();
    String mTipoCabelo = Tab2TCabelo.getTipoCabelo();
    String mTamanhoCabelo = Tab3TamanhoC.getTamanhoCabelo();

    //Objet vetor do caminho das imagens não populado
    public int[] img_id = new int[]{};

    ImageButton buttonCuidados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //função para popular o vetor com base na combinação do usuário
        VerificarCombinacao();

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

        buttonCuidados = (ImageButton) findViewById(R.id.image_button_cuidados);
        buttonCuidados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentCuidados = new Intent(CortesRecActivity.this, CuidadosActivity.class);
                startActivity(intentCuidados);
            }
        });

    }

    private void VerificarCombinacao() {

        //Verificando as combinações e populando o vetor
        if(mTipoCabelo == "afro" && mTamanhoCabelo == "curto"){

            img_id = new int[]{
                    R.drawable.af_curto_1, R.drawable.af_curto_2,
                    R.drawable.af_curto_3, R.drawable.af_curto_4,
                    R.drawable.af_curto_5
            };
        }else if(mTipoCabelo == "afro" && mTamanhoCabelo == "medio"){

            img_id = new int[]{
                    R.drawable.af_medio_1, R.drawable.af_medio_2,
                    R.drawable.af_medio_3, R.drawable.af_medio_4,
                    R.drawable.af_medio_5
            };

        } else if(mTipoCabelo == "afro" && mTamanhoCabelo == "longo"){

            img_id = new int[]{
                    R.drawable.af_longo_1, R.drawable.af_longo_2,
                    R.drawable.af_longo_3,R.drawable.af_longo_4
            };

        }else if(mTipoCabelo == "cacheado" && mTamanhoCabelo == "curto"){

            img_id = new int[]{
                    R.drawable.cach_curto_1, R.drawable.cach_curto_2,
                    R.drawable.cach_curto_3, R.drawable.cach_curto_4
            };
        }else if(mTipoCabelo == "cacheado" && mTamanhoCabelo == "medio"){
            img_id = new int[]{
                    R.drawable.cach_medio_1, R.drawable.cach_medio_2,
                    R.drawable.cach_medio_3, R.drawable.cach_medio_4
            };
        }

    }

}