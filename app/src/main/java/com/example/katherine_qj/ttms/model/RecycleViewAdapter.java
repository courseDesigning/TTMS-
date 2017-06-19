package com.example.katherine_qj.ttms.model;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.katherine_qj.ttms.R;

import java.util.List;

/**
 * Created by katherine on 5/15/17.
 */

public class RecycleViewAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener{
    private Context context;
    private List<People>list;
    /*private View loadView;*/

    private static final int TYPE_NORMAL = 0X001;
    private static final int TYPE_LOAD = 0X002;
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;


    public RecycleViewAdapter(Context context) {
        this.context = context;
    }

    public RecycleViewAdapter(Context context, List<People> list) {
        this.context = context;
        this.list = list;

    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


                View view = LayoutInflater.from(context).inflate(R.layout.people_item, parent, false);
                view.setOnClickListener(this);
                return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder) {
            if (list != null) {
                ((MyViewHolder) holder).titie_userid.setText(list.get(position).getEmp_id()+"");
                ((MyViewHolder) holder).titie_username.setText(list.get(position).getEmp_name());
                ((MyViewHolder) holder).itemView.setTag(list.get(position).getEmp_id());
            }
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    @Override
    public int getItemViewType(int position) {
        if (position + 1 == getItemCount()) {
            return TYPE_LOAD;
        } else {
            return TYPE_NORMAL;
        }
    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(v, (int)v.getTag());
             Log.e("ID",(int)v.getTag()+"");
        }
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView titie_username;
        TextView titie_userid;

        public MyViewHolder(View view) {
            super(view);
            titie_userid = (TextView)view.findViewById(R.id.people_id);
            titie_username = (TextView) view.findViewById(R.id.people_name);
        }
    }


    public static interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, int ID);
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;


    }
}
