package br.com.outputers.aplicativochavoso;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimatedStateListDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class Inicial extends AppCompatActivity {

    private ImageView imgViewLogo;

    SharedPreferences CadastroPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicial2);

        imgViewLogo = findViewById(R.id.logo_splash);

        //splash
        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.mytransition);
        imgViewLogo.startAnimation(myanim);

        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {

                    CadastroPreferences = getSharedPreferences("cadastro",Context.MODE_PRIVATE);
                    Boolean cadastrou = CadastroPreferences.getBoolean("cadastrou", false);
                    Log.e("CADASTROU", cadastrou.toString());

                    if(cadastrou) {
                        intentEntrar2Vez(); // Caso o usuário já seja cadastrado
                    }else{
                        intentEntrar1Vez();
                    }
                }
            }
        };


        timer.start();


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
