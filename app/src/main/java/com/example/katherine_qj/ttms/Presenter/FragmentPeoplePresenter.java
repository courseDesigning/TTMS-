package com.example.katherine_qj.ttms.Presenter;

import android.content.Context;
import android.os.Message;
import android.util.Log;

import com.example.katherine_qj.ttms.IView.IFragmentManagment;
import com.example.katherine_qj.ttms.model.GetPeopleoModel;
import com.example.katherine_qj.ttms.model.JsonUtils;
import com.example.katherine_qj.ttms.model.People;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by katherine on 5/15/17.
 */

public class FragmentPeoplePresenter {
    private int emp_id;
    private String emp_no;
    private String emp_name;
    private String emp_tel_num;
    private String emp_addr;
    private String emp_email;
    private Context context;
    private People people;
    private IFragmentManagment ifragmentManagment;
    private List<People> peoples;
    private GetPeopleoModel getPeopleoModel;
    private JsonUtils jsonUtils = new JsonUtils();
    android.os.Handler handler = new android.os.Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0: {
                    String s = (String) msg.obj;
                    peoples = getPeopleFromJson(s);
                    Log.e("","");
                    ifragmentManagment.setRecycleView(peoples);
                    ifragmentManagment.setRefreshing(false);

                    break;
                }
                case 1: {
                    ifragmentManagment.setLoadingFaild();
                    ifragmentManagment.showMassage("网络错误");
                    ifragmentManagment.setRefreshing(false);
                    break;

                }

            }
        }
    };

    public FragmentPeoplePresenter(Context context, IFragmentManagment ifragmentNotice, List<People> list) {
        this.context = context;
        this.getPeopleoModel = new GetPeopleoModel();
        this.ifragmentManagment = ifragmentNotice;
        this.peoples = list;
    }

    public void getAllPeople() {
        getPeopleoModel.getAllPeople(handler);
    }

    public List<People> getPeopleFromJson(String s) {
        List<People> notices = new ArrayList<>();
        JSONArray jsonarray = null;
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
                    people = new People();
                    people.setEmp_id(emp_id);
                    people.setEmp_no(emp_no);
                    people.setEmp_name(emp_name);
                    people.setEmp_addr(emp_addr);
                    people.setEmp_email(emp_email);
                    people.setEmp_tel_num(emp_tel_num);
                    notices.add(people);
                }

            } else {
                ifragmentManagment.showMassage("接口挂了还是什么鬼的我也不叽到啊");
                ifragmentManagment.setRefreshing(false);
                return null;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return notices;
    }
}

