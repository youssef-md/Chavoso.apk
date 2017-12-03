package br.com.outputers.aplicativochavoso;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.bumptech.glide.Glide;

/**
 * Created by Lucas Dutra on 11/09/2017.
 */

public class Tab2TCabelo extends Fragment {

    String TipoCabelo = "null";

    ImageButton btnCabeloAfro;
    ImageButton btnCabeloCacheado;
    ImageButton btnCabeloLiso;
    ImageButton btnCabeloOndulado;

    SharedPreferences CadastroPreferences;

    //CortesSalvosDAO cadastroDAO;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.tab2, container, false);

        //Instanciando os ImageButton
        btnCabeloAfro = rootView.findViewById(R.id.imgbtn_cabelo_afro);
        btnCabeloCacheado = rootView.findViewById(R.id.imgbtn_cabelo_cacheado);
        btnCabeloLiso = rootView.findViewById(R.id.imgbtn_cabelo_liso);
        btnCabeloOndulado = rootView.findViewById(R.id.imgbtn_cabelo_ondulado);

        //Usando o Glide para popular as imagens dos ImageButton
        Glide.with(rootView).load(R.drawable.cabelo_afro).into(btnCabeloAfro);
        Glide.with(rootView).load(R.drawable.cabelo_cacheado).into(btnCabeloCacheado);
        Glide.with(rootView).load(R.drawable.cabelo_liso).into(btnCabeloLiso);
        Glide.with(rootView).load(R.drawable.cabelo_ondulado).into(btnCabeloOndulado);


        final SharedPreferences CadastroPreferences = this.getActivity().getSharedPreferences("cadastro", Context.MODE_PRIVATE);

        btnCabeloAfro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TipoCabelo = "afro";
                GuardarTipoCabelo();
            }
        });

        btnCabeloCacheado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TipoCabelo = "cacheado";
                GuardarTipoCabelo();
            }
        });

        btnCabeloLiso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TipoCabelo = "liso";
                GuardarTipoCabelo();
            }
        });

        btnCabeloOndulado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TipoCabelo = "ondulado";
                GuardarTipoCabelo();
            }
        });

        return rootView;
    }

    public void GuardarTipoCabelo(){

        CadastroPreferences = this.getActivity().getSharedPreferences("cadastro", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = CadastroPreferences.edit();
        editor.putString("tipo_cabelo", TipoCabelo);
        editor.apply();

        Log.e("Guardar Tipo Cabelo", CadastroPreferences.getString("tipo_cabelo","nao"));

        switchTabInActivity(2);
    }

    public void switchTabInActivity(int index){
        TabLayout tabLayout = (TabLayout) getActivity().findViewById(R.id.tabs);
        TabLayout.Tab tab = tabLayout.getTabAt(index);
        tab.select();
    }

}

