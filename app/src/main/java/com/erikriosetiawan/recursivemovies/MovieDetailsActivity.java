package com.erikriosetiawan.recursivemovies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class MovieDetailsActivity extends AppCompatActivity {

    private ImageView imgPosterDetails;
    private TextView txtTitleDetails, txtReleaseDateDetails, txtDescriptionDetails;

    public static final String DATA_KEY = "Zxi87f*jk'd";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);


        imgPosterDetails = findViewById(R.id.img_poster_details);
        txtTitleDetails = findViewById(R.id.txt_title_details);
        txtReleaseDateDetails = findViewById(R.id.txt_release_date_details);
        txtDescriptionDetails = findViewById(R.id.txt_description_details);

        Movie movie = getIntent().getParcelableExtra(DATA_KEY);
        imgPosterDetails.setImageResource(movie.getPoster());
        txtTitleDetails.setText(movie.getTitle());
        txtReleaseDateDetails.setText(movie.getRelease());
        txtDescriptionDetails.setText(movie.getDescription());

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(txtTitleDetails.getText().toString());
        }
    }
}
