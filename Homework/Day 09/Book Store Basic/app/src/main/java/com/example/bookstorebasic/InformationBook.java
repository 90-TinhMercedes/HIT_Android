package com.example.bookstorebasic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.text.DecimalFormat;

public class InformationBook extends AppCompatActivity {
    private TextView tvTitle, tvAuthor, tvPrice, tvRateStar, tvDescription,
            tvNumOfReview, tvCategory, tvNumOfPage;
    private ImageView imageBook;
    private Button btnRate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_book);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        mappings();

        Intent intentInformationBook = getIntent();
        String imgLink = intentInformationBook.getStringExtra("imgBookLink");
        String title = intentInformationBook.getStringExtra("titleBook");
        String author = intentInformationBook.getStringExtra("authorBook");
        long price = intentInformationBook.getLongExtra("priceBook", 0);
        float rateStar = intentInformationBook.getFloatExtra("rateBook", 0);
        String description = intentInformationBook.getStringExtra("descriptionBook");
        long numOfReview = intentInformationBook.getLongExtra("numOfReviewBook", 0);
        String category = intentInformationBook.getStringExtra("categoryBook");
        long numOfPage = intentInformationBook.getLongExtra("numOfPageBook", 0);


        tvTitle.setText(title);
        tvAuthor.setText(author);
//        tvPrice.setText(String.valueOf(price));
        tvPrice.setText(formatNumberCurrency(String.valueOf(price)));
        tvRateStar.setText(String.valueOf(rateStar));
        tvDescription.setText(description);
        tvNumOfReview.setText(String.valueOf(numOfReview));
        tvCategory.setText(category);
        tvNumOfPage.setText(String.valueOf(numOfPage));
        Glide.with(InformationBook.this).load(imgLink).placeholder(R.drawable.replace_picture).into(imageBook);
        
        btnRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(InformationBook.this, "© 2021 TinhMercedes", Toast.LENGTH_LONG).show();
            }
        });

    }

    private static String formatNumberCurrency(String number) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###,##0");
        return decimalFormat.format(Long.parseLong(number));
    }


    private void mappings() {
        tvTitle = findViewById(R.id.tv_title);
        imageBook = findViewById(R.id.img_book);
        tvAuthor = findViewById(R.id.author);
        tvPrice = findViewById(R.id.price);
        tvRateStar = findViewById(R.id.rate_star);
        tvDescription = findViewById(R.id.description);
        tvNumOfReview = findViewById(R.id.num_of_review);
        tvCategory = findViewById(R.id.categoty);
        tvNumOfPage = findViewById(R.id.num_of_page);
        btnRate = findViewById(R.id.btn_rate);
    }
}