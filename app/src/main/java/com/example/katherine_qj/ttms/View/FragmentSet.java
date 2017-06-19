package com.example.katherine_qj.ttms.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.katherine_qj.ttms.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Katherine-qj on 2017/4/8.
 */

public class FragmentSet extends Fragment {
    private ViewPager fragmentHomeViewPager;
    private List<View> viewPagerList = new ArrayList<>();
    private View view;
    private ImageButton search;
    private RadioGroup radioGroup;
    private RadioButton radioButton_room;
    private RadioButton radioButton_plan;
    private RadioButton radioButton_voide;
    private RadioButton radioButton_people;
    private List<Fragment> fragmentListSet;
    private fragmentPlan fragmentPlan;
    private fragmentVoide fragmentVoide;
    private fragmentManagment fragmentPeople;
    private fragmentRoom fragmentRoom;
    private boolean isafirst =true;
    private FragmentPagerAdapter fragmentPagerAdapterHome;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentListSet = new ArrayList<Fragment>();
        fragmentPlan = new fragmentPlan();
        fragmentVoide = new fragmentVoide();
        fragmentPeople = new fragmentManagment();
        fragmentRoom = new fragmentRoom();
        fragmentListSet.add(fragmentRoom);
        fragmentListSet.add(fragmentPlan);
        fragmentListSet.add(fragmentVoide);
        fragmentListSet.add(fragmentPeople);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = (View)inflater.inflate(R.layout.activity_set,container,false);
        initView();
        initViewpager();
        return view;
    }
    public void initView(){
       /* search = (ImageButton)view.findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),SearchActivity.class);
                startActivity(intent);
            }
        });*/
        fragmentHomeViewPager = (ViewPager)view.findViewById(R.id.fragment_home_viewpager);
        radioGroup = (RadioGroup)view.findViewById(R.id.radio_group_home);
        radioButton_room = (RadioButton)view.findViewById(R.id.radiobutton_room);
        radioButton_plan= (RadioButton)view.findViewById(R.id.radiobutton_plan);
        radioButton_voide = (RadioButton)view.findViewById(R.id.radiobutton_voide);
        radioButton_people = (RadioButton)view.findViewById(R.id.radiobutton_people);

        FragmentManager fragmentManager = getChildFragmentManager();
        fragmentPagerAdapterHome = new FragmentPagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                return fragmentListSet.get(position);
            }

            @Override
            public int getCount() {
                return fragmentListSet.size();
            }
        };


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radiobutton_room:
                        fragmentHomeViewPager.setCurrentItem(0);
                        radioButton_room.setChecked(true);
                        radioButton_room.setTextColor(getResources().getColor(R.color.library_red));
                        radioButton_plan.setTextColor(getResources().getColor(R.color.library_norall));
                        radioButton_voide.setTextColor(getResources().getColor(R.color.library_norall));
                        radioButton_people.setTextColor(getResources().getColor(R.color.library_norall));

                        break;
                    case R.id.radiobutton_plan:
                        fragmentHomeViewPager.setCurrentItem(1);
                        radioButton_plan.setChecked(true);
                        radioButton_plan.setTextColor(getResources().getColor(R.color.library_red));
                        radioButton_room.setTextColor(getResources().getColor(R.color.library_norall));
                        radioButton_voide.setTextColor(getResources().getColor(R.color.library_norall));
                        radioButton_people.setTextColor(getResources().getColor(R.color.library_norall));

                        break;
                    case R.id.radiobutton_voide:
                        fragmentHomeViewPager.setCurrentItem(2);
                        radioButton_voide.setChecked(true);
                        radioButton_voide.setTextColor(getResources().getColor(R.color.library_red));
                        radioButton_room.setTextColor(getResources().getColor(R.color.library_norall));
                        radioButton_plan.setTextColor(getResources().getColor(R.color.library_norall));
                        radioButton_people.setTextColor(getResources().getColor(R.color.library_norall));

                        break;
                    case R.id.radiobutton_people:
                        fragmentHomeViewPager.setCurrentItem(3);
                        radioButton_people.setChecked(true);
                        radioButton_people.setTextColor(getResources().getColor(R.color.library_red));
                        radioButton_room.setTextColor(getResources().getColor(R.color.library_norall));
                        radioButton_plan.setTextColor(getResources().getColor(R.color.library_norall));
                        radioButton_voide.setTextColor(getResources().getColor(R.color.library_norall));

                        break;
                }
            }
        });
    }
    public void initViewpager(){
       // fragmentHomeViewPager.setPageTransformer(true,new TransfromAnm());
        fragmentHomeViewPager.setAdapter(fragmentPagerAdapterHome);
        fragmentHomeViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:{
                        radioButton_room.setChecked(true);
                        radioButton_room.setTextColor(getResources().getColor(R.color.library_red));
                        radioButton_plan.setTextColor(getResources().getColor(R.color.library_norall));
                        radioButton_voide.setTextColor(getResources().getColor(R.color.library_norall));
                        radioButton_people.setTextColor(getResources().getColor(R.color.library_norall));

                        break;
                    }
                    case 1:{
                        radioButton_plan.setChecked(true);
                        radioButton_plan.setTextColor(getResources().getColor(R.color.library_red));
                        radioButton_room.setTextColor(getResources().getColor(R.color.library_norall));
                        radioButton_voide.setTextColor(getResources().getColor(R.color.library_norall));
                        radioButton_people.setTextColor(getResources().getColor(R.color.library_norall));
                        break;
                    }
                    case 2:{
                        radioButton_voide.setChecked(true);
                        radioButton_voide.setTextColor(getResources().getColor(R.color.library_red));
                        radioButton_room.setTextColor(getResources().getColor(R.color.library_norall));
                        radioButton_plan.setTextColor(getResources().getColor(R.color.library_norall));
                        radioButton_people.setTextColor(getResources().getColor(R.color.library_norall));
                        break;
                    }
                    case 3:{
                        radioButton_people.setChecked(true);
                        radioButton_people.setTextColor(getResources().getColor(R.color.library_red));
                        radioButton_room.setTextColor(getResources().getColor(R.color.library_norall));
                        radioButton_plan.setTextColor(getResources().getColor(R.color.library_norall));
                        radioButton_voide.setTextColor(getResources().getColor(R.color.library_norall));

                        break;
                    }
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

}
