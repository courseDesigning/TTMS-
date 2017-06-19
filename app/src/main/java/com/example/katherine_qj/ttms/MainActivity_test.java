package com.example.katherine_qj.ttms;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.katherine_qj.ttms.View.FragmentHome;
import com.example.katherine_qj.ttms.View.FragmentMy;
import com.example.katherine_qj.ttms.View.FragmentSet;
import com.example.katherine_qj.ttms.model.ToastMassage;
import com.qfdqc.views.seattable.SeatTable;

import java.util.ArrayList;
import java.util.List;

public class MainActivity_test extends AppCompatActivity {
    Button button ;

    SeatTable mSeatTable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_test);
        button = (Button)findViewById(R.id.button_sale);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"售票成功",Toast.LENGTH_SHORT).show();
            }
        });
        mSeatTable = (SeatTable) findViewById(R.id.seatView);
//        mSeatTable.setScreenName(detail.getStudio_name());//设置屏幕名称
        mSeatTable.setMaxSelected(3);//设置最多选中
        mSeatTable.setData(13, 15);
        mSeatTable.setSeatChecker(new SeatTable.SeatChecker() {

            @Override
            public boolean isValidSeat(int row, int column) {
                if(column==2) {
                    return false;
                }
                return true;
            }

            @Override
            public boolean isSold(int row, int column) {
                if(row==6&&column==6){
                    return true;
                }
                return false;
            }

            @Override
            public void checked(int row, int column) {


            }

            @Override
            public void unCheck(int row, int column) {


            }

            @Override
            public String[] checkedSeatTxt(int row, int column) {

                return null;
            }
        });



    }

}