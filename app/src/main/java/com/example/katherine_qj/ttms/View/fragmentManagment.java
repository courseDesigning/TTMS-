package com.example.katherine_qj.ttms.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.katherine_qj.ttms.IView.IFragmentManagment;
import com.example.katherine_qj.ttms.Presenter.FragmentPeoplePresenter;
import com.example.katherine_qj.ttms.R;
import com.example.katherine_qj.ttms.model.People;
import com.example.katherine_qj.ttms.model.Play;
import com.example.katherine_qj.ttms.model.RecycleViewAdapter;
import com.example.katherine_qj.ttms.model.Room;
import com.example.katherine_qj.ttms.model.ToastMassage;
import com.example.katherine_qj.ttms.model.Voide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by katherine on 5/15/17.
 */

public class fragmentManagment extends Fragment implements IFragmentManagment {
    private View view;
    private Button add_people;
    private ToastMassage toastMassage;
    private RecyclerView notice_recycleview;
    private RelativeLayout loading_relativeLayout;
    private RelativeLayout loadingfaild_relativeLayout;
    private LinearLayout Recycleview_relativeLayout;
    private List<People> list = new ArrayList<>();
    private SwipeRefreshLayout notice_swipeRefreshLayout;
    private FragmentPeoplePresenter FragmentPeoplePresenter;
    private RecycleViewAdapter recycleViewAdapter ;
    private RecyclerView.OnScrollListener mRecycleViewOnScrollerChanged;
    private Intent intent;
    private Intent intents;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = (View)inflater.inflate(R.layout.fragment_people,container,false);
        InitView();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        FragmentPeoplePresenter.getAllPeople();
    }

    public void InitView(){
        intents = new Intent(getContext(),AddPeopleActivity.class);
        toastMassage = new ToastMassage();
        intent = new Intent(getContext(),DetilePeopleActivity.class);
        notice_recycleview = (RecyclerView)view.findViewById(R.id.people_recyclerView);
        notice_recycleview.setLayoutManager(new LinearLayoutManager(notice_recycleview.getContext()));
        add_people = (Button)view.findViewById(R.id.people_add);
        add_people.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intents);

            }
        });
        loading_relativeLayout = (RelativeLayout)view.findViewById(R.id.loading_now);
        loadingfaild_relativeLayout=(RelativeLayout)view.findViewById(R.id.loading_faild);
        Recycleview_relativeLayout = (LinearLayout)view.findViewById(R.id.recycleview_relativeLayout);
        notice_swipeRefreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.notice_swiplayout);
        notice_swipeRefreshLayout.setColorSchemeResources(R.color.library_red);
        FragmentPeoplePresenter = new FragmentPeoplePresenter(getContext(),this,list);
        notice_swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                list.clear();
                FragmentPeoplePresenter.getAllPeople();
            }
        });

    }

    @Override
    public void showMassage(String massage) {
        toastMassage.showMassage(massage,getContext());
    }

    @Override
    public void setNoHaveMore() {
    }

    @Override
    public void setRefreshing(boolean statue) {
        notice_swipeRefreshLayout.setRefreshing(statue);

    }


    @Override
    public void setRecycleView(List<People> list) {
        Recycleview_relativeLayout.setVisibility(View.VISIBLE);
        loading_relativeLayout.setVisibility(View.INVISIBLE);
        loadingfaild_relativeLayout.setVisibility(View.INVISIBLE);
        notice_recycleview.setAdapter(recycleViewAdapter = new RecycleViewAdapter(getContext(),list));
        recycleViewAdapter.setOnItemClickListener(new RecycleViewAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int ID) {
                Log.e("","");
                intent.putExtra("ID",ID);
                startActivity(intent);

            }
        });


    }

    @Override
    public void setRecycleViewVoide(List<Voide> list) {

    }

    @Override
    public void setRecycleViewPlay(List<Play> list) {

    }

    @Override
    public void setRecycleViewRoom(List<Room> list) {

    }

    @Override
    public void setLoadingFaild() {

    }

    @Override
    public void setLoading() {

    }

    @Override
    public void setRecycleView() {

    }

}
