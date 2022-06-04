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

public class AdapterGrid extends RecyclerView.Adapter<AdapterGrid.GridViewHolder> {
    private ArrayList<ModelPahlawan> datapahlawan;

    public AdapterGrid(ArrayList<ModelPahlawan> datapahlawan) {
        this.datapahlawan = datapahlawan;
    }


    //call back
    public interface OnItemClickCallBack{
        void onItemClicked(ModelPahlawan data);
    }

    private OnItemClickCallBack callBack;
    public void setOnItemClickCallBack(OnItemClickCallBack callBack) {
        this.callBack = callBack;
    }
    // End Call back

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item_pahlawan, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, int position) {
        ModelPahlawan pahlawan = datapahlawan.get(position);

        Glide
                .with(holder.itemView.getContext())
                .load(pahlawan.getFoto())
                .into(holder.ivgridpahlawan);

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

    public class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView ivgridpahlawan;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            ivgridpahlawan = itemView.findViewById(R.id.iv_grid_pahlawan);
        }
    }
}
