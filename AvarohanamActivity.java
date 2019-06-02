package com.krishnan.android.ragaidentifier;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import java.util.jar.Manifest;

/**
 * Created by anand on 11/20/18.
 */

public class AvarohanamActivity extends AppCompatActivity{

    private static final String TAG = "AvarohanamActivity";


    private Ragam[] ragams = new Ragam[263];

    private Button findRagam;
    private Button MainMenu;
    private ToggleButton R1;
    private ToggleButton R2;
    private ToggleButton R3;

    private ToggleButton G1;
    private ToggleButton G2;
    private ToggleButton G3;

    private ToggleButton M1;
    private ToggleButton M2;

    private ToggleButton D1;
    private ToggleButton D2;
    private ToggleButton D3;

    private ToggleButton N1;
    private ToggleButton N2;
    private ToggleButton N3;

    Scanner scan;

    public String Avarohanam = "S";
    String answerRagam = "";

    public AvarohanamActivity() throws FileNotFoundException {
    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.avarohanam);

        MainMenu = (Button)findViewById(R.id.mainMenu);
        MainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AvarohanamActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


        try {
            DataInputStream textFileStream = new DataInputStream(getAssets().open(String.format("ragams.txt")));
            scan = new Scanner(textFileStream);
        }
        catch (IOException e) {
            e.printStackTrace();
            Log.d(TAG, "Not getting the input file");
        }

        for(int a = 0; a < 263; a++) {
            String[] tokens;
            String input = scan.nextLine();
            //Log.d(TAG, input);

            tokens = input.split(",");

            ragams[a] = new Ragam(tokens[0], tokens[1], tokens[2]);
        }


        //Log.d(TAG, ragams[55].getRagam());


        R1 = (ToggleButton) findViewById(R.id.R1);
        R2 = (ToggleButton) findViewById(R.id.R2);
        R3 = (ToggleButton) findViewById(R.id.R3);

        G1 = (ToggleButton) findViewById(R.id.G1);
        G2 = (ToggleButton) findViewById(R.id.G2);
        G3 = (ToggleButton) findViewById(R.id.G3);

        M1 = (ToggleButton) findViewById(R.id.M1);
        M2 = (ToggleButton) findViewById(R.id.M2);

        D1 = (ToggleButton) findViewById(R.id.D1);
        D2 = (ToggleButton) findViewById(R.id.D2);
        D3 = (ToggleButton) findViewById(R.id.D3);


        N1 = (ToggleButton) findViewById(R.id.N1);
        N2 = (ToggleButton) findViewById(R.id.N2);
        N3 = (ToggleButton) findViewById(R.id.N3);


        findRagam = (Button) findViewById(R.id.FindRagam);
        findRagam.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(N1.isChecked() == true) {
                    Avarohanam += "N1";
                    N1.setBackgroundColor(333333);
                }
                if(N2.isChecked() == true) {
                    Avarohanam += "N2";
                }

                if(N3.isChecked() == true) {
                    Avarohanam += "N3";
                }

                if(D1.isChecked() == true) {
                    Avarohanam += "D1";
                }
                if(D2.isChecked() == true) {
                    Avarohanam += "D2";
                }

                if(D3.isChecked() == true) {
                    Avarohanam += "D3";
                }

                Avarohanam += "P";

                if(M1.isChecked() == true) {
                    Avarohanam += "M1";
                }
                if(M2.isChecked() == true) {
                    Avarohanam += "M2";
                }

                if(G1.isChecked() == true) {
                    Avarohanam += "G1";
                }
                if(G2.isChecked() == true) {
                    Avarohanam += "G2";
                }
                if(G3.isChecked() == true) {
                    Avarohanam += "G3";
                }

                if(R1.isChecked() == true) {
                    Avarohanam += "R1";
                }
                if(R2.isChecked() == true) {
                    Avarohanam += "R2";
                }
                if(R3.isChecked() == true) {
                    Avarohanam += "R3";
                }
                Avarohanam += "S";

                if(checkRagam() == true) {

                } else {
                    Intent intent = new Intent(AvarohanamActivity.this, ArohanamActivity.class);
                    startActivity(intent);
                    Avarohanam = "";
                }

            }
        });


    }


    private boolean checkRagam() {

        Bundle bundle = getIntent().getExtras();
        String Arohanam = bundle.getString("Arohanam");

        Log.d(TAG, Arohanam);
        Log.d(TAG, Avarohanam);

        //Log.d(TAG, "Length" + ragams.length);
        //Log.d(TAG, ragams[66].getArohanam());
        //Log.d(TAG, ragams[66].getAvarohanam());
        for(int i = 0; i < ragams.length; i++) {

            if(ragams[i].getAvarohanam().equalsIgnoreCase(Avarohanam)) {

                if(ragams[i].getArohanam().equalsIgnoreCase(Arohanam)) {
                    //Log.d(TAG, ragams[i].getRagam());
                    answerRagam = ragams[i].getRagam();
                    //Toast.makeText(this, answerRagam, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(AvarohanamActivity.this, Pop.class);
                    intent.putExtra("ragam",ragams[i].getRagam());
                    startActivity(intent);
                    //startActivity(new Intent(AvarohanamActivity.this, Pop.class));
                    return true;
                }
            }

        }
        Toast.makeText(this, "Please try again. There is no such Raga!", Toast.LENGTH_SHORT).show();
        return false;
    }

}
