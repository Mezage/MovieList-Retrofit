package edu.uci.swe264p.retrofit;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieViewHolder> {
    private List<Movie> movieList;

    MovieListAdapter(List<Movie> list){
        this.movieList = list;
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder{
        TextView title, date, vote, overview;
        ImageView poster;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tvTitle);
            date = itemView.findViewById(R.id.tvReleaseDate);
            vote = itemView.findViewById(R.id.tvVote);
            overview = itemView.findViewById(R.id.tvOverview);
            poster = itemView.findViewById(R.id.ivMovie);
        }
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_row, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movieAttr = movieList.get(position);

        MovieViewHolder vHolder = (MovieViewHolder) holder;
        vHolder.title.setText(movieAttr.getTitle());
        vHolder.date.setText(movieAttr.getReleaseDate());
        vHolder.vote.setText(movieAttr.getVoteAverage().toString());
        vHolder.overview.setText(movieAttr.getOverview());

        Picasso.get().load("https://image.tmdb.org/t/p/w500" + movieAttr.getPosterPath()).into(vHolder.poster);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }
}
