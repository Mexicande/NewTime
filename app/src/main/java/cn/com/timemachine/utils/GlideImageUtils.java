package cn.com.timemachine.utils;

import android.app.Activity;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.lzy.imagepicker.loader.ImageLoader;

import java.io.File;

import cn.com.timemachine.R;

/**
 * ================================================
 * 作    者：jeasonlzy（廖子尧 Github地址：https://github.com/jeasonlzy0216
 * 版    本：1.0
 * 创建日期：2016/5/19
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class GlideImageUtils implements ImageLoader {

    @Override
    public void displayImage(Activity activity, String path, ImageView imageView, int width, int height) {
        RequestOptions requestOptions = new RequestOptions();
                requestOptions.centerCrop()
                        .error(R.drawable.ic_default_image)           //设置错误图片
                        .placeholder(R.drawable.ic_default_image)     //设置占位图片
                        .skipMemoryCache(true) // 跳过内存缓存
                        .diskCacheStrategy(DiskCacheStrategy.ALL); // 不缓存到SDCard中

        Glide.with(activity)                             //配置上下文
                .load(Uri.fromFile(new File(path)))//设置图片路径(fix #8,文件名包含%符号 无法识别和显示)
                .apply(requestOptions)
                .into(imageView);
    }

    @Override
    public void displayImagePreview(Activity activity, String path, ImageView imageView, int width, int height) {
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL); // 不缓存到SDCard中

        Glide.with(activity)                             //配置上下文
                .load(Uri.fromFile(new File(path)))      //设置图片路径(fix #8,文件名包含%符号 无法识别和显示)
                .apply(requestOptions)
                .into(imageView);
    }

    @Override
    public void clearMemoryCache() {
    }


    public void RidImagePreview(Activity activity, int id, ImageView imageView, int width, int height) {
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL); // 不缓存到SDCard中

        Glide.with(activity)                             //配置上下文
                .load(id)      //设置图片路径(fix #8,文件名包含%符号 无法识别和显示)
                .apply(requestOptions)
                .into(imageView);
    }
}
