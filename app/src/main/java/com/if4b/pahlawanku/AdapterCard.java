package com.if4b.pahlawanku;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AdapterCard extends RecyclerView.Adapter<AdapterCard.CardViewHolder> {
    private ArrayList<ModelPahlawan> datapahlawan;

    public AdapterCard(ArrayList<ModelPahlawan> datapahlawan) {
        this.datapahlawan = datapahlawan;
    }

    public interface OnItemClickCallBack{
        void onItemClicked(ModelPahlawan data);
    }

    private AdapterGrid.OnItemClickCallBack callBack;
    public void setOnItemClickCallBack(AdapterGrid.OnItemClickCallBack callBack) {
        this.callBack = callBack;
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

        Glide
                .with(holder.itemView.getContext())
                .load(pahlawan.getFoto())
                .into(holder.ivpahlawan);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callBack.onItemClicked(datapahlawan.get(holder.getAdapterPosition()));
            }
        });
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
