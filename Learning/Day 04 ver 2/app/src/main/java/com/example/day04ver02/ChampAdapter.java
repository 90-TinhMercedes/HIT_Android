package com.example.day04ver02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChampAdapter extends RecyclerView.Adapter<ChampAdapter.ViewHolder> {

    List<ChampLoL> list; // Bước 2
    Context context;

    // Bước 3
    public ChampAdapter(List<ChampLoL> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public ChampAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext()); // Bước 1
        View view = inflater.inflate(R.layout.champ_lol, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    // Bước 5
    @Override
    public void onBindViewHolder(@NonNull ChampAdapter.ViewHolder holder, int position) {
        ChampLoL champLoL = list.get(position);
        holder.imgAvatar.setImageResource(champLoL.getAvatar());
        holder.tvChamp.setText(champLoL.getChamp());
        holder.tvInfo.setText(champLoL.getInfo());



    }

    // truyền vào size của list
    @Override
    public int getItemCount() {
        return list.size();
    }


    // nơi ánh xạ
    // Bước 4
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgAvatar;
        TextView tvChamp;
        TextView tvInfo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAvatar = itemView.findViewById(R.id.imgAvatar);
            tvChamp = itemView.findViewById(R.id.tvChamp);
            tvInfo = itemView.findViewById(R.id.tvInfo);
        }
    }
}
