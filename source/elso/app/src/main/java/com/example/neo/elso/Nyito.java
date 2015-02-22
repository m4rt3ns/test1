package com.example.neo.elso;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;


public class Nyito extends ActionBarActivity implements SensorEventListener {

    Sensor acc;
    SensorManager sm;
    ProgressBar pb1;
    ProgressBar pb2;
    ProgressBar pb3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nyito);
        sm = (SensorManager)getSystemService(SENSOR_SERVICE);
        acc = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(this, acc, SensorManager.SENSOR_DELAY_NORMAL);
        pb1 = (ProgressBar)findViewById(R.id.pbX);
        pb2 = (ProgressBar)findViewById(R.id.pbY);
        pb3 = (ProgressBar)findViewById(R.id.pbZ);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_nyito, menu);
        return true;
    }

    public void btn1OnClick(View v) {
        Button btn = (Button) v;
        btn.setText("alma");

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        pb1.setProgress(Math.round(event.values[0]*10));
        pb2.setProgress(Math.round(event.values[1]*10));
        pb3.setProgress(Math.round(event.values[2]*10));

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
}
