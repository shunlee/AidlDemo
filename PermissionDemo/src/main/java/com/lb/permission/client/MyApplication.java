package com.lb.permission.client;

import android.app.Application;
import com.lb.permission.service.IPermissionService;
/**
 * Created by shunli on 16-7-5.
 */
public class MyApplication extends Application {
    public IPermissionService iPermissionService;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public IPermissionService getIPermService() {
        return iPermissionService;
    }

    public void setIPermService(IPermissionService iPermService) {
        this.iPermissionService = iPermService;
    }
}
