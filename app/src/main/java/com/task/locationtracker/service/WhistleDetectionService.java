package com.task.locationtracker.service;

import android.app.Service;
import android.content.Intent;
import android.media.AudioRecord;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;
import androidx.media3.common.C;

public class WhistleDetectionService extends Service {
    private static final int MIN_AMP_THRESHOLD = 5000;
    private static final int SAMPLE_RATE = 44100;
    private static final String TAG = "WhistleDetectionService";
    /* access modifiers changed from: private */
    public AudioRecord audioRecord;
    private Handler handler;
    private Thread listeningThread;
    /* access modifiers changed from: private */
    public MediaPlayer mediaPlayer;

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        initializeAudioRecord();
        initializeMediaPlayer();
    }

    private void initializeAudioRecord() {
       audioRecord = new AudioRecord(1, SAMPLE_RATE, 16, 2, AudioRecord.getMinBufferSize(SAMPLE_RATE, 16, 2));
        startListening();
    }

    private void initializeMediaPlayer() {
       mediaPlayer = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
       handler = new Handler();
    }

    private void startListening() {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                short[] sArr = new short[1024];
           audioRecord.startRecording();
           playRingtone();
                while (!Thread.interrupted()) {
                    int read = WhistleDetectionService.this.audioRecord.read(sArr, 0, 1024);
                    if (read > 0) {
                   processAudioBuffer(sArr, read);
                    }
                }
           audioRecord.stop();
           audioRecord.release();
            }
        });
       listeningThread = thread;
        thread.start();
    }

    /* access modifiers changed from: private */
    public void processAudioBuffer(short[] sArr, int i) {
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j += (long) Math.abs(sArr[i2]);
        }
        if (j / ((long) i) > C.DEFAULT_SEEK_BACK_INCREMENT_MS) {
            Log.d(TAG, "Whistle detected!");
            playRingtone();
        }
    }

    /* access modifiers changed from: private */
    public void playRingtone() {
        MediaPlayer mediaPlayer2 =mediaPlayer;
        if (mediaPlayer2 != null && !mediaPlayer2.isPlaying()) {
           handler.post(new Runnable() {
                public void run() {
               mediaPlayer.start();
                }
            });
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(C.DEFAULT_SEEK_BACK_INCREMENT_MS);
                    Intent intent = new Intent();
                    intent.setAction("WHISTLE_SERVICE_COMPLETE");
               sendBroadcast(intent);
               stopSelf();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        return i2;
    }

    public void onDestroy() {
        super.onDestroy();
        Thread thread =listeningThread;
        if (thread != null) {
            thread.interrupt();
        }
        MediaPlayer mediaPlayer2 =mediaPlayer;
        if (mediaPlayer2 != null && mediaPlayer2.isPlaying()) {
           mediaPlayer.stop();
           mediaPlayer.release();
        }
    }
}
