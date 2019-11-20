package com.secondfury.attractgroup;

import android.app.Application;
import android.content.Context;

/**
 * Created by Konstantyn Zakharchenko on 19.11.2019.
 */
public class App extends Application {
    private static Context context;

    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
}
