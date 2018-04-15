package top.ovo.flide.fresco;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.view.View;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import top.ovo.flide.RequestMan;

/**
 * Created by caojianfeng on 30/03/2018.
 */

public class RequestManFrescoImpl extends RequestMan {

    public RequestManFrescoImpl(Object contextWith) {
        super(contextWith);
    }

    @Override
    public void init() {
        Context context = null;
        if (activitySoftReference != null) {
            context = activitySoftReference.get();
        }
        if (context == null && contextSoftReference != null) {
            context = contextSoftReference.get();
        }
        if (context == null) {
            throw new RuntimeException("null context");
        }
        Fresco.initialize(context);
        DiskCacheStrategy.init();
    }


    @Override
    public void into(View imageView) {
        if (imageView == null) {

            throw new RuntimeException("Null imageView");

        } else if (!(imageView instanceof SimpleDraweeView)) {

            throw new RuntimeException("Need SimpleDraweeView instance but '" +
                    imageView.getClass().getName() + "' recevied");

        }
        Context context = null;
        if (this.contextSoftReference != null) {
            context = this.contextSoftReference.get();
            if (context == null) {
                throw new RuntimeException("null context");
            }
        } else if (this.activitySoftReference != null) {
            Activity activity = activitySoftReference.get();
            if (activity != null && !activity.isFinishing()) {
                context = activity;
            }
        } else {
            throw new RuntimeException("need context");
        }

        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) imageView;


        if (this.thumbnail > 0) {
            ImageRequest request = ImageRequestBuilder.newBuilderWithSource(Uri.parse(url))
                    .setResizeOptions(new ResizeOptions(dip2px(context, 100), dip2px(context, 100)))
                    .build();

            DraweeController controller = Fresco.newDraweeControllerBuilder()
                    .setImageRequest(request)
                    .setOldController(simpleDraweeView.getController())
                    .setControllerListener(new ControllerListener<ImageInfo>() {
                        @Override
                        public void onSubmit(String id, Object callerContext) {

                        }

                        @Override
                        public void onFinalImageSet(String id, @Nullable ImageInfo imageInfo, @Nullable Animatable animatable) {

                        }

                        @Override
                        public void onIntermediateImageSet(String id, @Nullable ImageInfo imageInfo) {

                        }

                        @Override
                        public void onIntermediateImageFailed(String id, Throwable throwable) {

                        }

                        @Override
                        public void onFailure(String id, Throwable throwable) {

                        }

                        @Override
                        public void onRelease(String id) {

                        }
                    })
                    .build();
            simpleDraweeView.setController(controller);
        }

        if (this.centerCrop) {
            simpleDraweeView.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
            simpleDraweeView.getHierarchy().setPlaceholderImage(this.placeHolderResId, ScalingUtils.ScaleType.CENTER_CROP);
            simpleDraweeView.getHierarchy().setFailureImage(this.errorResId, ScalingUtils.ScaleType.CENTER_CROP);
        } else if (this.centerInside){
            simpleDraweeView.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_INSIDE);
            simpleDraweeView.getHierarchy().setPlaceholderImage(this.placeHolderResId, ScalingUtils.ScaleType.CENTER_INSIDE);
            simpleDraweeView.getHierarchy().setFailureImage(this.errorResId, ScalingUtils.ScaleType.CENTER_INSIDE);
        } else{
            simpleDraweeView.getHierarchy().setPlaceholderImage(this.placeHolderResId);
            simpleDraweeView.getHierarchy().setFailureImage(this.errorResId);
        }
        simpleDraweeView.setImageURI(url);
    }

    private int dip2px(Context context, int dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);

    }
}
