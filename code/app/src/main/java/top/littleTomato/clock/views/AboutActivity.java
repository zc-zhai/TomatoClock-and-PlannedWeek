package top.littleTomato.clock.views;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import top.littleTomato.clock.R;
import top.littleTomato.clock.base.BaseActivity;
import top.littleTomato.clock.dagger.ActivityModule;
import top.littleTomato.clock.dagger.DaggerActivityComponent;
import top.littleTomato.clock.presenter.AboutHolder;
import top.littleTomato.clock.presenter.AboutPresenter;

public class AboutActivity extends BaseActivity implements AboutHolder.View {

    @Inject
    AboutPresenter mPresenter;

    @BindView(R.id.open_network)
    Button mOpenNetwork;
    @BindView(R.id.tv_version)
    TextView mTvVersion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mPresenter.bindView(this);
        mPresenter.onCreate(savedInstanceState);
    }

    @Override
    public void initializeInjector() {
        DaggerActivityComponent.builder().activityModule(new ActivityModule(this)).build().inject(this);
    }

    @Override
    public int getLayoutResID() {
        return R.layout.activity_about;
    }

    @OnClick(R.id.open_network)
    public void onClick() {
        mPresenter.openNetworkOnclick();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return mPresenter.onOptionsItemSelected(item);
    }

    @Override
    public void back() {
        finish();
    }

    @Override
    public void updateVersionView(String versionName) {
        mTvVersion.setText(versionName);
    }
}
