package com.example.thread;

import android.app.Service;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Fixedthread extends AppCompatActivity {

    private Button fixedthread;
    ExecutorService service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixedthread);
        findId();
        createThreadpool();
        listener();

    }

    private void listener() {

        fixedthread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<4;i++){
                    service.execute(new Runnable() {
                        @Override
                        public void run() {
                            Log.i("run", "run: "+Thread.currentThread().getId());

                        }
                    });
                }
            }
        });

    }

    private void createThreadpool() {
            //service= Executors.newFixedThreadPool(4);
           //service=Executors.newCachedThreadPool();
        service=Executors.newSingleThreadExecutor();

    }

    private void findId() {
        fixedthread=findViewById(R.id.fixedthread);

    }
}
