package com.example.natsu.myapplication.services;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;

import android.net.Uri;
import android.os.Binder;
import android.os.Environment;
import android.os.IBinder;

import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.webkit.MimeTypeMap;
import android.widget.Toast;


import com.example.natsu.myapplication.activities.ServiceActivity;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.ProgressCallback;

import java.io.File;

public class MyService extends Service {
    public MyService() {
    }

    final String LOG_TAG = "myLogs";

    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    public class MyBinder extends Binder {
        public MyService getService() {
            return MyService.this;
        }
    }

    public void download(String source) {
        final int id = 1;
        final NotificationManager mNotifyManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        final NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);

        mBuilder.setContentTitle("File Download")
                .setContentText("Download in progress")
                .setSmallIcon(android.R.drawable.ic_dialog_info);

        Ion.with(this)
                .load(source)
                .progressHandler(new ProgressCallback() {
                    @Override
                    public void onProgress(long downloaded, long total) {
                        mBuilder.setProgress((int) total, (int) downloaded, false);
                        mNotifyManager.notify(id, mBuilder.build());
                    }
                })
                .write(new File(Environment.getExternalStorageDirectory().getPath() + "/Download/Example.zip"))
                .setCallback(new FutureCallback<File>() {
                    @Override
                    public void onCompleted(Exception e, File file) {
                        // download done...
                        // do stuff with the File or error
                        if (e != null) {
                            mBuilder.setContentText("Error downloading file")
                                    .setProgress(0, 0, false)
                                    .setSmallIcon(android.R.drawable.ic_dialog_alert);
                            mNotifyManager.notify(id, mBuilder.build());
                            return;
                        }

                        mBuilder.setContentText("Download complete")
                                .setProgress(0, 0, false);

                        Intent intent = new Intent();
                        intent.setAction(android.content.Intent.ACTION_VIEW);
                        file = new File(Environment.getExternalStorageDirectory().getPath() + "/Download/Example.zip");

                        String ext = file.getName().substring(file.getName().indexOf(".") + 1);
                        intent.setDataAndType(Uri.fromFile(file), MimeTypeMap.getSingleton().getMimeTypeFromExtension(String.valueOf(ext)));

                        PendingIntent pIntent = PendingIntent.getActivity(MyService.this, 0, intent, 0);
                        mBuilder.setContentIntent(pIntent);
                        mNotifyManager.notify(id, mBuilder.build());
                    }
                });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}