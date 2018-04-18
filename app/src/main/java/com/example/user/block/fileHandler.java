package com.example.user.block;

import android.content.Context;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Harry on 21/02/2018.
 * For BLOCK group project
 */

public class fileHandler {

    private String[] wordBank;
    private BufferedReader reader = null;
    private Context thisContext;

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
