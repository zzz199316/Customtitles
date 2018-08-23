package com.plgf.customtitle;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.readystatesoftware.systembartint.SystemBarTintManager;
import java.util.TimerTask;
/**
 * 作者：zzz on 2018/8/21 0021 10:22
 * 邮箱：1038883524@qq.com
 * 功能：自定义Activity，支持6.0权限。支持沉浸式状态栏
 */
public class CustomActivity extends CheckPermissionsActivity {
    private int res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//        imageLoader = ImageLoader.getInstance();

    }

    public void setStatusBarColor(int res){
        this.res = res;
    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            initState();
        }catch (Exception ex){
        }

    }

    //沉浸式状态栏
    private void initState() {
        //透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //透明导航栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        SystemBarTintManager tintManager = new SystemBarTintManager(this);
        // 激活状态栏
        tintManager.setStatusBarTintEnabled(true);
        // enable navigation bar tint 激活导航栏
        tintManager.setNavigationBarTintEnabled(false);
        //设置系统栏设置颜色
        //tintManager.setTintColor(R.color.red);
        //给状态栏设置颜色
        tintManager.setStatusBarTintResource(R.color.mask_tags_1);
        //Apply the specified drawable or color resource to the system navigation bar.
        //给导航栏设置资源
        tintManager.setNavigationBarTintResource(R.color.mask_tags_1);
    }
    public void showSnackBar(String message) {
        showSnackBar(message,"知道了",2000);
    }
    public void showSnackBar(String message,String action,int ms) {
        //去掉虚拟按键
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION //隐藏虚拟按键栏
                | View.SYSTEM_UI_FLAG_IMMERSIVE //防止点击屏幕时,隐藏虚拟按键栏又弹了出来
        );
        final Snackbar snackbar = Snackbar.make(getWindow().getDecorView(), message, Snackbar.LENGTH_INDEFINITE);
        snackbar.setCallback(new Snackbar.Callback() {
            @Override
            public void onDismissed(Snackbar snackbar, int event) {
                super.onDismissed(snackbar, event);
                // Snackbar关闭时回调
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
            }
            @Override
            public void onShown(Snackbar snackbar) {
                super.onShown(snackbar);
                // Snackbar打开时回调
            }
        });
        snackbar.setAction(action, new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                snackbar.dismiss();
                //隐藏SnackBar时记得恢复隐藏虚拟按键栏,不然屏幕底部会多出一块空白布局出来,和难看
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
            }

        });
        snackbar.show();
        new Handler().postDelayed(new TimerTask() {
            @Override
            public void run() {
                snackbar.dismiss();
                //隐藏SnackBar时记得恢复隐藏虚拟按键栏,不然屏幕底部会多出一块空白布局出来,和难看
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
            }
        },ms);

    }

}
