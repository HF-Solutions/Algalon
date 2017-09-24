package org.alcha.algalonj.models.wow;

import com.google.gson.JsonObject;

/**
 * <p>Created by Alcha on Sep 15, 2017 @ 09:33.</p>
 */

public class Time {
    private long mTime;
    private int mHours;
    private int mMinutes;
    private int mSeconds;
    private int mMilliseconds;
    private boolean mIsPositive;

    public Time() {
    }

    public static Time newInstanceFromJson(JsonObject jsonObject) {
        Time time = new Time();

        if (jsonObject.has("time"))
            time.setTime(jsonObject.get("time").getAsLong());
        else time.setTime(-1L);

        if (jsonObject.has("hours"))
            time.setHours(jsonObject.get("hours").getAsInt());
        else time.setHours(-1);

        if (jsonObject.has("minutes"))
            time.setMinutes(jsonObject.get("minutes").getAsInt());
        else time.setMinutes(-1);

        if (jsonObject.has("seconds"))
            time.setSeconds(jsonObject.get("seconds").getAsInt());
        else time.setSeconds(-1);

        if (jsonObject.has("milliseconds"))
            time.setMilliseconds(jsonObject.get("milliseconds").getAsInt());
        else time.setMilliseconds(-1);

        if (jsonObject.has("isPositive"))
            time.setPositive(jsonObject.get("isPositive").getAsBoolean());
        else time.setPositive(false);

        return time;
    }

    public long getTime() {
        return mTime;
    }

    public void setTime(long time) {
        mTime = time;
    }

    public int getHours() {
        return mHours;
    }

    public void setHours(int hours) {
        mHours = hours;
    }

    public int getMinutes() {
        return mMinutes;
    }

    public void setMinutes(int minutes) {
        mMinutes = minutes;
    }

    public int getSeconds() {
        return mSeconds;
    }

    public void setSeconds(int seconds) {
        mSeconds = seconds;
    }

    public int getMilliseconds() {
        return mMilliseconds;
    }

    public void setMilliseconds(int milliseconds) {
        mMilliseconds = milliseconds;
    }

    public boolean isPositive() {
        return mIsPositive;
    }

    public void setPositive(boolean positive) {
        mIsPositive = positive;
    }
}
