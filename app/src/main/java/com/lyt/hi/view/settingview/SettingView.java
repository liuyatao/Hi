package com.lyt.hi.view.settingview;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lyt.hi.R;

import org.w3c.dom.Text;

import java.util.List;

import cn.bmob.v3.listener.InitListener;

/**
 * Created by Administrator on 2015/12/12.
 */
public class SettingView extends LinearLayout {

    private List<SettingItem> settingItems;
    private TextView titleText;
    private TextView valueText;

    private Context context;

    public SettingView(Context context) {
        super(context);
       this.context=context;
    }
    public SettingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
    }
    public SettingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;
    }

    public void addItem(SettingItem newItem){
         CardView view= (CardView) LayoutInflater.from(context).inflate(R.layout.card_setting,null,false);
        FrameLayout.LayoutParams layoutParams=new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(50,50,50,50);
        view.setLayoutParams(layoutParams);
        titleText= (TextView) view.findViewById(R.id.card_setting_title);
        valueText= (TextView) view.findViewById(R.id.card_setting_value);
        titleText.setText(newItem.getTitle());
        valueText.setText(newItem.getValue());
        addView(view);
    }


}
