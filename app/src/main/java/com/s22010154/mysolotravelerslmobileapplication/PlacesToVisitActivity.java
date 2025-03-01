package com.s22010154.mysolotravelerslmobileapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class PlacesToVisitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_to_visit);

        // Pinnawala video
        VideoView videoViewPinnawala = findViewById(R.id.videopinnawala);
        videoViewPinnawala.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.pinnawala);

        videoViewPinnawala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!videoViewPinnawala.isPlaying()) {
                    videoViewPinnawala.start();
                } else {
                    videoViewPinnawala.pause();
                }
            }
        });
        MediaController mediaControllerPinnawala = new MediaController(this);
        mediaControllerPinnawala.setAnchorView(videoViewPinnawala);
        videoViewPinnawala.setMediaController(mediaControllerPinnawala);

        // Jungle Beach video
        VideoView videoViewJungleBeach = findViewById(R.id.videojunglebeach);
        videoViewJungleBeach.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.jungle_beach);

        videoViewJungleBeach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!videoViewJungleBeach.isPlaying()) {
                    videoViewJungleBeach.start();
                } else {
                    videoViewJungleBeach.pause();
                }
            }
        });
        MediaController mediaControllerJungleBeach = new MediaController(this);
        mediaControllerJungleBeach.setAnchorView(videoViewJungleBeach);
        videoViewJungleBeach.setMediaController(mediaControllerJungleBeach);
    }
}
