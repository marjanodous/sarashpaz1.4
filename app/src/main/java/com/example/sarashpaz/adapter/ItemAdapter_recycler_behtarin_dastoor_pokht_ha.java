package com.example.sarashpaz.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sarashpaz.model.Item_recycler_behtarin_dastoor_pokht_ha;
import com.example.sarashpaz.R;
import com.example.sarashpaz.Tozihat;

import java.util.List;

public class ItemAdapter_recycler_behtarin_dastoor_pokht_ha extends RecyclerView.Adapter<ItemAdapter_recycler_behtarin_dastoor_pokht_ha.MyViewHolder> {

    List<Item_recycler_behtarin_dastoor_pokht_ha>itemList2;
    Context mContext2;
    public static boolean flag_behtarin_dastoor_pokht_ha=false;

    public ItemAdapter_recycler_behtarin_dastoor_pokht_ha(List<Item_recycler_behtarin_dastoor_pokht_ha>itemList2, Context mContext2){
        this.itemList2 = itemList2;
        this.mContext2 = mContext2;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View aView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_bartarindastoorpokht,parent,false);
        return new MyViewHolder(aView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.aName2.setText(itemList2.get(position).getuName2());
        holder.aAvatar2.setImageResource(itemList2.get(position).getuAvatar2());
        holder.aAvatar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag_behtarin_dastoor_pokht_ha=true;
                Intent intent  = new Intent(mContext2, Tozihat.class);
                intent.putExtra("title_bdph",itemList2.get(position).getuName2());
                intent.putExtra("image_bdph",itemList2.get(position).getuAvatar2());
                mContext2.startActivity(intent);            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList2.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView aAvatar2;
        public TextView aName2;

        public MyViewHolder(View itemView) {
            super(itemView);
            aAvatar2 = itemView.findViewById(R.id.img_recycler_bartarinDastoorPokht);
            aName2 = itemView.findViewById(R.id.txt_name_bartarinDastoorPokht);
        }
    }

}