package com.example.thread;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Schedule extends AppCompatActivity {

    private Button schedule;
    private ScheduledExecutorService service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        findId();
        initThreadpool();
        scheduleListener();

    }

    private void findId() {
        schedule=findViewById(R.id.schedule);
    }

    private void scheduleListener() {

        schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                serviceScheduling();
            }
        });

    }


    private void serviceScheduling() {

        service.schedule(new Task(),10, TimeUnit.SECONDS);
        service.scheduleAtFixedRate(new Task(),15,10,TimeUnit.SECONDS);
        //service.scheduleWithFixedDelay(new Task(),15,10,TimeUnit.SECONDS);

    }

    private void initThreadpool() {
        service= Executors.newScheduledThreadPool(2);


    }


    class Task implements Runnable{


        @Override
        public void run() {
//        for(int i=0;i<399;i++)
//        {
//            Log.i("run", "run:inside loop "+i);
//        }
            Log.i("run", "run: "+Thread.currentThread().getId());

        }
    }
}
