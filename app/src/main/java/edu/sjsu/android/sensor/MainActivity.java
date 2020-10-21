package edu.sjsu.android.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView textview;
    private SensorManager sensorManager;
    private List<Sensor> deviceSensors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview = findViewById(R.id.textview);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        deviceSensors = sensorManager.getSensorList(Sensor.TYPE_ALL);


        //textview.setText(deviceSensors.toString());

        printSensors();
    }

    private void printSensors() {
        for (Sensor sensor : deviceSensors)
        {
            textview.setText(textview.getText() + "\n" + sensor.getName());
        }
    }
}