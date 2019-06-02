package com.krishnan.android.ragaidentifier;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.media.MediaPlayer;
import java.io.IOException;

/**
 * Created by anand on 11/21/18.
 */

public class Pop extends Activity{


    private TextView ragamName;
    private String name;
    private Button back;
    private Button sampleButton;

    private static final String TAG = "Pop";




    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.popwindow);

        back = (Button) findViewById(R.id.doneButton);
        ragamName = (TextView) findViewById(R.id.ragamName);

        sampleButton = (Button) findViewById(R.id.Samplebutton);

        final MediaPlayer mediaPlayer = new MediaPlayer();


        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width * 0.8), (int)(height * 0.8));

        Bundle bundle = getIntent().getExtras();
        name = bundle.getString("ragam");

        ragamName.setText(name);


        sampleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String file_path = "http://www.ragasurabhi.com/carnatic-music-mp3/raga-";
                file_path+=name;
                file_path+="-signature.mp3";
                file_path = file_path.toLowerCase();
                Log.d(TAG, "This is the URL: " + file_path);


                try {
                    mediaPlayer.setDataSource(file_path);
                    mediaPlayer.prepare();
                    mediaPlayer.start();

                } catch (IOException e) {
                    e.printStackTrace();
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

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mediaPlayer.isPlaying()) {

                    mediaPlayer.stop();
                }

                Intent intent = new Intent(Pop.this, ArohanamActivity.class);
                startActivity(intent);

            }
        });

    }


}
