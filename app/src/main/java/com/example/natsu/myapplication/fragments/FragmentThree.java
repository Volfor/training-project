package com.example.natsu.myapplication.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.natsu.myapplication.R;

public class FragmentThree extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_three, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        try {
            changeText(getArguments().getString("fragtext3"));
        } catch (Exception ignored) {}
    }

    public void changeText(String s){
        try {
            TextView frv = (TextView) getView().findViewById(R.id.textViewFragmentThree);
            frv.setText(s);
        } catch (Exception ignored) {}
    }
}
