package com.secondfury.attractgroup;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.annotation.DrawableRes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Konstantyn Zakharchenko on 19.11.2019.
 */
public class MainPresenter {
    private static MainPresenter instance = new MainPresenter();
    public static final long ONE_HOUR_MILLIS = 60 * 60 * 1000;
    public static final long ONE_MINUTE_MILLIS = 1 * 60 * 1000;
    public static final long ONE_DAY = 24 * 60 * 60 * 1000;
    private List<DataBundle> data;
    private HashMap<Integer, Bitmap> pictures = new HashMap<>();
    int[] drawableResources = new int[]{R.drawable.car1, R.drawable.car2, R.drawable.car3, R.drawable.car4, R.drawable.car5};

    private MainPresenter() {
        data = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            data.add(new MockDataBundle("item" + i, preperaTime(i), getBitmap(drawableResources[i % drawableResources.length])));
        }

    }

    private Bitmap getBitmap(@DrawableRes int resource) {
        if (!pictures.containsKey(resource)) {
            pictures.put(resource, BitmapFactory.decodeResource(App.getContext().getResources(), resource));
        }
        return pictures.get(resource);


    }

    private long preperaTime(int index) {
        long timeNow = System.currentTimeMillis();
        long decreasingDays = ONE_DAY * index;
        long decreasingHours = (long) (ONE_HOUR_MILLIS * index * 1.5);
        long decreasingMinutes = ONE_MINUTE_MILLIS * index * 3;
        return timeNow - decreasingDays - decreasingHours - decreasingMinutes;
    }

    public static MainPresenter getInstance() {
        return instance;
    }

    public List<DataBundle> getData() {
        return data;
    }

}
