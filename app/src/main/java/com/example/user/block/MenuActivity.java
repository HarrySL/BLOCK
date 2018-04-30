package com.example.user.block;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.IOException;


public class MenuActivity extends GenerateActivity {

    Context context = this;
    Context targetContext;
    Intent intent = new Intent();
    public MenuActivity() throws IOException {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //Buttons
        Button[] buttons = new Button[9];
        buttons[0] = findViewById(R.id.menu1);
        buttons[1] = findViewById(R.id.menu2);
        buttons[2] = findViewById(R.id.menu3);
        buttons[3] = findViewById(R.id.menu4);
        buttons[4] = findViewById(R.id.menu5);
        buttons[5] = findViewById(R.id.menu6);
        buttons[6] = findViewById(R.id.menu7);
        buttons[7] = findViewById(R.id.menu8);
        buttons[8] = findViewById(R.id.menu9);
        //Create listeners
        buttons[0].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                intent.putExtra("FILE", "adjBank.txt");
                setResult(PICK_ACTIVITY_REQUEST, intent);
                finish();
            }
        });
        buttons[1].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                intent.putExtra("FILE", "nounBank.txt");
                setResult(PICK_ACTIVITY_REQUEST, intent);
                finish();
            }
        });
        buttons[2].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                intent.putExtra("FILE", "verbsBank.txt");
                setResult(PICK_ACTIVITY_REQUEST, intent);
                finish();
            }
        });
        buttons[3].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                intent.putExtra("FILE", "Colours.txt");
                setResult(PICK_ACTIVITY_REQUEST, intent);
                finish();
            }
        });
        buttons[4].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                intent.putExtra("FILE", "typeFaces.txt");
                setResult(PICK_ACTIVITY_REQUEST, intent);
                finish();
            }
        });
        buttons[5].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                intent.putExtra("FILE", "materials.txt");
                setResult(PICK_ACTIVITY_REQUEST, intent);
                finish();
            }
        });
        buttons[6].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                intent.putExtra("FILE", "composers.txt");
                setResult(PICK_ACTIVITY_REQUEST, intent);
                finish();
            }
        });
        buttons[7].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                intent.putExtra("FILE", "musicGenres.txt");
                setResult(PICK_ACTIVITY_REQUEST, intent);
                finish();
            }
        });
        buttons[8].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                intent.putExtra("FILE", "instruments.txt");
                setResult(PICK_ACTIVITY_REQUEST, intent);
                finish();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK) {
            switch (requestCode) {
                case 1:

                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    break;
            }
        }
    }

   public void doThing(int x, String string) {
        setFile(x, string);
    }

}