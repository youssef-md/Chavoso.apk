package br.com.outputers.aplicativochavoso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

import static br.com.outputers.aplicativochavoso.Tab2TCabelo.TipoCabelo;
import static br.com.outputers.aplicativochavoso.Tab3TamanhoC.TamanhoCabelo;

public class PopUp extends AppCompatActivity {


    //Objet vetor do caminho das imagens não populado
    public int[] full_img_id = new int[]{};


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        VerificarCombinacao();
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


    private void VerificarCombinacao() {

        //Verificando as combinações e populando o vetor
        if(TipoCabelo == "afro" && TamanhoCabelo == "curto"){

            full_img_id = new int[]{
                    R.drawable.full_af_curto_1, R.drawable.full_af_curto_2,
                    R.drawable.full_af_curto_3, R.drawable.full_af_curto_4,
                    R.drawable.full_af_curto_5
            };
        }else if(TipoCabelo == "afro" && TamanhoCabelo == "medio"){

            full_img_id = new int[]{
                    R.drawable.full_af_medio_1, R.drawable.full_af_medio_2,
                    R.drawable.full_af_medio_3, R.drawable.full_af_medio_4,
                    R.drawable.full_af_medio_5,
             };

        } else if(TipoCabelo == "afro" && TamanhoCabelo == "longo"){

            full_img_id = new int[]{
                    R.drawable.full_af_longo_1, R.drawable.full_af_longo_2,
                    R.drawable.full_af_longo_3, R.drawable.full_af_longo_4
            };

        }else if(TipoCabelo == "cacheado" && TamanhoCabelo == "curto"){

            full_img_id = new int[]{
                    R.drawable.full_cach_curto_1, R.drawable.full_cach_curto_2,
                    R.drawable.full_cach_curto_3, R.drawable.full_cach_curto_4
            };
        }else if(TipoCabelo == "cacheado" && TamanhoCabelo == "medio"){
            full_img_id = new int[]{
                    R.drawable.full_cach_medio_1, R.drawable.full_cach_medio_2,
                    R.drawable.full_cach_medio_3, R.drawable.full_cach_medio_4
            };
        }else if(TipoCabelo == "cacheado" && TamanhoCabelo == "longo"){
            full_img_id = new int[]{
                    R.drawable.full_cach_longo_1, R.drawable.full_cach_longo_2,
                    R.drawable.full_cach_longo_3, R.drawable.full_cach_longo_4
            };
        }

    }
}
