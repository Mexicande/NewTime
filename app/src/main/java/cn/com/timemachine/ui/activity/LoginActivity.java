package cn.com.timemachine.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.com.timemachine.R;
import cn.com.timemachine.ui.base.BaseActivity;
import cn.com.timemachine.view.editext.PowerfulEditText;
import cn.com.timemachine.view.supertextview.SuperButton;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.iv_logo)
    ImageView ivLogo;
    @BindView(R.id.tv_app)
    TextView tvApp;
    @BindView(R.id.et_name)
    PowerfulEditText etName;
    @BindView(R.id.et_PassWord)
    PowerfulEditText etPassWord;
    @BindView(R.id.super_Button)
    SuperButton superButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_login;
    }

    @OnClick({R.id.super_Button, R.id.tv_forget})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.super_Button:
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finish();
                break;
            case R.id.tv_forget:
                startActivity(new Intent(LoginActivity.this, UpdatePWActivity.class));
                finish();
                break;
            default:
                break;
        }
    }
}
