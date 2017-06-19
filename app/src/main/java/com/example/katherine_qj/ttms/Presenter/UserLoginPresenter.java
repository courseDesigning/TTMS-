package com.example.katherine_qj.ttms.Presenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;

import com.example.katherine_qj.ttms.IView.ILoginView;
import com.example.katherine_qj.ttms.model.User;
import com.example.katherine_qj.ttms.model.UserModel;

/**
 * Created by katherine on 5/11/17.
 */

public class UserLoginPresenter {
    private User user = User.getInstance();
    private UserModel userModel;
    private ILoginView iLoginView;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private String username;
    private String password;
    public UserLoginPresenter(ILoginView iLoginView){
        this.iLoginView = iLoginView;
        this.userModel = new UserModel();
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0:{
                    iLoginView.hideLoading();
                    iLoginView.finashActivity();
                    //不存储
                    RemberUserAndPassword();
                    CancelRemember();
                    iLoginView.getNewINtent();
                    user.setOnline(true);

                    break;
                }
                case 2:{
                    iLoginView.hideLoading();
                    iLoginView.NetWorkError();

                }
                case 3:{
                    user.setOnline(true);
                    iLoginView.hideLoading();
                    iLoginView.finashActivity();
                    iLoginView.getNewINtent();
                    //登陆到主界面
                    RemberUserAndPassword();
                    break;
                }
                case 4:{
                    user.setOnline(true);
                    iLoginView.hideLoading();
                    iLoginView.finashActivity();
                    iLoginView.getSaleIntent();
                    //登陆到主界面
                    RemberUserAndPassword();
                    break;
                }
                default:
                    break;
            }
        }
    };
    public void  RemberUserAndPassword(){
        editor = preferences.edit();
        editor.clear();
        editor.putString("userId",iLoginView.getUserId());
        editor.putString("password",iLoginView.getPassword());
        editor.putBoolean("remember_password",iLoginView.getRememberStu());
        editor.commit();
    }
    public void CancelRemember(){
        editor = preferences.edit();
        editor.clear();
    }

    public Boolean  checkdIsRemember(Context context){
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return  preferences.getBoolean("remember_password",false);
    }
    public void setUserNameAndPasswordAndLogin(boolean b){
        if (b){
            iLoginView.setUserId(preferences.getString("userId",""));
            iLoginView.setPassword(preferences.getString("password",""));
            iLoginView.setRememberStu(preferences.getBoolean("remember_password",false));
            // userModel.Login(iLoginView.getUserId(), iLoginView.getPassword(),iLoginView.getRememberStu(),handler);
        }
    }
    public void login(String username,String id,Boolean isRember) {
        this.username = username;
        this.password = id;
        if (username.equals("")) {
            iLoginView.UsernameEmpty();
            return;
        } else if (id.equals("")) {
            iLoginView.PasswordEmpty();
            return;
        } else {
            iLoginView.showLoading();
            userModel.Login(iLoginView.getUserId(), iLoginView.getPassword(),iLoginView.getRememberStu(),handler);
        }
    }
}
