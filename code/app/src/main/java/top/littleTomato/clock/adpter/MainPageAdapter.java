package top.littleTomato.clock.adpter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import javax.inject.Inject;

import top.littleTomato.clock.entities.MainPageItem;



public class MainPageAdapter extends FragmentPagerAdapter {

    private List<MainPageItem> mPageItems;

    @Inject
    public MainPageAdapter(FragmentManager fm, List<MainPageItem> pageItems) {
        super(fm);
        mPageItems = pageItems;
    }

    @Override
    public Fragment getItem(int position) {
        return mPageItems.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return mPageItems.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mPageItems.get(position).getTitle();
    }
}
