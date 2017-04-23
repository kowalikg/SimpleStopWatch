package milqaa.student.agh.edu.pl.sysopysymulator;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class mainActivity extends AppCompatActivity {

    private int totalSeconds;
    private boolean isRunning;
    private boolean runningBeforeStop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null){
            totalSeconds = savedInstanceState.getInt("totalSeconds");
            isRunning = savedInstanceState.getBoolean("running");
            runningBeforeStop = savedInstanceState.getBoolean("beforeRunning");
        }
        setContentView(R.layout.activity_main);
        runTimer();
    }
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putInt("totalSeconds", totalSeconds);
        savedInstanceState.putBoolean("running", isRunning);
        savedInstanceState.putBoolean("beforeRunning", runningBeforeStop);
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
    }
    @Override
    protected void onPause(){
        super.onPause();
        runningBeforeStop = isRunning;
        System.out.println(runningBeforeStop);
        isRunning = false;
    }
    @Override
    protected void onResume(){
        super.onResume();
        System.out.println(runningBeforeStop);
        isRunning = runningBeforeStop;
    }
    private void runTimer() {
        final TextView clock = (TextView) findViewById(R.id.clock);
        final Handler clockHandler = new Handler();

        clockHandler.post(new Runnable() {
            @Override
            public void run() {
                int hours = totalSeconds / 3600;
                int minutes = (totalSeconds % 3600) / 60;
                int seconds = totalSeconds % 60;
                String str = String.format(Locale.US, "%02d:%02d:%02d", hours, minutes, seconds);
                clock.setText(str);
                if (isRunning){
                    totalSeconds++;
                    System.out.println(totalSeconds);
                }
                clockHandler.postDelayed(this, 1000);
            }
        });
    }

    public void startClock(View v){
        isRunning = true;
    }
    public void stopClock(View v){
        isRunning = false;
    }
    public void resetClock(View v){
        isRunning = false;
        totalSeconds = 0;
    }
}
