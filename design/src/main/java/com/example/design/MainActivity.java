package com.example.design;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

public class MainActivity extends AppCompatActivity {
    EditText editText1, editText2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bmob.initialize(this, "96318af062a16892a1adaa6ea9177605");
        final EditText editText1 = findViewById(R.id.edit1);
        final EditText editText2 = findViewById(R.id.edit2);
        Button button = findViewById(R.id.button);
        TextView textView3 =findViewById(R.id.te3);
      textView3.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent =new Intent(MainActivity.this,Main3Activity.class);
              startActivity(intent);
          }
      });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final String user = editText1.getText().toString();
                final String password = editText2.getText().toString();
                if (TextUtils.isEmpty(user) || TextUtils.isEmpty(password)) {
                    Toast.makeText(MainActivity.this, "密码或账号不能为空", Toast.LENGTH_LONG).show();
                    return;
                }
                BmobUser use = new BmobUser();
                use.setUsername(user);
                use.setPassword(password);
                use.signUp(new SaveListener<BmobUser>() {
                    @Override
                    public void done(BmobUser bmobUser, BmobException e) {
                        if (e == null) {
                                //注册成功跳转到登陆界面
                                Toast.makeText(MainActivity.this, "注册成功", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(MainActivity.this, Main3Activity.class);
                                startActivity(intent);
                                } else{

                            Toast.makeText(MainActivity.this, "注册失败，该用户名已被占用", Toast.LENGTH_LONG).show();
                        }

                    }
                });
            }

        });
        BmobUser bmobUser = BmobUser.getCurrentUser();
        if(bmobUser != null){


            // 允许用户使用应用

        }else{
            //缓存用户对象为空时， 可打开用户注册界面…

        }

    }
}

