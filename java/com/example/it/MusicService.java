package com.example.it;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class MusicService extends Service {

    MediaPlayer myplayer;

    public IBinder onBind(Intent myintent) {
        return null;
    }
    public void onCreate() {
        myplayer = MediaPlayer.create(this, R.raw.background);
        myplayer.setLooping(false);
    }
    public void onDestroy() {
        Toast.makeText(this, "MusicService 가 정지되었습니다", Toast.LENGTH_SHORT).show();
        myplayer.stop();
    }
    public int onStartCommand(Intent myintnet, int flags, int startId) {
        Toast.makeText(this, "MusicService 가 시작되었습니다", Toast.LENGTH_SHORT).show();
        myplayer.start();
        return super.onStartCommand(myintnet, flags, startId);
    }
}
