package br.com.outputers.aplicativochavoso;

import android.content.Context;
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
    SharedPreferences CadastroPreferences;
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

        CadastroPreferences = getSharedPreferences("cadastro", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = CadastroPreferences.edit();

        EditarDados = findViewById(R.id.btn_editar_dados);
        EditarDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putBoolean("editar",true);
                editor.apply();
                Intent vaiProCadastro = new Intent(TelaInicial2vez.this, AttCaractActivity.class);
                startActivity(vaiProCadastro);
            }
        });

    }
}
