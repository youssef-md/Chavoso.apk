package br.com.outputers.aplicativochavoso;

/**
 * Created by Lucas Dutra on 11/09/2017.
 */
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.os.Bundle;
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

    //CadastroDAO cadastroDAO;

    SharedPreferences CadastroPreferences;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.tab1, container, false);

        //instanciando os btn, sempre usando rootView.
        btnRostoQuadrado = rootView.findViewById(R.id.imgbtn_rosto_quadrado);
        btnRostoRedondo = rootView.findViewById(R.id.imgbtn_rosto_redondo);
        btnRostoOval = rootView.findViewById(R.id.imgbtn_rosto_oval);
        btnRostoDiamante = rootView.findViewById(R.id.imgbtn_rosto_diamante);


        //final SharedPreferences preferences = this.getActivity().getSharedPreferences("UserInfo", Context.MODE_PRIVATE);

        //cadastroDAO = new CadastroDAO(this.getContext());


        btnRostoQuadrado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TipoRosto = "quadrado";
                //GuardarTipoRosto();
                GuardarTipoRosto();
                Toast.makeText(rootView.getContext(), "O seu tipo de rosto é " + CadastroPreferences.getString("tipo_rosto","nao"), Toast.LENGTH_SHORT).show();
            }
        });

        btnRostoRedondo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TipoRosto = "redondo";
                GuardarTipoRosto();
                //GuardarTipoRosto();
                Toast.makeText(rootView.getContext(), "O seu tipo de rosto é " + CadastroPreferences.getString("tipo_rosto","nao"), Toast.LENGTH_SHORT).show();
            }
        });

        btnRostoOval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TipoRosto = "oval";
                GuardarTipoRosto();
                //GuardarTipoRosto();
                Toast.makeText(rootView.getContext(), "O seu tipo de rosto é " + CadastroPreferences.getString("tipo_rosto","nao"), Toast.LENGTH_SHORT).show();
            }
        });

        btnRostoDiamante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TipoRosto = "diamante";
                GuardarTipoRosto();
                //GuardarTipoRosto();
                Toast.makeText(rootView.getContext(),"O seu tipo de rosto é " + CadastroPreferences.getString("tipo_rosto","nao"), Toast.LENGTH_SHORT).show();
            }
        });

        //cadastroDAO.close();

        return rootView;
    }

    public void GuardarTipoRosto(){


        CadastroPreferences = this.getActivity().getSharedPreferences("cadastro", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = CadastroPreferences.edit();
        editor.putString("tipo_rosto", TipoRosto);
        editor.apply();


        /*cadastroDAO = new CadastroDAO(this.getContext());
        cadastroDAO.insertTipoRosto(TipoRosto);
        cadastroDAO.close();
        */
    }

}
