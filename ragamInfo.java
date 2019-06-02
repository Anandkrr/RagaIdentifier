package com.krishnan.android.ragaidentifier;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.IOException;

public class ragamInfo extends AppCompatActivity {

    private Button BackButton;
    private TextView ragam;
    private TextView Avaronam;
    private TextView Avarohanam;
    private Button sampleButton;

    private String ragamName;

    private static final String TAG = "ragamInfo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ragam_info);

        BackButton = (Button) findViewById(R.id.ragamInfoBack);
        ragam = (TextView) findViewById(R.id.ragamTextView);

        Avaronam = (TextView) findViewById(R.id.ragamArohanam);
        Avarohanam = (TextView) findViewById(R.id.ragamAvarohanam);
        sampleButton = (Button) findViewById(R.id.sampleButton);

        final MediaPlayer mediaPlayer = new MediaPlayer();

        Bundle bundle = getIntent().getExtras();
        final String ragamName = bundle.getString("ragamName");
        String arohanamName = "Arohanam " + bundle.getString("arohanam");
        String avaronamName = "Avaronam " + bundle.getString("avaronam");


        ragam.setText(ragamName);
        Avaronam.setText(arohanamName);
        Avarohanam.setText(avaronamName);


        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mediaPlayer.isPlaying()) {

                    mediaPlayer.stop();
                }

                Intent intent = new Intent(ragamInfo.this, ragamsByName.class);
                startActivity(intent);
            }
        });

        sampleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String file_path = "http://www.ragasurabhi.com/carnatic-music-mp3/raga-";
                file_path+=ragamName;
                file_path+="-signature.mp3";
                file_path = file_path.toLowerCase();
                Log.d(TAG, "This is the URL: " + file_path);




                try {
                    mediaPlayer.setDataSource(file_path);
                    mediaPlayer.prepare();
                    mediaPlayer.start();

                } catch (IOException e) {
                    //mediaPlayer.stop();
                    Intent intent = new Intent(ragamInfo.this, ragamsByName.class);
                    startActivity(intent);
                    Toast.makeText(ragamInfo.this, "The selected ragam does not have a sample",
                            Toast.LENGTH_SHORT).show();
                    //e.printStackTrace();
                }

                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        mediaPlayer.release();
                        mediaPlayer = null;
                    }
                });
                file_path = "";
            }

        });




    }
}
