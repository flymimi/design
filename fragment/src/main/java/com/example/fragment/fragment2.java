package com.example.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class fragment2 extends Fragment {
    private TextView textView;

    public  static  fragment2  newInstance(String tag) {
        fragment2 f2 =new fragment2();
        Bundle bundle =new Bundle();
        bundle.putString("tag",tag);
        f2.setArguments(bundle);
        return f2;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment2,container,false);
        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView =view.findViewById(R.id.text2);
textView.setText(getArguments().getString("tag"));
    }



}
