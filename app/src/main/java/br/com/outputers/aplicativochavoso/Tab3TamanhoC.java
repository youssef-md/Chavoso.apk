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
    SharedPreferences CadastroPreferences;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.tab3, container, false);


        btnTamanhoCurto = rootView.findViewById(R.id.imgbtn_tamanho_curto);
        btnTamanhoMedio = rootView.findViewById(R.id.imgbtn_tamanho_medio);
        btnTamandoLongo = rootView.findViewById(R.id.imgbtn_tamanho_longo);


        final SharedPreferences CadastroPreferences = this.getActivity().getSharedPreferences("cadastro", Context.MODE_PRIVATE);

        btnTamanhoCurto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TamanhoCabelo = "curto";
                GuardarTamanhoCabelo();
                if(!CadastroPreferences.getBoolean("cadastrou",false))
                    Toast.makeText(rootView.getContext(), "O seu cabelo é "+ CadastroPreferences.getString("tamanho_cabelo", "nao"), Toast.LENGTH_SHORT).show();
                IntentCortesRec(rootView);
            }
        });

        btnTamanhoMedio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TamanhoCabelo = "medio";
                GuardarTamanhoCabelo();
                if(!CadastroPreferences.getBoolean("cadastrou",false))
                    Toast.makeText(rootView.getContext(), "O seu cabelo é "+ CadastroPreferences.getString("tamanho_cabelo", "nao"), Toast.LENGTH_SHORT).show();
                IntentCortesRec(rootView);
            }
        });

        btnTamandoLongo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TamanhoCabelo = "longo";
                GuardarTamanhoCabelo();
                if(!CadastroPreferences.getBoolean("cadastrou",false))
                    Toast.makeText(rootView.getContext(), "O seu cabelo é "+ CadastroPreferences.getString("tamanho_cabelo", "nao"), Toast.LENGTH_SHORT).show();
                IntentCortesRec(rootView);
            }
        });

        return rootView;
    }

    public void GuardarTamanhoCabelo(){

        /*cadastroDAO = new CadastroDAO(this.getContext());
        cadastroDAO.insertTamanhoCabelo(TamanhoCabelo);
        cadastroDAO.close();
        */

        CadastroPreferences = this.getActivity().getSharedPreferences("cadastro", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = CadastroPreferences.edit();
        editor.putString("tamanho_cabelo", TamanhoCabelo);
        editor.apply();

    }


    public void IntentCortesRec(View rootView) {

        CadastroPreferences = this.getActivity().getSharedPreferences("cadastro", Context.MODE_PRIVATE);

        String mTipoRosto = CadastroPreferences.getString("tipo_rosto", "nao");
        String mTipoCabelo = CadastroPreferences.getString("tipo_cabelo", "nao");
        String mTamanhoCabelo = CadastroPreferences.getString("tamanho_cabelo", "nao");

        Boolean cadastrou = CadastroPreferences.getBoolean("cadastrou", false);

        //Tratando usuário retardado
        if (mTipoRosto.equals("nao") || mTipoCabelo.equals("nao") || mTamanhoCabelo.equals("nao")) {

            Toast.makeText(rootView.getContext(), "Preencha todos os dados antes de prosseguir, mongol", Toast.LENGTH_SHORT).show();

        } else if(cadastrou){

            Toast.makeText(rootView.getContext(), "Seus dados foram atualizados", Toast.LENGTH_SHORT).show();
            getActivity().finish();

        }else{

            Intent intentCortesRec = new Intent(getActivity(), CortesRecActivity.class);

            //cadastroDAO.insertCadastrou();
            //cadastroDAO.close();


            SharedPreferences.Editor editor= CadastroPreferences.edit();
            editor.putBoolean("cadastrou", true);
            editor.apply();

            startActivity(intentCortesRec);
            getActivity().finish();
        }
    }

}
