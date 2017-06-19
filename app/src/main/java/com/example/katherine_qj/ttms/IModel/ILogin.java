package com.example.katherine_qj.ttms.IModel;

import android.os.Handler;

/**
 * Created by katherine on 5/11/17.
 */

public interface ILogin {
    public  void Login(String id, String password,Boolean isRember, Handler handler);
}
