package br.com.outputers.aplicativochavoso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import static br.com.outputers.aplicativochavoso.R.id.entrar_image_button;

public class Inicial extends AppCompatActivity {

    ImageButton btnTelaInicial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicial2);

        btnTelaInicial = (ImageButton) findViewById(R.id.entrar_image_button);
        btnTelaInicial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentEntrar = new Intent(Inicial.this, AttCaractActivity.class);
                startActivity(intentEntrar);
            }
        }) ;
    }



}
