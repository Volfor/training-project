package com.example.natsu.myapplication.activities;

import android.app.FragmentTransaction;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import com.example.natsu.myapplication.fragments.FragmentOne;
import com.example.natsu.myapplication.fragments.FragmentThree;
import com.example.natsu.myapplication.fragments.FragmentTwo;
import com.example.natsu.myapplication.R;

public class ThirdActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
    }

    public void onBut1Click(View view) {
        EditText editTextFragOne = (EditText) findViewById(R.id.editTextFragmentOne);

        FragmentOne frag = new FragmentOne();
        if(!(editTextFragOne.getText().toString().equals(""))) {
            Bundle bundle = new Bundle();
            bundle.putString("fragtext1", editTextFragOne.getText().toString());

            frag.setArguments(bundle);
        }

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_container, frag);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }

    public void onBut2Click(View view) {
        EditText editTextFragTwo = (EditText) findViewById(R.id.editTextFragmentTwo);

        FragmentTwo frag2 = new FragmentTwo();
        if(!editTextFragTwo.getText().toString().equals("")) {
            Bundle bundle = new Bundle();
            bundle.putString("fragtext2", editTextFragTwo.getText().toString());

            frag2.setArguments(bundle);
        }

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_container2, frag2);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }

    public void onBut3Click(View view) {
        EditText editTextFragThree = (EditText) findViewById(R.id.editTextFragmentThree);

        FragmentThree frag3 = new FragmentThree();
        if(!editTextFragThree.getText().toString().equals("")) {
            Bundle bundle = new Bundle();
            bundle.putString("fragtext3", editTextFragThree.getText().toString());
            frag3.setArguments(bundle);
        }

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_container3, frag3);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }

}
