package com.example.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.zip.Inflater;

public class fragment1 extends Fragment {
    private  S s;
    private Button button2;
    private  Button button3;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1,container,false);
      return  view;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        s= (S) context;
    }

    public  interface  S{
    void   onclick(String text);
}
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        button2 =view.findViewById(R.id.b2);
        button3=view.findViewById(R.id.b3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              s.onclick("逍遥叹是一首好歌");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add(fragment2.newInstance("你是一直猪"));

            }
        });
       fragment2 fragment2 =new fragment2();
    }
    private void  add(Fragment fragment){

        FragmentManager fragmentManager =getFragmentManager();
        FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.f2,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();



    }
}
