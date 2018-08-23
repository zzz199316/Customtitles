# Customtitles

1.添加依赖

	
  allprojects {
    repositories {
       maven { url 'https://jitpack.io' }
	  }
  }
  
    dependencies {
	        implementation 'com.github.zzz199316:Customtitles:v1.0.0'
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
            
            
         2.自定义baseactivity
           支持6.0权限请求    public void check(String[] needPermissions);
           支持沉浸式状态栏    public void setStatusBarColor(int res);
           支持snackbar显示   public void showSnackBar(String message);
           

  
  
  



    
