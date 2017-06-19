package com.example.katherine_qj.ttms.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.katherine_qj.ttms.R;
import com.example.katherine_qj.ttms.model.CustomerViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Katherine-qj on 2017/4/8.
 */

public class FragmentHome extends Fragment {
    private View view;
    private CustomerViewPager viewPager;
    private List<View> viewPagerList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = (View) inflater.inflate(R.layout.fragment_home, container, false);
        initView();
        return view;
    }

    public void initView() {
        viewPager = (CustomerViewPager) view.findViewById(R.id.set_fragment_viewpager);
        InitViewPagerList();
    }

    public void InitViewPagerList() {
        ImageView imageView1 = new ImageView(getContext());
        ImageView imageView2 = new ImageView(getContext());
        ImageView imageView3 = new ImageView(getContext());
        ImageView imageView4 = new ImageView(getContext());
        imageView1.setBackgroundResource(R.mipmap.h1);
        viewPagerList.add(imageView1);
        imageView2.setBackgroundResource(R.mipmap.h2);
        viewPagerList.add(imageView2);
        imageView3.setBackgroundResource(R.mipmap.h3);
        viewPagerList.add(imageView3);
        imageView4.setBackgroundResource(R.mipmap.h4);
        viewPagerList.add(imageView4);
        viewPager.setViewPageViews(viewPagerList);
    }
}


