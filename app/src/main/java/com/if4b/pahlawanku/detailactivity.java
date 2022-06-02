package com.if4b.pahlawanku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class detailactivity extends AppCompatActivity {
    private TextView tvNama, tvTentang;
    private ImageView ivFoto;
    private String ynama,ytentang,yfoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailactivity);

        initView();

        Intent terima = getIntent();
        ynama = terima.getStringExtra("xNama");
        ytentang = terima.getStringExtra("xTentang");
        yfoto = terima.getStringExtra("xFoto");

        tvNama.setText(ynama);
        tvTentang.setText(ytentang);

        Glide.with(detailactivity.this)
                .load(yfoto)
                .into(ivFoto);
    }

    private void initView(){
        tvNama =findViewById(R.id.tv_nama_pahlawan);
        tvTentang = findViewById(R.id.tv_tentang_pahlwan);
        ivFoto = findViewById(R.id.iv_foto);
    }
}