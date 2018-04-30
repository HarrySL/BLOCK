package com.example.user.block;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GenerateActivity extends MainActivity {

    Context context = this;

    //Output Boxes
    TextView topOutput;
    TextView midOutput;
    TextView botOutput;
    //FileHandlers and default files
    public fileHandler file1;
    public fileHandler file2;
    public fileHandler file3;
    //Activity request variable
    static int PICK_ACTIVITY_REQUEST;

    public GenerateActivity(){
    }

    @Override
        protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate);

        //Get button
        Button buttonRoll = findViewById(R.id.buttonRoll);
        //Get output areas
        topOutput = findViewById(R.id.topBoxOutput);
        midOutput = findViewById(R.id.midBoxOutput);
        botOutput = findViewById(R.id.botBoxOutput);

        //Load files if preset
        if(presetLock)
        {
            setFile(1,topInput);
            setFile(2,midInput);
            setFile(3,botInput);
        }

        //Set button listener
        buttonRoll.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                if(file1 != null)
                    topOutput.setText(file1.generate());
                if(file2 != null)
                    midOutput.setText(file2.generate());
                if(file3 != null)
                    botOutput.setText(file3.generate());
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String file = data.getStringExtra("FILE");
        // Check which request we're responding to
        if (requestCode == PICK_ACTIVITY_REQUEST) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {

            }
            setFile(PICK_ACTIVITY_REQUEST, file);
        }
    }

    //Selection System goes here
    public void onTextClick(View v){
        if(!presetLock) {
            if (v == topOutput)
                PICK_ACTIVITY_REQUEST = 1;
            else if (v == midOutput)
                PICK_ACTIVITY_REQUEST = 2;
            else if (v == botOutput)
                PICK_ACTIVITY_REQUEST = 3;

            Intent pickFileIntent = new Intent(GenerateActivity.this, MenuActivity.class);
            startActivityForResult(pickFileIntent, PICK_ACTIVITY_REQUEST);
        }
    }

    public void setFile(int x, String textFile)
    {
        switch(x) {
            case 1:
                file1 = new fileHandler(textFile, context);
                break;
            case 2:
                file2 = new fileHandler(textFile, context);
                break;
            case 3:
                file3 = new fileHandler(textFile, context);
                break;
        }
    }

    private int pickFile(){
        Intent pickFileIntent = new Intent(GenerateActivity.this,MenuActivity.class);
        startActivityForResult(pickFileIntent, PICK_ACTIVITY_REQUEST);
        return 1;
    }


}

