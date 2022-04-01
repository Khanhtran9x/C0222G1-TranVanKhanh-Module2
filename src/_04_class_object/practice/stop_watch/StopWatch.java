package _04_class_object.practice.stop_watch;

import java.util.Calendar;
import java.util.Date;

public class StopWatch {
    private long startTime, stopTime;

    public StopWatch() {
        this.startTime = Calendar.getInstance().getTimeInMillis();
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getStopTime() {
        return stopTime;
    }

    public void setStopTime(long stopTime) {
        this.stopTime = stopTime;
    }
    public void start(){
        this.startTime = Calendar.getInstance().getTimeInMillis();
    }
    public void stop(){
        this.stopTime = Calendar.getInstance().getTimeInMillis();
    }
    public long getElapsedTime(){
        return this.stopTime - this.startTime;
    }
}
