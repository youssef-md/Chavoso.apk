package br.com.outputers.aplicativochavoso;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



public class CuidadosActivity extends AppCompatActivity {

    SharedPreferences CadastroPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        CadastroPreferences = getSharedPreferences("cadastro",Context.MODE_PRIVATE);

        String mTipoCabelo = CadastroPreferences.getString("tipo_cabelo", "nao");

        //Verificando o tipo de cabelo para relacionar a tela CuidadoCabelo
        switch (mTipoCabelo) {
            case "afro":
                setContentView(R.layout.activity_cuidado_afro);
                break;
            case "cacheado":
                setContentView(R.layout.activity_cuidado_cacheado);
                break;
            case "liso":
                setContentView(R.layout.activity_cuidado_liso);
                break;
            case "ondulado":
                setContentView(R.layout.activity_cuidado_ondulado);
                break;
        }
    }
}
