package com.example.katherine_qj.ttms.IView;

import com.example.katherine_qj.ttms.model.People;
import com.example.katherine_qj.ttms.model.Play;
import com.example.katherine_qj.ttms.model.Room;
import com.example.katherine_qj.ttms.model.Voide;

import java.util.List;

/**
 * Created by katherine on 5/15/17.
 */

public interface IFragmentManagment {
     void showMassage(String massage);
     void setNoHaveMore();
     void setRefreshing(boolean statue);
     void setRecycleView(List<People> list);
     void setRecycleViewVoide(List<Voide> list);
     void setRecycleViewPlay(List<Play> list);
     void setRecycleViewRoom(List<Room> list);
     void setLoadingFaild();
     void setLoading();
     void setRecycleView();
}
