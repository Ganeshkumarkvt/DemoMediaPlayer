package com.example.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView list;
    TextView sname;
    ImageButton img;
    SeekBar seek;
    Boolean isPlaying = true;
    String[] SongName = {"Vaathi Coming - Master", "Antha Kanna Paathaaka - Master", "Kutty Story - Master", "Quit Pannuda - Master", "Polakattum Para Para - Master", "Pona Pogattum - Master", "Vaathi Raid - Master", "Master - The Blaster - Master", "Beat Of Master (Instrumental) - Master" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        sname = findViewById(R.id.sngname);
        img = findViewById(R.id.pauseplay);
        seek = findViewById(R.id.seekBar);
        img.setOnClickListener(v -> {
            if(isPlaying) {
                img.setImageDrawable(getDrawable(R.drawable.play));
                seek.setThumb(getDrawable(R.drawable.pause_circle));
                isPlaying=false;
            }else{
                img.setImageDrawable(getDrawable(R.drawable.pause));
                seek.setThumb(getDrawable(R.drawable.play_circle));
                isPlaying=true;
            }
        });
        list = findViewById(R.id.list);
        CustomAdapter customAdapter = new CustomAdapter(this, SongName);
        list.setAdapter(customAdapter);
        list.isScrollingCacheEnabled();
        list.setOnItemClickListener((parent, view, position, id) -> sname.setText(SongName[position]));
    }


}