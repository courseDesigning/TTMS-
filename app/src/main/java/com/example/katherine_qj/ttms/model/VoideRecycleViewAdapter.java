package com.example.katherine_qj.ttms.model;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.katherine_qj.ttms.R;

import java.util.List;

/**
 * Created by katherine on 6/5/17.
 */

public class VoideRecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener{
    private Context context;
    private List<Voide> list;
    /*private View loadView;*/

    private static final int TYPE_NORMAL = 0X001;
    private static final int TYPE_LOAD = 0X002;
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;


    public VoideRecycleViewAdapter(Context context) {
        this.context = context;
    }

    public VoideRecycleViewAdapter(Context context, List<Voide> list) {
        this.context = context;
        this.list = list;

    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(context).inflate(R.layout.voide_item, parent, false);
        view.setOnClickListener(this);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder) {
            if (list != null) {
                Glide.with(context).load(list.get(position).getfilm_img()).into(((MyViewHolder) holder).voide_image);
                ((MyViewHolder) holder).voide_name.setText(list.get(position).getFilm_name());
                ((MyViewHolder) holder).itemView.setTag(list.get(position).getFilm_id());
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
        ImageView voide_image;
        TextView voide_name;

        public MyViewHolder(View view) {
            super(view);
            voide_image = (ImageView) view.findViewById(R.id.voide_image);
            voide_name = (TextView) view.findViewById(R.id.voide_name);
        }
    }


    public static interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, int ID);
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;


    }
}
