package com.ex.androidarchcomponentsproject.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ex.androidarchcomponentsproject.R;
import com.ex.androidarchcomponentsproject.models.Items;

import java.util.ArrayList;

import io.realm.Realm;

public class MenuListAdapter extends RecyclerView.Adapter<MenuListAdapter.ViewHolder> {

    Context context;
    private ItemClickListener mClickListener;
    private ArrayList<Items> items ;

    public MenuListAdapter(Context context, ArrayList<Items> items) {
        this.context = context;
        this.items = items;
    }
    @NonNull
    @Override
    public MenuListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item, parent, false);
        return new MenuListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuListAdapter.ViewHolder holder, int position) {

        holder.itemName.setText(items.get(position).getName());
        Glide.with(context)
                .load(items.get(position).getPhotoUrl())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView itemName;

        ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.list_item_img);
            itemName = itemView.findViewById(R.id.ItemTxtView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null)
                mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    public String getItem(int id) {
        return items.get(id).getId();
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

}

