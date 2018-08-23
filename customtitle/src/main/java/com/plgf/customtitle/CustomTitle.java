package com.plgf.customtitle;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * 作者：zzz on 2018/8/20 0020 15:35
 * 邮箱：1038883524@qq.com
 * 功能：自定义Title
 */

public class CustomTitle extends RelativeLayout {

    private String title;
    private int titleColor;
    private float textsize;
    private ImageView img_left;
    private ImageView img_right;
    private TextView tv_title;
    private RelativeLayout relativeLayout;
    private int resourceId;
    private int resourceId_left;
    private int resourceId_right;
    private OnClickListen onLeftClickListen;
    private OnClickListen onRightClickListen;
    private OnClickListen onRightTvClickListen;
    private Context context;
    private TextView tv_right;


    public CustomTitle(Context context) {
        super(context);
    }

    public CustomTitle(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.context = context;

        LayoutInflater.from(context).inflate(R.layout.view_custom_title, this);
        img_left = (ImageView) findViewById(R.id.view_img_left);
        img_right = (ImageView) findViewById(R.id.view_img_right);
        tv_title = (TextView) findViewById(R.id.view_tv_title);
        relativeLayout = (RelativeLayout) findViewById(R.id.view_re);
        tv_right = (TextView) findViewById(R.id.view_tv_right);
        init();

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.customTitle);
        title = typedArray.getString(R.styleable.customTitle_titletext);
        if (title!=null&&!title.equals("")){
            setTitle(title);
        }

        titleColor = typedArray.getInt(R.styleable.customTitle_titletextcolor, Color.BLACK);
        setTitleColor(titleColor);

        textsize = typedArray.getDimension(R.styleable.customTitle_titletextsize, 18);
        setTextSize(textsize);

        resourceId = typedArray.getInt(R.styleable.customTitle_titletextbackground,Color.BLACK);
        setTitleBackgroud(resourceId);

        resourceId_left = typedArray.getResourceId(R.styleable.customTitle_leftimg, R.drawable.i);
        setLeftBackgroud(resourceId_left);

        resourceId_right = typedArray.getResourceId(R.styleable.customTitle_rightimg, R.drawable.i);
        setRightBackgroud(resourceId_right);


        typedArray.recycle();

    }

    private void init() {
        img_left.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onLeftClickListen!=null){
                    onLeftClickListen.onclick(v);
                }else {
                    ((Activity)context).finish();
                }
            }
        });
        img_right.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onRightClickListen!=null){
                    onRightClickListen.onclick(v);
                }
            }
        });
        tv_right.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onRightTvClickListen!=null){
                    onRightTvClickListen.onclick(v);
                }
            }
        });

    }


    public CustomTitle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CustomTitle(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    //设置标题
    public void setTitle(String title) {
        this.title = title;
        tv_title.setText(title);
        invalidate();
    }

    //设置标题颜色
    public void setTitleColor(int titleColor) {

        this.titleColor = titleColor;
        tv_title.setTextColor(titleColor);
        invalidate();
    }

    //设置标题字体大小
    public void setTextSize(float textsize) {
        this.textsize = textsize;
        tv_title.setTextSize(textsize);
        invalidate();
    }
    //设置标题栏背景 ，支持颜色
    public void setTitleBackgroud(int resourceId) {
        relativeLayout.setBackgroundColor(resourceId);
        invalidate();
    }

    //设置左按钮，支持图片
    public void setLeftBackgroud(int resourceId_left){

        if (resourceId_left==R.drawable.i){
            img_left.setVisibility(GONE);
        }

        this.resourceId_left = resourceId_left;
        img_left.setBackgroundResource(resourceId_left);
        invalidate();
    }

    //设置右按钮，支持图片
    public void setRightBackgroud(int resourceId_right){
        if (resourceId_right==R.drawable.i){
            img_right.setVisibility(GONE);
        }
        this.resourceId_right = resourceId_right;
        img_right.setBackgroundResource(resourceId_right);
        invalidate();
    }
    //左点击事件
    public void setLeftOnClickListen(OnClickListen onClickListen){
        this.onLeftClickListen = onClickListen;
    }
    //右图片点击事件
    public void setRightOnClickListen(OnClickListen onClickListen){
        this.onRightClickListen = onClickListen;
    }

    //右文点击事件，与右图片同时只能支持一个
    public void setRightTvOnClickListen(OnClickListen onClickListen){
        this.onRightTvClickListen = onClickListen;
    }

    //右文字设置，如果设置右文字点击，必须设置右文字
    public void setRightTvText(String rightText){
        tv_right.setText(rightText);
        invalidate();
    }
}
