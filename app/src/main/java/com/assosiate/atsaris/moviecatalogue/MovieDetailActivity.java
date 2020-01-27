package com.assosiate.atsaris.moviecatalogue;



import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MovieDetailActivity extends AppCompatActivity {

    String title,description, audience_score, tomato_meter, runtime, releas_date, genre,directedby;
    int path;

    public static final String EXTRA_MOVIE = "extra_movie";

    TextView tvTitle,tvDescription, tvAudienceScore, tvTomatoMeter,tvRunTime, tvReleaseDate, tvGenre,tvDirectedby;

    ImageView imagePoster;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        tvTitle= findViewById(R.id.txt_title);
        tvDescription=findViewById(R.id.txt_description);
        tvAudienceScore=findViewById(R.id.txt_audience_score);
        tvTomatoMeter=findViewById(R.id.txt_tomato_meter);
        tvRunTime=findViewById(R.id.txt_runtime);
        tvReleaseDate=findViewById(R.id.txt_date_release);
        tvGenre=findViewById(R.id.txt_genres);
        tvDirectedby=findViewById(R.id.txt_directed_by);
        imagePoster=findViewById(R.id.img_poster);

        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);

        path=movie.getPoster();
        imagePoster.setImageResource(path);

        title=movie.getTitle();
        tvTitle.setText(title);

        description=movie.getDescription();
        tvDescription.setText(description);

        tomato_meter=movie.getTomato_meter();
        tvTomatoMeter.setText(tomato_meter);

        genre=movie.getGenres();
        tvGenre.setText(genre);

        runtime=movie.getRuntime();
        tvRunTime.setText(runtime);

        releas_date=movie.getRelease_date();
        tvReleaseDate.setText(releas_date);

        directedby=movie.getDirectedby();
        tvDirectedby.setText(directedby);

        audience_score=movie.getAudience_score();
        tvAudienceScore.setText(audience_score);
    }
}
