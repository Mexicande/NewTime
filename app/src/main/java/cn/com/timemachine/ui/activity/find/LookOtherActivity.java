package cn.com.timemachine.ui.activity.find;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.necer.ncalendar.calendar.NCalendar;
import com.necer.ncalendar.listener.OnCalendarChangedListener;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.com.timemachine.R;
import cn.com.timemachine.ui.activity.time.ReleaseTimeActivity;
import cn.com.timemachine.ui.adapter.HomeAdapter;
import cn.com.timemachine.ui.adapter.TimeAdapter;
import cn.com.timemachine.ui.base.BaseActivity;
import cn.com.timemachine.ui.fragment.HomeFragment;
import cn.com.timemachine.utils.ActivityUtils;
import cn.com.timemachine.utils.Utils;
import cn.com.timemachine.view.supertextview.SuperTextView;

/**
 * @author apple
 *         查看
 */
public class LookOtherActivity extends BaseActivity implements OnCalendarChangedListener {

    @BindView(R.id.bt_back)
    TextView btBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_date)
    TextView tvDate;
    @BindView(R.id.bt_theme)
    SuperTextView btTheme;
    @BindView(R.id.time_recycler)
    RecyclerView timeRecycler;
    @BindView(R.id.ncalendarrrr)
    NCalendar ncalendarrrr;
    private HomeAdapter mHomeAdapter;
    List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
        setListener();
    }

    private void initView() {
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
        return R.layout.activity_look_other;
    }
    private void initData() {
        List<String> list=new ArrayList<>();
        list.add("Aname");
        list.add("Bname");
        list.add("Cname");
        list.add("Dname");
        list.add("Ename");
        list.add("Fname");
        mHomeAdapter=new HomeAdapter(null);
        timeRecycler.setLayoutManager(new LinearLayoutManager(this));
        timeRecycler.setAdapter(mHomeAdapter);
        mHomeAdapter.addData(list);

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
        ncalendarrrr.toWeek();

    }
    @Override
    public void onCalendarChanged(DateTime dateTime) {
        tvDate.setText(Utils.getMonth(dateTime.getMonthOfYear()) + " " + dateTime.getYear());
    }
}
