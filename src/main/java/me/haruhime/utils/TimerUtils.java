package me.haruhime.utils;

public class TimerUtils {

    private long past;

    public TimerUtils() {
        past = 0;
    }

    public boolean hasPassed(float tp) {
        return (float) (getTime() - past) >= tp;
    }

    public long getTime() {
        return System.nanoTime() / 1000000;
    }

    public void renew() {
        past = getTime();
    }

}
