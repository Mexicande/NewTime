package cn.com.timemachine.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.com.timemachine.R;
import cn.com.timemachine.ui.base.BaseActivity;

public class EditInforActivity extends BaseActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tvTitle.setText(R.string.user_title);
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
        return R.layout.activity_edit_infor;
    }

    @OnClick({R.id.bt_back, R.id.tv_title})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_back:
                finish();
                break;
            default:
                break;
        }
    }
}
