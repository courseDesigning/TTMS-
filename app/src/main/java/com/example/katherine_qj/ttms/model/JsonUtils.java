package com.example.katherine_qj.ttms.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by katherine on 5/11/17.
 */

public class JsonUtils {
    private String successFlag;
    private String successSession;
    private int type;

    JSONObject jsonObject1 ;
    JSONObject jsonObject2;


    public String  JsonGetSuccessFlag( String json){
        try {
            jsonObject1 = new JSONObject(json);
            jsonObject2 = (JSONObject)jsonObject1.getJSONObject("Detail");
            successFlag = jsonObject2.getString("status");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return successFlag;

    }
    public int  JsonGetTYpeFlag( String json){
        try {
            jsonObject1 = new JSONObject(json);
            jsonObject2 = (JSONObject)jsonObject1.getJSONObject("Detail");
            type = jsonObject2.getInt("type");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return type;

    }
    public String  JsonGetSuccessSession( String json){
        try {
            jsonObject1 = new JSONObject(json);
            jsonObject2 = (JSONObject)jsonObject1.getJSONObject("Detail");
            successSession = jsonObject2.getString("session");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return successSession;
    }

}
