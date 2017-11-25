package br.com.outputers.aplicativochavoso;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import static br.com.outputers.aplicativochavoso.Tab1TRosto.TipoRosto;
import static br.com.outputers.aplicativochavoso.Tab2TCabelo.TipoCabelo;

/**
 * Created by Lucas Dutra on 11/09/2017.
 */

public class Tab3TamanhoC extends Fragment {

    static String TamanhoCabelo = "null";

    ImageButton btnTamanhoCurto;
    ImageButton btnTamanhoMedio;
    ImageButton btnTamandoLongo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.tab3, container, false);


        btnTamanhoCurto = rootView.findViewById(R.id.imgbtn_tamanho_curto);
        btnTamanhoMedio = rootView.findViewById(R.id.imgbtn_tamanho_medio);
        btnTamandoLongo = rootView.findViewById(R.id.imgbtn_tamanho_longo);



        btnTamanhoCurto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TamanhoCabelo = "curto";
                Toast.makeText(rootView.getContext(), "O seu cabelo é "+ TamanhoCabelo, Toast.LENGTH_SHORT).show();
                IntentCortesRec(rootView);
            }
        });

        btnTamanhoMedio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TamanhoCabelo = "medio";
                Toast.makeText(rootView.getContext(), "O seu cabelo é "+ TamanhoCabelo, Toast.LENGTH_SHORT).show();
                IntentCortesRec(rootView);
            }
        });

        btnTamandoLongo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TamanhoCabelo = "longo";
                Toast.makeText(rootView.getContext(), "O seu cabelo é "+ TamanhoCabelo, Toast.LENGTH_SHORT).show();
                IntentCortesRec(rootView);
            }
        });

        return rootView;
    }

    public void IntentCortesRec(View rootView) {

        //Tratando usuário retardado
        if (TipoRosto == "null" || TipoCabelo == "null" || TamanhoCabelo == "null") {
            Toast.makeText(rootView.getContext(), "Preencha todos os dados antes de prosseguir, mongol", Toast.LENGTH_SHORT).show();
        } else {
            Intent intentCortesRec = new Intent(getActivity(), CortesRecActivity.class);
            startActivity(intentCortesRec);
            getActivity().finish();
        }
    }

}
