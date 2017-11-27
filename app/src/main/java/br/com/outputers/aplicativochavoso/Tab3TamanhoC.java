package br.com.outputers.aplicativochavoso;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
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

public class Tab3TamanhoC extends Fragment {

    String TamanhoCabelo = "null";

    ImageButton btnTamanhoCurto;
    ImageButton btnTamanhoMedio;
    ImageButton btnTamandoLongo;

    CadastroDAO cadastroDAO;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.tab3, container, false);


        btnTamanhoCurto = rootView.findViewById(R.id.imgbtn_tamanho_curto);
        btnTamanhoMedio = rootView.findViewById(R.id.imgbtn_tamanho_medio);
        btnTamandoLongo = rootView.findViewById(R.id.imgbtn_tamanho_longo);


        final SharedPreferences preferences = this.getActivity().getSharedPreferences("UserInfo", Context.MODE_PRIVATE);

        btnTamanhoCurto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TamanhoCabelo = "curto";
                GuardarTamanhoCabelo();
                Toast.makeText(rootView.getContext(), "O seu cabelo é "+ cadastroDAO.getDataTamanhoCabelo(), Toast.LENGTH_SHORT).show();
                IntentCortesRec(rootView);
            }
        });

        btnTamanhoMedio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TamanhoCabelo = "medio";
                GuardarTamanhoCabelo();
                Toast.makeText(rootView.getContext(), "O seu cabelo é "+ cadastroDAO.getDataTamanhoCabelo(), Toast.LENGTH_SHORT).show();
                IntentCortesRec(rootView);
            }
        });

        btnTamandoLongo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TamanhoCabelo = "longo";
                GuardarTamanhoCabelo();
                Toast.makeText(rootView.getContext(), "O seu cabelo é "+ cadastroDAO.getDataTamanhoCabelo(), Toast.LENGTH_SHORT).show();
                IntentCortesRec(rootView);
            }
        });

        return rootView;
    }

    public void GuardarTamanhoCabelo(){

        cadastroDAO = new CadastroDAO(this.getContext());
        cadastroDAO.insertTamanhoCabelo(TamanhoCabelo);
        cadastroDAO.close();
    }


    public void IntentCortesRec(View rootView) {

        String mTipoRosto = cadastroDAO.getDataTipoRosto();
        String mTipoCabelo = cadastroDAO.getDataTipoCabelo();
        String mTamanhoCabelo = cadastroDAO.getDataTamanhoCabelo();

        //Toast.makeText(getActivity(), mTipoRosto, Toast.LENGTH_SHORT).show();
        //Toast.makeText(getActivity(), mTipoCabelo, Toast.LENGTH_SHORT).show();
        //Toast.makeText(getActivity(), mTamanhoCabelo, Toast.LENGTH_SHORT).show();
        
        //Tratando usuário retardado
        if (mTipoRosto == "nao" || mTipoCabelo.equals("nao") || mTamanhoCabelo.equals("nao")) {
            Toast.makeText(rootView.getContext(), "Preencha todos os dados antes de prosseguir, mongol", Toast.LENGTH_SHORT).show();
        } else {
            Intent intentCortesRec = new Intent(getActivity(), CortesRecActivity.class);

            cadastroDAO.insertCadastrou();
            cadastroDAO.close();

            startActivity(intentCortesRec);
            getActivity().finish();
        }
    }

}
