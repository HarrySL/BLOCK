package com.example.user.block;

import android.content.Context;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class GenerateActivity extends AppCompatActivity {

    Context context = this;
    public GenerateActivity() throws IOException {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate);
        BufferedReader reader = null;

        //On create, read text files.
        //In full build should only read relevant files when generating output.
        Button buttonRoll = (Button) findViewById(R.id.buttonRoll);
        //Get output areas
        final TextView topOutput = (TextView) findViewById(R.id.topBoxOutput);
        final TextView midOutput = (TextView) findViewById(R.id.midBoxOutput);
        final TextView botOutput = (TextView) findViewById(R.id.botBoxOutput);

        //Get word banks
        //Add option system
        final fileHandler verbs = new fileHandler("verbsBank.txt", context);
        final fileHandler adj = new fileHandler("adjBank.txt", context);
        final fileHandler bot = new fileHandler("verbsBank.txt", context);

        buttonRoll.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                topOutput.setText(verbs.generate());
                midOutput.setText(adj.generate());
                botOutput.setText(bot.generate());
            }
        });

    }
}
