package com.example.katherine_qj.ttms.View;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.katherine_qj.ttms.IView.IDetailPeople;
import com.example.katherine_qj.ttms.Presenter.DetailPeoplePresenter;
import com.example.katherine_qj.ttms.R;
import com.example.katherine_qj.ttms.model.People;
import com.example.katherine_qj.ttms.model.ToastMassage;

/**
 * Created by katherine on 5/17/17.
 */

public class DetilePeopleActivity extends Activity implements IDetailPeople,View.OnClickListener {
    private int detail_id;
    String username = null;
    private ImageButton detail_back;
    private TextView detail_text_id;
    private EditText detail_name;
    private EditText detail_tel;
    private EditText detail_email;
    private EditText detail_adress;
    private Button  detail_delete;
    private Button   detail_modify;
    private DetailPeoplePresenter detailPeoplePresenter;
    private ToastMassage toastMassage;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        detail_id = getIntent().getIntExtra("ID",0);
        setContentView(R.layout.activity_detilepeople);
        initView();
        detailPeoplePresenter.getDetailPeople(detail_id);
    }
    public void initView(){
        toastMassage = new ToastMassage();
        detailPeoplePresenter = new DetailPeoplePresenter(this,this);
        detail_back = (ImageButton)findViewById(R.id.detail_people_back);
        detail_back.setOnClickListener(this);
        detail_text_id = (TextView)findViewById(R.id.detail_people_id);
        detail_name = (EditText)findViewById(R.id.detail_people_name);
        detail_email = (EditText)findViewById(R.id.detail_people_emile);
        detail_adress = (EditText)findViewById(R.id.detail_people_dress);
        detail_tel = (EditText)findViewById(R.id.detail_people_tel);
        detail_delete = (Button)findViewById(R.id.detail_people_detele);
        detail_modify = (Button)findViewById(R.id.detail_people_modify);
        detail_delete.setOnClickListener(this);
        detail_modify.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.detail_people_back:
                finish();
                break;
            case R.id.detail_people_detele:
                //删除
                detailPeoplePresenter.delPeople(username);
                break;
            case R.id.detail_people_modify:
                //执行修改逻辑
                detailPeoplePresenter.modifyPeople(getModifyMessage());
                break;
        }

    }

    @Override
    public void showMessage(People people) {
        detail_text_id.setText(people.getEmp_id()+"");
        detail_name.setText(people.getEmp_name());
        detail_email.setText(people.getEmp_email());
        detail_adress.setText(people.getEmp_addr());
        detail_tel.setText(people.getEmp_tel_num());
        username = people.getEmp_no();
    }

    @Override
    public void emptyMessage() {
        detail_text_id.setText("");
        detail_name.setText("");
        detail_email.setText("");
        detail_adress.setText("");
        detail_tel.setText("");

    }

    @Override
    public void showMassageError(String s) {
        toastMassage.showMassage(s,getApplicationContext());
    }

    @Override
    public void ShowTost(String s) {
        toastMassage.showMassage(s,getApplicationContext());
    }

    public People getModifyMessage(){
        People people = new People();
        people.setEmp_id(detail_id);
        people.setEmp_name(detail_name.getText().toString());
        people.setEmp_tel_num(detail_tel.getText().toString());
        people.setEmp_addr(detail_adress.getText().toString());
        people.setEmp_email(detail_email.getText().toString());
        return  people;
    }
}
