package com.example.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
private int image[] ={R.drawable.first,R.drawable.second,R.drawable.third,R.drawable.fourth,R.drawable.fourth};
private  String text[]={"首页","发布","消息","我的","好的"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
List<Map<String,Object>> list =new ArrayList<Map<String,Object>>();
for (int i =0;i<image.length;i++){
    Map<String,Object> map=new HashMap<String, Object>();
    map.put("image",image[i]);
    map.put("text",text[i]);
    list.add(map);
}
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,list,R.layout.main, new String[]{"image","text"},new int[]{R.id.img,R.id.text});
ListView listView =findViewById(R.id.listview);
listView.setAdapter(simpleAdapter);
listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Map<String,Object> map = (Map<String, Object>) parent.getItemAtPosition(position);
        Toast.makeText(MainActivity.this,map.get("text").toString(),Toast.LENGTH_LONG).show();

    }
});
}


    }

