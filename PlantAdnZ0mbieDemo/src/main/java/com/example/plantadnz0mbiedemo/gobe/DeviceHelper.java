package com.example.plantadnz0mbiedemo.gobe;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.util.DisplayMetrics;

/**
 * 处理设备的适应性
 */
public class DeviceHelper {
    private  static  int[]deviceSize =new int[2];
    public  static Bitmap resizeBitmap(Bitmap bitmap){
        if (bitmap!=null){
            int width =bitmap.getWidth();
            int height =bitmap.getHeight();
            //进行变换，矩阵变换
            Matrix matrix =new Matrix();
            matrix.postScale(Config.scaleWidth,Config.scaleHeight);
            Bitmap resizeBitmap =Bitmap.createBitmap(bitmap,0,0,width,height,matrix,true);
            return  resizeBitmap;


        }else {
            return null;
        }
    }
    /**
     * 返回设备尺寸
     */

    public  static  int[] getDeviceInfo(Context context){
        if (deviceSize[0]==0&&deviceSize[1]==0){
            DisplayMetrics metrics =new DisplayMetrics();
            ((Activity)context).getWindowManager().getDefaultDisplay().getMetrics(metrics);
            deviceSize[0]=metrics.widthPixels;
            deviceSize[1] =metrics.heightPixels;


        }
        return  deviceSize;
    }
}
