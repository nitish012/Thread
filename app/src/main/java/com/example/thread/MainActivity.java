package com.example.thread;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private Button schedule,fixedthread;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findId();
        schedule.setOnClickListener(this);
        fixedthread.setOnClickListener(this);

    }


    private void findId() {

        schedule=findViewById(R.id.schedule);
        fixedthread=findViewById(R.id.fixedthread);

    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.schedule)
        {
            intent=new Intent(MainActivity.this,Schedule.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.fixedthread){
            intent=new Intent(MainActivity.this,Fixedthread.class);
            startActivity(intent);
        }

    }
}
