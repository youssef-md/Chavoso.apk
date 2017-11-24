package br.com.outputers.aplicativochavoso;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by Lucas Dutra on 11/09/2017.
 */

public class Tab2TCabelo extends Fragment {

    static String TipoCabelo = "null";


    ImageButton btnCabeloAfro;
    ImageButton btnCabeloCacheado;
    ImageButton btnCabeloLiso;
    ImageButton btnCabeloOndulado;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.tab2, container, false);

        btnCabeloAfro = rootView.findViewById(R.id.imgbtn_cabelo_afro);
        btnCabeloCacheado = rootView.findViewById(R.id.imgbtn_cabelo_cacheado);
        btnCabeloLiso = rootView.findViewById(R.id.imgbtn_cabelo_liso);
        btnCabeloOndulado = rootView.findViewById(R.id.imgbtn_cabelo_ondulado);


        btnCabeloAfro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TipoCabelo = "afro";
                Toast.makeText(rootView.getContext(), TipoCabelo, Toast.LENGTH_SHORT).show();
            }
        });

        btnCabeloCacheado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TipoCabelo = "cacheado";
                Toast.makeText(rootView.getContext(), TipoCabelo, Toast.LENGTH_SHORT).show();
            }
        });

        btnCabeloLiso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TipoCabelo = "liso";
                Toast.makeText(rootView.getContext(), TipoCabelo, Toast.LENGTH_SHORT).show();
            }
        });

        btnCabeloOndulado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TipoCabelo = "ondulado";
                Toast.makeText(rootView.getContext(), TipoCabelo, Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }
}

