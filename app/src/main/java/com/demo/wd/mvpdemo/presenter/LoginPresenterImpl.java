package com.demo.wd.mvpdemo.presenter;

import com.demo.wd.mvpdemo.bean.UserBean;
import com.demo.wd.mvpdemo.biz.UserBiz;
import com.demo.wd.mvpdemo.biz.UserBizImpl;
import com.demo.wd.mvpdemo.listener.LoginListener;
import com.demo.wd.mvpdemo.view.LoginView;

/**
 * Created by Administrator on 2016/5/19.
 */
public class LoginPresenterImpl implements LoginPresenter,LoginListener {
    private UserBiz mUserBiz;
    private LoginView mLoginView;
    public LoginPresenterImpl(LoginView loginView){
        mLoginView = loginView;
        mUserBiz = new UserBizImpl(this);
    }

    @Override
    public void login() {
        UserBean mUserBean = new UserBean();
        mUserBean.setUsername(mLoginView.getUsername());
        mUserBean.setPassword(mLoginView.getPassword());
        mUserBiz.login(mUserBean);
    }

    @Override
    public void cancel() {
        mLoginView.clearUsername();
        mLoginView.clearPasswrod();
    }

    @Override
    public void loginStatus(boolean statue) {
        String result = null;
        if (statue) {
            result = "success";
        } else {
            result = "fail";
        }
        mLoginView.showMessage(result);
    }
}
