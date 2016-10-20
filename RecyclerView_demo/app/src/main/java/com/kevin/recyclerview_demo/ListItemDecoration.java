package com.kevin.recyclerview_demo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Administrator on 2016/10/20.
 */
public class ListItemDecoration extends RecyclerView.ItemDecoration {
    private Drawable drawable;
    private final static int DEAFULT_ORENTATION = LinearLayoutManager.VERTICAL;
    private int mOrientation;

    public ListItemDecoration(Context context,int orientation){
        if (orientation!=LinearLayoutManager.VERTICAL && orientation!=LinearLayoutManager.HORIZONTAL){
            this.mOrientation=DEAFULT_ORENTATION;
        }else{
            this.mOrientation=orientation;
        }
        drawable = context.getResources().getDrawable(R.drawable.divider);

    }


    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        if(mOrientation == LinearLayoutManager.HORIZONTAL){
            drawHorizontal(c,parent);
        }else{
            drawVertical(c,parent);
        }
    }

    private void drawHorizontal(Canvas c,RecyclerView parent){
        int top = parent.getPaddingTop();
        int bottom = parent.getHeight()-parent.getPaddingBottom();

        int childCount = parent.getChildCount();
        for (int i =0;i<childCount;i++){
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams)child.getLayoutParams();

            int left = child.getRight()+params.rightMargin;
            int right = left+drawable.getIntrinsicHeight();
            drawable.setBounds(left,top,right,bottom);
            drawable.draw(c);
        }

    }

    private void drawVertical(Canvas c,RecyclerView parent){
        int left = parent.getPaddingLeft();
        int right = parent.getWidth()-parent.getPaddingRight();

        int childCount = parent.getChildCount();
        for(int i=0;i<childCount;i++){
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams)child.getLayoutParams();
            int top = child.getBottom()+params.bottomMargin;
            int buttom = top+drawable.getIntrinsicHeight();
            drawable.setBounds(left,top,right,buttom);
            drawable.draw(c);
        }

    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
    }


}
