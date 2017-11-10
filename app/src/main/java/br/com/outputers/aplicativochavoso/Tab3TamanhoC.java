package br.com.outputers.aplicativochavoso;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Lucas Dutra on 11/09/2017.
 */

public class Tab3TamanhoC extends Fragment {

    Button btnCortesRec;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab3, container, false);

        btnCortesRec = (Button) rootView.findViewById(R.id.btn_cortes_rec);
        btnCortesRec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentCortesRec = new Intent(getActivity(), CortesRecActivity.class);
                startActivity(intentCortesRec);
            }
        });

        return rootView;
    }

}
