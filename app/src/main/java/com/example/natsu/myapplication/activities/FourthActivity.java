package com.example.natsu.myapplication.activities;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.natsu.myapplication.R;

import java.util.Random;

public class FourthActivity extends Activity {

    LinearLayout linearLayout;
    int wrapContent = LinearLayout.LayoutParams.WRAP_CONTENT;
    int matchParent = LinearLayout.LayoutParams.MATCH_PARENT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
    }

    public void onCreateViewButtonClick(View view) {
        LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(wrapContent, matchParent, 1.0f);
        ImageView imgView = new ImageView(this);

        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        imgView.setBackgroundColor(color);

        linearLayout.addView(imgView, lParams);
    }

}
