package com.newgame.allgamesapp.Adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.newgame.allgamesapp.Activity.All_Games;
import com.newgame.allgamesapp.R;
import com.newgame.allgamesapp.model.Games;
import java.util.ArrayList;
public class GameitemAdapter extends RecyclerView.Adapter<GameitemAdapter.ViewHolder> {

    private ArrayList<Games> Gamelist;
    private Context context;
    GameClickListener listener;
    public interface GameClickListener {
        void onGamegClick(Games Gamelist);
    }
    public GameitemAdapter(ArrayList<Games> Gamelist, Context context, GameClickListener clickListener) {
        this.Gamelist = Gamelist;
        this.context = context;
        this.listener = clickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.game_list_row,
                parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GameitemAdapter.ViewHolder holder, int position) {
        final Games Games = Gamelist.get(position);
        holder.imageView.setImageResource(Games.getImageResourse());
        holder.titleTextView.setText(Games.getTitle());
        holder.fav_imageview.setImageResource(R.drawable.ic_baseline_favorite_border_24);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GameitemAdapter.this.listener.onGamegClick(Games);
            }
        });
        holder.fav_imageview.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        All_Games.gmm.AddtoFav(Gamelist.get(position));
                    }
                }
        );
    }

    @Override
    public int getItemCount() {
        return Gamelist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView,imageview_mai,fav_imageview;
        TextView titleTextView, likeCountTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            fav_imageview = itemView.findViewById(R.id.fav_imageview);
            titleTextView = itemView.findViewById(R.id.titleTextView);
        }
    }
}
