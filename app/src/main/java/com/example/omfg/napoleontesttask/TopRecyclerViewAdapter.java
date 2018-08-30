package com.example.omfg.napoleontesttask;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TopRecyclerViewAdapter  {
    private String[] mDataSet;

    public static class TopViewHolder extends RecyclerView.ViewHolder{
        public TextView mTextView;
        public TopViewHolder(View itemView){
            super(itemView);

        }
    }
    public TopRecyclerViewAdapter(Context context) {

    }



}
