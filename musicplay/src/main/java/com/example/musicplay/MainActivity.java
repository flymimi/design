package com.example.musicplay;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
private ImageButton button;
private  boolean pause=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageButton imageButton =findViewById(R.id.b1);
        final MediaPlayer mediaPlayer =MediaPlayer.create(MainActivity.this,R.raw.one);
      final   ImageView imageView=findViewById(R.id.imageview);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mediaPlayer.isPlaying()&&pause){
                    Animation animation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.fry1);
                    imageView.startAnimation(animation);
                    ((ImageButton)v).setImageResource(R.drawable.b2);
                    mediaPlayer.start();

                    pause=false;
                }
             else {
                    Animation animation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.fry1);
                    imageView.clearAnimation();
                    ((ImageButton)v).setImageResource(R.drawable.b1);
                    mediaPlayer.pause();

                    pause=true;

                }


            }
        });

    }
}
