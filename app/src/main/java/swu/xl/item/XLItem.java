package swu.xl.item;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class XLItem extends LinearLayout {
    //资源
    private int icon_id = R.drawable.ic_launcher_background;
    //文本
    private String title = "测试";

    //正常状态的颜色
    private int normal_color = Color.BLACK;
    private int select_color = Color.MAGENTA;

    //记录自身的索引
    private int item_index = 0;

    //布局id
    private int layout_id = R.layout.item_layout;

    //显示icon的视图
    private ImageView icon_view;
    //显示title的视图
    private TextView title_view;

    //按钮的状态-正常
    public static final int STATUS_NORMAL = 0;
    //按钮的状态-选中
    public static final int STATUS_SELECT = 1;

    /**
     * 构造方法：Java代码初始化
     * @param context
     */
    public XLItem(Context context, int icon_id, String title, int item_index, int normal_color, int select_color, int layout_id) {
        super(context);

        this.icon_id = icon_id;
        this.title = title;
        this.item_index = item_index;
        this.normal_color = normal_color;
        this.select_color = select_color;
        if (layout_id != 0){
            this.layout_id = layout_id;
        }

        //初始化操作
        init();
    }

    /**
     * 构造方法：Xml代码初始化
     * @param context
     * @param attrs
     */
    public XLItem(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        //1.获得所有属性值的集合
        if (attrs != null){
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.XLItem);
            //2.解析属性
            icon_id = typedArray.getResourceId(R.styleable.XLItem_icon_id,icon_id);
            title = typedArray.getString(R.styleable.XLItem_title);
            normal_color = typedArray.getColor(R.styleable.XLItem_normal_color,normal_color);
            select_color = typedArray.getColor(R.styleable.XLItem_select_color,select_color);
            layout_id = typedArray.getResourceId(R.styleable.XLItem_layout_id,layout_id);

            //3.释放资源
            typedArray.recycle();
        }

        //初始化操作
        init();
    }

    /**
     * 改变状态
     * @param status
     */
    public void changeStatus(int status){
        //判断状态
        if (status == STATUS_NORMAL){
            icon_view.setColorFilter(normal_color);
            title_view.setTextColor(normal_color);
        }else {
            icon_view.setColorFilter(select_color);
            title_view.setTextColor(select_color);
        }
    }

    /**
     * 初始化操作
     */
    private void init() {
        //找到控件
        LinearLayout layout = (LinearLayout) LayoutInflater.from(getContext()).inflate(layout_id,this);
        icon_view = layout.findViewById(R.id.icon);
        title_view = layout.findViewById(R.id.title);

        //设置数据
        icon_view.setImageResource(icon_id);
        title_view.setText(title);

        //改为选中状态
        changeStatus(STATUS_NORMAL);

        setBackgroundColor(Color.TRANSPARENT);
    }

    /**
     * 测量
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec,heightMeasureSpec);

        //获得此ViewGroup上级容器为其推荐的宽和高，以及计算模式
        int widthMode = MeasureSpec. getMode(widthMeasureSpec);
        int heightMode = MeasureSpec. getMode(heightMeasureSpec);
        int sizeWidth = MeasureSpec. getSize(widthMeasureSpec);
        int sizeHeight = MeasureSpec. getSize(heightMeasureSpec);
        int layoutWidth = 0;
        int layoutHeight = 0;
        // 计算出所有的childView的宽和高
        measureChildren(widthMeasureSpec, heightMeasureSpec);

        int cWidth = 0;
        int cHeight = 0;
        int count = getChildCount();

        if(widthMode == MeasureSpec. EXACTLY){
            //如果布局容器的宽度模式是确定的（具体的size或者match_parent），直接使用父窗体建议的宽度
            layoutWidth = sizeWidth;
        } else{
            //如果是未指定或者wrap_content，我们都按照包裹内容做，宽度方向上只需要拿到所有子控件中宽度做大的作为布局宽度
            for ( int i = 0; i < count; i++)  {
                View child = getChildAt(i);
                cWidth = child.getMeasuredWidth();
                //获取子控件最大宽度
                layoutWidth = cWidth > layoutWidth ? cWidth : layoutWidth;
            }
        }
        //高度很宽度处理思想一样
        if(heightMode == MeasureSpec. EXACTLY){
            layoutHeight = sizeHeight;
        } else{
            for ( int i = 0; i < count; i++)  {
                View child = getChildAt(i);
                cHeight = child.getMeasuredHeight();
                layoutHeight = cHeight > layoutHeight ? cHeight : layoutHeight;
            }
        }

        // 测量并保存layout的宽高
        setMeasuredDimension(layoutWidth, layoutHeight);
    }

    //set，get方法
    public int getIcon_id() {
        return icon_id;
    }

    public void setIcon_id(int icon_id) {
        this.icon_id = icon_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNormal_color() {
        return normal_color;
    }

    public void setNormal_color(int normal_color) {
        this.normal_color = normal_color;
    }

    public int getSelect_color() {
        return select_color;
    }

    public void setSelect_color(int select_color) {
        this.select_color = select_color;
    }

    public int getItem_index() {
        return item_index;
    }

    public void setItem_index(int item_index) {
        this.item_index = item_index;
    }

    public int getLayout_id() {
        return layout_id;
    }

    public void setLayout_id(int layout_id) {
        this.layout_id = layout_id;
    }
}
