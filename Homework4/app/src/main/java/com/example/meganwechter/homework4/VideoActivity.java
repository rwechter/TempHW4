package com.example.meganwechter.homework4;

import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        // VideoView reference see main.xml
        VideoView mVideoView = (VideoView)findViewById(R.id.videoview);

        String uriPath = "android.resource://com.example.meganwechter.homework4/"+R.raw.movie;

        // Creates a Uri which parses the given encoded URI string
        Uri uri = Uri.parse(uriPath);

        // set the video URO
        mVideoView.setVideoURI(uri);
        // start the video
        mVideoView.requestFocus();
        mVideoView.start();

    }
}
