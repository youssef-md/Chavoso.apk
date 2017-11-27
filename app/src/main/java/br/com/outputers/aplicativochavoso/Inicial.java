package br.com.outputers.aplicativochavoso;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import static br.com.outputers.aplicativochavoso.R.id.entrar_image_button;

public class Inicial extends AppCompatActivity {

    ImageButton btnTelaInicial;

    CadastroDAO cadastroDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicial2);


        cadastroDAO = new CadastroDAO(this);// correção do null "Attempt to invoke virtual method..."

        String cadastrou = cadastroDAO.getDataCadastrou();
        cadastroDAO.close(); // fechando o DAO

        if(cadastrou.equals("sim")) {
            intentEntrar2Vez(); // Caso o usuário já seja cadastrado
        }

        btnTelaInicial = (ImageButton) findViewById(R.id.entrar_image_button);
        btnTelaInicial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                intentEntrar1Vez();
            }
        }) ;
    }

    private void intentEntrar2Vez() {

        Intent intentCortesRect = new Intent(Inicial.this, TelaInicial2vez.class);
        startActivity(intentCortesRect);
        finish();
    }

    public void intentEntrar1Vez(){

        Intent intentEntrar = new Intent(Inicial.this, AttCaractActivity.class);
        startActivity(intentEntrar);
        finish();
    }

}
