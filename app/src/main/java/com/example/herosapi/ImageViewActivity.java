package com.example.herosapi;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
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
            String imgUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTQtqoYVNgs4SvecZY-yL4QJ4sw1tfOKlJssIIh_2XECO9ZcGJfGg";
            URL url = new URL(imgUrl);


        }
        catch (IOException e){
            Toast.makeText(ImageViewActivity.this, "Error : "+e.getLocalizedMessage(), Toast.LENGTH_LONG).show();

        }
    }
}
