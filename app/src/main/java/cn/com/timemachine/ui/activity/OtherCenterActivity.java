package cn.com.timemachine.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.siyamed.shapeimageview.CircularImageView;
import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.com.timemachine.R;
import cn.com.timemachine.ui.adapter.FlexBoxAdapter;
import cn.com.timemachine.view.tag.view.AutoWrapLineLayout;
import cn.com.timemachine.view.tag.view.ViewUtils;

public class OtherCenterActivity extends AppCompatActivity {

    @BindView(R.id.bv_dynamic_blur)
    ImageView bvDynamicBlur;
    @BindView(R.id.circularImage)
    CircularImageView circularImage;
    @BindView(R.id.tv_nick)
    TextView tvNick;
    @BindView(R.id.tv_schoolName)
    TextView tvSchoolName;
    FlexBoxAdapter mFlexBoxAdapter;
    @BindView(R.id.usual_tags_container)
    AutoWrapLineLayout usualTagsContainer;
    private ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_center);
        ButterKnife.bind(this);
        initDate();
        initView();
    }

    private void initView() {
      /*  FlexboxLayoutManager manager = new FlexboxLayoutManager();
        //设置主轴排列方式
        //设置是否换行
        manager.setFlexWrap(FlexWrap.WRAP);
        manager.setFlexDirection(FlexDirection.ROW);
        manager.setJustifyContent(JustifyContent.FLEX_START);
        manager.setAlignItems(AlignItems.STRETCH);
        ivRecycler.setLayoutManager(manager);
        mFlexBoxAdapter = new FlexBoxAdapter(list);
        ivRecycler.setAdapter(mFlexBoxAdapter);*/
        usualTagsContainer.removeAllViews();
        for(final String text : list){
            usualTagsContainer.addView(ViewUtils.getTagLayout(this, text, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //mTagEditText.commitUsualTag(text);
                }
            }));
        }
    }

    private void initDate() {
        list = new ArrayList<>();
        list.add("Aname");
        list.add("Bname");
        list.add("Cname");
        list.add("Dname");
        list.add("Ename");
        list.add("Fname");
        list.add("Gname");
        list.add("Hname");
        list.add("Iname");
    }
}
