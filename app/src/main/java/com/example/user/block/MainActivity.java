package com.example.user.block;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //public static final String EXTRA_MESSAGE = "com.example.user.block.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Button
        Button button = (Button) findViewById(R.id.buttonStart);
        //Create listener
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //Move to next activity on tap
                startActivity(new Intent(MainActivity.this, GenerateActivity.class));
            }
        });
    }
}
