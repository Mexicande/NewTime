package cn.com.timemachine.ui.adapter;

import android.support.annotation.Nullable;
import android.text.Layout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.com.timemachine.R;

/**
 * Created by apple on 2017/12/29.
 */

public class HomeAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public HomeAdapter(int layout, List<String> data) {
        super(layout, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

        helper.setText(R.id.user_nick,item);
    }


}
