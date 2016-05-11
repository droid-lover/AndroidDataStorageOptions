package com.myjarvis.datastorageoptions;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

/*
* sachin property
* */
public class MainActivity extends AppCompatActivity {


    TextView firstHalf, secondHalf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        firstHalf = (TextView) findViewById(R.id.firstTView);
        secondHalf = (TextView) findViewById(R.id.secondTView);

        firstHalf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, SharedPrefrencesActivity.class);
                startActivity(i);
            }
        });

        secondHalf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, InternalStorageActivity.class);
                startActivity(i);
            }
        });
    }
}
