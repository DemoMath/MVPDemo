package com.demo.wd.mvpdemo.view;

/**
 * Created by Administrator on 2016/5/19.
 */
public interface LoginView {
    String getUsername();
    String getPassword();
    void clearUsername();
    void clearPasswrod();
    void showMessage(String msg);
}
