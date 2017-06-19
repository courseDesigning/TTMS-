package com.example.katherine_qj.ttms.Presenter;

import android.content.Context;
import android.os.Message;
import android.util.Log;
import android.view.View;

import com.example.katherine_qj.ttms.IView.IFragmentManagment;
import com.example.katherine_qj.ttms.model.GetPeopleoModel;
import com.example.katherine_qj.ttms.model.GetVoideModel;
import com.example.katherine_qj.ttms.model.JsonUtils;
import com.example.katherine_qj.ttms.model.People;
import com.example.katherine_qj.ttms.model.Voide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by katherine on 6/2/17.
 */

public class FragmentVoidePresenter {
    private int film_id;
    private String film_name;
    private String film_tostar;
    private String film_release;
    private String film_hourlong;
    private String film_type;
    private int film_price;
    private String film_img;
    private String film_information;
    private Context context;
    private Voide voide;
    private IFragmentManagment iFragmentManagment;
    private List<Voide> list_voide;
    private GetVoideModel getVoideModel;
    private JsonUtils jsonUtils = new JsonUtils();
    public FragmentVoidePresenter(Context context, IFragmentManagment iFragmentVoide, List<Voide> list) {
        this.context = context;
        this.getVoideModel = new GetVoideModel();
        this.iFragmentManagment = iFragmentVoide;
        this.list_voide = list;
    }
    android.os.Handler handler = new android.os.Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0: {
                    String s = (String) msg.obj;
                    list_voide = getPeopleFromJson(s);
                    Log.e("","");
                    //传数据到显示界面
                    iFragmentManagment.setRecycleViewVoide(list_voide);
                    iFragmentManagment.setRefreshing(false);
                    break;
                }
                case 1: {
                    iFragmentManagment.setLoadingFaild();
                    iFragmentManagment.showMassage("网络错误");
                    iFragmentManagment.setRefreshing(false);
                    break;

                }

            }
        }
    };
    public void getAllVoide(){
        getVoideModel.getAllVoide( handler);
    }
    public List<Voide> getPeopleFromJson(String s) {
        List<Voide> notices = new ArrayList<>();
        JSONArray jsonarray = null;
        try {
            JSONObject jsonObject1 = new JSONObject(s);
            if (jsonObject1.getBoolean("Result")) {
                String date = jsonObject1.getString("Detail");
                jsonarray = new JSONArray(date);
                for (int i = 0; i < jsonarray.length(); i++) {
                    JSONObject jsonObject = (JSONObject) jsonarray.get(i);
                    film_id = jsonObject.getInt("film_id");
                    film_name = jsonObject.getString("film_name");
                    film_tostar = jsonObject.getString("film_tostar");
                    film_release = jsonObject.getString("film_release");
                    film_hourlong = jsonObject.getString("film_hourlong");
                    film_type = jsonObject.getString("film_type");
                    film_price = jsonObject.getInt("film_price");
                    film_img = jsonObject.getString("film_img");
                    film_information = jsonObject.getString("film_information");
                    voide = new Voide();
                    voide.setFilm_id(film_id);
                    voide.setFilm_name(film_name);
                    voide.setFilm_tostar(film_tostar);
                    voide.setFilm_release(film_release);
                    voide.setFilm_hourlong(film_hourlong);
                    voide.setFilm_price(film_price);
                    voide.setFilm_type(film_type);
                    voide.setfilm_img(film_img);
                    voide.setFilm_information(film_information);
                    notices.add(voide);
                }

            } else {
                iFragmentManagment.showMassage("接口挂了还是什么鬼的我也不叽到啊");
                iFragmentManagment.setRefreshing(false);
                return null;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return notices;
    }
}
