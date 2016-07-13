package com.lb.permission.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by shunli on 16-6-28.
 */
public class PermissionIntentService extends Service {
    private final PermissionServiceImpl mPermissionService = new PermissionServiceImpl(this);

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mPermissionService;
    }

}
