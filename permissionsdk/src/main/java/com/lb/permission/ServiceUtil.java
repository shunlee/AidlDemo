package com.lb.permission;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.ServiceConnection;

/**
 * Created by shunli on 16-7-5.
 */
public class ServiceUtil {
    private static final String ACTION_SERVICE = "com.lb.rmstools.IPermissionService";
    private static final String SERVICE_PACKAGE = "com.lb.permission.service";
    private static void bindToService(Intent intent, Context context, ServiceConnection callback) {
        Context realActivity = context.getApplicationContext();
        if (realActivity == null) {
            realActivity = context;
        }
        ContextWrapper cw = new ContextWrapper(realActivity);
        cw.startService(intent);
        cw.bindService(intent, callback, Context.BIND_AUTO_CREATE);
    }

    public static void bindPermissionService(Context context, ServiceConnection callback) {
        Intent intent = new Intent(ACTION_SERVICE);
        intent.setPackage(SERVICE_PACKAGE);
        bindToService(intent, context, callback);
    }
}
