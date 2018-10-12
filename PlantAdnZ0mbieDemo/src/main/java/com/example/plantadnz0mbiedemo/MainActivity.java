package com.example.plantadnz0mbiedemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.plantadnz0mbiedemo.gobe.Config;
import com.example.plantadnz0mbiedemo.gobe.DeviceHelper;
import com.example.plantadnz0mbiedemo.view.GameView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        init();
        setContentView(new GameView(this));
    }
    private  void  init(){
        Config.deviceWidth = DeviceHelper.getDeviceInfo(this)[0];
        Config.deciceHeifht =DeviceHelper.getDeviceInfo(this)[1];
        Config.gameBk = BitmapFactory.decodeResource(getResources(),R.drawable.bk);
        //获得缩放比：利用背景图片作为基准
        Config.scaleWidth =Config.deviceWidth/(float)Config.gameBk.getWidth();
        Config.scaleHeight =Config.deciceHeifht/(float)Config.gameBk.getHeight();
        //使用缩放生成目标图片
        Config.gameBk =DeviceHelper.resizeBitmap(Config.gameBk);
    }
}
