package com.task.locationtracker.service;

import android.app.Service;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.IBinder;
import android.os.Vibrator;

public class AntiPocketService extends Service implements SensorEventListener {
    private Sensor proximitySensor;
    private SensorManager sensorManager;
    private Vibrator vibrator;

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        SensorManager sensorManager2 = (SensorManager) getSystemService("sensor");
        this.sensorManager = sensorManager2;
        this.proximitySensor = sensorManager2.getDefaultSensor(8);
        this.vibrator = (Vibrator) getSystemService("vibrator");
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        Sensor sensor = this.proximitySensor;
        if (sensor == null) {
            return 1;
        }
        this.sensorManager.registerListener(this, sensor, 3);
        return 1;
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.proximitySensor != null) {
            this.sensorManager.unregisterListener(this);
        }
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 8 && sensorEvent.values[0] < this.proximitySensor.getMaximumRange()) {
            vibrate();
        }
    }

    private void vibrate() {
        this.vibrator.vibrate(50000);
    }
}
