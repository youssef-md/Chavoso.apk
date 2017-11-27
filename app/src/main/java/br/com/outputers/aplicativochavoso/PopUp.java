package br.com.outputers.aplicativochavoso;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.wifi.p2p.nsd.WifiP2pServiceRequest;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class PopUp extends AppCompatActivity {


    //Objet vetor do caminho das imagens não populado
    public int[] full_img_id = new int[]{};

    ImageButton btnChavei;
    Button btnFechar;

    CadastroDAO cadastroDAO;
    String mTipoCabelo;
    String mTamanhoCabelo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        cadastroDAO = new CadastroDAO(this);
        mTipoCabelo = cadastroDAO.getDataTipoCabelo();
        mTamanhoCabelo = cadastroDAO.getDataTamanhoCabelo();

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

        //<Salvando o drawable clicado no INTERNAL STORAGE>
        btnChavei = findViewById(R.id.imgbtn_popup_chavei);
        btnChavei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(PopUp.this, "O Corte foi salvo ", Toast.LENGTH_SHORT).show();

            }
        });
        //<Salvando o drawable clicado no SDCARD>
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
        }

    }

}
