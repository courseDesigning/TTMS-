package com.example.katherine_qj.ttms.model;

import android.os.Handler;
import android.os.Message;

import com.example.katherine_qj.ttms.IModel.IAddPeolpleModel;

/**
 * Created by katherine on 5/18/17.
 */

public class AddPeopleModel implements IAddPeolpleModel {
    PeopleOnline peopleOnline = PeopleOnline.getInstance();
    GetHttpResponseString getHttpResponseString = new GetHttpResponseString();
    @Override
    public void addNewPeople(final Handler handler, final People people) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String s = getHttpResponseString.getResponString(getHttpResponseString.getAddPeopleUrl(people.getEmp_no(),people.getEmp_name(),people.getEmp_tel_num(),people.getEmp_addr(),people.getEmp_email()),peopleOnline.getSsession_id(),getHttpResponseString.getRequestBodyAllUser());
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
