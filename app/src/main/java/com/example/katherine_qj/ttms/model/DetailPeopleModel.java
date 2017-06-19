package com.example.katherine_qj.ttms.model;

import android.os.Handler;
import android.os.Message;

/**
 * Created by katherine on 5/17/17.
 */

public class DetailPeopleModel {
    PeopleOnline P = PeopleOnline.getInstance();
    GetHttpResponseString getHttpResponseString = new GetHttpResponseString();

    public void delPeople(final  String username,final Handler handler){
        new Thread(new Runnable() {
            @Override
            public void run() {
                String s =getHttpResponseString.getResponString(getHttpResponseString.getdelURL(),P.getSsession_id(),getHttpResponseString.getRequestBodyDel(username));
              //  String s = getHttpResponseString.getResponString(getHttpResponseString.getDetailPeopleUrl(id),P.getSsession_id(),getHttpResponseString.getRequestBodyAllUser());
                //    String s = getHttpResponseString.getResponString(getHttpResponseString.getDetailPeopleUrl(id));
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
    public void getPeopleDetail(final int id,final Handler handler) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String s = getHttpResponseString.getResponString(getHttpResponseString.getDetailPeopleUrl(id),P.getSsession_id(),getHttpResponseString.getRequestBodyAllUser());
            //    String s = getHttpResponseString.getResponString(getHttpResponseString.getDetailPeopleUrl(id));
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
    public void ModifyPeople(final Handler handler, final People people) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String s = getHttpResponseString.getResponString(
                        getHttpResponseString.
                                getModifyUrl(people.getEmp_id(),people.getEmp_name(),people.getEmp_tel_num(),people.getEmp_addr(),people.getEmp_email()),P.getSsession_id(),getHttpResponseString.getRequestBodyAllUser());
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
