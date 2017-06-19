package com.example.katherine_qj.ttms.model;

import android.os.Handler;
import android.util.Log;

import com.example.katherine_qj.ttms.IModel.ILogin;
/**
 * Created by katherine on 5/11/17.
 */

public class UserModel implements ILogin{
    GetHttpResponseString getHttpResponseString = new GetHttpResponseString();
    JsonUtils jsonUtils = new JsonUtils();
    @Override
    public void Login(final String id, final  String password, final Boolean isRember, final Handler handler) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String s = null;
                String fal = null;
                User user = User.getInstance();
                s = getHttpResponseString.getResponString(getHttpResponseString.getLoginUrl(id, password));
                Log.e("123",s);
                if (!s.equals("un")) {
                 if (!(fal=jsonUtils.JsonGetSuccessFlag(s)).equals("0")) {
                     if (fal.equals("1")) {
                         user.setOnline(true);
                         user.setSession(jsonUtils.JsonGetSuccessSession(s));
                         if (jsonUtils.JsonGetTYpeFlag(s)==0) {
                             if (isRember) {
                                 handler.sendEmptyMessageAtTime(3, 0);
                             } else {
                                 handler.sendEmptyMessageAtTime(0, 0);
                             }
                         }else{
                             handler.sendEmptyMessageAtTime(4, 0);
                         }
                     } else {
                         if (isRember) {
                             handler.sendEmptyMessageAtTime(3, 0);
                         } else {
                             handler.sendEmptyMessageAtTime(0, 0);
                         }
                     }
                 }

                }else {
                    handler.sendEmptyMessageAtTime(2,0);
                }
            }
        }).start();
    }
}
