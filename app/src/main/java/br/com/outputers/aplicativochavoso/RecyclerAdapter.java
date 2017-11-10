package br.com.outputers.aplicativochavoso;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Youssef on 07/11/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    ArrayList<AlbumCortes> arrayList = new ArrayList<>();

    public RecyclerAdapter(ArrayList<AlbumCortes> arrayList){

        this.arrayList = arrayList;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,
                parent, false);

        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        //Picasso.with(context).placeholder(arrayList.get(position).getImg_id());
        holder.imageView.setImageResource(arrayList.get(position).getImg_id());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public MyViewHolder(View itemView) {

            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.album_cortes_rec);
        }
    }

}
