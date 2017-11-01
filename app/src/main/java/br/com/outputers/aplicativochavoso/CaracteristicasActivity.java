package br.com.outputers.aplicativochavoso;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

public class CaracteristicasActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caracteristicas);
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.viewpager);

        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        final TabLayout.Tab tipoderosto = tabLayout.newTab();
        final TabLayout.Tab tamanhodocabelo = tabLayout.newTab();
        final TabLayout.Tab cabelotipo = tabLayout.newTab();

        /*tipoderosto.setText("Tipo de rosto");
        tamanhodocabelo.setText("Tamanho do cabelo");
        cabelotipo.setText("Tipo do cabelo");

        View RostoView=getLayoutInflater().inflate(R.layout.custom_tab, null);
        ImageView rosto = RostoView.findViewById(R.id.image);
        TextView textorosto = RostoView.findViewById(R.id.text_view);
        rosto.setImageResource(R.drawable.tipoderosto);
        textorosto.setText("TipoRosto");

        View TamCabeloView=getLayoutInflater().inflate(R.layout.custom_tab, null);
        ImageView tamcabelo = TamCabeloView.findViewById(R.id.image);
        TextView textocabelo = TamCabeloView.findViewById(R.id.text_view);
        tamcabelo.setImageResource(R.drawable.tamanhodocabelo);
        textorosto.setText("TamanhoCabelo");

        View TipoCabeloView=getLayoutInflater().inflate(R.layout.custom_tab, null);
        ImageView tipocabelo = TipoCabeloView.findViewById(R.id.image);
        TextView textotipocabelo = TipoCabeloView.findViewById(R.id.text_view);
        tipocabelo.setImageResource(R.drawable.tipoderosto);
        textorosto.setText("TipoCabelo");

        tipoderosto.setCustomView(RostoView);
        tamanhodocabelo.setCustomView(TamCabeloView);
        tipoderosto.setCustomView(TipoCabeloView);*/

        tipoderosto.setIcon(R.drawable.tipoderosto);
        tamanhodocabelo.setIcon(R.drawable.tamanhodocabelo);
        cabelotipo.setIcon(R.drawable.tipodecabelo);

        tabLayout.addTab(tipoderosto, 0);
        tabLayout.addTab(tamanhodocabelo, 1);
        tabLayout.addTab(cabelotipo, 2);

        tabLayout.setTabTextColors(ContextCompat.getColorStateList(this,R.color.tab_selector));
        tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this,R.color.tab_selector));

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0: {
                        tipoderosto.setIcon(R.drawable.tipoderosto_barber);
                        tamanhodocabelo.setIcon(R.drawable.tamanhodocabelo);
                        cabelotipo.setIcon(R.drawable.tipodecabelo);
                        break;
                    }
                    case 1: {
                        tipoderosto.setIcon(R.drawable.tipoderosto);
                        tamanhodocabelo.setIcon(R.drawable.tamanhodocabelobarber);
                        cabelotipo.setIcon(R.drawable.tipodecabelo);
                        break;
                    }
                    case 2: {
                        tipoderosto.setIcon(R.drawable.tipoderosto);
                        tamanhodocabelo.setIcon(R.drawable.tamanhodocabelo);
                        cabelotipo.setIcon(R.drawable.tipodecabelo_barber);
                        break;
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}
