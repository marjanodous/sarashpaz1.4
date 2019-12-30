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

import com.example.sarashpaz.model.Item_recycler_myanvade;
import com.example.sarashpaz.R;
import com.example.sarashpaz.Tozihat;

import java.util.List;

public class ItemAdapter_recycler_myanvade extends RecyclerView.Adapter<ItemAdapter_recycler_myanvade.MyViewHolder> {
    List<Item_recycler_myanvade> itemList;
    Context mContext;
    public static boolean flag_myanvade=false;
    public ItemAdapter_recycler_myanvade(List<Item_recycler_myanvade> itemList, Context mContext) {
        this.itemList = itemList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View aView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_myanvade, parent, false);
        return new MyViewHolder(aView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.aName.setText(itemList.get(position).getuName());
        holder.aAvatar.setImageResource(itemList.get(position).getuAvatar());
        holder.aAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag_myanvade=true;
                Intent intent  = new Intent(mContext, Tozihat.class);
                intent.putExtra("title_myanvade",itemList.get(position).getuName());
                intent.putExtra("image_myanvade",itemList.get(position).getuAvatar());
                mContext.startActivity(intent);            }
        });
//        holder.lLMain.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent  = new Intent(mContext, Tozihat.class);
//                intent.putExtra("title",itemList.get(position).getuName());
//                intent.putExtra("image",itemList.get(position).getuAvatar());
//                mContext.startActivity(intent);
//                Log.i("a", "position is " + position);
//                Toast.makeText(mContext, "fff " + position, Toast.LENGTH_LONG).show();
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView aAvatar;
        public TextView aName;
//        CardView cardView;
//        LinearLayout lLMain;

        public MyViewHolder(View itemView) {
            super(itemView);

//            cardView = itemView.findViewById(R.id.card_myanvade);
//            lLMain = itemView.findViewById(R.id.lLMain);
            aAvatar = itemView.findViewById(R.id.img_recycler_myanvade);
            aName = itemView.findViewById(R.id.txt_name_mianvade);

        }
    }
}

