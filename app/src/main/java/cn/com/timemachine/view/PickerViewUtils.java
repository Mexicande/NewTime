package cn.com.timemachine.view;

import android.content.Context;
import android.graphics.Color;
import android.view.View;


import com.bigkoo.pickerview.OptionsPickerView;

import java.util.List;

import cn.com.timemachine.R;
import cn.com.timemachine.view.supertextview.SuperTextView;


/**
 *
 * @author apple
 * @date 2017/10/9
 */

public class PickerViewUtils {


    public static void setPickerView(final SuperTextView superTextView, final List<String> list, final Context mContent, String title){
        int color = mContent.getResources().getColor(R.color.colorPrimary);
        OptionsPickerView pvOptions = new OptionsPickerView.Builder(mContent, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                //返回的分别是三个级别的选中位置
                String tx = list.get(options1);
                superTextView.setCenterString(tx);
                superTextView.setCenterTextColor(mContent.getResources().getColor(R.color.text_black_color33));

            }
        })

                .setTitleText(title)
                .setTitleColor(color)//标题文字颜色

                .setDividerColor(color)
                .setTextColorCenter(Color.BLACK) //设置选中项文字颜色
                .setContentTextSize(20)
                .setSubmitColor(color)
                .setCancelColor(color)
                .build();
        pvOptions.setPicker(list);//一级选择器
        pvOptions.show();
    }
}
