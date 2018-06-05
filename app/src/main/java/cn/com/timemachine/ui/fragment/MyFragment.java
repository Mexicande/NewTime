package cn.com.timemachine.ui.fragment;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.github.siyamed.shapeimageview.CircularImageView;
import com.lzy.imagepicker.ImagePicker;
import com.lzy.imagepicker.bean.ImageItem;
import com.lzy.imagepicker.ui.ImageGridActivity;
import com.lzy.imagepicker.view.CropImageView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.com.timemachine.R;
import cn.com.timemachine.ui.activity.AboutActivity;
import cn.com.timemachine.ui.activity.EditInforActivity;
import cn.com.timemachine.ui.activity.LoginActivity;
import cn.com.timemachine.ui.activity.SettingActivity;
import cn.com.timemachine.ui.activity.center.CoachApproveActivity;
import cn.com.timemachine.ui.base.BaseLazyFragment;
import cn.com.timemachine.utils.ActivityUtils;
import cn.com.timemachine.utils.GlideImageUtils;
import jp.wasabeef.glide.transformations.BlurTransformation;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends BaseLazyFragment {
    Unbinder unbinder;
    @BindView(R.id.bv_dynamic_blur)
    ImageView bvDynamicBlur;
    @BindView(R.id.circularImage)
    CircularImageView circularImage;


    private int initLevel;
    ArrayList<ImageItem> images = null;
    GlideImageUtils glideImageUtils;
    private ImagePicker imagePicker;


    public MyFragment() {
        // Required empty public constructor
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    protected boolean isLazyLoad() {
        return true;
    }

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_my;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        Glide.with(this).load(R.mipmap.header)
                .apply(bitmapTransform(new BlurTransformation(1)))
                .into(bvDynamicBlur);

        if (glideImageUtils != null && images.size() != 0) {
            Glide.with(this).load(images.get(0).path)
                    .apply(bitmapTransform(new BlurTransformation(25)))
                    .into(bvDynamicBlur);
            glideImageUtils.displayImagePreview(getActivity(), images.get(0).path, circularImage, 0, 0);
        }
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    private void pickFromGallery() {
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            requestPermission(Manifest.permission.READ_EXTERNAL_STORAGE,
                    getString(R.string.permission_read_storage_rationale),
                    REQUEST_STORAGE_READ_ACCESS_PERMISSION);
        } else {
            prickerImage();
        }
    }

    private void prickerImage() {
        imagePicker = ImagePicker.getInstance();
        imagePicker.setImageLoader(new GlideImageUtils());
        imagePicker.setMultiMode(false);
        imagePicker.setStyle(CropImageView.Style.RECTANGLE);
        Integer width = Integer.valueOf("200");
        Integer height = Integer.valueOf("200");
        width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, width, getResources().getDisplayMetrics());
        height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, height, getResources().getDisplayMetrics());
        imagePicker.setFocusWidth(width);
        imagePicker.setFocusHeight(height);
        imagePicker.setShowCamera(true);
        imagePicker.setCrop(true);
        imagePicker.setSaveRectangle(true);
        imagePicker.setSelectLimit(1);

        imagePicker.setOutPutX(Integer.valueOf("800"));
        imagePicker.setOutPutY(Integer.valueOf("800"));
        Intent intent = new Intent(getActivity(), ImageGridActivity.class);
        intent.putExtra(ImageGridActivity.EXTRAS_IMAGES, images);
        //ImagePicker.getInstance().setSelectedImages(images);
        startActivityForResult(intent, 100);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_STORAGE_READ_ACCESS_PERMISSION:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    pickFromGallery();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == ImagePicker.RESULT_CODE_ITEMS) {
            if (data != null && requestCode == 100) {
                images = (ArrayList<ImageItem>) data.getSerializableExtra(ImagePicker.EXTRA_RESULT_ITEMS);
                glideImageUtils = new GlideImageUtils();
                Glide.with(this).load(images.get(0).path)
                        .apply(bitmapTransform(new BlurTransformation(25)))
                        .into(bvDynamicBlur);
                glideImageUtils.displayImagePreview(getActivity(), images.get(0).path, circularImage, 0, 0);
            } else {
                Toast.makeText(getActivity(), "没有数据", Toast.LENGTH_SHORT).show();
            }
        }
    }


    @OnClick({R.id.super_infor, R.id.super_attention, R.id.super_fans,
            R.id.super_setting,R.id.circularImage,R.id.super_coach})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.super_infor:
                ActivityUtils.startActivity(EditInforActivity.class);
                break;
            case R.id.super_attention:
                ActivityUtils.startActivity(LoginActivity.class);
                break;
            case R.id.super_fans:
                break;
            case R.id.super_setting:
                ActivityUtils.startActivity(SettingActivity.class);
                break;
            case R.id.circularImage:
                pickFromGallery();
                break;
            case R.id.super_coach:
                ActivityUtils.startActivity(CoachApproveActivity.class);

                break;
            default:
                break;
        }
    }
}
