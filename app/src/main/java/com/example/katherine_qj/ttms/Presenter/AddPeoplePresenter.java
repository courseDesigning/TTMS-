package com.example.katherine_qj.ttms.Presenter;

import android.content.Context;
import android.os.Message;

import com.example.katherine_qj.ttms.IView.IAddPeople;
import com.example.katherine_qj.ttms.IView.IDetailPeople;
import com.example.katherine_qj.ttms.model.AddPeopleModel;
import com.example.katherine_qj.ttms.model.DetailPeopleModel;
import com.example.katherine_qj.ttms.model.People;

/**
 * Created by katherine on 5/31/17.
 */

public class AddPeoplePresenter {
    private Context context;
    private IAddPeople iAddPeople;
    private AddPeopleModel addPeopleModel;
    android.os.Handler handler = new android.os.Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0: {
                    String s = (String) msg.obj;
                    break;
                }
                case 1: {

                    break;

                }

            }
        }
    };
    public AddPeoplePresenter(Context context, IAddPeople iAddPeople){
        this.context = context;
        this.iAddPeople = iAddPeople;
        this.addPeopleModel = new AddPeopleModel();
    }
    public void Addpeople(People people){
        addPeopleModel.addNewPeople(handler,people);
    }
}
