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

import com.example.katherine_qj.ttms.Presenter.FragmentVoidePresenter;
import com.example.katherine_qj.ttms.R;
import com.example.katherine_qj.ttms.model.People;
import com.example.katherine_qj.ttms.model.Play;
import com.example.katherine_qj.ttms.model.Room;
import com.example.katherine_qj.ttms.model.ToastMassage;
import com.example.katherine_qj.ttms.model.Voide;
import com.example.katherine_qj.ttms.model.VoideRecycleViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by katherine on 5/15/17.
 */

public class fragmentVoide extends Fragment  implements IFragmentManagment{
    private View view;
    private Button add_voide;
    private ToastMassage toastMassage;
    private RecyclerView voide_recycleview;
    private RelativeLayout loading_relativeLayout;
    private RelativeLayout loadingfaild_relativeLayout;
    private LinearLayout Recycleview_relativeLayout;
    private List<Voide> list = new ArrayList<>();
    private SwipeRefreshLayout voide_swipeRefreshLayout;
    private com.example.katherine_qj.ttms.Presenter.FragmentVoidePresenter FragmentVoidePresenter;
    private VoideRecycleViewAdapter voiderecycleViewAdapter ;
    private RecyclerView.OnScrollListener mRecycleViewOnScrollerChanged;
    private Intent intent;
    private Intent intents;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = (View)inflater.inflate(R.layout.fragment_voide,container,false);
        InitView();
        FragmentVoidePresenter.getAllVoide();
        return view;
    }
    public void InitView(){
        //intents = new Intent(getContext(),AddPeopleActivity.class);
        toastMassage = new ToastMassage();
       intent = new Intent(getContext(),DetileVoideActivity.class);
        voide_recycleview = (RecyclerView)view.findViewById(R.id.voide_recyclerView);
        voide_recycleview.setLayoutManager(new LinearLayoutManager(voide_recycleview.getContext()));
        add_voide = (Button)view.findViewById(R.id.voide_add);
        add_voide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intents);

            }
        });
        loading_relativeLayout = (RelativeLayout)view.findViewById(R.id.loading_now);
        loadingfaild_relativeLayout=(RelativeLayout)view.findViewById(R.id.loading_faild);
        Recycleview_relativeLayout = (LinearLayout)view.findViewById(R.id.recycleview_relativeLayout);
        voide_swipeRefreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.voide_swiplayout);
        voide_swipeRefreshLayout.setColorSchemeResources(R.color.library_red);
        FragmentVoidePresenter = new FragmentVoidePresenter(getContext(),this,list);
        voide_swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                list.clear();
                FragmentVoidePresenter.getAllVoide();
            }
        });

    }

    @Override
    public void showMassage(String massage) {

    }

    @Override
    public void setNoHaveMore() {

    }

    @Override
    public void setRefreshing(boolean statue) {
        voide_swipeRefreshLayout.setRefreshing(statue);

    }

    @Override
    public void setRecycleView(List<People> list) {

    }

    @Override
    public void setRecycleViewVoide(List<Voide> list) {
        Recycleview_relativeLayout.setVisibility(View.VISIBLE);
        loading_relativeLayout.setVisibility(View.INVISIBLE);
        loadingfaild_relativeLayout.setVisibility(View.INVISIBLE);
        voide_recycleview.setAdapter(voiderecycleViewAdapter = new VoideRecycleViewAdapter(getContext(),list));
        voiderecycleViewAdapter.setOnItemClickListener(new VoideRecycleViewAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int ID) {
                Log.e("","");
                intent.putExtra("ID",ID);
                startActivity(intent);

            }
        });


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
