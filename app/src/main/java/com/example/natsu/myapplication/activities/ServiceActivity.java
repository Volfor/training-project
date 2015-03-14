package com.example.natsu.myapplication.activities;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.example.natsu.myapplication.R;
import com.example.natsu.myapplication.services.MyService;

public class ServiceActivity extends Activity {

    final String LOG_TAG = "myLogs";
    MyService mService;
    boolean mBound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, MyService.class);
        bindService(intent, conn, BIND_AUTO_CREATE);
    }

    public void onDownloadButtonClick(View v) {
        if (mBound) {
            mService.download("https://dl.dropboxusercontent.com/u/9689938/Example.zip");
            //"https://vk.com/doc72718449_373797788"
            //"http://developer.clockworkmod.com/downloads/51/4883/cm-10.1-20130512-CPUFREQ-m7.zip"
        }
    }

    private ServiceConnection conn = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName className, IBinder service) {
            MyService.MyBinder binder = (MyService.MyBinder) service;
            mService = binder.getService();
            mBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            mBound = false;
        }
    };

}
