package com.krishnan.android.ragaidentifier;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;

/**
 * Created by anand on 11/20/18.
 */


public class ArohanamActivity extends AppCompatActivity {

    private static final String TAG = "ArohanamActivity";

    private Button nextButton;
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

    public String Arohanam = "S";


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.arohanam);

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

        nextButton = (Button) findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(R1.isChecked() == true) {
                    Arohanam += "R1";
                    R1.setBackgroundColor(Color.RED);
                }
                if(R2.isChecked() == true) {
                    Arohanam += "R2";
                }
                if(R3.isChecked() == true) {
                    Arohanam += "R3";
                }

                if(G1.isChecked() == true) {
                    Arohanam += "G1";
                }
                if(G2.isChecked() == true) {
                    Arohanam += "G2";
                }
                if(G3.isChecked() == true) {
                    Arohanam += "G3";
                }

                if(M1.isChecked() == true) {
                    Arohanam += "M1";
                }
                if(M2.isChecked() == true) {
                    Arohanam += "M2";
                }

                Arohanam += "P";

                if(D1.isChecked() == true) {
                    Arohanam += "D1";
                }
                if(D2.isChecked() == true) {
                    Arohanam += "D2";
                }
                if(D3.isChecked() == true) {
                    Arohanam += "D3";
                }

                if(N1.isChecked() == true) {
                    Arohanam += "N1";
                }
                if(N2.isChecked() == true) {
                    Arohanam += "N2";
                }

                if(N3.isChecked() == true) {
                    Arohanam += "N3";
                }
                Arohanam += "S";
                Log.d(TAG, Arohanam);


                Intent intent = new Intent(ArohanamActivity.this, AvarohanamActivity.class);
                intent.putExtra("Arohanam", Arohanam);
                startActivity(intent);

            }
        });

    }

}
