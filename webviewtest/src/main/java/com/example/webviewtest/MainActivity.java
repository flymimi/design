package com.example.webviewtest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
TextView reposeText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button sendRequest =findViewById(R.id.send_request);
        reposeText=findViewById(R.id.repose_text);
        sendRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId()==R.id.send_request){
                    sendRequestWithHttpURLConnection();
                }
            }
        });

    }

    private void sendRequestWithHttpURLConnection() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                BufferedReader reader = null;
             try{   URL url = new URL("https://www.baidu.com");
                 connection=(HttpURLConnection)url.openConnection();
                connection.setRequestMethod("GET");
                connection.setConnectTimeout(8000);
                connection.setReadTimeout(8000);
                 InputStream in =connection.getInputStream();
                 reader =new BufferedReader(new InputStreamReader(in));
                 StringBuilder response =new StringBuilder();
                 String line;
                 while ((line=reader.readLine())!=null){
                     response.append(line);
                 }
                 showResponse(response.toString());
            }catch (Exception e){
                 e.printStackTrace();
             }finally {
                 if(reader!=null){
                     try {
                         reader.close();
                     } catch (IOException e) {
                         e.printStackTrace();
                     }
                 }
                 if (connection!=null){
                     connection.disconnect();
                 }
             }

            }
        }).start();
    }

    private void showResponse(final String response) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                reposeText.setText(response);
            }
        });
    }
}
