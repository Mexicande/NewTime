package cn.com.timemachine.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 2018/1/27.
 */

public class MyViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> list = new ArrayList<>();
    public MyViewPagerAdapter(FragmentManager fm, List<Fragment>list) {
        super(fm);
        this.list=list;
    }


    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}