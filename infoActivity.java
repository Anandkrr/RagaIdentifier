package com.krishnan.android.ragaidentifier;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by anand on 11/20/18.
 */

public class infoActivity extends AppCompatActivity {
    private Button backButton;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);

        backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(infoActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });



    }
}
