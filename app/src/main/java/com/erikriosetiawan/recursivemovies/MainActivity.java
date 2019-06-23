package com.erikriosetiawan.recursivemovies;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] dataTitle;
    private String[] dataReleaseDate;
    private String[] dataDescription;
    private TypedArray dataPoster;
    private MovieAdapter adapter;
    private ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Popular Movie List");
        }
        adapter = new MovieAdapter(this);
        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Movie movie = new Movie();
                movie.setTitle(movies.get(position).getTitle());
                movie.setRelease(movies.get(position).getRelease());
                movie.setDescription(movies.get(position).getDescription());
                movie.setPoster(movies.get(position).getPoster());

                Intent intentMoveMoviesObject = new Intent(MainActivity.this, MovieDetailsActivity.class);
                intentMoveMoviesObject.putExtra(MovieDetailsActivity.DATA_KEY, movie);
                startActivity(intentMoveMoviesObject);
            }
        });
    }

    private void prepare() {
        dataTitle = getResources().getStringArray(R.array.data_title);
        dataReleaseDate = getResources().getStringArray(R.array.data_release_date);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataPoster = getResources().obtainTypedArray(R.array.data_poster);
    }

    private void addItem() {
        movies = new ArrayList<>();

        for (int i = 0; i < dataTitle.length; i++) {
            Movie movie = new Movie();
            movie.setTitle(dataTitle[i]);
            movie.setRelease(dataReleaseDate[i]);
            movie.setDescription(dataDescription[i]);
            movie.setPoster(dataPoster.getResourceId(i, -1));
            movies.add(movie);
        }
        adapter.setMovies(movies);
    }
}
