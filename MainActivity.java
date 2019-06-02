package com.krishnan.android.ragaidentifier;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    private Button ragam_by_swaram;
    private Button ragam_by_name;
    private Button ragam_by_voice;
    private Button settings;
    private Button info;
    private TextView titleText;
    private TextView authorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ragam_by_name = (Button) findViewById(R.id.ragam_by_name);
        ragam_by_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ragamsByName.class);
                startActivity(intent);
            }
        });


        ragam_by_swaram = (Button) findViewById(R.id.ragam_by_swaram);
        ragam_by_swaram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ArohanamActivity.class);
                startActivity(intent);
            }
        });

        ragam_by_voice = (Button) findViewById(R.id.ragam_by_voice);
        ragam_by_voice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        settings = (Button) findViewById(R.id.settings_button);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

        info = (Button) findViewById(R.id.info_button);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, infoActivity.class);
                startActivity(intent);
            }
        });

        titleText = (TextView) findViewById(R.id.title_name);
        authorText = (TextView) findViewById(R.id.author_name);



    }
}
