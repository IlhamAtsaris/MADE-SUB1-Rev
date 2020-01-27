package com.assosiate.atsaris.moviecatalogue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String[] dataTitle, dataDescription, dataAudiencescore, dataTomatometer, dataRuntime, dataReleasedate, dataGenre, dataDirectedby;
    private TypedArray dataPoster;
    private MovieAdapter adapter;
    ArrayList<Movie> movies;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.lv_list);
        adapter = new MovieAdapter(this);
        listView.setAdapter(adapter);

        prepare();
        addItem();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,View view,int i,long l) {
                Intent ObjectIntent = new Intent(MainActivity.this,MovieDetailActivity.class);
                ObjectIntent.putExtra(MovieDetailActivity.EXTRA_MOVIE,movies);
                startActivity(ObjectIntent);
    }
});

    }

    @Override
    public void onClick(View v) {
        //
    }

    private void addItem() {
        ArrayList<Movie> movies = new ArrayList<>();

        for (int i = 0; i < dataTitle.length;i++) {
            Movie movie= new Movie();
            movie.setPoster(dataPoster.getResourceId(i,-1));
            movie.setTitle(dataTitle[i]);
            movie.setDescription(dataDescription[i]);
            movie.setAudience_score(dataAudiencescore[i]);
            movie.setTomato_meter(dataTomatometer[i]);
            movie.setRuntime(dataRuntime[i]);
            movie.setRelease_date(dataReleasedate[i]);
            movie.setGenres(dataGenre[i]);
            movie.setDirectedby(dataDirectedby[i]);

            movies.add(movie);
        }
        adapter.setMovies(movies);
    }
    private void prepare() {
        dataTitle = getResources().getStringArray(R.array.data_title);
        dataDescription= getResources().getStringArray(R.array.data_description);
        dataPoster=getResources().obtainTypedArray(R.array.data_poster);
        dataAudiencescore=getResources().getStringArray(R.array.data_audience_score);
        dataTomatometer=getResources().getStringArray(R.array.data_tomato_meter);
        dataRuntime=getResources().getStringArray(R.array.data_runtime);
        dataReleasedate=getResources().getStringArray(R.array.data_in_theater);
        dataGenre=getResources().getStringArray(R.array.data_genres);
        dataDirectedby=getResources().getStringArray(R.array.data_directer_by);
    }
}