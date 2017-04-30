package milqaa.student.agh.edu.pl.TimerPack;

import java.util.Locale;

/**
 * Created by Gabrysia on 30.04.2017.
 */

public class StopWatch {
    private int totalMilis;
    private boolean isRunning;
    private boolean runningBeforeStop;

    public StopWatch(int totalMilis, boolean isRunning, boolean runningBeforeStop){
        this.totalMilis = totalMilis;
        this.isRunning = isRunning;
        this.runningBeforeStop = runningBeforeStop;
    }
    public StopWatch(){
        this.totalMilis = 0;
        this.isRunning = false;
        this.runningBeforeStop = false;
    }
    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public boolean wasRunningBeforeStop() {
        return runningBeforeStop;
    }

    public void setRunningBeforeStop(boolean runningBeforeStop) {
        this.runningBeforeStop = runningBeforeStop;
    }
    public String tick(){
        String text = "";
        int totalSeconds = totalMilis / 100;
        int seconds = totalSeconds % 60;
        int minutes = (totalSeconds % 3600) / 60;
        int hours = totalSeconds / 3600;

        text = String.format(Locale.US, "%02d:%02d:%02d:%02d", hours, minutes, seconds, totalMilis % 100);

        if (isRunning){
            totalMilis++;
            System.out.println(totalSeconds);
        }
        return text;
    }

    public int getTotalMilis() {
        return totalMilis;
    }

    public void setTotalMilis(int totalMilis) {
        this.totalMilis = totalMilis;
    }

    public void pause() {
        runningBeforeStop = isRunning;
        isRunning = false;
    }

    public void resume() {
        isRunning = runningBeforeStop;
    }

}
