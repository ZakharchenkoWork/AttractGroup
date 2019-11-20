package com.secondfury.attractgroup.data;

import android.graphics.Bitmap;

/**
 * Created by Konstantyn Zakharchenko on 19.11.2019.
 */
public interface DataBundle {
    String getName();

    long getTime();

    Bitmap getImage();
}
