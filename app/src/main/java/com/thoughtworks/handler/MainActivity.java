package com.thoughtworks.handler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Message;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private MyHandlerExecutor myHandlerExecutor;

    @OnClick(R.id.event_a)
    void event_a_click() {
        Message msg = Message.obtain();
        msg.what = 1;
        this.myHandlerExecutor.sendMessage(msg);
    }

    @OnClick(R.id.event_b)
    void event_b_click() {
        Message msg = Message.obtain();
        msg.what = 2;
        this.myHandlerExecutor.sendMessage(msg);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        this.myHandlerExecutor = new MyHandlerExecutor(getBaseContext());
        this.myHandlerExecutor.start();

    }
}