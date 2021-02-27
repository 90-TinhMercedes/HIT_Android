package com.example.leagueoflegendsshopver2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.leagueoflegendsshopver2.databinding.LeagueOfLegendsItemBinding;

import java.util.List;

public class ItemLoLAdapter extends RecyclerView.Adapter<ItemLoLAdapter.ViewHolder> {
    private List<LeagueOfLegendsItem> list;
    private Context context;
    IClickItem mIClickItem;

    public void setmIClickItem(IClickItem mIClickItem) {
        this.mIClickItem = mIClickItem;
    }

    public ItemLoLAdapter(List<LeagueOfLegendsItem> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        LeagueOfLegendsItemBinding binding = DataBindingUtil.inflate(inflater, R.layout.league_of_legends_item, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LeagueOfLegendsItem item = list.get(position);
        holder.binding.imgItem.setImageResource(item.getImageItem());
        holder.binding.imgMoney.setImageResource(item.getImageMoney());
        holder.binding.imgPlus.setImageResource(item.getImagePlusItem());
        holder.binding.imgMinus.setImageResource(item.getImageMinusItem());
        holder.binding.tvNameItem.setText(item.getNameItem());
        holder.binding.tvMfg.setText(item.getMFG());
        holder.binding.tvPrice.setText(String.valueOf(item.getPrice()));
        holder.binding.tvAmountOrder.setText(String.valueOf(item.getAmountOrder()));
        holder.binding.imgPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIClickItem.clickPlusItem(item);
            }
        });
        holder.binding.imgMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIClickItem.clickMinusItem(item);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LeagueOfLegendsItemBinding binding;
        public ViewHolder(@NonNull LeagueOfLegendsItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

//    lúc đầu code chưa sử dụng DataBinding
//
//    @NonNull
//    @Override
//    public ItemLoLAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//        View view = inflater.inflate(R.layout.league_of_legends_item, parent, false);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ItemLoLAdapter.ViewHolder holder, int position) {
//        LeagueOfLegendsItem item = list.get(position);
//        holder.imgItem.setImageResource(item.getImageItem());
//        holder.imgMoney.setImageResource(item.getImageMoney());
//        holder.imgPlusItem.setImageResource(item.getImagePlusItem());
//        holder.imgMinusItem.setImageResource(item.getImageMinusItem());
//        holder.tvNameItem.setText(item.getNameItem());
//        holder.tvMFG.setText(item.getMFG());
//        holder.tvPrice.setText(String.valueOf(item.getPrice()));
//        holder.tvAmountOrder.setText(String.valueOf(item.getAmountOrder()));
//        holder.imgPlusItem.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mIClickItem.clickPlusItem(item);
//            }
//        });
//        holder.imgMinusItem.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mIClickItem.clickMinusItem(item);
//            }
//        });
//    }
//
//    @Override
//    public int getItemCount() {
//        return list.size();
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder {
//        ImageView imgItem, imgMoney, imgPlusItem, imgMinusItem;
//        TextView tvNameItem, tvMFG, tvPrice, tvAmountOrder;
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            imgItem = itemView.findViewById(R.id.img_item);
//            imgMoney = itemView.findViewById(R.id.img_money);
//            imgPlusItem = itemView.findViewById(R.id.img_plus);
//            imgMinusItem = itemView.findViewById(R.id.img_minus);
//            tvNameItem = itemView.findViewById(R.id.tv_name_item);
//            tvMFG = itemView.findViewById(R.id.tv_mfg);
//            tvPrice = itemView.findViewById(R.id.tv_price);
//            tvAmountOrder = itemView.findViewById(R.id.tv_amount_order);
//        }
//    }
}
