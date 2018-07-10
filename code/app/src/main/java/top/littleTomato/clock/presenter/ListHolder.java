package top.littleTomato.clock.presenter;

import android.content.Intent;
import android.os.Bundle;

import java.util.List;

import top.littleTomato.clock.base.BasePresenter;
import top.littleTomato.clock.base.BaseView;
import top.littleTomato.clock.entities.TaskDetailEntity;

public interface ListHolder {


    interface View extends BaseView {
        Intent intent();

        void updateToolbarTitle(String s);

        void showNoResults();

        void hideNoResults();

        void updateList(List<TaskDetailEntity> list);

        void startActivityAndForResult(Intent intent, int requestCode);

        void finishActivity();
    }

    interface Presenter extends BasePresenter {
        void onCreate(Bundle savedInstanceState);

        void onDestroy();

        void onItemClick(int position, TaskDetailEntity entity);
    }

}
