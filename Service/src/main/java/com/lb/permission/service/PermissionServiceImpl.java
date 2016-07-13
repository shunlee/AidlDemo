package com.lb.permission.service;

import android.content.Context;
import android.os.RemoteException;

/**
 * Created by shunli on 16-6-28.
 */
public class PermissionServiceImpl extends IPermissionService.Stub {
    private Context mContext;

    public PermissionServiceImpl(Context context) {
        mContext = context;
    }

    @Override
    public String getIMEINumber() throws RemoteException {
        return "test IMEI";
    }
}
