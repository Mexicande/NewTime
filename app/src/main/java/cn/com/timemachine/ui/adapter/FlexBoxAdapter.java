package cn.com.timemachine.ui.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.android.flexbox.AlignSelf;
import com.google.android.flexbox.FlexboxLayoutManager;

import java.util.List;

import cn.com.timemachine.R;
import cn.com.timemachine.view.supertextview.SuperButton;

/**
 * Created by apple on 2018/1/11.
 */

public class FlexBoxAdapter extends BaseQuickAdapter<String, BaseViewHolder> {



    public FlexBoxAdapter( @Nullable List<String> data) {
        super(R.layout.textview_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_flex, item);
        SuperButton view = helper.getView(R.id.tv_flex);
        ViewGroup.LayoutParams lp = view.getLayoutParams();
        if (lp instanceof FlexboxLayoutManager.LayoutParams) {
            FlexboxLayoutManager.LayoutParams flexboxLp =
                    (FlexboxLayoutManager.LayoutParams) view.getLayoutParams();
            flexboxLp.setFlexBasisPercent(0.5f);
            //flexboxLp.setAlignSelf(AlignSelf.FLEX_START);

        }

    }
}
