package com.if4b.pahlawanku;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterCard extends RecyclerView.Adapter<AdapterCard.CardViewHolder> {
    private ArrayList<ModelPahlawan> datapahlawan;

    public AdapterCard(ArrayList<ModelPahlawan> datapahlawan) {
        this.datapahlawan = datapahlawan;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item_pahlawan, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        ModelPahlawan pahlawan = datapahlawan.get(position);

        holder.tvnamapahlawan.setText(pahlawan.getNama());
        holder.tvtentangpahlawan.setText(pahlawan.getTentang());
    }

    @Override
    public int getItemCount() {
        return datapahlawan.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView ivpahlawan;
        TextView tvnamapahlawan, tvtentangpahlawan;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            ivpahlawan = itemView.findViewById(R.id.iv_pahlawan);
            tvnamapahlawan = itemView.findViewById(R.id.tv_nama_pahlawan);
            tvtentangpahlawan = itemView.findViewById(R.id.tv_tentang_pahlawan);
        }
    }
}
