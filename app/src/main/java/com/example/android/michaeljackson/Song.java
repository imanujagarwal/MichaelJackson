package com.example.android.michaeljackson;

/**
 * Created by anuj on 17/10/17.
 */

public class Song {

    String collectionName;
    String trackName;
    String previewUrl;
    String artworkUrl100;
    String releaseDate;
    String trackTimeMillis;
    String primaryGenreName;

    public Song(
            String collectionName,
            String trackName,
            String previewUrl,
            String artworkUrl100,
            String releaseDate,
            String trackTimeMillis,
            String primaryGenreName)
    {
        this.collectionName = collectionName;
        this.trackName = trackName;
        this.previewUrl = previewUrl;
        this.artworkUrl100 = artworkUrl100;
        this.releaseDate = releaseDate;
        this.trackTimeMillis = trackTimeMillis;
        this.primaryGenreName = primaryGenreName;
    }



    public String getCollectionName() {
        return collectionName;
    }

    public String getTrackName() {
        return trackName;
    }


    public String getPreviewUrl() {
        return previewUrl;
    }


    public String getArtworkUrl100() {
        return artworkUrl100;
    }


    public String getReleaseDate() {
        return releaseDate;
    }


    public String getTrackTimeMillis() {
        return trackTimeMillis;
    }


    public String getPrimaryGenreName() {
        return primaryGenreName;
    }
}
