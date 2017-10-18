package com.example.android.michaeljackson;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by anuj on 18/10/17.
 */

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_layout);
        final Context context = this;

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String album = intent.getStringExtra("album");
        String artwork = intent.getStringExtra("artwork");
        String releasedate = intent.getStringExtra("releasedate");
        String duration = intent.getStringExtra("duration");
        final String tracklink = intent.getStringExtra("tracklink");

        ImageView imageView =  (ImageView) findViewById(R.id.backdrop);

        TextView mTitle = (TextView)findViewById(R.id.song_title);
        TextView mAlbum = (TextView) findViewById(R.id.album_title);
        ImageView mArtwork = (ImageView) findViewById(R.id.artwork);
        TextView mReleaseDate = (TextView) findViewById(R.id.release_date);
        TextView mDuartion = (TextView) findViewById(R.id.duration);
        Button mTrackLink = (Button) findViewById(R.id.track_button);


        mTitle.setText(title);
        mAlbum.setText(album);
        mReleaseDate.setText(releasedate.substring(0,10));
        mDuartion.setText(Utilities.getFormattedTime(duration));

        Picasso.with(getBaseContext()).load(artwork).into(mArtwork);


        Picasso.with(getBaseContext()).load("http://redcarpetrefs.com/wp-content/uploads/2016/06/Screen-Shot-2016-06-05-at-4.56.35-PM-1024x512.png").into(imageView);

        mTrackLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context
                        ,WebViewActivity.class);
                i.putExtra("trackUrl",tracklink);
                startActivity(i);
            }
        });
    }
}
