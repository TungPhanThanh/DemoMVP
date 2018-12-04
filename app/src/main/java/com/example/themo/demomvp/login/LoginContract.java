package com.example.themo.demomvp.login;

public interface LoginContract {
    interface View {

        void loginValidations();

        void loginSuccess();

        void loginFailure();
    }

    interface Presenter {
        void performingLogin(String userName, String password);
    }
}
