package com.example.user.block;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.channels.AsynchronousFileChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Harry on 21/02/2018.
 */

public class fileHandler {

    private String[] wordBank;
    private BufferedReader reader = null;
    private InputStreamReader ISReader = null;
    private Context thisContext;
    fileHandler()
    {

    }

    fileHandler(String file, Context context)
    {
        giveContext(context);
        String bank = file;
        wordBank = readLines(bank);
    }

    public void giveContext(Context context)
    {
        thisContext = context;
    }
    public String[] readLines(String file)
    {
        try {
            //reader = new BufferedReader(new FileReader(file));
            reader = new BufferedReader(new InputStreamReader(thisContext.getAssets().open(file)));
            List<String> lines = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            reader.close();
            return lines.toArray(new String[lines.size()]);
        }
        catch (IOException e)
        {
            String[] exception = {"Read Lines Error"};
            return exception;
        }

        /*
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
        */
    }

    public String generate()
    {
        String output;
        if (wordBank.length >= 2) {
            int Num = ThreadLocalRandom.current().nextInt(0, wordBank.length - 1);
            output = wordBank[Num];
        }
        else if(wordBank.length == 1)
        {
            output = wordBank[0];
        }
        else
        {
            output = "Generate Error";
        }
        return output;
    }
}
