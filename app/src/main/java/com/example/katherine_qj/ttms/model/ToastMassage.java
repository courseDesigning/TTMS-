package com.example.katherine_qj.ttms.model;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by katherine on 5/11/17.
 */

public class ToastMassage {
    public void showMassage(String massage, Context context){
        Toast.makeText(context,massage,Toast.LENGTH_SHORT).show();
    }
}
