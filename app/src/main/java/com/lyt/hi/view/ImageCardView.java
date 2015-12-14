package com.lyt.hi.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2015/12/12.
 */
public class ImageCardView extends LinearLayout {

    public ImageCardView(Context context) {
        super(context);
        setHorizontalGravity(VERTICAL);
    }

    public ImageCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setHorizontalGravity(VERTICAL);

    }

    public ImageCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setHorizontalGravity(VERTICAL);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

}
