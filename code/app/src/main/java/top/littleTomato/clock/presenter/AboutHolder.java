package top.littleTomato.clock.presenter;

import android.os.Bundle;
import android.view.MenuItem;

import top.littleTomato.clock.base.BasePresenter;
import top.littleTomato.clock.base.BaseView;

public interface AboutHolder {

    interface View extends BaseView {
        void back();

        void updateVersionView(String versionName);
    }

    interface Presenter extends BasePresenter {
        void openNetworkOnclick();

        boolean onOptionsItemSelected(MenuItem item);

        void onCreate(Bundle savedInstanceState);
    }

}
