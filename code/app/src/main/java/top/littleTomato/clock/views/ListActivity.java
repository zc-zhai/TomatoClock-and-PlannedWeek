package top.littleTomato.clock.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import top.littleTomato.clock.R;
import top.littleTomato.clock.adpter.ListAdapter;
import top.littleTomato.clock.base.BaseActivity;
import top.littleTomato.clock.dagger.ActivityModule;
import top.littleTomato.clock.dagger.DaggerActivityComponent;
import top.littleTomato.clock.entities.TaskDetailEntity;
import top.littleTomato.clock.presenter.ListHolder;
import top.littleTomato.clock.presenter.ListPresenter;

public class ListActivity extends BaseActivity implements ListHolder.View {


    @Inject
    ListAdapter mListAdapter;
    @Inject
    ListPresenter mPresenter;

    @BindView(R.id.rv_list)
    RecyclerView mList;
    @BindView(R.id.ll_no_results)
    View mNoResultsView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.bindView(this);
        mPresenter.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutResID() {
        return R.layout.activity_list;
    }

    @Override
    public void initializeInjector() {
        DaggerActivityComponent.builder().activityModule(new ActivityModule(this)).build().inject(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void initializeViews() {
        super.initializeViews();
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mListAdapter.setListener((position, entity) -> mPresenter.onItemClick(position, entity));
        mList.setLayoutManager(new LinearLayoutManager(this));
        mList.setAdapter(mListAdapter);
    }

    @Override
    public Intent intent() {
        return getIntent();
    }

    @Override
    public void updateToolbarTitle(String s) {
        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle(s);
    }

    @Override
    public void showNoResults() {
        mNoResultsView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideNoResults() {
        mNoResultsView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void updateList(List<TaskDetailEntity> list) {
        mListAdapter.setList(list);
    }

    @Override
    public void startActivityAndForResult(Intent intent, int requestCode) {
        startActivityForResult(intent, requestCode);
    }

    @Override
    public void finishActivity() {
        finish();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
        mListAdapter = null;
        mList = null;
        mPresenter = null;
    }
}
