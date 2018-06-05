package cn.com.timemachine.ui.activity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.CustomListener;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.bigkoo.pickerview.view.TimePickerView;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.com.timemachine.R;
import cn.com.timemachine.model.CityEntityBean;
import cn.com.timemachine.ui.base.BaseActivity;
import cn.com.timemachine.utils.GetJsonDataUtil;
import cn.com.timemachine.view.PickerViewUtils;
import cn.com.timemachine.view.supertextview.SuperTextView;

public class EditInforActivity extends BaseActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.bt_back)
    TextView btBack;
    @BindView(R.id.bt_header)
    SuperTextView btHeader;
    @BindView(R.id.bt_nick)
    SuperTextView btNick;
    @BindView(R.id.bt_name)
    SuperTextView btName;
    @BindView(R.id.bt_sex)
    SuperTextView btSex;
    @BindView(R.id.bt_birthday)
    SuperTextView btBirthday;
    @BindView(R.id.bt_city)
    SuperTextView btCity;
    private List<String>sexList;
    private List<CityEntityBean> options1Items = new ArrayList<>();
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<String>>> options3Items = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tvTitle.setText(R.string.user_title);
        String[] sexArray = getResources().getStringArray(R.array.sex);
        sexList = Arrays.asList(sexArray);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                // 写子线程中的操作,解析省市区数据
                initJsonData();
            }
        });
        thread.start();    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar.titleBar(R.id.toolbar)
                .navigationBarColor(R.color.shape1)
                .init();
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_edit_infor;
    }


    @OnClick({R.id.bt_back,R.id.bt_header, R.id.bt_sex, R.id.bt_birthday, R.id.bt_city,
            R.id.bt_educational, R.id.occupational, R.id.bt_label, R.id.bt_desc})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_back:
                finish();
                break;
            case R.id.bt_header:
                break;
            case R.id.bt_sex:
                PickerViewUtils.setPickerView(btSex,sexList,this,"性别");
                break;
            case R.id.bt_birthday:
                pvOptions();
                break;
            case R.id.bt_city:
                showPickerView();
                break;
            case R.id.bt_educational:
                break;
            case R.id.occupational:
                break;
            case R.id.bt_label:
                break;
            case R.id.bt_desc:
                break;
            default:
                break;
        }
    }


    /**
     * 性别条件选择器
     */
    private  void  pvOptions(){

        TimePickerView pvTime = new TimePickerBuilder(this, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                btBirthday.setRightString(getTime(date));
            }
        })
                .setCancelColor(getResources().getColor(R.color.colorPrimary))
                .setSubmitColor(getResources().getColor(R.color.colorPrimary))
                .setTitleBgColor(getResources().getColor(R.color.white))
                //标题背景颜色 Night mode
                //.setTitleColor(getResources().getColor(R.color.white))
                .setSubmitColor(Color.BLACK)
                //确定按钮文字颜色
                .setCancelColor(Color.BLACK)
                //取消按钮文字颜色
                //标题文字颜色
                .setSubCalSize(17)
                //确定和取消文字大小
                //.isDialog(true)
                //是否显示为对话框样式
                .build();
        pvTime.show();
    }
    private String getTime(Date date) {
        //可根据需要自行截取数据显示
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    private void showPickerView() {// 弹出选择器

        OptionsPickerView pvOptions = new OptionsPickerBuilder(this, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                //返回的分别是三个级别的选中位置
                String tx = options1Items.get(options1).getPickerViewText() +
                        options2Items.get(options1).get(options2) +
                        options3Items.get(options1).get(options2).get(options3);
                btCity.setRightString(tx);


            }
        })

                .setTitleText("城市选择")
                .setCancelColor(getResources().getColor(R.color.colorPrimary))
                .setSubmitColor(getResources().getColor(R.color.colorPrimary))
                .setDividerColor(Color.BLACK)
                .setTextColorCenter(Color.BLACK)
                //设置选中项文字颜色
                .setContentTextSize(20)
                .build();

        pvOptions.setPicker(options1Items, options2Items, options3Items);
        //三级选择器
        pvOptions.show();
    }



    /**
     * 添加省份数据
     *
     * 注意：如果是添加的JavaBean实体，则实体类需要实现 IPickerViewData 接口，
     * PickerView会通过getPickerViewText方法获取字符串显示出来。
     */
    private void initJsonData() {//解析数据
        String jsondata = new GetJsonDataUtil().getJson(this);

        List<CityEntityBean> jsonBean = parseData(jsondata);
        options1Items = jsonBean;


        for (int i=0;i<jsonBean.size();i++){
            //遍历省份
            ArrayList<String> citylist = new ArrayList<>();
            //该省的城市列表（第二级）
            ArrayList<ArrayList<String>> provinceArealist = new ArrayList<>();
            //该省的所有地区列表（第三极）

            for (int c=0; c<jsonBean.get(i).getCity().size(); c++){
                //遍历该省份的所有城市
                String cityname = jsonBean.get(i).getCity().get(c).getName();
                citylist.add(cityname);
                //添加城市

                ArrayList<String> arrayList = new ArrayList<>();
                //该城市的所有地区列表

                //如果无地区数据，建议添加空字符串，防止数据为null 导致三个选项长度不匹配造成崩溃
                if (jsonBean.get(i).getCity().get(c).getArea() == null
                        ||jsonBean.get(i).getCity().get(c).getArea().size()==0) {
                    arrayList.add("");
                }else {

                    //该城市对应地区所有数据
                    //添加该城市所有地区数据
                    arrayList.addAll(jsonBean.get(i).getCity().get(c).getArea());


                }
                provinceArealist.add(arrayList);
                //添加该省所有地区数据
            }


            options2Items.add(citylist);



            options3Items.add(provinceArealist);
        }


    }



    public ArrayList<CityEntityBean> parseData(String result) {//Gson 解析

        ArrayList<CityEntityBean> detail = new ArrayList<>();
        try {
            JSONArray data = new JSONArray(result);
            Gson gson = new Gson();
            for (int i = 0; i < data.length(); i++) {
                CityEntityBean entity = gson.fromJson(data.optJSONObject(i).toString(), CityEntityBean.class);
                detail.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return detail;
    }

}
