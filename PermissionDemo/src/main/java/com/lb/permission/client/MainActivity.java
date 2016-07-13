package com.lb.permission.client;

import android.os.Bundle;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.lb.permission.PermissionLoaderListener;
import com.lb.permission.PermissionManager;
import com.lb.permission.service.IPermissionService;

public class MainActivity extends AppCompatActivity {
    PermissionManager permissionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        permissionManager = new PermissionManager(getApplicationContext(), new PermissionLoaderListener() {
            @Override
            public void onPermissonConnectedSuccess(IPermissionService iPermissionService) {
                ((MyApplication)getApplication()).setIPermService(iPermissionService);
                try {
                    Log.d("shunli", "iPermissionService.getimei =" + iPermissionService.getIMEINumber());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onPermissonConnectedFail() {
                ((MyApplication)getApplication()).setIPermService(null);
            }
        });
    }

}