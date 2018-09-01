package com.example.omfg.napoleontesttask.Networking.Requests;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.InputStream;

public class ImageDownloader extends AsyncTask<String, Void, Bitmap> {


    @Override
    protected Bitmap doInBackground(String... strings) {
String url = strings[0];
    Bitmap image = null;

    try{
        InputStream in = new java.net.URL(url).openStream();
        image = BitmapFactory.decodeStream(in);

    }catch (Exception e){e.printStackTrace();}


        return image;
    }
}
