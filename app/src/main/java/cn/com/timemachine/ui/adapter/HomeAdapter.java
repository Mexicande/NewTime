package cn.com.timemachine.ui.adapter;

import android.support.annotation.Nullable;
import android.text.Layout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.com.timemachine.R;

/**
 *
 * @author apple
 * @date 2017/12/29
 * 发现
 */

public class HomeAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public HomeAdapter( List<String> data) {
        super(R.layout.home_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.user_nick,item);
    }


}
