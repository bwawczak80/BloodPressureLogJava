package net.wawczak.brian.bloodpressurelog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                finish();

                startActivity(new Intent(SplashScreen.this, DisclaimerPage.class));

            }
        };

        Timer start = new Timer();
        start.schedule(task, 3500);
    }
}

