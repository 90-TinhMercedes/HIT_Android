package com.example.bookstorebasic.listbookandadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bookstorebasic.MainActivity;
import com.example.bookstorebasic.R;
import com.example.bookstorebasic.interfaceinteract.IOnClickMenuItem;

import java.util.List;


public class MenuBookAdapter extends RecyclerView.Adapter<MenuBookAdapter.ViewHolder> {
    List<MenuBook> list;
    Context context;
    IOnClickMenuItem mIOnClickMenuItem;

    public void setmIOnClickMenuItem(IOnClickMenuItem mIOnClickMenuItem) {
        this.mIOnClickMenuItem = mIOnClickMenuItem;
    }

    public MenuBookAdapter(List<MenuBook> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MenuBookAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_menu_book, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuBookAdapter.ViewHolder holder, int position) {
        MenuBook item = list.get(position);
        Glide.with(context).load(item.getImgLink()).placeholder(R.drawable.replace_picture).into(holder.imgMenuBook);
        holder.tvMenuTitleBook.setText(item.getMenuTitleBook());
        holder.imgMenuBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIOnClickMenuItem.iClickItem(item);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgMenuBook;
        TextView tvMenuTitleBook;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgMenuBook = itemView.findViewById(R.id.img_menu_book);
            tvMenuTitleBook = itemView.findViewById(R.id.tv_menu_book_title);
        }
    }
}
