package com.example.it;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button start, end;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = (Button) findViewById(R.id.button16);
        end = (Button) findViewById(R.id.button17);

        start.setOnClickListener(this::onClick);
        end.setOnClickListener(this::onClick);

        startService(new Intent(this,MusicService.class));

        mediaPlayer = MediaPlayer.create(this, R.raw.battery);

        ImageButton ima_1 = (ImageButton) findViewById(R.id.imageButton1);
        ima_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent my1Intent = new Intent(MainActivity.this, activity2.class);
                startActivity(my1Intent);
            }
        });

        ImageButton ima_2 = (ImageButton) findViewById(R.id.imageButton2);
        ima_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent my2Intent = new Intent(MainActivity.this, activity3.class);
                startActivity(my2Intent);
            }
        });

        ImageButton ima_3 = (ImageButton) findViewById(R.id.imageButton3);
        ima_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent my3Intent = new Intent(MainActivity.this, activity5.class);
                startActivity(my3Intent);
            }
        });

        final MediaPlayer myVoice;
        myVoice = MediaPlayer.create(this, R.raw.voice);

        final Button bv = (Button) findViewById(R.id.button);
        bv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                if (myVoice.isPlaying()) {
                    myVoice.pause();
                }
                else{
                    myVoice.start();
                }
            }
        });
    }

    public void onClick(View src) {
        switch (src.getId()){
            case R.id.button16:
                startService(new Intent(this,MusicService.class));
                break;
            case R.id.button17:
                stopService(new Intent(this,MusicService.class));
                break;
        }
    }

    public void onResume() {
        super.onResume();

        IntentFilter filter = new IntentFilter();

        filter.addAction(Intent.ACTION_BATTERY_LOW);

        registerReceiver(receiver, filter);
    }

    @Override
    public void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }

    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();

            if (action.equals(Intent.ACTION_BATTERY_LOW)) {
                mediaPlayer.start();
            }
        }
    };

    public void onBackPressed(){
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}