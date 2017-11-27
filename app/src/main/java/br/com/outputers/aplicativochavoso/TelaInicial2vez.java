package br.com.outputers.aplicativochavoso;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class TelaInicial2vez extends AppCompatActivity {

    ImageButton CortesRec2;
    ImageButton EditarDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial2vez);


        CortesRec2 = findViewById(R.id.btn_cortes_rec_2);
        CortesRec2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent vaiProCortesRec = new Intent(TelaInicial2vez.this, CortesRecActivity.class);
                startActivity(vaiProCortesRec);
            }
        });

        EditarDados = findViewById(R.id.btn_editar_dados);
        EditarDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent vaiProCadastro = new Intent(TelaInicial2vez.this, AttCaractActivity.class);
                startActivity(vaiProCadastro);
            }
        });

    }
}
