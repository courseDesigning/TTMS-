package com.example.katherine_qj.ttms.IView;

import com.example.katherine_qj.ttms.model.People;

/**
 * Created by katherine on 5/31/17.
 */

public interface IAddPeople {
    void showMessage(People people);
    void emptyMessage();
    void showMassageError(String s);
    void ShowTost(String s);
    People getPeopleMessage();
}
