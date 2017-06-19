package com.example.katherine_qj.ttms.Presenter;

import android.content.Context;
import android.os.Message;
import android.util.Log;

import com.example.katherine_qj.ttms.IView.IFragmentManagment;
import com.example.katherine_qj.ttms.model.GetPlanModel;
import com.example.katherine_qj.ttms.model.JsonUtils;
import com.example.katherine_qj.ttms.model.Play;
import com.example.katherine_qj.ttms.model.Voide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by katherine on 6/7/17.
 */

public class FragmentPlayPresenter {
    private int  play_id;
    private int  studio_id;
    private String  play_start;
    private String  play_end;
    private  int film_id;
    private String  film_name;
    private Context context;
    private Play play;
    private List<Play> List_play;
    private GetPlanModel getPlanModel;
    private JsonUtils jsonUtils = new JsonUtils();
    private IFragmentManagment iFragmentManagment;
    public FragmentPlayPresenter (Context context,IFragmentManagment iFragmentManagment,List<Play> list){
        this.context = context;
        this.iFragmentManagment = iFragmentManagment;
        this.List_play = list;
        getPlanModel= new GetPlanModel();
    }
    android.os.Handler handler = new android.os.Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0: {
                    String s = (String) msg.obj;
                    List_play = getPlayFromJson(s);
                    Log.e("","");
                    //传数据到显示界面
                    iFragmentManagment.setRecycleViewPlay(List_play);
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
    public void getAllPlay(){
        getPlanModel.getAllPlan( handler);
    }
    public List<Play> getPlayFromJson(String s) {
        List<Play> plays = new ArrayList<>();
        JSONArray jsonarray = null;
        try {
            JSONObject jsonObject1 = new JSONObject(s);
            if (jsonObject1.getBoolean("Result")) {
                String date = jsonObject1.getString("Detail");
                jsonarray = new JSONArray(date);
                for (int i = 0; i < jsonarray.length(); i++) {
                    JSONObject jsonObject = (JSONObject) jsonarray.get(i);
                    play_id = jsonObject.getInt("play_id");
                    studio_id = jsonObject.getInt("studio_id");
                    play_start = jsonObject.getString("play_start");
                    play_end = jsonObject.getString("play_end");
                    film_id = jsonObject.getInt("film_id");
                    film_name = jsonObject.getString("film_name");
                    play = new Play();
                    play.setFilm_id(film_id);
                    play.setFilm_name(film_name);
                    play.setPlay_end(play_end);
                    play.setPlay_start(play_start);
                    play.setPlay_id(play_id);
                    play.setStudio_id(studio_id);

                    plays.add(play);
                }

            } else {
                iFragmentManagment.showMassage("接口挂了还是什么鬼的我也不叽到啊");
                iFragmentManagment.setRefreshing(false);
                return null;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return plays;
    }

}
