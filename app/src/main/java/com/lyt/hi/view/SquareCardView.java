package com.lyt.hi.view;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.util.Log;

/**
 * 一个宽和高相等的CardView
 * Created by Administrator on 2015/12/11.
 */
public class SquareCardView extends CardView {
    public SquareCardView(Context context) {
        super(context);
    }

    public SquareCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode=MeasureSpec.getMode(widthMeasureSpec);
        int widthSize=MeasureSpec.getSize(widthMeasureSpec);
        Log.e("msg","widthMode为"+mode(widthMode)+"widthSize为："+widthSize);

        int heightMode=MeasureSpec.getMode(heightMeasureSpec);
        int heightSize=MeasureSpec.getSize(heightMeasureSpec);
        Log.e("msg","heightMode为"+mode(heightMode)+"heightSize为："+heightSize);
        setMeasuredDimension(widthSize,widthSize);

    }
    String mode(int mode){

        if (mode==MeasureSpec.EXACTLY){
            return "EXACTLY";
        }else if (mode==MeasureSpec.AT_MOST){
            return "AT_MOST";
        }else if (mode==MeasureSpec.UNSPECIFIED){
            return "UNSPECIFIED";
        }
        return null;

    }
}
