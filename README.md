# XLItem-常用的子项

详细内容博客地址:[自定义View-XLItem](http://www.fanandjiu.com/article/57ba19fd.html)

简介：

本来我用来作为自己自定义XLBottomView中的子项的。

app模块是使用例子，其运行效果：

![](https://android-1300729795.cos.ap-chengdu.myqcloud.com/project/Self_View/XLItem/XLItem.gif)

### 1. 添加依赖

Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:
~~~
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
~~~

Step 2. Add the dependency
~~~
dependencies {
   implementation 'com.github.xiaoshitounen:XLItem:1.0.4'
}
~~~

### 2. Xml文件中静态添加使用

~~~xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity"
    android:id="@+id/root">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        android:gravity="center"
        android:layout_alignParentBottom="true"
        android:background="@color/colorPrimary"
        >

        <swu.xl.item.XLItem
            android:layout_width="60dp"
            android:layout_height="60dp"
            android:layout_centerInParent="true"
            app:title="测试"
            />

        <swu.xl.item.XLItem
            android:layout_width="60dp"
            android:layout_height="60dp"
            android:layout_centerInParent="true"
            app:title="测试"

            />

        <swu.xl.item.XLItem
            android:layout_width="60dp"
            android:layout_height="60dp"
            android:layout_centerInParent="true"
            app:title="测试"
            />

    </LinearLayout>

</RelativeLayout>
~~~

#### ① 属性

- icon_id:图标
- title:标题
- normal_color:正常状态的颜色
- select_color:选中状态的颜色
- layout_id:布局文件的id，不自定义的话使用默认的

#### ② 页面样式

默认的页面样式是一个xml文件，你可以自己定义你想要的样式。

例子：
~~~xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="40dp"
    android:layout_height="60dp"
    android:orientation="vertical"
    android:gravity="center"
    >

    <ImageView
        android:id="@+id/icon"
        android:layout_width="40dp"
        android:layout_height="40dp"
        android:src="@drawable/ic_launcher_background"
        android:scaleType="fitXY"
        />

    <TextView
        android:id="@+id/title"
        android:layout_width="40dp"
        android:layout_height="20dp"
        android:text="测试"
        android:gravity="center"
        />


</LinearLayout>
~~~

#### ③ item状态的切换

~~~java
XLItem item = new XLItem(this, R.drawable.ic_launcher_background, "测试", 0, Color.BLACK, Color.MAGENTA, R.layout.item_layout);

//切换为选中状态
item.changeStatus(XLItem.STATUS_SELECT);

//切换为正常状态
item.changeStatus(XLItem.STATUS_NORMAL);
~~~


### 3. Java代码中动态添加

~~~java
XLItem item = new XLItem(this, R.drawable.ic_launcher_background, "测试", 0, Color.BLACK, Color.MAGENTA, R.layout.item_layout);
~~~
