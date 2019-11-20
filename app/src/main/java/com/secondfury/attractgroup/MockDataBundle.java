package com.secondfury.attractgroup;

import android.graphics.Bitmap;

/**
 * Created by Konstantyn Zakharchenko on 19.11.2019.
 */
public class MockDataBundle implements DataBundle {
    private String name;
    private long time;
    private Bitmap image;

    public MockDataBundle(String name, long time, Bitmap image) {
        this.name = name;
        this.time = time;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public long getTime() {
        return time;
    }

    public Bitmap getImage() {
        return image;
    }
}
