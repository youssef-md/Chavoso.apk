package br.com.outputers.aplicativochavoso;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static br.com.outputers.aplicativochavoso.Tab2TCabelo.TipoCabelo;


public class CuidadosActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Verificando o tipo de cabelo para relacionar a tela CuidadoCabelo
        if(TipoCabelo == "afro"){
            setContentView(R.layout.activity_cuidado_afro);
        }else if(TipoCabelo == "cacheado"){
            setContentView(R.layout.activity_cuidado_cacheado);
        }else if(TipoCabelo == "liso"){
            setContentView(R.layout.activity_cuidado_liso);
        }else if(TipoCabelo == "ondulado"){
            setContentView(R.layout.activity_cuidado_ondulado);
        }

    }

}
