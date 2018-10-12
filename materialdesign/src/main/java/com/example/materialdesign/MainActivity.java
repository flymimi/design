package com.example.materialdesign;

import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private DrawerLayout drawerLayout;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tool,menu);
    drawerLayout =findViewById(R.id.drawlayout);
        NavigationView navigationView =findViewById(R.id.nav);
        //默认选中
        FloatingActionButton floatingActionButton =findViewById(R.id.fl);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"删除嘛",Snackbar.LENGTH_LONG).setAction("不删除", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this,"删除了",Toast.LENGTH_SHORT).show();
                    }
                }).show();
            }
        });
        navigationView.setCheckedItem(R.id.nav1);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawers();
                return  true;

            }
        });
        ActionBar actionBar =getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.icon4);
        }
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
            case  R.id.one:
                Toast.makeText(MainActivity.this,"你点击了按钮一",Toast.LENGTH_SHORT).show();
                break;
            case  R.id.two:
                Toast.makeText(MainActivity.this,"你点击了按钮er",Toast.LENGTH_SHORT).show();
                break;
            case  R.id.three:
                Toast.makeText(MainActivity.this,"你点击了按钮san",Toast.LENGTH_SHORT).show();
                break;
                default:

        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar =findViewById(R.id.toolbar);
      setSupportActionBar(toolbar);

    }
}
