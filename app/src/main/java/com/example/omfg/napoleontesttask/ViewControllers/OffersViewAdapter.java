package com.example.omfg.napoleontesttask.ViewControllers;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;

import com.example.omfg.napoleontesttask.R;

import java.util.List;

import AppObjects.Offer;

public class OffersViewAdapter extends BaseAdapter {

    Context context;
    LayoutInflater layoutInflater;
    List<AppObjects.Offer> offers;

    public OffersViewAdapter(Context context,  List<Offer> offers) {
        this.context = context;
        this.offers = offers;

    }

    @Override
    public int getCount() {
        return offers.size();
    }

    @Override
    public Object getItem(int i) {
        return offers.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {


            view = layoutInflater.inflate(R.layout.sales_layout,viewGroup,false);

return null;


    }
}
