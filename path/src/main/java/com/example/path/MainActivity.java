package com.example.path;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    private  boolean flag =true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FrameLayout frameLayout =findViewById(R.id.frame);
        final AnimationDrawable animationDrawable = (AnimationDrawable) frameLayout.getBackground();
frameLayout.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if(flag){
            animationDrawable.start();
flag=false;
        }else {
            animationDrawable.stop();
            flag=true;

        }
    }
});
    }
}
