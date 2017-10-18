package com.example.android.michaeljackson;

/**
 * Created by anuj on 18/10/17.
 */

public class Utilities {

    public static String getFormattedTime(String timeInMilis){

        long minutes = (Integer.parseInt(timeInMilis) / 1000)  / 60;
        int seconds = (Integer.parseInt(timeInMilis) / 1000) % 60;

        return minutes + " minutes " + seconds + " seconds";
    }
}
