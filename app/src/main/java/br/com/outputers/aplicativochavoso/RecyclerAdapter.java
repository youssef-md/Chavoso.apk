package br.com.outputers.aplicativochavoso;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.ArrayList;

/**
 * Created by Youssef on 07/11/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {


    ArrayList<AlbumCortes> arrayList = new ArrayList<>();
    Context context; // Context para o android saber quem sou eu ao criar uma Intent


    // Construtor que vai settar os valores que foram passados para eles nas variaveis desta classe
    public RecyclerAdapter(Context context, ArrayList<AlbumCortes> arrayList){
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout_cortes_rec, parent, false);

        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        // Populando a RecyclerView
        holder.imageView.setImageResource(arrayList.get(position).getImg_id());

        // Tratando o click em um determinado item
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentPopUp = new Intent(context, PopUp.class);
                //passando a posição do item que foi clicado, usando o putExtra
                intentPopUp.putExtra("position", holder.getAdapterPosition());
                context.startActivity(intentPopUp);

            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public MyViewHolder(View itemView) {

            super(itemView);

            imageView = itemView.findViewById(R.id.album_cortes_rec);
        }
    }

}