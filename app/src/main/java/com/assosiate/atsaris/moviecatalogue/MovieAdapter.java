package com.assosiate.atsaris.moviecatalogue;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {
    private final Context context;
    private ArrayList<Movie> movies;

    void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    MovieAdapter(Context context) {
        this.context = context;
        movies=new ArrayList<>();
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;
        if (itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.item_movie, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(itemView);
        Movie movie = (Movie) getItem(i);
        viewHolder.bind(movie);
        return itemView;
    }

    public class ViewHolder {
        private TextView txtTitle, txtDescription, txtTomatometer, txtGenres;
        private ImageView imgPoster;

        ViewHolder(View view) {
            txtTitle = view.findViewById(R.id.txt_title);
            txtDescription = view.findViewById(R.id.txt_description);
            imgPoster = view.findViewById(R.id.img_poster);
            txtTomatometer = view.findViewById(R.id.txt_tomato_meter);
            txtGenres = view.findViewById(R.id.txt_genres);


        }

        void bind(Movie movie) {
            txtTitle.setText(movie.getTitle());
            txtDescription.setText(movie.getDescription());
            txtTomatometer.setText(movie.getTomato_meter());
            txtGenres.setText(movie.getGenres());
            imgPoster.setImageResource(movie.getPoster());


        }

    }
}
