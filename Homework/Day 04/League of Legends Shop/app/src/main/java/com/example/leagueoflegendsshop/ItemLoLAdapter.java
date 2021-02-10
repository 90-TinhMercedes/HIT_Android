package com.example.leagueoflegendsshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemLoLAdapter extends RecyclerView.Adapter<ItemLoLAdapter.ViewHolder> {

    List<LeagueOfLegendsItem> list;
    Context context;
    WhenClickItem whenClickItem;

    public void setWhenClickItem(WhenClickItem whenClickItem) {
        this.whenClickItem = whenClickItem;
    }

    public ItemLoLAdapter(List<LeagueOfLegendsItem> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public ItemLoLAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.league_of_legends_items, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemLoLAdapter.ViewHolder holder, int position) {
        LeagueOfLegendsItem lolItem = list.get(position);
        holder.imgItem.setImageResource(lolItem.getImageItem());
        holder.tvNameItem.setText(lolItem.getNameItem());
        holder.tvMFG.setText(lolItem.getMFG());
        holder.tvPrice.setText(String.valueOf(lolItem.getPrice()));
        holder.tvAmountOrder.setText(String.valueOf(lolItem.getAmountOrder()));
        holder.imgMoney.setImageResource(lolItem.getMoney());
        holder.imgPlus.setImageResource(lolItem.getPlusItem());
        holder.imgMinus.setImageResource(lolItem.getMinusItem());

        holder.imgPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                whenClickItem.clickPlusItem(lolItem);
            }
        });

        holder.imgMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                whenClickItem.clickMinusItem(lolItem);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgItem;
        TextView tvNameItem;
        TextView tvMFG;
        TextView tvPrice;
        TextView tvAmountOrder;
        ImageView imgMoney;
        ImageView imgPlus;
        ImageView imgMinus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgItem = itemView.findViewById(R.id.imgItem);
            imgMoney = itemView.findViewById(R.id.imgMoney);
            imgPlus = itemView.findViewById(R.id.imgPlus);
            imgMinus = itemView.findViewById(R.id.imgMinus);
            tvNameItem = itemView.findViewById(R.id.tvNameItem);
            tvMFG = itemView.findViewById(R.id.tvMFG);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvAmountOrder = itemView.findViewById(R.id.tvAmountOrder);
        }
    }
}
