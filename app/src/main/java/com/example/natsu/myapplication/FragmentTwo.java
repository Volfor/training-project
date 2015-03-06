package com.example.natsu.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentTwo extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_two, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        try {
            changeText(getArguments().getString("fragtext2"));
        } catch (Exception ignored) {}

    }

    public void changeText(String s){
        try {
            TextView frv = (TextView) getView().findViewById(R.id.textViewFragmentTwo);
            frv.setText(s);
        } catch (Exception ignored) {}
    }
}