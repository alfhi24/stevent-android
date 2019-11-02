package com.astronaut.stevent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListEventAdapter extends RecyclerView.Adapter<ListEventAdapter.ListViewHolder> {

    private ArrayList<Event> listEvent;

    public ListEventAdapter(ArrayList<Event> list) {
        this.listEvent = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_event, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Event event = listEvent.get(position);
        Glide.with(holder.itemView.getContext())
                .load(event.getImage())
                .apply(new RequestOptions().override(100,100))
                .into(holder.imgPhoto);
        holder.tvName.setText(event.getName());
        holder.tvDate.setText(event.getDate());
        holder.tvLocation.setText(event.getLocation());
        holder.tvDetail.setText(event.getDetail());
    }

    @Override
    public int getItemCount() {
        return listEvent.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {

        ImageView imgPhoto;
        TextView tvName, tvDate, tvLocation, tvDetail;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDate = itemView.findViewById(R.id.tv_item_date);
            tvLocation = itemView.findViewById(R.id.tv_item_location);
            tvDetail = itemView.findViewById(R.id.tv_item_detail);
        }
    }
}
