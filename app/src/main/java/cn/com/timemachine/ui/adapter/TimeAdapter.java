package cn.com.timemachine.ui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.com.timemachine.R;

/**
 *
 * @author apple
 * @date 2017/12/29
 */

public class TimeAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public TimeAdapter( List<String> data) {
        super(R.layout.time_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

        helper.setText(R.id.user_nick,item)
                .addOnClickListener(R.id.super_delect)
                .addOnClickListener(R.id.super_order);
    }


}
