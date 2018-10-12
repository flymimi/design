package com.example.plantadnz0mbiedemo.view;

        import android.content.Context;
        import android.graphics.BitmapFactory;
        import android.graphics.Canvas;
        import android.graphics.Paint;
        import android.util.Log;
        import android.view.SurfaceHolder;
        import android.view.SurfaceView;

        import com.example.plantadnz0mbiedemo.R;
        import com.example.plantadnz0mbiedemo.gobe.Config;

/*
 * GameView游戏核心类：继承SurfaceView类，实现
 * */
public class GameView extends SurfaceView implements SurfaceHolder.Callback,Runnable{
    //相关成员变量声明
    private  Context context;
    private Canvas canvas;
    private Paint paint;
    private  SurfaceHolder surfaceHolder;
    private  boolean gameRunFlag;
    private  static  GameView gameView;

    public GameView(Context context) {
        super(context);
        this.context =context;
        this.paint =new Paint();
        this.surfaceHolder =this.getHolder();
        this.surfaceHolder.addCallback(this);

        this.gameRunFlag =true;
        gameView =this;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        //启动游戏
        new Thread(this).start();


    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    @Override
    public void run() {
        while (this.gameRunFlag){
            long _startTime =System.currentTimeMillis();
            synchronized (surfaceHolder){

                try {
                    canvas =surfaceHolder.lockCanvas();
                    logic();
                    draw();

                }catch (Exception e){
                    Log.e("*****==Mydebug==****","异常错误信息"+e.getMessage());

                }finally {
                    //解锁并提交画布
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
            long _emdTime =System.currentTimeMillis();
            long _sleepTime =40-(_emdTime-_startTime);
            //实现游戏帧数 40毫秒即25帧/秒
            if (_sleepTime>0) {
                try {
                    Thread.sleep(_sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //绘制方法
    private void draw() {
        //canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.bk),0,0,paint);
        canvas.drawBitmap(Config.gameBk,0,0,paint);
    }
    //游戏核心逻辑方法
    private void logic() {
    }

    public  static  GameView getInstance(){
        return  gameView;
    }
}
