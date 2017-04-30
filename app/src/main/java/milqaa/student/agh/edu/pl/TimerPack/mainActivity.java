package milqaa.student.agh.edu.pl.TimerPack;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class mainActivity extends AppCompatActivity {
    StopWatch stopWatch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null){
            stopWatch = new StopWatch(savedInstanceState.getInt("totalMilis"),
                    savedInstanceState.getBoolean("running"),
                    savedInstanceState.getBoolean("beforeRunning"));
        }
        else{
            stopWatch = new StopWatch();
        }
        setContentView(R.layout.activity_main);
        runTimer();
    }
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putInt("totalMilis", stopWatch.getTotalMilis());
        savedInstanceState.putBoolean("running", stopWatch.isRunning());
        savedInstanceState.putBoolean("beforeRunning", stopWatch.wasRunningBeforeStop());
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
    }
    @Override
    protected void onPause(){
        super.onPause();
        stopWatch.pause();
    }
    @Override
    protected void onResume(){
        super.onResume();
        stopWatch.resume();
    }
    private void runTimer() {
        final TextView clock = (TextView) findViewById(R.id.clock);
        final Handler clockHandler = new Handler();

        clockHandler.post(new Runnable() {
            @Override
            public void run() {

                String str = stopWatch.tick();
                clock.setText(str);
                clockHandler.postDelayed(this, 10);
            }
        });
    }

    public void startClock(View v){
        stopWatch.setRunning(true);
    }
    public void stopClock(View v){
        stopWatch.setRunning(false);
    }
    public void resetClock(View v){
        stopWatch = new StopWatch();
    }
}
