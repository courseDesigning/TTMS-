package com.example.katherine_qj.ttms.model;

import android.util.Log;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

import okio.BufferedSink;

/**
 * Created by katherine on 5/11/17.
 */

public class GetHttpResponseString {
    PeopleOnline p  = PeopleOnline.getInstance();
    public static OkHttpClient client = new OkHttpClient();
    public String getResponString(String url,String sessionid,RequestBody requestBody){
            Request request = new Request.Builder()
                    .url(url)
                    .addHeader("Cookie",sessionid)
                    .post(requestBody)
                    .build();
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                return response.body().string();
            }
            else {
                return "un";
            }
        } catch (final IOException e) {
            e.printStackTrace();
            return  "un";
        }
    }
    public RequestBody getRequestBodyAllUser(){
        RequestBody formBody = new RequestBody() {
            @Override
            public MediaType contentType() {
                return null;
            }

            @Override
            public void writeTo(BufferedSink sink) throws IOException {

            }
        };
        return  formBody;
    }
    public RequestBody getRequestBodyDel(String username){
        RequestBody formBody = new FormEncodingBuilder()
                .add("username", username)
                .build();
        return  formBody;
    }

    public String getResponString(String url) {
        final Request request = new Request.Builder().get().tag(this).url(url).build();
        Response response=null;
        try {
            response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                response.toString();
                p.setSsession_id( StringSplite(response.header("set-cookie")));

                return response.body().string();
            } else {
                throw new IOException("Unexpected code " + response);

            }
        } catch (final IOException e) {
            e.printStackTrace();
            return  "un";
        }
    }
    public String getdelURL(){
        return "http://123.206.67.174:18000/user/daleteUser";
    }
    public String getModifyUrl(int emp_id ,String emp_name,String emp_tel_num,String emp_addr,String emp_email ){
        return "http://123.206.67.174:18000/user/updataUser?emp_id="+emp_id+"&emp_name="+emp_name+"&emp_tel_num="
                +emp_tel_num+"&emp_addr="+emp_addr+"&emp_email="+emp_email;
    }
    public String  getAddPeopleUrl(String username,String name,String tel,String address,String email){
        return "http://123.206.67.174:18000/user/register?username="+username+"&name="+name+"&tel="
                +tel+"&address="+address+"&email="+email;
    }
    public String getDetailPeopleUrl(int id){
        return"http://123.206.67.174:18000/user/queryUser"+"?"+"userId="+id;
    }

    public String getLoginUrl(String username,String password){
        return "http://123.206.67.174:18000/user/login"+"?"+"username="+username+"&"+"password="+password;
    }
    public String getAllPeopleUrl(){

        return "http://123.206.67.174:18000/user/queryUser";
    }
    public String getAllVoide(){

        return "http://123.206.67.174:18000/film/querys";
    }
    public String getAllRoom(){
        return "http://123.206.67.174:18000/studio/queryStudio";
    }
    public String getAllPlan(){
        return "http://123.206.67.174:18000/play/queryPlay";
    }
    public String StringSplite(String setcookie){
        String s  = setcookie.substring(0,setcookie.indexOf(';'));
        return s;
    }
}
