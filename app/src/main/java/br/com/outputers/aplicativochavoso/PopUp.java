package br.com.outputers.aplicativochavoso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class PopUp extends AppCompatActivity {

    // Vetor com o caminho das imagens fullsize
    int[] full_img_id = {
            R.drawable.full_af_curto_1, R.drawable.full_af_curto_2,
            R.drawable.full_af_curto_3, R.drawable.full_af_curto_4,
            R.drawable.full_af_curto_5
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up);

        // recebendo a posição do item que foi clicado (putExtras)
        int position = (int) getIntent().getExtras().get("position");

        Button btnFechar = (Button) findViewById(R.id.btn_fechar_popup);
        btnFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        ImageView imageView = findViewById(R.id.full_popup_image);
        imageView.setImageResource(full_img_id[position]);
    }
}
