package com.krishnan.android.ragaidentifier;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ragamsByName extends AppCompatActivity {

    private Button backButton;
    private Ragam[] ragams = new Ragam[263];
    int i = 0;
    int a = 0;


    Scanner scan;
    ListView list;

    private static final String TAG = "ragamsByName";
    ArrayList<String> ragamList = new ArrayList<>();


    private ArrayAdapter adapter;

    public ragamsByName() throws FileNotFoundException {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ragamsbyname);

        EditText ragamFilter = (EditText) findViewById(R.id.searchFilter);


        try {
            DataInputStream textFileStream = new DataInputStream(getAssets().open(String.format("ragams.txt")));
            scan = new Scanner(textFileStream);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        for(int a = 0; a < 263; a++) {
            String[] tokens;
            String input = scan.nextLine();
            //Log.d(TAG, input);

            tokens = input.split(",");

            ragams[a] = new Ragam(tokens[0], tokens[1], tokens[2]);
        }




        for(int i = 0; i < ragams.length; i++) {
            ragamList.add(ragams[i].getRagam());
            //Log.d(TAG, ragams[i].getRagam());
        }

        list = (ListView) findViewById(R.id.ragamList);
        adapter = new ArrayAdapter(this, R.layout.listrow, R.id.textView2, ragamList);
        list.setAdapter(adapter);


        ragamFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                (ragamsByName.this).adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String name =  list.getItemAtPosition(i).toString();
                a = ragamList.indexOf(name);


                String ragamName = ragams[a].getRagam();
                String arohanam = ragams[a].getArohanam();
                String avaronam = ragams[a].getAvarohanam();

                //Log.d(TAG, item.getRagam());
                Intent intent = new Intent(ragamsByName.this, ragamInfo.class);

                intent.putExtra("ragamName", ragamName);
                intent.putExtra("arohanam", arohanam);
                intent.putExtra("avaronam", avaronam);

                startActivity(intent);
            }
        });





        backButton = (Button) findViewById(R.id.ragamByNameBackButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ragamsByName.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
