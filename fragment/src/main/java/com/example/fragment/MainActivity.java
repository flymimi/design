package com.example.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements fragment1.S{
    private  TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button =findViewById(R.id.b1);
        TextView textView =findViewById(R.id.one);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add(new fragment1());

            }
        });

    }
    private void  add(Fragment fragment){

        FragmentManager fragmentManager =getFragmentManager();
        FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.f1,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();



    }

    @Override
    public void onclick(String text) {
        textView.setText(text);
    }
}
