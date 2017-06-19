package com.example.katherine_qj.ttms.View;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.katherine_qj.ttms.IView.ILoginView;
import com.example.katherine_qj.ttms.MainActivity;
import com.example.katherine_qj.ttms.MainActivity_test;
import com.example.katherine_qj.ttms.Presenter.UserLoginPresenter;
import com.example.katherine_qj.ttms.R;
import com.example.katherine_qj.ttms.model.ToastMassage;

/**
 * Created by Katherine-qj on 2017/4/6.
 */

public class LoginActivity extends Activity  implements ILoginView{
    private EditText loginIdEditText;
    private EditText loginPasswordEditText;
    private Button loginButton;
    private CheckBox loginCheckBox;
    private String loginIdString;
    private String loginPasswordString;
    private boolean remberPassword;
    private boolean isRember;
    private Context context;
    private ProgressBar loding;
    private ToastMassage toastMassage = new ToastMassage();
    private UserLoginPresenter userLoginPresenter = new UserLoginPresenter(this);
    public  Context getmyLoginActivity(){
        return this.context;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        InitView();
    }
    public void InitView(){
        Intent intent  = new Intent(this, MainActivity.class);
        loding = (ProgressBar) findViewById(R.id.loding);
        loginIdEditText=(EditText)findViewById(R.id.editTextUsername);
        loginIdEditText.setText(loginIdString);
        loginPasswordEditText = (EditText)findViewById(R.id.editTextPassword);
        loginPasswordEditText.setText(loginPasswordString);
        loginButton = (Button)findViewById(R.id.button_login);
        loginCheckBox = (CheckBox)findViewById(R.id.login_rember_check);
        isRember = userLoginPresenter.checkdIsRemember(getApplicationContext());
        userLoginPresenter.setUserNameAndPasswordAndLogin(isRember);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLoginPresenter.login(getUserId(),getPassword() ,getRememberStu());
            }
        });
    }


    @Override
    public String getUserId() {
        return loginIdEditText.getText().toString();
    }

    @Override
    public String getPassword() {

        return loginPasswordEditText.getText().toString();
    }

    @Override
    public void setUserId(String userId) {
        loginIdEditText.setText(userId);
    }

    @Override
    public void setPassword(String password) {
        loginPasswordEditText.setText(password);

    }

    @Override
    public void setRememberStu(boolean b) {
        loginCheckBox.setChecked(b);

    }

    @Override
    public boolean getRememberStu() {
        return loginCheckBox.isChecked();
    }

    @Override
    public void clearUserId() {

    }

    @Override
    public void clearPassword() {
    }

    @Override
    public void showLoading() {
        loding.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        loding.setVisibility(View.INVISIBLE);
    }



    @Override
    public void showFailedError() {

    }

    @Override
    public void finashActivity() {
        finish();
    }

    @Override
    public void MassageError() {
        toastMassage.showMassage("账号错误，账号不存在或密码错误",getApplicationContext());
        //Toast.makeText(getApplicationContext(),"账号错误，账号不存在或密码错误", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void UsernameEmpty() {
        toastMassage.showMassage("请输入用户名",getApplicationContext());
        //  Toast.makeText(getApplicationContext(), "请输入用户名", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void PasswordEmpty() {
        toastMassage.showMassage("请输入密码",getApplicationContext());
        // Toast.makeText(getApplicationContext(), "请输入密码", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void NetWorkError() {
        toastMassage.showMassage("没网还是接口挂了我也不知道",getApplicationContext());

    }

    @Override
    public void getNewINtent() {
        Intent intent  = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void getSaleIntent() {
       Intent intents = new Intent(this, MainActivity_test.class);
        startActivity(intents);


    }
}
