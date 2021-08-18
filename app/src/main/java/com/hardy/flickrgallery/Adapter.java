package com.hardy.flickrgallery;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hardy.flickrgallery.Models.Photo;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context;
    List<Photo> photo;

    public Adapter(Context context, List<Photo> photo) {
        this.context = context;
        this.photo = photo;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Photo p=photo.get(position);
        String imageUrl=p.getUrl_s();
        holder.title_text.setText(p.getTitle());
        Glide.with(context)
                .load(imageUrl)
                .into(holder.imageView);
//                .error(R.drawable.ninja);

    }

    @Override
    public int getItemCount() {
        return photo.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title_text;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title_text=itemView.findViewById(R.id.title_text);
            imageView=itemView.findViewById(R.id.image_view);

        }
    }

}
