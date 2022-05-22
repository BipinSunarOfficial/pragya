package com.example.meroarkoapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter  extends BaseAdapter {
    private List<Product> productList = new ArrayList<>();
    private Context context;

    ListAdapter(List<Product> productList, Context mContext){
        this.productList.addAll(productList);
        context = mContext;
    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Product getItem(int i) {
        return productList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
