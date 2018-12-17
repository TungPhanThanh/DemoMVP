package com.example.themo.demomvp.login;

import android.text.TextUtils;

public class LoginPresenter implements LoginContract.Presenter {
    public static final String USERNAME = "TungPhan";
    public static final String PASSWORD = "123456";
    private LoginContract.View mView;

    public void setView(LoginContract.View view) {
        mView = view;
    }

    @Override
    public void performingLogin(String userName, String password) {
        if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(password)) {
            mView.loginValidations();
        } else {
            if (userName.equals(USERNAME) && password.equals(PASSWORD)) {
                mView.loginSuccess();
                return;
            }
            mView.loginFailure();
        }
    }
}
