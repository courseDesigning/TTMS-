package com.example.katherine_qj.ttms.model;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.katherine_qj.ttms.R;

import java.util.List;

/**
 * Created by katherine on 6/7/17.
 */

public class PlayRecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener{
    private Context context;
    private List<Play> list;
    /*private View loadView;*/

    private static final int TYPE_NORMAL = 0X001;
    private static final int TYPE_LOAD = 0X002;
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;


    public PlayRecycleViewAdapter(Context context) {
        this.context = context;
    }

    public PlayRecycleViewAdapter(Context context, List<Play> list) {
        this.context = context;
        this.list = list;

    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(context).inflate(R.layout.play_item, parent, false);
        view.setOnClickListener(this);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder) {
            if (list != null) {
                ((MyViewHolder) holder).play_id.setText(list.get(position).getPlay_id()+" ");
                ((MyViewHolder) holder).studio_id.setText(list.get(position).getStudio_id()+"号演出厅");
                ((MyViewHolder) holder).play_name.setText(list.get(position).getFilm_name());
                ((MyViewHolder) holder).itemView.setTag(list.get(position).getPlay_id());
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
        TextView play_id;
        TextView play_name;
        TextView studio_id;

        public MyViewHolder(View view) {
            super(view);
            studio_id = (TextView)view.findViewById(R.id.item_studio_id);
            play_id = (TextView) view.findViewById(R.id.item_play_id);
            play_name = (TextView) view.findViewById(R.id.item_play_name);
        }
    }


    public static interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, int ID);
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;


    }
}

