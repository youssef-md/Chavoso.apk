package br.com.outputers.aplicativochavoso;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class CortesRecActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<AlbumCortes> arrayList = new ArrayList<>();

    int[] img_id = {
            R.drawable.liso_curto_1, R.drawable.liso_medio_1,
            R.drawable.liso_longo_1, R.drawable.af_curto_1,
            R.drawable.af_medio_1, R.drawable.af_longo_1,
            R.drawable.enr_curto_1, R.drawable.enr_medio_1,
            R.drawable.enr_longo_1, R.drawable.ond_curto_1,
            R.drawable.ond_medio_1, R.drawable.ond_longo_1
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cortes_rec);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        layoutManager = new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        for(int id : img_id){

            arrayList.add(new AlbumCortes(id));
        }

        adapter = new RecyclerAdapter(arrayList);
        recyclerView.setAdapter(adapter);

    }
}
