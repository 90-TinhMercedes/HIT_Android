package com.example.leagueoflegendsshop;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class PayYourCart extends AppCompatActivity {

    ImageView imgBack;
    TextView tvSumPrice, tvQuestionPayConfirm, tvQuestionPayCancel;
    Button btnConfirmPay, btnCancelPay, btnConfirmYes, btnConfirmNo, btnCancelYes, btnCancelNo;
    RecyclerView rcvListOrder;
    List<LeagueOfLegendsItem> listOrder;
    LeagueOfLegendsItem leagueOfLegendsItem;
    Dialog dialogConfirmPay, dialogCancelPay;
    ProgressBar progressBarConfirm, progressBarCancel;
    RadioButton rbShipCOD, rbSmartBanking;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_your_cart);
        Mappings();
        Intent intent = getIntent();
        String sumPrice = intent.getStringExtra("sumPrice");
        tvSumPrice.setText(sumPrice);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        listOrder = new ArrayList<>();
        listOrder = (List<LeagueOfLegendsItem>) intent.getSerializableExtra("listOrder");
        ItemLoLAdapter itemLoLAdapter = new ItemLoLAdapter(listOrder, PayYourCart.this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(PayYourCart.this, RecyclerView.VERTICAL, false);
        rcvListOrder.setLayoutManager(layoutManager);
        rcvListOrder.setAdapter(itemLoLAdapter);

        //xử lý xác nhận Confirm and Cancel
        // button Confirm Pay
        dialogConfirmPay = new Dialog(PayYourCart.this);
        dialogConfirmPay.setContentView(R.layout.dialog_confirm_pay);
        dialogConfirmPay.setCancelable(false);
        dialogConfirmPay.getWindow().setBackgroundDrawable(getDrawable(R.drawable.background_dialog_dangky));
        dialogConfirmPay.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialogConfirmPay.getWindow().getAttributes().windowAnimations = R.style.animation;

        // button Cancel Pay
        dialogCancelPay = new Dialog(PayYourCart.this);
        dialogCancelPay.setContentView(R.layout.dialog_cancel_pay);
        dialogCancelPay.setCancelable(false);
        dialogCancelPay.getWindow().setBackgroundDrawable(getDrawable(R.drawable.background_dialog_dangky));
        dialogCancelPay.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialogCancelPay.getWindow().getAttributes().windowAnimations = R.style.animation;


        tvQuestionPayConfirm = (TextView) dialogConfirmPay.findViewById(R.id.tvQuestionPayConfirm);
        progressBarConfirm = (ProgressBar) dialogConfirmPay.findViewById(R.id.progressBarConfirm);
        btnConfirmYes = (Button) dialogConfirmPay.findViewById(R.id.btnConfirmYes);
        btnConfirmNo = (Button) dialogConfirmPay.findViewById(R.id.btnConfirmNo);
        tvQuestionPayCancel = (TextView) dialogCancelPay.findViewById(R.id.tvQuestionPayCancel);
        progressBarCancel = (ProgressBar) dialogCancelPay.findViewById(R.id.progressBarCancel);
        btnCancelYes = (Button) dialogCancelPay.findViewById(R.id.btnCancelYes);
        btnCancelNo = (Button) dialogCancelPay.findViewById(R.id.btnCancelNo);

        progressBarConfirm.setVisibility(View.INVISIBLE);
        progressBarCancel.setVisibility(View.INVISIBLE);

        btnConfirmPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String payWay = "";
                if(rbShipCOD.isChecked()){
                    payWay = "Cash On Delivery?";
                } else {
                    payWay = "Smart Banking?";
                }
                String finalPayWay = payWay;
                tvQuestionPayConfirm.setText("Xác nhận thanh toán: " + tvSumPrice.getText().toString() +  " $ bằng hình thức: " + finalPayWay);
                dialogConfirmPay.show();
            }
        });


        btnConfirmYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBarConfirm.setVisibility(View.VISIBLE);
                Toast.makeText(PayYourCart.this, "Please wait...", Toast.LENGTH_SHORT).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        progressBarConfirm.setVisibility(View.INVISIBLE);
                        tvSumPrice.setText("0");
                        listOrder.clear();
                        itemLoLAdapter.notifyDataSetChanged();
                        dialogConfirmPay.dismiss();
                        Toast.makeText(PayYourCart.this, "Xác nhận thanh toán đơn hàng thành công. Quý khách vui lòng xem thời gian dự kiến nhận hàng tại mục Thông Báo.", Toast.LENGTH_LONG).show();
                        Toast.makeText(PayYourCart.this, "Màn hình sẽ chuyển hướng trong 3s", Toast.LENGTH_SHORT).show();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(PayYourCart.this, "Quý khách tiếp tục sử dụng dịch vụ.", Toast.LENGTH_SHORT).show();
                                Intent intentReOrder = new Intent(PayYourCart.this, LeagueOfLegendsItemShop.class);
                                startActivity(intentReOrder);
                            }
                        },9000);
                    }
                }, 3000);
            }
        });
        btnConfirmNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogConfirmPay.dismiss();
            }
        });

        btnCancelPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBarCancel.setVisibility(View.INVISIBLE);
                tvQuestionPayCancel.setText("Bạn có muốn huỷ toàn bộ đơn hàng và order lại?");
                dialogCancelPay.show();
            }
        });

        btnCancelYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBarCancel.setVisibility(View.VISIBLE);
                Toast.makeText(PayYourCart.this, "Please wait...", Toast.LENGTH_SHORT).show();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        listOrder.clear();
                        itemLoLAdapter.notifyDataSetChanged();
                        tvSumPrice.setText("0");
                        dialogCancelPay.dismiss();
                        Toast.makeText(PayYourCart.this, "Quý khách đã huỷ đơn hàng thành công. Màn hình sẽ chuyển hướng trong 3s.", Toast.LENGTH_LONG).show();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(PayYourCart.this, "Quý khách tiếp tục sử dụng dịch vụ.", Toast.LENGTH_LONG).show();
                                Intent intentReOder = new Intent(PayYourCart.this, LeagueOfLegendsItemShop.class);
                                startActivity(intentReOder);
                            }
                        }, 5500);
                    }
                }, 3000);
            }
        });

        btnCancelNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogCancelPay.dismiss();
            }
        });

    }

    private void Mappings() {
        imgBack = (ImageView) findViewById(R.id.imgBack);
        tvSumPrice = (TextView) findViewById(R.id.tvSumPrice);
        btnCancelPay = (Button) findViewById(R.id.btnCancelPay);
        btnConfirmPay = (Button) findViewById(R.id.btnConfirmPay);
        rcvListOrder = (RecyclerView) findViewById(R.id.rcvListOrder);
        rbShipCOD = (RadioButton) findViewById(R.id.rbShipCOD);
        rbSmartBanking = (RadioButton) findViewById(R.id.rbSmartBanking);
    }
}