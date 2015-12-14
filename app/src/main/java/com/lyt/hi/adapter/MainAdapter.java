package com.lyt.hi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lyt.hi.R;

import java.util.zip.Inflater;

/**
 * Created by Administrator on 2015/12/11.
 */
public class MainAdapter extends RecyclerView.Adapter{


    private Context context;

    private String[] strings={"gfff","dd","dd","d","gfff","dd","dd","d","gfff","dd","dd","d","gfff","dd","dd","d","gfff","dd","dd","d"};

    public MainAdapter(Context context) {
        this.context = context;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root= LayoutInflater.from(context).inflate(R.layout.main_recycler_item,parent,false);
        return new MainViewHolder(root);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MainViewHolder viewHolder=(MainViewHolder)holder;
      /*  viewHolder.textView.setText(strings[position]);*/


    }

    @Override
    public int getItemCount() {
        return strings.length;
    }

    class  MainViewHolder extends RecyclerView.ViewHolder{

        private TextView textView;
        public MainViewHolder(View itemView) {
            super(itemView);
           /* textView= (TextView) itemView.findViewById(R.id.main_recyclerView_text);*/
        }
    }
}
