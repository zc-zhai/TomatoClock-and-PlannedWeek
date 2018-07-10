package top.littleTomato.clock.views;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import top.littleTomato.clock.R;
import top.littleTomato.clock.adpter.MainPageAdapter;
import top.littleTomato.clock.base.BaseActivity;
import top.littleTomato.clock.dagger.ActivityModule;
import top.littleTomato.clock.dagger.DaggerActivityComponent;
import top.littleTomato.clock.entities.TaskDetailEntity;
import top.littleTomato.clock.entities.TaskState;
import top.littleTomato.clock.fragments.PageFragment;
import top.littleTomato.clock.presenter.MainHolder;
import top.littleTomato.clock.presenter.MainPresenter;
import top.littleTomato.clock.utils.SnackBarUtils;

public class MainActivity extends BaseActivity implements PageFragment.OnPageFragmentInteractionListener, MainHolder.View {

    public static final String TAG = "MainActivity";
    @BindView(R.id.tab)
    TabLayout mTab;
    @BindView(R.id.vp)
    ViewPager mVp;
    @BindView(R.id.cl_main)
    CoordinatorLayout mClMain;
    @Inject
    MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.bindView(this);
        mPresenter.onCreate(savedInstanceState);
    }

    @Override
    protected void initializeViews() {
        super.initializeViews();
        mTab.setupWithViewPager(mVp);
    }

    @Override
    public int getLayoutResID() {
        return R.layout.activity_main;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mPresenter.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }

    @OnClick({R.id.fab,R.id.fab1})
    public void onClick(View v) {
        if(v.getId()==R.id.fab){
        mPresenter.onFabClick();}
        else
        { mPresenter.onFabClick1();}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(true);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return mPresenter.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mPresenter.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onListTaskItemClick(int position, TaskDetailEntity entity) {
        mPresenter.onListTaskItemClick(position, entity);
    }


    @Override
    public void onListTaskItemLongClick(final int position, final TaskDetailEntity entity) {
        mPresenter.onListTaskItemLongClick(position, entity);
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
    }


    @Override
    public void initializeInjector() {
        DaggerActivityComponent.builder().activityModule(new ActivityModule(this)).build().inject(this);
    }

    @Override
    public int getCurrentViewPagerItem() {
        return mVp.getCurrentItem();
    }

    @Override
    public void startActivityAndForResult(Intent intent, int newActivityRequestCode) {
        startActivityForResult(intent, newActivityRequestCode);
    }

    @Override
    public void finishActivity() {
        finish();
    }

    @Override
    public void setViewPagerAdapter(MainPageAdapter adapter) {
        mVp.setAdapter(adapter);
    }

    @Override
    public Intent getActivityIntent() {
        return getIntent();
    }

    @Override
    public void setViewPagerCurrentItem(int currIndex, boolean b) {
        mVp.setCurrentItem(currIndex, b);
    }

    @Override
    public void showAction(String message, String action, View.OnClickListener listener) {
        SnackBarUtils.showAction(mClMain, message, action, listener);
    }

    @Override
    public void showDialog(int position, TaskDetailEntity entity) {

        BottomSheetDialog bottomSheetDialog = new FixedBottomSheetDialog(this);
        View view = getLayoutInflater().inflate(R.layout.dl_task_item_menu, mClMain, false);

        TextView tvFlagText = (TextView) view.findViewById(R.id.tv_flag_task);

        if (entity.getState() != TaskState.FINISHED) {
            tvFlagText.setText("标记为已完成");
        } else {
            tvFlagText.setText("标记为未完成");
        }

        view.findViewById(R.id.ll_action_flag_task).setOnClickListener(v -> {
            bottomSheetDialog.dismiss();
            mPresenter.dialogActionFlagTask(position, entity);
        });


        view.findViewById(R.id.ll_action_edit).setOnClickListener(v -> {
            bottomSheetDialog.dismiss();
            mPresenter.dialogActionEditTask(position, entity);
        });

        view.findViewById(R.id.ll_action_delete).setOnClickListener(v -> {
            bottomSheetDialog.dismiss();
            mPresenter.dialogActionDeleteTask(position, entity);
        });

        view.findViewById(R.id.ll_action_put_off).setOnClickListener(v -> {
            bottomSheetDialog.dismiss();
            mPresenter.dialogActionPutOffTask(position, entity);

        });

        bottomSheetDialog.setContentView(view);
        bottomSheetDialog.setOwnerActivity(this);
        bottomSheetDialog.show();
    }
}
