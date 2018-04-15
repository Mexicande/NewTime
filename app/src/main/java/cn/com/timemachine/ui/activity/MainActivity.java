package cn.com.timemachine.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.com.timemachine.R;
import cn.com.timemachine.other.MyViewPagerAdapter;
import cn.com.timemachine.other.NoTouchViewPager;
import cn.com.timemachine.other.NormalItemView;
import cn.com.timemachine.other.TestRepeatTab;
import cn.com.timemachine.ui.base.BaseActivity;
import cn.com.timemachine.ui.fragment.FindFragment;
import cn.com.timemachine.ui.fragment.MyFragment;
import cn.com.timemachine.ui.fragment.TimeFragment;
import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.PageNavigationView;
import me.majiajie.pagerbottomtabstrip.item.BaseTabItem;


public class MainActivity extends BaseActivity {


    @BindView(R.id.viewPager)
    NoTouchViewPager viewPager;
    @BindView(R.id.tab)
    PageNavigationView tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initImmersionBar();
        initView();


    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }


    private void initView() {
        NavigationController navigationController = tab.custom()
                .addItem(newItem(R.mipmap.icon_find, R.mipmap.icon_find_selected, "发现"))
                .addItem(newItem(R.mipmap.icon_time_default, R.mipmap.icon_time_selected, "时光"))
                .addItem(newItem(R.mipmap.icon_my, R.mipmap.icon_my_selected, "我"))
                .build();
        List<Fragment>list=new ArrayList<>();
        list.add(new FindFragment());
        list.add(new TimeFragment());
        list.add(new MyFragment());

        viewPager.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager(), list));

        //自动适配ViewPager页面切换
        navigationController.setupWithViewPager(viewPager);

    }

    //创建一个Item
    private BaseTabItem newItem(int drawable, int checkedDrawable, String text) {
        NormalItemView onlyIconItemView = new NormalItemView(this);
        onlyIconItemView.initialize(drawable, checkedDrawable, text);
        onlyIconItemView.setTextDefaultColor(Color.parseColor("#666666"));
        onlyIconItemView.setTextCheckedColor(Color.parseColor("#009EFD"));
        return onlyIconItemView;
    }

    //创建一个Item(测试重复点击的方法)
    private BaseTabItem newItem_test(int drawable, int checkedDrawable) {
        TestRepeatTab testRepeatTab = new TestRepeatTab(this);
        testRepeatTab.initialize(drawable, checkedDrawable);
        return testRepeatTab;
    }

 /*   @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.titleBar(R.id.toolbar)
                .navigationBarColor(R.color.shape1)
                .init();
    }*/

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(1000==requestCode){
            Log.i("Activity","11111");
        }
    }
}
