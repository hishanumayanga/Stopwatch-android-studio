package hizashi.inc.stopwatch;
//CT-2017-067 M.H.H.P.UMAYANGA

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;

public class stopwatchActivity extends AppCompatActivity {

    private Chronometer stopwatch;
    private boolean running;
    private long pauseTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);

        stopwatch=findViewById(R.id.chronometer2);
        stopwatch.setFormat("Time: %s");

        stopwatch.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if((SystemClock.elapsedRealtime()-stopwatch.getBase())>=10000){
                    stopwatch.setBase(SystemClock.elapsedRealtime());
                }
            }
        });

    }//onCreate

    public void Start(View view){
        if(!running){
            stopwatch.setBase(SystemClock.elapsedRealtime()-pauseTime);
            stopwatch.start();
            running=true;
        }

    }

    public void Pause(View view){
    if(running){
        pauseTime=SystemClock.elapsedRealtime()-stopwatch.getBase();
        stopwatch.stop();
        running=false;
    }
    }

    public void Reset(View view){
        stopwatch.setBase(SystemClock.elapsedRealtime());
        pauseTime=0;

    }
}