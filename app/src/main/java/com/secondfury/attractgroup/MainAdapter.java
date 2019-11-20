package com.secondfury.attractgroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Konstantyn Zakharchenko on 19.11.2019.
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {
    private List<DataBundle> data = new ArrayList<>();
    private List<DataBundle> shownData = new ArrayList<>();
    private OnItemClickListener onItemClickListener;

    public MainAdapter(List<DataBundle> data, OnItemClickListener onItemClickListener) {
        this.shownData.addAll(data);
        this.data.addAll(data) ;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        DataBundle dataBundle = shownData.get(position);

        holder.image.setImageBitmap(dataBundle.getImage());
        holder.name.setText(dataBundle.getName());
        holder.time.setText(TimeUtils.prepareTimeForList(dataBundle.getTime()));

        holder.itemView.setOnClickListener(v -> onItemClickListener.onClick(getIndex(dataBundle)));
    }

    @Override
    public int getItemCount() {

        return shownData != null ? shownData.size() : 0;

    }


    public void filterByName(String search) {
        if (search != null && !search.equals("")) {
            String preparedText = search.toLowerCase();
            shownData.clear();
            for (int i = 0; i < data.size(); i++) {
                if (data.get(i).getName().contains(preparedText)) {
                    shownData.add(data.get(i));
                }
            }

        } else {
            shownData.clear();
            shownData.addAll(data);
        }
        notifyDataSetChanged();
    }
    private int getIndex(DataBundle dataBundle){
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).equals(dataBundle)){
                return i;
            }
        }
        return 0;
    }
    class MainViewHolder extends RecyclerView.ViewHolder {
        View itemView;
        ImageView image;
        TextView name;
        TextView time;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            time = itemView.findViewById(R.id.time);
        }
    }

    public interface OnItemClickListener {
        void onClick(int itemIndex);
    }
}
