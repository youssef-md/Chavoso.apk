package br.com.outputers.aplicativochavoso;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;


public class PopUp extends AppCompatActivity {


    //Objet vetor do caminho das imagens não populado
    public int[] full_img_id = new int[]{};

    Button btnFechar;
    String mTipoCabelo;
    String mTamanhoCabelo;
    SharedPreferences CadastroPreferences;
    SharedPreferences CortesSalvos;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        CadastroPreferences = getSharedPreferences("cadastro",Context.MODE_PRIVATE);
        CortesSalvos = getSharedPreferences("cortes_salvos", Context.MODE_PRIVATE);

        mTipoCabelo = CadastroPreferences.getString("tipo_cabelo", "nao");
        mTamanhoCabelo = CadastroPreferences.getString("tamanho_cabelo", "nao");

        VerificarCombinacao();

        setContentView(R.layout.activity_pop_up);

        // recebendo a posição do item que foi clicado (putExtras)
        final int position = (int) getIntent().getExtras().get("position");

        ImageView imageView = findViewById(R.id.full_popup_image);
        imageView.setImageResource(full_img_id[position]); //Mostra a imagem correspondente ao click

        btnFechar = findViewById(R.id.btn_fechar_popup);
        btnFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    boolean saveBitmapToFile(File dir, String fileName, Bitmap bm,
                             Bitmap.CompressFormat format, int quality) {

        File imageFile = new File(dir,fileName);

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(imageFile);

            bm.compress(format,quality,fos);

            fos.close();

            return true;
        }
        catch (IOException e) {
            Log.e("app",e.getMessage());
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return false;
    }


    private void VerificarCombinacao() {

        //Verificando as combinações e populando o vetor
        if(mTipoCabelo.equals("afro") && mTamanhoCabelo.equals("curto")){
               full_img_id = new int[]{
                    R.drawable.full_af_curto_1, R.drawable.full_af_curto_2,
                    R.drawable.full_af_curto_3, R.drawable.full_af_curto_4,
                    R.drawable.full_af_curto_5
            };
        }else if(mTipoCabelo.equals("afro") && mTamanhoCabelo.equals("medio")){

            full_img_id = new int[]{
                    R.drawable.full_af_medio_1, R.drawable.full_af_medio_2,
                    R.drawable.full_af_medio_3, R.drawable.full_af_medio_4,
                    R.drawable.full_af_medio_5,
             };

        } else if(mTipoCabelo.equals("afro") && mTamanhoCabelo.equals("longo")){

            full_img_id = new int[]{
                    R.drawable.full_af_longo_1, R.drawable.full_af_longo_2,
                    R.drawable.full_af_longo_3, R.drawable.full_af_longo_4
            };

        }else if(mTipoCabelo.equals("cacheado") && mTamanhoCabelo.equals("curto")){

            full_img_id = new int[]{
                    R.drawable.full_cach_curto_1, R.drawable.full_cach_curto_2,
                    R.drawable.full_cach_curto_3, R.drawable.full_cach_curto_4
            };
        }else if(mTipoCabelo.equals("cacheado") && mTamanhoCabelo.equals("medio")){
            full_img_id = new int[]{
                    R.drawable.full_cach_medio_1, R.drawable.full_cach_medio_2,
                    R.drawable.full_cach_medio_3, R.drawable.full_cach_medio_4
            };
        }else if(mTipoCabelo.equals("cacheado") && mTamanhoCabelo.equals("longo")){
            full_img_id = new int[]{
                    R.drawable.full_cach_longo_1, R.drawable.full_cach_longo_2,
                    R.drawable.full_cach_longo_3, R.drawable.full_cach_longo_4
            };
        }else if(mTipoCabelo.equals("liso") && mTamanhoCabelo.equals("curto")){
            full_img_id = new int[]{
                    R.drawable.full_liso_curto_1, R.drawable.full_liso_curto_2,
                    R.drawable.full_liso_curto_3, R.drawable.full_liso_curto_4,
                    R.drawable.full_liso_curto_5
            };
        }else if(mTipoCabelo.equals("liso") && mTamanhoCabelo.equals("medio")){
            full_img_id = new int[]{
                    R.drawable.full_liso_medio_1, R.drawable.full_liso_medio_2,
                    R.drawable.full_liso_medio_3, R.drawable.full_liso_medio_4,
                    R.drawable.full_liso_medio_5
            };
        }else if(mTipoCabelo.equals("liso") && mTamanhoCabelo.equals("longo")){
            full_img_id = new int[]{
                    R.drawable.full_liso_longo_1, R.drawable.full_liso_longo_2,
                    R.drawable.full_liso_longo_3, R.drawable.full_liso_longo_4
            };
        }else if(mTipoCabelo.equals("ondulado") && mTamanhoCabelo.equals("curto")){
            full_img_id = new int[]{
                    R.drawable.full_ond_curto_1, R.drawable.full_ond_curto_2,
                    R.drawable.full_ond_curto_3, R.drawable.full_ond_curto_4
            };
        }else if(mTipoCabelo.equals("ondulado") && mTamanhoCabelo.equals("medio")){
            full_img_id = new int[]{
                    R.drawable.full_ond_medio_1, R.drawable.full_ond_medio_2,
                    R.drawable.full_ond_medio_3, R.drawable.full_ond_medio_4
            };
        }else if(mTipoCabelo.equals("ondulado") && mTamanhoCabelo.equals("longo")){
            full_img_id = new int[]{
                    R.drawable.full_ond_longo_1, R.drawable.full_ond_longo_2,
                    R.drawable.full_ond_longo_3, R.drawable.full_ond_longo_4
            };
        }


    }
}
