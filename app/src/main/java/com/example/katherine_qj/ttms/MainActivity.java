package com.example.katherine_qj.ttms;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.katherine_qj.ttms.View.FragmentHome;
import com.example.katherine_qj.ttms.View.FragmentMy;
import com.example.katherine_qj.ttms.View.FragmentSet;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ViewPager fragment_viewpager;
    private RadioGroup radioGroup;
    private RadioButton radioButton_home;
    private RadioButton radioButton_my;
    private RadioButton radioButton_set;
    private List<Fragment> fragmentList;
    private FragmentHome fragment_home;
    private FragmentMy fragment_my;
    private FragmentSet fragment_set;
    private FragmentPagerAdapter fragmentPagerAdapter;
    private RadioButton[] checks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initViewPager();
    }
    public void  initView(){
        fragment_viewpager = (ViewPager)findViewById(R.id.fragment_viewpager);
        radioGroup = (RadioGroup)findViewById(R.id.radio_group);
        radioButton_home = (RadioButton)findViewById(R.id.radiobutton_home);
        radioButton_my = (RadioButton)findViewById(R.id.radiobutton_my);
        radioButton_set = (RadioButton)findViewById(R.id.radiobutton_set);

        fragmentList = new ArrayList<Fragment>();
        fragment_home = new FragmentHome();
        fragment_my = new FragmentMy();
        fragment_set = new FragmentSet();
        fragmentList.add(fragment_home);
        fragmentList.add(fragment_set);
        fragmentList.add(fragment_my);
        checks = new RadioButton[3];
        checks[0] = (RadioButton) findViewById(R.id.radiobutton_home);
        checks[1] = (RadioButton) findViewById(R.id.radiobutton_set);
        checks[2] = (RadioButton) findViewById(R.id.radiobutton_my);
        for (int i = 0; i < checks.length; i++) {
            checks[i].setOnClickListener(this);
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentPagerAdapter = new FragmentPagerAdapter(fragmentManager) {
            @Override
            public android.support.v4.app.Fragment getItem(int position) {
                return fragmentList.get(position);
            }
            @Override
            public int getCount() {
                return fragmentList.size();
            }
        };



    }

    public void checkOneButton(int index){
        radioButton_home.setTextColor(getResources().getColor(R.color.library_norall));
        radioButton_my.setTextColor(getResources().getColor(R.color.library_norall));
        radioButton_set.setTextColor(getResources().getColor(R.color.library_norall));
        switch (index){
            case 0:{
                radioButton_home.setTextColor(getResources().getColor(R.color.library_red));
                break;
            }
            case 1:{
                radioButton_set.setTextColor(getResources().getColor(R.color.library_red));
                break;
            }
            case 2:{
                radioButton_my.setTextColor(getResources().getColor(R.color.library_red));
                break;
            }
        }
    }
    public void initViewPager(){
        fragment_viewpager.setAdapter(fragmentPagerAdapter);
        fragment_viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        radioButton_home.setChecked(true);
                        radioButton_home.setTextColor(getResources().getColor(R.color.library_red));
                        radioButton_my.setTextColor(getResources().getColor(R.color.library_norall));
                        radioButton_set.setTextColor(getResources().getColor(R.color.library_norall));

                        break;
                    case 1:
                        radioButton_set.setChecked(true);
                        radioButton_set.setTextColor(getResources().getColor(R.color.library_red));
                        radioButton_my.setTextColor(getResources().getColor(R.color.library_norall));
                        radioButton_home.setTextColor(getResources().getColor(R.color.library_norall));

                        break;
                    case 2:

                        radioButton_my.setChecked(true);
                        radioButton_my.setTextColor(getResources().getColor(R.color.library_red));
                        radioButton_home.setTextColor(getResources().getColor(R.color.library_norall));
                        radioButton_set.setTextColor(getResources().getColor(R.color.library_norall));


                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }


        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.radiobutton_set:{
                fragment_viewpager.setCurrentItem(1);
                checkOneButton(1);
                break;
            }
            case R.id.radiobutton_my:{
                fragment_viewpager.setCurrentItem(2);
                checkOneButton(2);
                break;
            }
            case R.id.radiobutton_home:{
                fragment_viewpager.setCurrentItem(0);
                checkOneButton(0);
                break;
            }
        }
    }
}