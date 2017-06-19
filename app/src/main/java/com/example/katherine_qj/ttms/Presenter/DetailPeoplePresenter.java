package com.example.katherine_qj.ttms.Presenter;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.katherine_qj.ttms.IView.IDetailPeople;
import com.example.katherine_qj.ttms.model.DetailPeopleModel;
import com.example.katherine_qj.ttms.model.People;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by katherine on 5/17/17.
 */

public class DetailPeoplePresenter {
    private Context context;
    private IDetailPeople iDetailPeople;
    private DetailPeopleModel detailPeopleModel;
    private People people;
    private int emp_id;
    private String emp_no;
    private String emp_name;
    private String emp_tel_num;
    private String emp_addr;
    private String emp_email;
    private JSONArray jsonarray;

    android.os.Handler handler = new android.os.Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0: {
                    String s = (String) msg.obj;
                    people = GetJsonDetail(s);
                    iDetailPeople.showMessage(people);
                    break;
                }
                case 1: {

                    break;

                }

            }
        }
    };
    android.os.Handler handlerss = new android.os.Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0: {
                    String s = (String) msg.obj;
                    people = GetJsonDetail(s);
                    iDetailPeople.showMessage(people);
                    break;
                }
                case 1: {

                    break;

                }

            }
        }
    };
    android.os.Handler handlers= new android.os.Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0: {
                    String s = (String) msg.obj;
                    GetJsonModify(s);
                    if ( GetJsonModify(s)==1){
                        iDetailPeople.ShowTost("修改成功");

                    }else {
                        iDetailPeople.showMassageError("接口挂了还是什么鬼的我也不叽到啊");

                    }
                            //
                    break;
                }
                case 1: {
                    iDetailPeople.showMassageError("接口挂了还是什么鬼的我也不叽到啊");

                    break;

                }

            }
        }
    };

    public DetailPeoplePresenter(Context context, IDetailPeople iDetailPeople){
        this.context = context;
        this.iDetailPeople  = iDetailPeople;
        this.detailPeopleModel = new DetailPeopleModel();

    }
    public void  getDetailPeople(int id){
        detailPeopleModel.getPeopleDetail(id,handler);

    }
    public void modifyPeople(People people){

        detailPeopleModel.ModifyPeople(handlers,people);
    }
    public void delPeople(String username){
        detailPeopleModel.delPeople(username,handlerss);
    }

    public People GetJsonDetail(String s){
        People p = new People();
        try {
            JSONObject jsonObject1 = new JSONObject(s);
            if (jsonObject1.getBoolean("Result")) {
                String date = jsonObject1.getString("Detail");
                jsonarray = new JSONArray(date);
                for (int i = 0; i < jsonarray.length(); i++) {
                    JSONObject jsonObject = (JSONObject) jsonarray.get(i);
                    emp_id = jsonObject.getInt("emp_id");
                    emp_no = jsonObject.getString("emp_no");
                    emp_name = jsonObject.getString("emp_name");
                    emp_tel_num = jsonObject.getString("emp_tel_num");
                    emp_addr = jsonObject.getString("emp_addr");
                    emp_email = jsonObject.getString("emp_email");
                    p.setEmp_id(emp_id);
                    p.setEmp_no(emp_no);
                    p.setEmp_name(emp_name);
                    p.setEmp_addr(emp_addr);
                    p.setEmp_email(emp_email);
                    p.setEmp_tel_num(emp_tel_num);

                }

            } else {
                iDetailPeople.showMassageError("接口挂了还是什么鬼的我也不叽到啊");

                return null;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return p;
    }
    public int GetJsonModify(String s){
        int f = 0;
        try {
            JSONObject jsonObject = new JSONObject(s);
            if (jsonObject.getBoolean("Result")){
                JSONObject jsonObject1 = jsonObject.getJSONObject("Detail");
                f = jsonObject1.getInt("status");
            }else {
                iDetailPeople.showMassageError("接口挂了还是什么鬼的我也不叽到啊");
            }
        }catch (JSONException e){
            e.printStackTrace();
        }

        return f;


    }
}
