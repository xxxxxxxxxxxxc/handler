package com.thoughtworks.handler;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.lang.ref.WeakReference;

public class MyHandler extends Handler {
    private final WeakReference<Context> context;

    public MyHandler(@NonNull Looper looper, WeakReference<Context> context) {
        super(looper);
        this.context = context;
    }

    @Override
    public void handleMessage(@NonNull Message msg) {
        Log.d("msg", String.valueOf(msg.what));
        Toast.makeText(this.context.get(), String.format("msg arrived with type %s", msg.what), Toast.LENGTH_SHORT).show();
    }
}
