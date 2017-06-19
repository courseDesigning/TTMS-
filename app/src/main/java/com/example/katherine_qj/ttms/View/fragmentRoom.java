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
import com.example.katherine_qj.ttms.Presenter.FragmentPlayPresenter;
import com.example.katherine_qj.ttms.Presenter.FragmentRoomPresenter;
import com.example.katherine_qj.ttms.R;
import com.example.katherine_qj.ttms.model.People;
import com.example.katherine_qj.ttms.model.Play;
import com.example.katherine_qj.ttms.model.PlayRecycleViewAdapter;
import com.example.katherine_qj.ttms.model.Room;
import com.example.katherine_qj.ttms.model.RoomRecycleViewAdapter;
import com.example.katherine_qj.ttms.model.ToastMassage;
import com.example.katherine_qj.ttms.model.Voide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by katherine on 5/15/17.
 */

public class fragmentRoom extends Fragment  implements IFragmentManagment{
    private View view;
    private Button add_room;
    private ToastMassage toastMassage;
    private RecyclerView room_recycleview;
    private RelativeLayout loading_relativeLayout;
    private RelativeLayout loadingfaild_relativeLayout;
    private LinearLayout Recycleview_relativeLayout;
    private List<Room> list = new ArrayList<>();
    private SwipeRefreshLayout room_swipeRefreshLayout;
    private FragmentRoomPresenter fragmentRoomPresenter;
    private RoomRecycleViewAdapter roomrecycleViewAdapter ;
    private RecyclerView.OnScrollListener mRecycleViewOnScrollerChanged;
    private Intent intent;
    private Intent intents;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = (View)inflater.inflate(R.layout.fragment_room,container,false);
        initView();
        fragmentRoomPresenter.getAllRoom();
        return view;
    }
    public void initView(){
        //intents = new Intent(getContext(),AddPeopleActivity.class);
        //intent = new Intent(getContext(),DetileVoideActivity.class);
        toastMassage = new ToastMassage();
        room_recycleview = (RecyclerView)view.findViewById(R.id.room_recyclerView);
        room_recycleview.setLayoutManager(new LinearLayoutManager(room_recycleview.getContext()));
        add_room= (Button)view.findViewById(R.id.plan_add);
//        add_room.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(intents);
//
//            }
//        });
        loading_relativeLayout = (RelativeLayout)view.findViewById(R.id.loading_now);
        loadingfaild_relativeLayout=(RelativeLayout)view.findViewById(R.id.loading_faild);
        Recycleview_relativeLayout = (LinearLayout)view.findViewById(R.id.recycleview_relativeLayout);
        room_swipeRefreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.room_swiplayout);
        room_swipeRefreshLayout.setColorSchemeResources(R.color.library_red);
        fragmentRoomPresenter = new FragmentRoomPresenter(getContext(),this,list);
        room_swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                list.clear();
                fragmentRoomPresenter.getAllRoom();
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
        room_swipeRefreshLayout.setRefreshing(statue);
    }

    @Override
    public void setRecycleView(List<People> list) {

    }

    @Override
    public void setRecycleViewVoide(List<Voide> list) {

    }

    @Override
    public void setRecycleViewPlay(List<Play> list) {

    }

    @Override
    public void setRecycleViewRoom(List<Room> list) {
        Recycleview_relativeLayout.setVisibility(View.VISIBLE);
        loading_relativeLayout.setVisibility(View.INVISIBLE);
        loadingfaild_relativeLayout.setVisibility(View.INVISIBLE);
        room_recycleview.setAdapter(roomrecycleViewAdapter = new RoomRecycleViewAdapter(getContext(),list));
       /* roomrecycleViewAdapter.setOnItemClickListener(new RoomRecycleViewAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int ID) {
                Log.e("","");
                intent.putExtra("ID",ID);
             //   startActivity(intent);

            }
        });*/
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
