package com.chaomitang.basket.sensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class SensorMonitor implements SensorEventListener {
    // 速度阈值，当摇晃速度达到这值后产生作用
    private static final int SPEED = 5000;
    private static final int UPDATE_INTERVAL_TIME = 50;
    private SensorManager sensorManager;
    private Sensor sensor;
    private OnShakeListener onShakeListener;
    private Context context;
    private float lastX;
    private float lastY;
    private float lastZ;
    private long lastUpdateTime;

    public SensorMonitor(Context context) {
        this.context = context;
        start();
    }

    /**
     * 开始检测
     */
    public void start() {
        sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        if (sensorManager != null) {
            sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        }
        if (sensor != null) {
            if (sensorManager != null) {
                sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_GAME);
            }
        }
    }

    /**
     * 停止检测
     */
    public void stop() {
        sensorManager.unregisterListener(this);
    }

    /**
     * 摇晃监听接口
     */
    public interface OnShakeListener {
        void onShake();
    }

    /**
     * 设置重力感应监听器
     */
    public void setOnShakeListener(OnShakeListener listener) {
        onShakeListener = listener;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    /**
     * 重力感应器感应获得变化数据
     *
     */
    @Override
    public void onSensorChanged(SensorEvent event) {
        long currentUpdateTime = System.currentTimeMillis();
        long timeInterval = currentUpdateTime - lastUpdateTime;
        if (timeInterval < UPDATE_INTERVAL_TIME) return;
        lastUpdateTime = currentUpdateTime;
        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[2];
        float deltaX = x - lastX;
        float deltaY = y - lastY;
        float deltaZ = z - lastZ;
        lastX = x;
        lastY = y;
        lastZ = z;
        double speed = Math.sqrt(deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ) / timeInterval * 10000;
        if (speed >= SPEED) {
            onShakeListener.onShake();
        }
    }
}