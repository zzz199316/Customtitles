# Customtitles

1.添加依赖

	
  allprojects {
    repositories {
       maven { url 'https://jitpack.io' }
	  }
  }
  
    dependencies {
	        implementation 'com.github.zzz199316:Customtitles:v1.0.1'
	  }
    
    2.使用
        1.自定义title，继承RelativeLayout
          <com.plgf.customtitle.CustomTitle xmlns:android="http://schemas.android.com/apk/res/android"
            xmlns:app="http://schemas.android.com/apk/res-auto"
            android:id="@+id/act_aboutus_title"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:clipToPadding="true"
            android:fitsSystemWindows="true"
            android:background="#e5e7ea"
            app:leftimg="@mipmap/back"
            app:titletext="关于我们"
            app:titletextbackground="@color/mask_tags_1"
            app:titletextcolor="#efefef"></com.plgf.customtitle.CustomTitle>
            
            支持左右点击事件，默认左点击事件为返回上一层
	    
	    //设置标题
	    public void setTitle(String title);

	    //设置标题颜色
	    public void setTitleColor(int titleColor)；

	    //设置标题字体大小
	    public void setTextSize(float textsize)；
	    //设置标题栏背景 ，支持颜色
	    public void setTitleBackgroud(int resourceId) ；

	    //设置左按钮，支持图片
	    public void setLeftBackgroud(int resourceId_left)；
	    //设置右按钮，支持图片
	    public void setRightBackgroud(int resourceId_right)；
	    //左点击事件
	    public void setLeftOnClickListen(OnClickListen onClickListen)；
	    //右图片点击事件
	    public void setRightOnClickListen(OnClickListen onClickListen)；

	    //右文点击事件，与右图片同时只能支持一个
	    public void setRightTvOnClickListen(OnClickListen onClickListen)；

	    //右文字设置，如果设置右文字点击，必须设置右文字
	    public void setRightTvText(String rightText)；
            
            
         2.自定义CustomActivity
           支持6.0权限请求    public void check(String[] needPermissions);
           支持沉浸式状态栏    public void setStatusBarColor(int res);
           支持snackbar显示   public void showSnackBar(String message);
           

  
  
  



    
