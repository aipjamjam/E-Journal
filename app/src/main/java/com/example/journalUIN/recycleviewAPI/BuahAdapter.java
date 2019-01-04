package com.example.journalUIN.recycleviewAPI;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class BuahAdapter extends RecyclerView.Adapter<BuahAdapter.BuahViewHolder>{
    private List<Buah> buah;
    private Context context;

    public BuahAdapter(List<Buah> buah, Context context) {
        this.buah = buah;
        this.context = context;
    }

    @NonNull
    @Override
    public BuahViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        return new BuahViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BuahViewHolder buahViewHolder, int i) {
        final Buah d = buah.get(i);
        //buahViewHolder.judul_jurnal.setText(d.getPath());
        buahViewHolder.nama_jurnal.setText(d.getSetting_value());

        //event click menampilkan detail cardview
        buahViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kirim = new Intent(context, DetailActivity.class);
                //tambaahan
                kirim.putExtra("id",d.getJournal_id());
                kirim.putExtra("path",d.getPath());
                kirim.putExtra("set_val",d.getSetting_value());
                kirim.putExtra("url",d.getUrl());
                kirim.putExtra("lastissue",d.getLastissue());
                context.startActivity(kirim);
            }
        });
    }

    @Override
    public int getItemCount() {
        return buah.size();
    }

    class BuahViewHolder extends RecyclerView.ViewHolder {
        TextView  nama_jurnal;
        public BuahViewHolder(@NonNull View itemView) {
            super(itemView);
            //judul_jurnal = itemView.findViewById(R.id.judul_jurnal);
            nama_jurnal = itemView.findViewById(R.id.nama_jurnal);
        }
    }
}
