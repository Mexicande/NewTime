package cn.com.timemachine.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.com.timemachine.R;
import cn.com.timemachine.ui.base.BaseActivity;
import cn.com.timemachine.utils.ActivityUtils;
import cn.com.timemachine.view.supertextview.SuperTextView;

public class SettingActivity extends BaseActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.super_location)
    SuperTextView superLocation;
    @BindView(R.id.super_about)
    SuperTextView superAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tvTitle.setText(R.string.SettingTitle);
        setListener();

    }
    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar.titleBar(R.id.toolbar)
                .navigationBarColor(R.color.shape1)
                .init();
    }
    @Override
    protected int setLayoutId() {
        return R.layout.activity_setting;
    }

    private void setListener() {
        superLocation.setSwitchCheckedChangeListener(new SuperTextView.OnSwitchCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    //打开位置
                }else {
                    //关闭位置

                }
            }
        });
    }

    @OnClick({R.id.bt_back, R.id.super_location, R.id.super_about, R.id.super_quit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_back:
                finish();
                break;
        /*    case R.id.super_location:
                if(superLocation.getSwitchIsChecked()){
                    superLocation.setSwitchIsChecked(false);
                }else {
                    superLocation.setSwitchIsChecked(true);
                }
                break;*/
            case R.id.super_about:
                ActivityUtils.startActivity(AboutActivity.class);
                break;
            case R.id.super_quit:
                break;
            default:
                break;
        }
    }
}
