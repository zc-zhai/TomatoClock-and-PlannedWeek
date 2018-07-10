package top.littleTomato.clock.views;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import top.littleTomato.clock.R;
import top.littleTomato.clock.base.BaseActivity;
import top.littleTomato.clock.views.ClockView;

public class ClockActivity extends BaseActivity {

    ClockView clockView;
    TextView start_btn;

    private int clicked = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);
        clockView = (ClockView) findViewById(R.id.clockView);
        start_btn = (TextView) findViewById(R.id.tv_start);
        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicked++;
                if(clicked % 2 == 1) {
                    clockView.start();
                    start_btn.setText("放弃本次");
                }
                else
                {
                    clockView.abandon();
                    start_btn.setText("开始专注");
                }
            }
        });
    }

    @Override
    public int getLayoutResID() {
        return R.layout.activity_clock;
    }
}
