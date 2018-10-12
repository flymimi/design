package com.example.design;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //发布内容的监听部分
        ImageButton imageButton =findViewById(R.id.second);
        ImageButton imageButton1 =findViewById(R.id.fouth);
final DrawerLayout drawerLayout =findViewById(R.id.drawlayout);
        NavigationView navigationView =findViewById(R.id.nav1);

        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
drawerLayout.openDrawer(GravityCompat.START);
            }
        });


        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                FragmentManager fragmentManager =getFragmentManager();
//                FragmentTransaction ft =fragmentManager.beginTransaction();
//                Fragment fragment=new fragment1();
//                ft.replace(R.id.fragment1,fragment);
//                ft.commit();
                Intent intent =new Intent(Main2Activity.this,Main4Activity.class);
                startActivity(intent);
            }
        });

        final TabHost tab = (TabHost) findViewById(android.R.id.tabhost);
        tab.setup();
        tab.addTab(tab.newTabSpec("tab1").setIndicator("首页", null).setContent(R.id.tab1));
        tab.addTab(tab.newTabSpec("tab2").setIndicator("校园新鲜事", null).setContent(R.id.tab2));
        TabWidget tabWidget = tab.getTabWidget();
        tab.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                tab.setCurrentTabByTag(tabId);
                updateTab(tab);
            }
        });//获取TabHost的头部

        for (int i = 0; i < tabWidget.getChildCount(); i++) {                         //循环每个tabView
            View view = tabWidget.getChildAt(i);                                 //获取tabView项
            view.setContentDescription(Integer.toString(i + 1));
            view.getLayoutParams().height = (int) (view.getLayoutParams().height / 1.2);
            switch (i) {
                case 0: {
                    view.setBackgroundColor(0xFFCCCCCC);
                    break;
                }
                case 1: {

                    view.setBackgroundColor(0xFFCCCCCC);

                    break;
                }

            }
            TextView tv = (TextView) tabWidget.getChildAt(i).findViewById(android.R.id.title);
            tv.setTextSize(25);
        }

    }



    private void updateTab(TabHost tab) {
        for (int i = 0; i < tab.getTabWidget().getChildCount(); i++) {
            View view = tab.getTabWidget().getChildAt(i);
            if (tab.getCurrentTab() == i) {//选中
                view.setBackgroundColor(0xFF0000FF);

            } else {
                view.setBackgroundColor(0xFFCCCCCC);//非选择的背景

            }
        }
    }
}









