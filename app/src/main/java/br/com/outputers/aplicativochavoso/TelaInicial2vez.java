package br.com.outputers.aplicativochavoso;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.bumptech.glide.Glide;

public class TelaInicial2vez extends AppCompatActivity {

    ImageButton CortesRec2;
    ImageButton EditarDados;

    ImageButton imgMe;

    SharedPreferences CadastroPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial2vez);

        CadastroPreferences = getSharedPreferences("cadastro", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = CadastroPreferences.edit();

        //Instanciando os ImgBtn
        CortesRec2 = findViewById(R.id.btn_cortes_rec_2);
        EditarDados = findViewById(R.id.btn_editar_dados);

        //Usando o Glide para carregar os background dos ImgBtn
        Glide.with(this).load(R.drawable.btn_cortes_rec).into(CortesRec2);
        Glide.with(this).load(R.drawable.btn_editar).into(EditarDados);


        CortesRec2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent vaiProCortesRec = new Intent(TelaInicial2vez.this, CortesRecActivity.class);
                startActivity(vaiProCortesRec);
            }
        });


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
