package com.example.gfbosurfaceview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;


//surface是View的子类常用于更新较快的页面
//View.OnTouchListener触摸事件


class GameView extends SurfaceView implements SurfaceHolder.Callback,View.OnTouchListener ,SensorEventListener{
    private  SurfaceHolder holder;
    private Canvas canvas;//画布
    private Paint paint;//画笔
    private  int sceenWidth,sceenHeight;
    private float x,y,radious =100;
    private  int direction =1;//圆变化的方向
    private boolean threadFlag;//线程管理标志
    private  float speed =1.0f;//每秒25帧/秒
    private SensorManager sm;//传感器管理类
    private  float[] accelerometerValues =new float[3];//加速度传感数据
    private  float[] mangeticFieldValues =new float[3];//地磁传感数据





    public GameView(Context context) {
        super((android.content.Context) context);
        holder =getHolder();//获取了当前托管对象
        holder.addCallback(this);//加载回调接口
        paint =new Paint();
        sceenWidth =getResources().getDisplayMetrics().widthPixels;
        sceenHeight =getResources().getDisplayMetrics().heightPixels;
        //圆坐标
        x=sceenWidth/2;
        y=sceenWidth/2;
        setOnTouchListener(this);
        //注册传感器
        sm = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        sm.registerListener(this,sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_GAME);
   sm.registerListener(this,sm.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD),SensorManager.SENSOR_DELAY_GAME);

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
threadFlag =true;//设置线程启动标志
        new DrawThread().start();

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {


    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
threadFlag=false;//设置线程停止标志

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        x=event.getRawX();
        y=event.getRawY();
        return false;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        //获取对应的传感数据
        if(event.sensor.getType()==Sensor.TYPE_ACCELEROMETER){
        accelerometerValues =event.values;
        }if(event.sensor.getType()==Sensor.TYPE_MAGNETIC_FIELD){
            mangeticFieldValues =event.values;
        }
        //数据处理：矩阵变化
        float[]values =new float[3];
        float[] r =new float[9];
        SensorManager.getRotationMatrix(r,null,accelerometerValues,mangeticFieldValues);
        SensorManager.getOrientation(r,values);
        values[1]= (float) Math.toDegrees(values[1]);
        values[2] = (float) Math.toDegrees(values[2]);
        if (values[2]>0&&x<sceenWidth)x+=5;//右移
        if (values[2]<0&&x>0)x-=5;//左移
        if(values[1]>0&&y>0)y-=5;//上移
        if (values[1]<0&&y<sceenHeight)y+=5;//下移


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    private class DrawThread extends  Thread {
        @Override
        public void run() {
            while (threadFlag){
long _statTime =System.currentTimeMillis();
canvas =holder.lockCanvas();//获取当前画布并锁定
                draw();//界面控制
                logic();//逻辑控制

                holder.unlockCanvasAndPost(canvas);//释放画布并提交刷新界面

long _endTime =System.currentTimeMillis();
long _sleepTime =(long)(speed*40)-(_endTime-_statTime);
if (_sleepTime>0){
    try {
        Thread.sleep(_sleepTime);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}

            }
        }
    }


    private void draw() {
        //设置画笔清除与重绘的模式
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        canvas.drawPaint(paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setColor(Color.WHITE);
        canvas.drawRect(0,0,sceenWidth,sceenHeight,paint);
        paint.setColor(Color.BLUE);
        canvas.drawCircle(x,y,radious,paint);
    }
    private void logic() {
        radious+=5*direction;
        if(radious>=200||radious<=50){

            direction*=-1;

        }

    }

}
