package com.example.day09ver01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ItemBookAdapter extends RecyclerView.Adapter<ItemBookAdapter.ViewHolder> {
    List<ItemBook> list;
    Context context;

    public ItemBookAdapter(List<ItemBook> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemBookAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_book_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemBookAdapter.ViewHolder holder, int position) {
        ItemBook item = list.get(position);
        holder.tvTitle.setText(item.getTitle());
        Glide.with(context).load(item.getImgLink()).into(holder.imageBook);
        holder.tvAuthor.setText(item.getAuthor());
        holder.tvPrice.setText(String.valueOf(item.getPrice()));
        holder.tvRateStar.setText(String.valueOf(item.getRateStar()));
        holder.tvDescription.setText(item.getDescription());
        holder.tvNumOfReview.setText(String.valueOf(item.getNumOfReview()));
        holder.tvCategoty.setText(item.getCategoty());
        holder.tvNumOfPage.setText(String.valueOf(item.getNumOfPage()));


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvAuthor, tvPrice, tvRateStar, tvDescription,
                tvNumOfReview, tvCategoty, tvNumOfPage;
        ImageView imageBook;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            imageBook = itemView.findViewById(R.id.img_book);
            tvAuthor = itemView.findViewById(R.id.author);
            tvPrice = itemView.findViewById(R.id.price);
            tvRateStar = itemView.findViewById(R.id.rate_star);
            tvDescription = itemView.findViewById(R.id.description);
            tvNumOfReview = itemView.findViewById(R.id.num_of_review);
            tvCategoty = itemView.findViewById(R.id.categoty);
            tvNumOfPage = itemView.findViewById(R.id.num_of_page);
        }
    }
}
