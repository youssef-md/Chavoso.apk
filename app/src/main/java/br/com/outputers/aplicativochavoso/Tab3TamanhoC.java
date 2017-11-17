package br.com.outputers.aplicativochavoso;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by Lucas Dutra on 11/09/2017.
 */

public class Tab3TamanhoC extends Fragment {

    static String TamanhoCabelo = "null";

    Button btnCortesRec;
    ImageButton btnTamanhoCurto;
    ImageButton btnTamanhoMedio;
    ImageButton btnTamandoLongo;

    public static String getTamanhoCabelo(){
        return TamanhoCabelo;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.tab3, container, false);


        btnCortesRec = (Button) rootView.findViewById(R.id.btn_cortes_rec);

        btnTamanhoCurto = rootView.findViewById(R.id.imgbtn_tamanho_curto);
        btnTamanhoMedio = rootView.findViewById(R.id.imgbtn_tamanho_medio);
        btnTamandoLongo = rootView.findViewById(R.id.imgbtn_tamanho_longo);

        btnCortesRec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentCortesRec = new Intent(getActivity(), CortesRecActivity.class);
                startActivity(intentCortesRec);
                getActivity().finish();
            }
        });


        btnTamanhoCurto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TamanhoCabelo = "curto";
                Toast.makeText(rootView.getContext(), TamanhoCabelo, Toast.LENGTH_SHORT).show();
            }
        });

        btnTamanhoMedio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TamanhoCabelo = "medio";
                Toast.makeText(rootView.getContext(), TamanhoCabelo, Toast.LENGTH_SHORT).show();
            }
        });

        btnTamandoLongo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TamanhoCabelo = "longo";
                Toast.makeText(rootView.getContext(), TamanhoCabelo, Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }

}
