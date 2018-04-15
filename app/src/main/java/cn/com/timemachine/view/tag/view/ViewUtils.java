package cn.com.timemachine.view.tag.view;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import cn.com.timemachine.R;


/**
 * Created by chenhao.ych on 2015/8/8.
 */
public class ViewUtils {
    public static View getTagLayout(Context context, String tagName, View.OnClickListener clickListener) {
        TextView tagBtn = (TextView) View.inflate(context, R.layout.tag_layout, null);
        tagBtn.setText(tagName);
        tagBtn.setTag(tagName);
        if (clickListener == null) {
            tagBtn.setClickable(false);
        } else {
            tagBtn.setOnClickListener(clickListener);
        }
        return tagBtn;
    }
}
