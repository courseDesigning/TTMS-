package com.example.katherine_qj.ttms.View;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.EditText;
import android.widget.TextView;
import com.example.katherine_qj.ttms.R;
/**
 * Created by katherine on 6/5/17.
 */

public class DetileVoideActivity extends Activity {
    private EditText film_tostar;
    private EditText film_release;
    private EditText film_hourlong;
    private EditText film_type;
    private EditText film_price;
    private TextView film_name;
    private TextView film_information;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detilevoide);
        initView();
    }
    public void initView(){
        film_tostar = (EditText)findViewById(R.id.film_tostar);
        film_release = (EditText)findViewById(R.id.film_release);
        film_hourlong = (EditText)findViewById(R.id.film_hourlong);
        film_type = (EditText)findViewById(R.id.film_type);
        film_price = (EditText)findViewById(R.id.film_price);
        film_name = (TextView)findViewById(R.id.film_name);
        film_information = (TextView)findViewById(R.id.film_information);
    }
}
