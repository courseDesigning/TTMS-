package com.example.katherine_qj.ttms.IView;

/**
 * Created by katherine on 5/11/17.
 */

public interface ILoginView {
    String getUserId();
    String getPassword();
    void setUserId(String userId);
    void setPassword(String password);
    void setRememberStu(boolean b);
    boolean getRememberStu();
    void clearUserId();
    void clearPassword();
    void showLoading();
    void hideLoading();
    void showFailedError();
    void finashActivity();
    void MassageError();
    void UsernameEmpty();
    void PasswordEmpty();
    void NetWorkError();
    void getNewINtent();
    void getSaleIntent();


}
