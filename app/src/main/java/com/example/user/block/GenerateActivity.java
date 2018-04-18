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
        final TextView topOutput = (TextView) findViewById(R.id.topBoxOutput);
        final TextView midOutput = (TextView) findViewById(R.id.midBoxOutput);

        final fileHandler verbs = new fileHandler("verbsBank.txt", context);
        final fileHandler adj = new fileHandler("adjBank.txt", context);

        buttonRoll.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                topOutput.setText(verbs.generate());
                midOutput.setText(adj.generate());
            }
        });

        /*

        List<String> list = new ArrayList<>();
        int size = 0;
        Object[] strings;

        try {
            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open("verbBank.txt")));
            String nLine = null;
            while ((nLine = reader.readLine()) != null) {
                //text.append(nLine);
                //text.append('\n');
                list.add(nLine);
            }
            size = list.size();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        TextView output = (TextView) findViewById(R.id.viewBox);
        //output.setText((CharSequence) text);
        //output.setText(list.get(3));

        String stringOut;
        int Num = 0;

        if (size != 0) {
            Num = ThreadLocalRandom.current().nextInt(0, size);
        } else {
            list.add("List machine broke");
        }
        //strings = list.toArray();
        //stringOut = strings[Num];
        stringOut = list.get(Num);

        output.setText(stringOut);
        */
    }
}
