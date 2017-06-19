package com.example.katherine_qj.ttms.model;

import android.os.Handler;
import android.os.Message;

import com.example.katherine_qj.ttms.IModel.IGetRoom;

/**
 * Created by katherine on 6/7/17.
 */

public class GetRoomModel implements IGetRoom {
    GetHttpResponseString getHttpResponseString =
            new GetHttpResponseString();
    @Override
    public void getAllRoom( final Handler handler) {

        final  PeopleOnline P = PeopleOnline.getInstance();
        new Thread(new Runnable() {
            @Override
            public void run() {
                String s = getHttpResponseString.getResponString(getHttpResponseString.getAllRoom(),P.getSsession_id(),getHttpResponseString.getRequestBodyAllUser());
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
