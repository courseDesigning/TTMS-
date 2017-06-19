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
 * Created by katherine on 6/7/17.
 */

public class RoomRecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener{
    private Context context;
    private List<Room> list;
    /*private View loadView;*/

    private static final int TYPE_NORMAL = 0X001;
    private static final int TYPE_LOAD = 0X002;
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;


    public RoomRecycleViewAdapter(Context context) {
        this.context = context;
    }

    public RoomRecycleViewAdapter(Context context, List<Room> list) {
        this.context = context;
        this.list = list;

    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(context).inflate(R.layout.room_item, parent, false);
        view.setOnClickListener(this);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder) {
            if (list != null) {
                ((MyViewHolder) holder).room_id.setText(list.get(position).getStudio_id()+" ");
                ((MyViewHolder) holder).room_name.setText(list.get(position).getStudio_name());
                ((MyViewHolder) holder).seat_count.setText(list.get(position).getStudio_col_count()*list.get(position).getStudio_row_count()+"个座位");
                ((MyViewHolder) holder).itemView.setTag(list.get(position).getStudio_id());
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
        TextView room_id;
        TextView room_name;
        TextView seat_count;

        public MyViewHolder(View view) {
            super(view);
            room_id = (TextView)view.findViewById(R.id.item_room_id);
            room_name = (TextView) view.findViewById(R.id.item_room_name);
            seat_count = (TextView) view.findViewById(R.id.item_room_seat);
        }
    }


    public static interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, int ID);
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;


    }
}
