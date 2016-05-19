package com.demo.wd.mvpdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.demo.wd.mvpdemo.presenter.LoginPresenter;
import com.demo.wd.mvpdemo.presenter.LoginPresenterImpl;
import com.demo.wd.mvpdemo.view.LoginView;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity implements LoginView{

    @InjectView(R.id.tv_username)
    EditText mTvUsername;
    @InjectView(R.id.tv_password)
    EditText mTvPassword;
    @InjectView(R.id.btn_login)
    Button mBtnLogin;
    @InjectView(R.id.btn_cancel)
    Button mBtnCancel;
    private LoginPresenter mLoginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        ButterKnife.inject(this);
        mLoginPresenter = new LoginPresenterImpl(this);
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLoginPresenter.login();
            }
        });

        mBtnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLoginPresenter.cancel();
            }
        });
    }

    @Override
    public String getUsername() {
        String tvUsername = mTvUsername.getText().toString().trim();
        return tvUsername;
    }

    @Override
    public String getPassword() {
        String tvPassword = mTvPassword.getText().toString().trim();
        return tvPassword;
    }

    @Override
    public void clearUsername() {
        mTvUsername.setText("");
    }

    @Override
    public void clearPasswrod() {
        mTvPassword.setText("");
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

}
