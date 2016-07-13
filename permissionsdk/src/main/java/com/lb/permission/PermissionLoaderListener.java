package com.lb.permission;

import com.lb.permission.service.IPermissionService;
/**
 * Created by shunli on 16-7-5.
 */
public abstract class PermissionLoaderListener {
    public abstract void onPermissonConnectedSuccess(IPermissionService iPermissionService);
    public abstract void onPermissonConnectedFail();
}
