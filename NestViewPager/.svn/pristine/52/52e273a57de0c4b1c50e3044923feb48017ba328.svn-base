package com.csdn.IconTabPageIndicator.icon;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/11/10.
 */
public class TabLine extends LinearLayout {

    private ImageView imageView;
    private TextView textView;
    private int iconWidth=10,iconHeight=10,iconPadding;

    private CharSequence mText;
    public void setIconWidth(int iconWidth,int iconHeight) {
        LinearLayout.LayoutParams ime_param=new LinearLayout.LayoutParams(iconWidth, iconHeight);
        imageView.setLayoutParams(ime_param);
        //invalidate();

    }
    public int mIndex;
    public void setIconPadding(int iconPadding) {
        this.iconPadding = iconPadding;
        this.setPadding(0,iconPadding,0,iconPadding);
       // this.invalidate();
    }
    public int getIndex() {
        return mIndex;
    }


    public TabLine(Context context) {
        super(context);
        init();
    }

    public TabLine(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TabLine(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init(){
        this.setOrientation(VERTICAL);

        LinearLayout.LayoutParams line_params=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT,1.0f);
        this.setLayoutParams(line_params);
        this.setBackgroundColor(Color.parseColor("#C3c3c3"));
        this.setGravity(Gravity.CENTER_HORIZONTAL);
        imageView=new ImageView(getContext());
        LinearLayout.LayoutParams ime_param=new LinearLayout.LayoutParams(iconWidth, iconHeight);
        textView=new TextView(getContext());
        LinearLayout.LayoutParams txt_param=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        imageView.setLayoutParams(ime_param);
        textView.setLayoutParams(txt_param);
        this.addView(imageView);
       // this.addView(textView);

    }

    public void setmTextSize(int textSize){
        textView.setTextSize(textSize);
        this.invalidate();
    }

    public void setmText(CharSequence charSequence){
        if(charSequence==null){
            textView.setVisibility(GONE);
        }
        textView.setText(charSequence);
        this.invalidate();
    }


    public void setIcon(int resId){
        imageView.setImageResource(resId);
        this.invalidate();
    }



   public void  setTextColor(int color){
       textView.setTextColor(color);
   }







}
