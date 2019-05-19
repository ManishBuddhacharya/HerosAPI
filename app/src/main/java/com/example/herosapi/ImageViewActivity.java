package com.example.herosapi;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.net.URL;

import url.Url;

public class ImageViewActivity extends AppCompatActivity {
    private ImageView imgView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);

        imgView = findViewById(R.id.imgPhoto);
        loadFromUrl();
    }

    private void StrictMode(){
        android.os.StrictMode.ThreadPolicy policy = new android.os.StrictMode.ThreadPolicy.Builder().permitAll().build();
        android.os.StrictMode.setThreadPolicy(policy);
    }

    private void loadFromUrl() {
        StrictMode();
        try {
            String imgUrl = "https://www.gststic.com/webp/gallery3/1.sm.png";
            URL= new URL(imgUrl);

        }
    }
}
