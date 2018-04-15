package cn.com.timemachine.ui.activity;

import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.com.timemachine.R;
import cn.com.timemachine.ui.base.BaseActivity;
import cn.com.timemachine.view.editext.PowerfulEditText;
import cn.com.timemachine.view.supertextview.SuperButton;

public class UpdatePWActivity extends BaseActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.et_PassWord)
    PowerfulEditText etPassWord;
    @BindView(R.id.et_confimPassWord)
    PowerfulEditText etConfimPassWord;
    @BindView(R.id.super_Button)
    SuperButton superButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        tvTitle.setText(getResources().getString(R.string.forget));
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_update_pw;
    }
}
