package com.example.recylerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private int []imageId ={R.drawable.organge,R.drawable.pear,R.drawable.shumei,R.drawable.tao};
    private String []text ={"橘子","香梨","树莓","桃子"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView =findViewById(R.id.recyclerview);

    }
}
