package top.littleTomato.clock.presenter;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import top.littleTomato.clock.adpter.MainPageAdapter;
import top.littleTomato.clock.base.BasePresenter;
import top.littleTomato.clock.base.BaseView;
import top.littleTomato.clock.entities.TaskDetailEntity;

public interface MainHolder {

    interface View extends BaseView {

        int getCurrentViewPagerItem();

        void startActivityAndForResult(Intent intent, int newActivityRequestCode);

        void finishActivity();

        void setViewPagerAdapter(MainPageAdapter adapter);

        Intent getActivityIntent();

        void setViewPagerCurrentItem(int currIndex, boolean b);

        void showAction(String message, String action, android.view.View.OnClickListener listener);

        void showDialog(int position, TaskDetailEntity entity);

    }

    interface Presenter extends BasePresenter {
        void onBackPressed();

        void onFabClick();
        void onFabClick1();

        boolean onOptionsItemSelected(MenuItem item);

        void onCreate(Bundle savedInstanceState);

        void onDestroy();

        void onActivityResult(int requestCode, int resultCode, Intent data);

        void onListTaskItemLongClick(int position, TaskDetailEntity entity);

        void dialogActionFlagTask(int position, TaskDetailEntity entity);

        void onListTaskItemClick(int position, TaskDetailEntity entity);

        void dialogActionEditTask(int position, TaskDetailEntity entity);

        void dialogActionDeleteTask(int position, TaskDetailEntity entity);

        void dialogActionPutOffTask(int position, TaskDetailEntity entity);
    }
}
