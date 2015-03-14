package com.example.natsu.myapplication.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.natsu.myapplication.R;

public class FragmentOne extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_one, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        //super.onViewCreated(view, savedInstanceState);
        try {
            changeText(getArguments().getString("fragtext1"));
        } catch (Exception ignored) {}
    }

    public void changeText(String s){
        try {
            TextView frv = (TextView) getView().findViewById(R.id.textViewFragmentOne);
            frv.setText(s);
        } catch (Exception ignored) {}
    }

}
