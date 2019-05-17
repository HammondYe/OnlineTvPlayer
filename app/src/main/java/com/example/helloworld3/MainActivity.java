package com.example.helloworld3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


public class MainActivity extends AppCompatActivity {

    private RecyclerView movieList;
    private MovieListAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        movieList = (RecyclerView) findViewById( R.id.movielist );


        movieList.setLayoutManager( new LinearLayoutManager( this ) );
        movieList.setAdapter( new MovieListAdapter( MainActivity.this, new MovieListAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                String movieName = MovieLab.get().getMovie( pos );
                String movieUrl = MovieLab.get().getUrl( pos );

                Intent intent = new Intent( MainActivity.this, LiveActivity.class );
                intent.putExtra( "uri", movieUrl );
                intent.putExtra( "name", movieName );
                startActivity( intent );
            }
        } ) );

    }}