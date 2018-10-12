package com.example.design;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class Main3Activity extends AppCompatActivity {

    private CheckBox rememberPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Bmob.initialize(this, "96318af062a16892a1adaa6ea9177605");
        final EditText editText1 = findViewById(R.id.edit1);
        final EditText editText2 = findViewById(R.id.edit2);
        Button button = findViewById(R.id.button);
        rememberPass=findViewById(R.id.checkbox);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = editText1.getText().toString();
                String password = editText2.getText().toString();
                if (TextUtils.isEmpty(user) || TextUtils.isEmpty(password)) {
                    Toast.makeText(Main3Activity.this, "密码不能为空", Toast.LENGTH_LONG).show();
                    return;
                }

               BmobUser bu2 = new BmobUser();
                bu2.setUsername(user);
                bu2.setPassword(password);
                // 使用BmobSDK提供的登录功能
                bu2.login(new SaveListener<BmobUser>() {

                    @Override
                    public void done(BmobUser bmobUser, BmobException e) {
                        if(e==null){

                            Intent intent =new Intent(Main3Activity.this,Main2Activity.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(Main3Activity.this, "账户名或密码不正确", Toast.LENGTH_SHORT).show();
                            Intent intent =new Intent(Main3Activity.this,MainActivity.class);
                            startActivity(intent);

                        }
                    }
                });


    }
});

    }
}

