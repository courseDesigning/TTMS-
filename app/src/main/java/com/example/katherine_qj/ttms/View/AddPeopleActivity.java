package com.example.katherine_qj.ttms.View;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.katherine_qj.ttms.IView.IAddPeople;
import com.example.katherine_qj.ttms.Presenter.AddPeoplePresenter;
import com.example.katherine_qj.ttms.R;
import com.example.katherine_qj.ttms.model.People;

/**
 * Created by katherine on 5/18/17.
 */

public class AddPeopleActivity extends Activity implements IAddPeople{
    private EditText username_add_people_edit;
    private EditText name_add_people_edit;
    private EditText adress_add_people_edit;
    private EditText tel_add_people_edit;
    private EditText email_add_people_edit;
    private Button button_add_people;
    private ImageButton button_add_people_back;
    private AddPeoplePresenter addPeoplePresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addpeople);
        initView();
        button_add_people.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addPeoplePresenter.Addpeople(getPeopleMessage());

            }
        });
        button_add_people_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private void initView(){
        addPeoplePresenter = new AddPeoplePresenter(this,this);
        username_add_people_edit = (EditText) findViewById(R.id.username_add_people);
        name_add_people_edit = (EditText) findViewById(R.id.name_add_people);
        adress_add_people_edit = (EditText) findViewById(R.id.adress_add_people);
        tel_add_people_edit = (EditText) findViewById(R.id.tel_add_people);
        email_add_people_edit = (EditText) findViewById(R.id.email_add_people);
        button_add_people = (Button)findViewById(R.id.button_add_people);
        button_add_people_back = (ImageButton)findViewById(R.id.add_people_back);
    }

    @Override
    public void showMessage(People people) {

    }

    @Override
    public void emptyMessage() {

    }

    @Override
    public void showMassageError(String s) {

    }

    @Override
    public void ShowTost(String s) {

    }

    @Override
    public People getPeopleMessage() {
        People p = new People();
        p.setEmp_no(username_add_people_edit.getText().toString());
        p.setEmp_email(email_add_people_edit.getText().toString());
        p.setEmp_tel_num(tel_add_people_edit.getText().toString());
        p.setEmp_addr(adress_add_people_edit.getText().toString());
        p.setEmp_name(name_add_people_edit.getText().toString());
        return p;
    }
}
