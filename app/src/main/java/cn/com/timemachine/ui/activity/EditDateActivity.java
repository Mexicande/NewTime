package cn.com.timemachine.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cn.com.timemachine.R;
import cn.com.timemachine.ui.base.BaseActivity;

public class EditDateActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_edit_date;
    }
}
