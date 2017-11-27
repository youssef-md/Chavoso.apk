package br.com.outputers.aplicativochavoso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaInicial2vez extends AppCompatActivity {

    Button CortesRec2;

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
    }
}
