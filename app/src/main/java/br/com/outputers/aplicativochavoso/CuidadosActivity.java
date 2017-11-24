package br.com.outputers.aplicativochavoso;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class CuidadosActivity extends AppCompatActivity {

    //pegando a variável estatica TipoCabelo
    String mTipoCabelo = Tab2TCabelo.TipoCabelo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Verificando o tipo de cabelo para relacionar a tela CuidadoCabelo
        if(mTipoCabelo == "afro"){
            setContentView(R.layout.activity_cuidado_afro);
        }else if(mTipoCabelo == "cacheado"){
            setContentView(R.layout.activity_cuidado_cacheado);
        }

    }

}
