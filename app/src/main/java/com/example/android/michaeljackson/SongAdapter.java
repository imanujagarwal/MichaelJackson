package com.example.android.michaeljackson;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.R.attr.start;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;
import static com.example.android.michaeljackson.R.id.song_name;

/**
 * Created by anuj on 17/10/17.
 */

public class SongAdapter extends ArrayAdapter {

    ArrayList<Song> songList;
    Context context;

    SongAdapter(Context context, int resourceId, ArrayList songList){
        super(context,resourceId,songList);
        this.songList  = songList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return songList.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable final View convertView, @NonNull ViewGroup parent) {

        View cv = convertView;
        final Song song = songList.get(position);

        if(cv == null ){
            cv = LayoutInflater.from(context).inflate(R.layout.listview_item,null);
        }

        TextView songName = cv.findViewById(song_name);
        songName.setText(song.getTrackName());

        TextView album = cv.findViewById(R.id.album);
        album.setText(song.getCollectionName());

        TextView tag = cv.findViewById(R.id.tag);
        tag.setText(song.getPrimaryGenreName());

        CircleImageView songPoster =  cv.findViewById(R.id.song_poster);

        String artwork = song.getArtworkUrl100();

        Picasso.with(context)
                .load(artwork)
                .into(songPoster);

        cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("title",song.getTrackName());
                intent.putExtra("album",song.getCollectionName());
                intent.putExtra("artwork",song.getArtworkUrl100());
                intent.putExtra("releasedate",song.getReleaseDate());
                intent.putExtra("duration",song.getTrackTimeMillis());
                intent.putExtra("tracklink",song.getPreviewUrl());

                context.startActivity(intent);
            }
        });



        return cv;
    }
}
