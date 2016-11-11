package com.csdn.pagerslidingtabstrip.view;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.pagerslidingtabstrip.R;


public class SlidingTab extends HorizontalScrollView {

    private int textColor = Color.WHITE;
    private int textDefColor = Color.WHITE;
    private int textFocusColor=Color.GREEN;
    private float textPadding = 15;
    private float textSize = 20;
    private float lineHeight = 10;
    private int lineColor =  Color.WHITE;
    private LinearLayout mLayout;
    private ViewPager mPager;
    private final PageListener mPageListener = new PageListener();
    private Paint mPaint;
    private int count ;
    private float offset = 52;
    private int lastScrollX;
    private int currentPosition;
    private float  currentPositionOffset;
    private float line_margin_top = 15;
    private OnTabPageChangeListener onTabPageChangeListener;


    public SlidingTab(Context context) {
        super(context);
    }
    public SlidingTab(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public SlidingTab(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public String[] s;


    private  void init(AttributeSet attrs){
        DisplayMetrics dm = getResources().getDisplayMetrics();
        offset = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, offset,dm);
        lineHeight = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, lineHeight,dm);
        textPadding = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, textPadding,dm);
        textSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, textSize,dm);
        TypedArray mTypedValue =  getContext().obtainStyledAttributes(attrs, R.styleable.SlingTab);
        textColor = mTypedValue.getColor(R.styleable.SlingTab_s_textColor, textColor);
        textDefColor  = mTypedValue.getColor(R.styleable.SlingTab_textDefColor, textDefColor);
        textPadding = mTypedValue.getDimension(R.styleable.SlingTab_textPadding, textPadding);
        textSize = mTypedValue.getDimension(R.styleable.SlingTab_s_textSize, textSize);
        lineHeight = mTypedValue.getDimension(R.styleable.SlingTab_lineHeight, lineHeight);
        lineColor  = mTypedValue.getColor(R.styleable.SlingTab_lineColor, lineColor);
        line_margin_top = mTypedValue.getDimension(R.styleable.SlingTab_line_marginTop, line_margin_top);
        textFocusColor  = mTypedValue.getColor(R.styleable.SlingTab_textFocusColor, textFocusColor);
        mTypedValue.recycle();
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
        setHorizontalScrollBarEnabled(false);
        mLayout = new LinearLayout(getContext());
        mLayout.setOrientation(LinearLayout.HORIZONTAL);
        mLayout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        addView(mLayout);
    }
    public void setViewPager(ViewPager mPager){
        if(mPager == null){
            throw new NullPointerException("current ViewPager for empty");
        }
        this.mPager = mPager;
        mPager.setOnPageChangeListener(mPageListener);
        notifyDataSetChanged();
    }


    public void setTitles(String[] s){
        this.s=s;
        for (int i = 0; i < s.length; i++) {
            mLayout.addView(addTab(i, s[i]));
         /*   if(i<s.length-1){

            }*/
        }
        scrollToChild(0, 0);
        setSelect(0);
    }






    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(count < 0){
            return;
        }
        mPaint.setColor(lineColor);
        int height = getMeasuredHeight();

        for(int i=0;i<s.length;i++){
            float lineRight = mLayout.getChildAt(i).getRight()- textPadding;
            canvas.drawLine(lineRight+textPadding , line_margin_top, lineRight+textPadding, height-line_margin_top, mPaint);

        }









       /*  float lineLeft = mLayout.getChildAt(currentPosition).getLeft() + textPadding;
         float lineRight = mLayout.getChildAt(currentPosition).getRight()- textPadding;








        if(currentPositionOffset > 0F && currentPosition < count){
             float Left = mLayout.getChildAt(currentPosition + 1).getLeft()  +  textPadding;
             float Right = mLayout.getChildAt(currentPosition + 1).getRight()-  textPadding;
             lineLeft = (currentPositionOffset * Left + (1F - currentPositionOffset) * lineLeft);
             lineRight = (currentPositionOffset * Right + (1F - currentPositionOffset) * lineRight);*/

        //  canvas.drawRect(lineLeft , height - lineHeight, lineRight, height, mPaint);
    }



    private void notifyDataSetChanged() {
        count =  mPager.getAdapter().getCount();
        for (int i = 0; i < count; i++) {
            mLayout.addView(addTab(i, mPager.getAdapter().getPageTitle(i).toString()));

        }
        scrollToChild(0, 0);
    }



    private TextView addTab(final int position, String title) {
        TextView mTextView = new TextView(getContext());
        mTextView.setId(position);
        mTextView.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT));
        mTextView.setGravity(Gravity.CENTER);
        mTextView.setText(title);
        mTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX,textSize);
        mTextView.setTextColor(textDefColor);
        mTextView.setPadding((int)textPadding, 0, (int)textPadding, 0);
        mTextView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // mPager.setCurrentItem(position);
                setSelect(position);
            }
        });
        return mTextView;
    }

    public void setSelect(int n){
        if(s==null){
            return;
        }
        TextView v;
        for(int i=0;i<s.length;i++){
            v=(TextView) mLayout.getChildAt(i);
            if(i==n){
                v.setTextColor(textFocusColor);
            }else {
                v.setTextColor(textDefColor);
            }
        }
    }




    void scrollToChild(int position , int positionOffset){
        if(count < 0 ||position==s.length){

            return;
        }

        int newPositionOffset  = mLayout.getChildAt(position).getLeft() + positionOffset;
        if(position > 0 || positionOffset > 0 ){
            newPositionOffset -= offset;
        }
        if(newPositionOffset != lastScrollX){
            lastScrollX = newPositionOffset;
            scrollTo(newPositionOffset, 0);
        }
    }



    public  interface OnTabPageChangeListener{
        void onPageScrollStateChanged(int state);
        void onPageScrolled(int position, float positionOffset, int positionOffsetPixels);
        void onPageSelected(int position);
    }


    class PageListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrollStateChanged(int state) {
            if(onTabPageChangeListener != null){
                onTabPageChangeListener.onPageScrollStateChanged(state);
            }
        }
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            SlidingTab.this.currentPosition = position;
            SlidingTab.this.currentPositionOffset = positionOffset;
            scrollToChild(position, (int) (positionOffset * mLayout.getChildAt(position).getWidth()) );
            invalidate();
            if(onTabPageChangeListener != null){
                onTabPageChangeListener.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }
        }

        @Override
        public void onPageSelected(int position) {

            if(onTabPageChangeListener != null){
                onTabPageChangeListener.onPageSelected(position );
            }

        }

    }
    public int getTextColor() {
        return textColor;
    }
    public void setTextColor(int textColor) {
        this.textColor = textColor;
        invalidate();
    }
    public int getTextDefColor() {
        return textDefColor;
    }
    public void setTextDefColor(int textDefColor) {
        this.textDefColor = textDefColor;
        invalidate();
    }
    public float getTextPadding() {
        return textPadding;
    }
    public void setTextPadding(float textPadding) {
        this.textPadding = textPadding;
        invalidate();
    }
    public float getTextSize() {
        return textSize;
    }
    public void setTextSize(float textSize) {
        this.textSize = textSize;
        invalidate();
    }
    public float getLineHeight() {
        return lineHeight;
    }
    public void setLineHeight(float lineHeight) {
        this.lineHeight = lineHeight;
        invalidate();
    }
    public int getLineColor() {
        return lineColor;
    }
    public void setLineColor(int lineColor) {
        this.lineColor = lineColor;
        invalidate();
    }
    public OnTabPageChangeListener getOnTabPageChangeListener() {
        return onTabPageChangeListener;
    }
    public void setOnTabPageChangeListener(
            OnTabPageChangeListener onTabPageChangeListener) {
        this.onTabPageChangeListener = onTabPageChangeListener;
    }







}