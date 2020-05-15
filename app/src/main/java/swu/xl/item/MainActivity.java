package swu.xl.item;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        XLItem item = new XLItem(this, R.drawable.ic_launcher_background, "测试", 0, Color.BLACK, Color.MAGENTA, R.layout.item_layout);

        RelativeLayout layout = findViewById(R.id.root);
        layout.addView(item);
    }
}
