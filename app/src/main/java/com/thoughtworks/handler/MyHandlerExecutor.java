package com.thoughtworks.handler;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import java.lang.ref.WeakReference;

public class MyHandlerExecutor extends Thread {

    private Looper looper;
    private MyHandler myHandler;
    private WeakReference<Context> context;

    public MyHandlerExecutor(Context context) {
        this.context = new WeakReference<>(context);
    }

    @Override
    public void run() {
        Log.d("msg", "start executor");
        Looper.prepare();
        this.looper = Looper.myLooper();
        this.myHandler = new MyHandler(this.looper, this.context);
        Looper.loop();
    }

    public void sendMessage(Message msg) {
        this.myHandler.sendMessage(msg);
    }
}
