package cn.com.timemachine.view;

import android.content.Context;
import android.graphics.Color;
import android.view.View;


import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;

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
        OptionsPickerView pvOptions = new OptionsPickerBuilder(mContent, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                String tx = list.get(options1);
                superTextView.setCenterString(tx);
                superTextView.setCenterTextColor(mContent.getResources().getColor(R.color.text_black_color33));
            }
        })
                .setTitleText(title)
                .setTitleColor(Color.BLACK)
                //标题文字颜色
                //设置选中项文字颜色
                .setContentTextSize(20)
                .setSubmitColor(color)
                .setCancelColor(color)
                .build();
        pvOptions.setPicker(list);
        //一级选择器
        pvOptions.show();
    }

    public static void setRightPickerView(final SuperTextView superTextView, final List<String> list, final Context mContent, String title){
        int color = mContent.getResources().getColor(R.color.colorPrimary);
        OptionsPickerView pvOptions = new OptionsPickerBuilder(mContent, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                String tx = list.get(options1);
                superTextView.setRightString(tx);
                superTextView.setRightTextColor(mContent.getResources().getColor(R.color.text_black_color33));
            }
        })
                .setTitleText(title)
                .setTitleColor(Color.BLACK)
                //标题文字颜色
                //设置选中项文字颜色
                .setContentTextSize(20)
                .setSubmitColor(color)
                .setCancelColor(color)
                .build();
        pvOptions.setPicker(list);
        //一级选择器
        pvOptions.show();
    }

}
