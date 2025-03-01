package com.s22010154.mysolotravelerslmobileapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class TemperatureActivity extends AppCompatActivity  implements SensorEventListener {
    private TextView temperatureTextView;
    private SensorManager sensorManager;
    private Sensor temperatureSensor;
    private Boolean isTemperatureSensorAvailable;
    private static final float HOT_THRESHOLD = 28.0f;
    private static final float COLD_THRESHOLD = 12.0f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

        temperatureTextView = findViewById (R.id.temperatureTextView);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        // Check if the ambient temperature sensor is available
        if (sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE) !=null) {

            temperatureSensor = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
            isTemperatureSensorAvailable = true;

            }else {
            temperatureTextView.setText("Ambient Temperature Sensor not available!");
            isTemperatureSensorAvailable = false;
            }
        }

    @Override
    public void onSensorChanged(SensorEvent event) {
        // Check if the event is from the ambient temperature sensor
        if (event.sensor.getType() == Sensor.TYPE_AMBIENT_TEMPERATURE) {
            float ambientTemperature = event.values[0];
            updateTemperatureDisplay(ambientTemperature);
        }
    }
    // Method to update the temperature display based on the current temperature
    private void updateTemperatureDisplay(float temperature) {
        String temperatureMessage;
        if (temperature > HOT_THRESHOLD) {
            temperatureMessage = "Temperature : " + temperature + "°C : A Hot Day";
        } else if (temperature < COLD_THRESHOLD) {
            temperatureMessage = "Temperature : " + temperature + "°C : A Cold Day";
        } else {
            temperatureMessage = "Temperature : " + temperature + "°C : A day with average temperature ";
        }
        temperatureTextView.setText(temperatureMessage);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onPause() {
        super.onPause();
        if(isTemperatureSensorAvailable){
            sensorManager.unregisterListener(this);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (isTemperatureSensorAvailable) {
            sensorManager.registerListener(this, temperatureSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }
}
