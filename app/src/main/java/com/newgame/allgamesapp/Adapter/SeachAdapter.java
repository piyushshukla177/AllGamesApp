package com.newgame.allgamesapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.newgame.allgamesapp.Activity.MWebActivity;
import com.newgame.allgamesapp.R;
import com.newgame.allgamesapp.model.Games;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SeachAdapter extends RecyclerView.Adapter<SeachAdapter.ViewHolder> {

    private ArrayList<Games> mData;
    private Context mContext;
    private List<Games> originalItems;


    public SeachAdapter(ArrayList<Games> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;

        this.originalItems = new ArrayList<>();
        originalItems.addAll(mData);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.game_list_row,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SeachAdapter.ViewHolder holder, int position) {
        final Games Games = mData.get(position);
        holder.tv_book_title.setText(mData.get(position).getTitle());
        holder.img_book_thumbnail.setImageResource(mData.get(position).getImageResourse());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext , MWebActivity.class);
                intent.putExtra("url", Games.getUrl());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void filter(final String strSearch) {
        if (strSearch.length() == 0) {
            mData.clear();
            mData.addAll(originalItems);
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                mData.clear();
                List<Games> collect = originalItems.stream()
                        .filter(i -> i.getTitle().toLowerCase().contains(strSearch))
                        .collect(Collectors.toList());

                mData.addAll(collect);
            } else {
                mData.clear();
                for (Games i : originalItems) {
                    if (i.getTitle().toLowerCase().contains(strSearch.toLowerCase())) {
                        mData.add(i);
                    }

                }
            }
        }
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_book_title;
        ImageView img_book_thumbnail;
        CardView cardView ;

        public ViewHolder(View itemView) {
            super(itemView);

            tv_book_title = (TextView) itemView.findViewById(R.id.titleTextView) ;
            img_book_thumbnail = (ImageView) itemView.findViewById(R.id.imageView);
            cardView = (CardView) itemView.findViewById(R.id.cardview_id);


        }
    }

}
