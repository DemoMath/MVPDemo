package com.demo.wd.mvpdemo.biz;

import android.text.TextUtils;

import com.demo.wd.mvpdemo.bean.UserBean;
import com.demo.wd.mvpdemo.listener.LoginListener;

/**
 * Created by Administrator on 2016/5/19.
 */
public class UserBizImpl implements UserBiz {

    private LoginListener mListener;
    public UserBizImpl(LoginListener loginListener) {
        mListener = loginListener;
    }

    @Override
    public void login(UserBean user) {
        boolean status = false;
        String username,password;
        username = user.getUsername();
        password = user.getPassword();
        if (!TextUtils.isEmpty(username) && ("wd").equals(username)) {
            if (!TextUtils.isEmpty(password) && ("123").equals(password)) {
                status = true;
            }
        }
        //把结果传回去
        mListener.loginStatus(status);
    }
}
