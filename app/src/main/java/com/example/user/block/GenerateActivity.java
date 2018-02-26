package com.example.user.block;

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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class GenerateActivity extends AppCompatActivity {

    public GenerateActivity() throws IOException {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate);

        //On create, read text files.
        //In full build should only read relevant files when generating output.
        Button buttonRoll = (Button)findViewById(R.id.buttonRoll);
        final TextView verbOutput = (TextView)findViewById(R.id.verbBoxOutput);
        final TextView adjOutput = (TextView)findViewById(R.id.adjBoxOutput);

        buttonRoll.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                //verbOutput.setText(verbs.generate());
                verbOutput.setText(generate(verbBank));
                //adjOutput.setText(adj.generate());
                //adjOutput.setText(generate(adjBank));
            }
        });
    }

    //fileHandler verbs = new fileHandler("verbs-bank.txt");
    //fileHandler verbs = new fileHandler("C:\\Users\\harry_lxvg8fi\\Desktop\\GroupProject\\BLOCK\\app\\src\\main\\assets\\verbs-bank.txt");
    //fileHandler adj = new fileHandler("adj-bank.txt");

    //InputStream verbStream = getAssets().open("verbs-bank.txt");
    //fileHandler verbs = new fileHandler(verbStream);

    File verbFile = new File("verbs-bank.txt");
    String[] verbBank = readLines(verbFile);

    public String[] readLines(File file) throws IOException
    {
        List<String> lines = new ArrayList<>();
        String line;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            reader.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        if(lines == null)
        {
            lines.add("Error");
            lines.add("Error");
        }
        lines.add("HELP");
        lines.add("Help");
        return lines.toArray(new String[lines.size()]);
    }

    public String generate(String[] bank)
    {
        String output;
        int Num = ThreadLocalRandom.current().nextInt(0, bank.length);
        output = bank[Num];
        return output;
    }

    /*String[] verbBank = {
            "accept",
            "ache",
            "acknowledge",
            "act",
            "add",
            "admire",
            "admit",
            "admonish",
            "advise",
            "adopt"
    };
    String[] adjBank = {
            "abandoned",
            "able",
            "absolute",
            "adorable",
            "adventurous",
            "academic",
            "acceptable",
            "acclaimed",
            "accomplished",
            "accurate",


    };*/

}
