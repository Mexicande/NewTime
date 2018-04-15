package cn.com.timemachine.ui.activity;

import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import cn.com.timemachine.R;
import cn.com.timemachine.ui.base.BaseActivity;

public class FindPwActivity extends BaseActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            tvTitle.setText(R.string.forget);
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
        return R.layout.activity_find_pw;
    }
}
