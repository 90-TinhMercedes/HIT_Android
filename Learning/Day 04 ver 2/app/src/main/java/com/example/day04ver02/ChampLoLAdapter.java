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

public class ChampLoLAdapter extends RecyclerView.Adapter<ChampLoLAdapter.ViewHolder> {
    List<ChampLoL> list;
    Context context;
    WhenClickItem whenClickItem;

    public void setWhenClickItem(WhenClickItem whenClickItem) {
        this.whenClickItem = whenClickItem;
    }

    public ChampLoLAdapter(List<ChampLoL> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ChampLoLAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.champ_lol, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ChampLoLAdapter.ViewHolder holder, int position) {
        ChampLoL champLoL = list.get(position);
        holder.imgAvatar.setImageResource(champLoL.getAvatar());
        holder.tvChamp.setText(champLoL.getChamp());
        holder.tvInfo.setText(champLoL.getInfo());
        holder.imgAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                whenClickItem.clickAvatar(champLoL);
            }
        });
        holder.tvChamp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                whenClickItem.clickChamp(champLoL);
            }
        });
        holder.tvInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                whenClickItem.clickInfo(champLoL);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgAvatar;
        TextView tvChamp;
        TextView tvInfo;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAvatar = (ImageView) itemView.findViewById(R.id.imgAvatar);
            tvChamp = (TextView) itemView.findViewById(R.id.tvChamp);
            tvInfo = (TextView) itemView.findViewById(R.id.tvInfo);
        }
    }
}
