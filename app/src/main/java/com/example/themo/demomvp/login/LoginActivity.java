package com.example.themo.demomvp.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.themo.demomvp.R;
import com.example.themo.demomvp.main.MainActivity;
import com.example.themo.demomvp.signup.SignUpActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener,
        LoginContract.View {
    private EditText mEditTextUserName;
    private EditText mEditTextPassword;
    private TextView mTextViewLogin;
    private TextView mTextViewSignUp;

    private LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        registerListener();
        initPresenter();
    }

    public void initView() {
        mEditTextUserName = findViewById(R.id.edit_text_user);
        mEditTextPassword = findViewById(R.id.edit_text_password);
        mTextViewLogin = findViewById(R.id.text_view_login);
        mTextViewSignUp = findViewById(R.id.text_view_sign_up);
    }

    public void registerListener() {
        mTextViewLogin.setOnClickListener(this);
        mTextViewSignUp.setOnClickListener(this);
    }

    public void initPresenter() {
        mLoginPresenter = new LoginPresenter();
        mLoginPresenter.setView(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.text_view_login:
                login();
                break;
            case R.id.text_view_sign_up:
                startActivity(new Intent(this, SignUpActivity.class));
                break;
            default:
                break;
        }
    }

    public void login() {
        String username = mEditTextUserName.getText().toString();
        String password = mEditTextPassword.getText().toString();
        mLoginPresenter.performingLogin(username, password);
    }

    @Override
    public void loginValidations() {
        Toast.makeText(this, getString(R.string.msg_validation), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this, getString(R.string.msg_success), Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    public void loginFailure() {
        Toast.makeText(this,getString(R.string.msg_failure), Toast.LENGTH_SHORT).show();
    }
}
