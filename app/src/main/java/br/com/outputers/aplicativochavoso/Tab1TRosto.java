package br.com.outputers.aplicativochavoso;

/**
 * Created by Lucas Dutra on 11/09/2017.
 */
import android.content.Context;
import android.content.SharedPreferences;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;


public class Tab1TRosto extends Fragment  {

    String TipoRosto = "null";

    ImageButton btnRostoQuadrado;
    ImageButton btnRostoRedondo;
    ImageButton btnRostoOval;
    ImageButton btnRostoDiamante;

    //CortesSalvosDAO cadastroDAO;

    SharedPreferences CadastroPreferences;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.tab1, container, false);

        //instanciando os btn, sempre usando rootView.
        btnRostoQuadrado = rootView.findViewById(R.id.imgbtn_rosto_quadrado);
        btnRostoRedondo = rootView.findViewById(R.id.imgbtn_rosto_redondo);
        btnRostoOval = rootView.findViewById(R.id.imgbtn_rosto_oval);
        btnRostoDiamante = rootView.findViewById(R.id.imgbtn_rosto_diamante);


        btnRostoQuadrado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TipoRosto = "quadrado";
                GuardarTipoRosto(TipoRosto);
            }
        });

        btnRostoRedondo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TipoRosto = "redondo";
                GuardarTipoRosto(TipoRosto);
            }
        });

        btnRostoOval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TipoRosto = "oval";
                GuardarTipoRosto(TipoRosto);
            }
        });

        btnRostoDiamante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TipoRosto = "diamante";
                GuardarTipoRosto(TipoRosto);
            }
        });

        return rootView;
    }

    public void GuardarTipoRosto(String tipo_rosto) {

        CadastroPreferences = this.getActivity().getSharedPreferences("cadastro", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = CadastroPreferences.edit();
        editor.putString("tipo_rosto", tipo_rosto);
        editor.apply();

        Log.e("Guardar Tipo Rosto", CadastroPreferences.getString("tipo_rosto","nao"));
        switchTabInActivity(1);
    }

    public void switchTabInActivity(int index){

        TabLayout tabLayout = (TabLayout) getActivity().findViewById(R.id.tabs);
        TabLayout.Tab tab = tabLayout.getTabAt(index);
        tab.select();
    }
}
