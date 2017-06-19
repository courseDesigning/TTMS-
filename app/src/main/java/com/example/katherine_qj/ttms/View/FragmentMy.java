package com.example.katherine_qj.ttms.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.katherine_qj.ttms.R;
import com.example.katherine_qj.ttms.model.User;

/**
 * Created by Katherine-qj on 2017/4/8.
 */

public class FragmentMy extends Fragment {
    private View view;
    private TextView myDateTextView;
    private TextView myMoneyTextView;
    private TextView myAchievementTextView;
    private TextView myCheckTextView;
    private TextView myUserName;
    private TextView myUserId;
    private User user = User.getInstance();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = (View)inflater.inflate(R.layout.fragment_my,container,false);
        return view;
    }
    public void initView(){
        myDateTextView = (TextView)view.findViewById(R.id.text_ziliao);
        myMoneyTextView = (TextView)view.findViewById(R.id.text_money);
        myAchievementTextView = (TextView)view.findViewById(R.id.text_yeji);
        myCheckTextView = (TextView)view.findViewById(R.id.text_kaoqin);
        myUserName = (TextView)view.findViewById(R.id.my_user_name);
        myUserId = (TextView)view.findViewById(R.id.my_user_id);
    }
}
