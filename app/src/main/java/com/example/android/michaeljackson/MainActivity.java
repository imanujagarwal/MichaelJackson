package com.example.android.michaeljackson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Song> songs;
    SongAdapter mSongAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list);

        songs = new ArrayList<Song>();

        mSongAdapter = new SongAdapter(this, R.layout.listview_item, songs);

        listView.setAdapter(mSongAdapter);

        String jsonData = getdata();

        try {
            parseAndFeedData(jsonData);
        } catch (Exception e) {
            String s;
        }

    }

    public void parseAndFeedData(String json) throws JSONException {

        JSONObject jsonObject = new JSONObject(json);
        JSONArray results = jsonObject.getJSONArray("results");

        String collectionName = "";
        String trackName = "";
        String previewUrl = "";
        String artworkUrl100 = "";
        String releaseDate = "";
        String trackTimeMillis = "";
        String primaryGenreName = "";


        for (int i = 0; i <results.length() ; i++) {

            JSONObject song = results.getJSONObject(i);

            if(song.has("collectionName"))
                collectionName = song.getString("collectionName");
            if(song.has("trackName"))
                trackName = song.getString("trackName");
            if(song.has("previewUrl"))
                previewUrl = song.getString("previewUrl");
            if(song.has("artworkUrl100"))
                artworkUrl100 = song.getString("artworkUrl100");
            if(song.has("releaseDate"))
                releaseDate = song.getString("releaseDate");
            if(song.has("trackTimeMillis"))
                trackTimeMillis = song.getString("trackTimeMillis");
            if(song.has("primaryGenreName"))
                primaryGenreName = song.getString("primaryGenreName");

            songs.add(new Song(
                    collectionName,
                    trackName,
                     previewUrl,
                     artworkUrl100,
                     releaseDate,
                     trackTimeMillis,
                     primaryGenreName));

        }
        mSongAdapter.notifyDataSetChanged();
    }

    public String getdata(){
        StringBuffer sb = new StringBuffer();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(getResources().openRawResource(
                    R.raw.michael_jackson)));
            String temp;
            while ((temp = br.readLine()) != null)
                sb.append(temp);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close(); // stop reading
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String myjsonstring = sb.toString();
        return myjsonstring;
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
