package com.example.user.block;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Harry on 21/02/2018.
 */

public class fileHandler {

    private String[] wordBank;

    fileHandler(String file) throws IOException
    {
        wordBank = readLines(file);
    }

    public String[] readLines(String file) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();
        return lines.toArray(new String[lines.size()]);
    };

    public String generate()
    {
        String output;
        int Num = ThreadLocalRandom.current().nextInt(0, wordBank.length - 1);
        output = wordBank[Num];
        return output;
    };
}
