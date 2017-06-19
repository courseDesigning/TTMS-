package com.example.katherine_qj.ttms.model;

import android.os.Handler;
import android.os.Message;

import com.example.katherine_qj.ttms.IModel.IGetPeople;

/**t
 * Created by katherine on 5/16/17.
 */

public class GetPeopleoModel implements IGetPeople{
    GetHttpResponseString getHttpResponseString =
            new GetHttpResponseString();

    @Override
    public void getAllPeople(final Handler handler) {
        final  PeopleOnline P = PeopleOnline.getInstance();
        new Thread(new Runnable() {
            @Override
            public void run() {
                String s = getHttpResponseString.getResponString(getHttpResponseString.getAllPeopleUrl(),P.getSsession_id(),getHttpResponseString.getRequestBodyAllUser());
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
