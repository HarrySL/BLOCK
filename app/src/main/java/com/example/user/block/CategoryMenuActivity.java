package com.example.user.block;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class CategoryMenuActivity extends GenerateActivity {

    //TextViews
    TextView writerView;
    TextView artistView;
    TextView musicianView;
    TextView customView;

    public CategoryMenuActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catmenu);

        writerView = findViewById(R.id.writers);
        artistView = findViewById(R.id.artists);
        musicianView = findViewById(R.id.musicians);
        customView = findViewById(R.id.custom);
    }

    //Selection System
    public void onTextClick(View v){

        String viewName = "placeholder";
        if(v == writerView) {
            viewName = "writers";
            presetLock = true;
            topInput = "adjBank.txt";
            midInput = "nounBank.txt";
            botInput = "verbsBank.txt";
            startActivity(new Intent(CategoryMenuActivity.this, GenerateActivity.class));
        }
        else if(v == artistView){
            viewName = "artists";
            presetLock = true;
            topInput = "Colours.txt";
            midInput = "typeFaces.txt";
            botInput = "materials.txt";
            startActivity(new Intent(CategoryMenuActivity.this, GenerateActivity.class));
        }
        else if(v == musicianView){
            viewName = "musicians";
            presetLock = true;
            topInput = "instruments.txt";
            midInput = "musicGenres.txt";
            botInput = "composers.txt";
            startActivity(new Intent(CategoryMenuActivity.this, GenerateActivity.class));
        }
        else if(v == customView){
            viewName = "custom";
            presetLock = false;
            startActivity(new Intent(CategoryMenuActivity.this, GenerateActivity.class));
        }

    }

}