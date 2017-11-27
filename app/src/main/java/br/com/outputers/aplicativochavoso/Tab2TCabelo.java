package br.com.outputers.aplicativochavoso;

import android.content.Context;
import android.content.SharedPreferences;
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

    String TipoCabelo = "null";

    ImageButton btnCabeloAfro;
    ImageButton btnCabeloCacheado;
    ImageButton btnCabeloLiso;
    ImageButton btnCabeloOndulado;

    CadastroDAO cadastroDAO;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.tab2, container, false);

        btnCabeloAfro = rootView.findViewById(R.id.imgbtn_cabelo_afro);
        btnCabeloCacheado = rootView.findViewById(R.id.imgbtn_cabelo_cacheado);
        btnCabeloLiso = rootView.findViewById(R.id.imgbtn_cabelo_liso);
        btnCabeloOndulado = rootView.findViewById(R.id.imgbtn_cabelo_ondulado);


        final SharedPreferences preferences = this.getActivity().getSharedPreferences("UserInfo", Context.MODE_PRIVATE);

        btnCabeloAfro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TipoCabelo = "afro";
                GuardarTipoCabelo();
                Toast.makeText(rootView.getContext(), "O seu tipo de cabelo é " + cadastroDAO.getDataTipoCabelo(), Toast.LENGTH_SHORT).show();
            }
        });

        btnCabeloCacheado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TipoCabelo = "cacheado";
                GuardarTipoCabelo();
                Toast.makeText(rootView.getContext(),"O seu tipo de cabelo é " + cadastroDAO.getDataTipoCabelo(), Toast.LENGTH_SHORT).show();
            }
        });

        btnCabeloLiso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TipoCabelo = "liso";
                GuardarTipoCabelo();
                Toast.makeText(rootView.getContext(), "O seu tipo de cabelo é " + cadastroDAO.getDataTipoCabelo(), Toast.LENGTH_SHORT).show();
            }
        });

        btnCabeloOndulado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TipoCabelo = "ondulado";
                GuardarTipoCabelo();
                Toast.makeText(rootView.getContext(), "O seu tipo de cabelo é " + cadastroDAO.getDataTipoCabelo(), Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }

    public void GuardarTipoCabelo(){

        cadastroDAO = new CadastroDAO(this.getContext());
        cadastroDAO.insertTipoCabelo(TipoCabelo);
        cadastroDAO.close();
    }

}

