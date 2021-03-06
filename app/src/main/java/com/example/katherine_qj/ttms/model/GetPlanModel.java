package com.example.katherine_qj.ttms.model;

import android.os.Handler;
import android.os.Message;

import com.example.katherine_qj.ttms.IModel.IGetPlan;

/**
 * Created by katherine on 6/6/17.
 */

public class GetPlanModel  implements IGetPlan {
    GetHttpResponseString getHttpResponseString =
            new GetHttpResponseString();
    @Override
    public void getAllPlan(final Handler handler) {
        final  PeopleOnline P = PeopleOnline.getInstance();
        new Thread(new Runnable() {
            @Override
            public void run() {
                //  String s = getHttpResponseString.getResponString(getHttpResponseString.getAllVoide());
                String s = getHttpResponseString.getResponString(getHttpResponseString.getAllPlan(),P.getSsession_id(),getHttpResponseString.getRequestBodyAllUser());
                if (!s.equals("un")){
                    Message message =handler.obtainMessage();
                    message.what = 0;
                    message.obj = s;
                    handler.sendMessage(message);
                }else {
                    handler.sendEmptyMessageAtTime(1,0);
                }
            }
        }).start();
    }
}
