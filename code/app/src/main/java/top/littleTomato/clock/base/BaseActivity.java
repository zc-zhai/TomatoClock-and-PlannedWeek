package top.littleTomato.clock.base;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import top.littleTomato.clock.R;
import top.littleTomato.clock.dagger.Injectable;



public abstract class BaseActivity extends AppCompatActivity implements BaseView, Injectable {

    @BindView(R.id.toolbar)
    protected Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResID());
        ButterKnife.bind(this);
        initializeInjector();   // 在 initializeViews() 可能会用到依赖注入的属性
        initializeViews();
    }

    @CallSuper
    protected void initializeViews() {
        setSupportActionBar(mToolbar);
    }


    @Override
    public void initializeInjector() {

    }
}
