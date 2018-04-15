package cn.com.timemachine.ui.activity.time;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.necer.ncalendar.calendar.NCalendar;
import com.necer.ncalendar.listener.OnCalendarChangedListener;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.com.timemachine.R;
import cn.com.timemachine.ui.base.BaseActivity;
import cn.com.timemachine.utils.Utils;
import cn.com.timemachine.view.PickerViewUtils;
import cn.com.timemachine.view.supertextview.SuperTextView;

/**
 * @author apple
 *         发布时光机
 */
public class ReleaseTimeActivity extends BaseActivity implements OnCalendarChangedListener {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.ncalendarrrr)
    NCalendar ncalendarrrr;
    @BindView(R.id.tv_date)
    TextView tvDate;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.bt_theme)
    SuperTextView btTheme;
    private List<String> themeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDate();
        setListener();
    }

    private void initDate() {
        String[] stringArray = getResources().getStringArray(R.array.theme);
        themeList = Arrays.asList(stringArray);
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar.titleBar(R.id.toolbar)
                .navigationBarColor(R.color.shape1)
                .init();
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_release_time;
    }

    private void setListener() {
        ncalendarrrr.post(new Runnable() {
            @Override
            public void run() {
                List<String> list = new ArrayList<>();
                list.add("2018-01-21");
                list.add("2017-12-16");
                list.add("2018-02-21");
                ncalendarrrr.setPoint(list);
            }
        });
        ncalendarrrr.setOnCalendarChangedListener(this);
    }

    @Override
    public void onCalendarChanged(DateTime dateTime) {
        tvDate.setText(Utils.getMonth(dateTime.getMonthOfYear()) + " " + dateTime.getYear());
    }

    @OnClick({R.id.bt_back, R.id.bt_theme})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_back:
                finish();
                break;
            case R.id.bt_theme:
                PickerViewUtils.setPickerView(btTheme, themeList, this, "婚姻状况");
                break;
            default:
                break;
        }
    }
}
