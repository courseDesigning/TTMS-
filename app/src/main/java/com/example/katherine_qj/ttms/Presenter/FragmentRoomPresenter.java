package com.example.katherine_qj.ttms.Presenter;

import android.content.Context;
import android.os.Message;
import android.util.Log;

import com.example.katherine_qj.ttms.IView.IFragmentManagment;
import com.example.katherine_qj.ttms.model.GetPlanModel;
import com.example.katherine_qj.ttms.model.GetRoomModel;
import com.example.katherine_qj.ttms.model.JsonUtils;
import com.example.katherine_qj.ttms.model.Play;
import com.example.katherine_qj.ttms.model.Room;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by katherine on 6/7/17.
 */

public class FragmentRoomPresenter {
    private int studio_id;
    private String studio_name;
    private int studio_row_count;
    private int studio_col_count;
    private int studio_flag;
    private Context context;
    private Room room;
    private List<Room> List_room;
    private GetRoomModel getRoomModel;
    private JsonUtils jsonUtils = new JsonUtils();
    private IFragmentManagment iFragmentManagment;
    public FragmentRoomPresenter (Context context,IFragmentManagment iFragmentManagment,List<Room> list){
        this.context = context;
        this.iFragmentManagment = iFragmentManagment;
        this.List_room = list;
        getRoomModel= new GetRoomModel();
    }
    android.os.Handler handler = new android.os.Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0: {
                    String s = (String) msg.obj;
                    Log.e("","");
                    List_room = getRoomFromJson(s);
                    //传数据到显示界面
                    iFragmentManagment.setRecycleViewRoom(List_room);
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
    public void getAllRoom(){
        getRoomModel.getAllRoom( handler);
    }
    public List<Room> getRoomFromJson(String s) {
        List<Room> rooms = new ArrayList<>();
        JSONArray jsonarray = null;
        try {
            JSONObject jsonObject1 = new JSONObject(s);
            if (jsonObject1.getBoolean("Result")) {
                String date = jsonObject1.getString("Detail");
                jsonarray = new JSONArray(date);
                for (int i = 0; i < jsonarray.length(); i++) {
                    JSONObject jsonObject = (JSONObject) jsonarray.get(i);
                    studio_row_count = jsonObject.getInt("studio_row_count");
                    studio_id = jsonObject.getInt("studio_id");
                    studio_name = jsonObject.getString("studio_name");
                    studio_col_count = jsonObject.getInt("studio_col_count");
                    studio_flag = jsonObject.getInt("studio_flag");
                    room = new Room();
                    room.setStudio_row_count(studio_row_count);
                    room.setStudio_id(studio_id);
                    room.setStudio_name(studio_name);
                    room.setStudio_col_count(studio_col_count);
                    room.setStudio_flag(studio_flag);

                    rooms.add(room);
                }

            } else {
                iFragmentManagment.showMassage("接口挂了还是什么鬼的我也不叽到啊");
                iFragmentManagment.setRefreshing(false);
                return null;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return rooms;
    }
}
