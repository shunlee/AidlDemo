package com.lb.permission;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import com.lb.permission.service.*;

/**
 * Created by shunli on 16-7-5.
 */
public class PermissionManager {
    PermissionLoaderListener permissionLoaderListener;
    private final H mHandler = new H();
    private IPermissionService mIPermService;

    public PermissionManager(Context context, PermissionLoaderListener permissionLoaderListener) {
        ServiceUtil.bindPermissionService(context, mSConnect);
        this.permissionLoaderListener = permissionLoaderListener;
    }

    private ServiceConnection mSConnect = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mIPermService = IPermissionService.Stub.asInterface(service);
            mHandler.sendEmptyMessage(H.SERVICE_CONNECT_SUCCESS);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mIPermService = null;
            mHandler.sendEmptyMessage(H.SERVICE_CONNECT_FAILED);
        }
    };

    private final class H extends Handler {
        private static final int SERVICE_CONNECT_SUCCESS = 1;
        private static final int SERVICE_CONNECT_FAILED = 2;

        private H() {
            super(Looper.getMainLooper());
        }

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SERVICE_CONNECT_SUCCESS:
                    permissionLoaderListener.onPermissonConnectedSuccess(mIPermService);
                    break;
                case SERVICE_CONNECT_FAILED:
                    permissionLoaderListener.onPermissonConnectedFail();
                    break;
            }
        }
    }
}
