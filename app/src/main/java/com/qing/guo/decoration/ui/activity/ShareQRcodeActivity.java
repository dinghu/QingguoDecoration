package com.qing.guo.decoration.ui.activity;

import android.Manifest;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.blankj.utilcode.util.ToastUtils;
import com.fkh.support.ui.activity.BaseActivity;
import com.fkh.support.ui.widget.TitleView;
import com.google.zxing.client.android.utils.ZXingUtils;
import com.qing.guo.decoration.R;
import com.qing.guo.decoration.utils.ImageUtils;
import com.tencent.mm.sdk.modelmsg.SendMessageToWX;
import com.tencent.mm.sdk.modelmsg.WXImageObject;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.co.namee.permissiongen.PermissionFail;
import kr.co.namee.permissiongen.PermissionGen;
import kr.co.namee.permissiongen.PermissionSuccess;
import me.shaohui.shareutil.ShareUtil;
import me.shaohui.shareutil.share.ShareListener;
import me.shaohui.shareutil.share.SharePlatform;
import me.shaohui.shareutil.share.instance.WxShareInstance;

/**
 * Created by dinghu on 2019/7/22.
 */
public class ShareQRcodeActivity extends BaseActivity {

    boolean isSetCode = false;
    @BindView(R.id.titleView)
    TitleView title;
    @BindView(R.id.qrcode)
    ImageView qrcode;
    @BindView(R.id.btnShare)
    ImageView btnShare;
    @BindView(R.id.shareView)
    View shareView;

    private String shareAskJoinfilePath;

    @Override
    protected int getLayout() {
        return R.layout.activity_share_app;
    }

    private static final int THUMB_SIZE = 150;
    /**
     * 分享单张图片到微信好友
     *
     * @param context context
     *                //     * @param picFile 要分享的图片文件
     */
    public void sharePictureToWechat(Context context, Bitmap bmp,boolean isTimelineCb) {

        //初始化 WXImageObject 和 WXMediaMessage 对象
        WXImageObject imgObj = new WXImageObject(bmp);
        WXMediaMessage msg = new WXMediaMessage();
        msg.mediaObject = imgObj;

        //设置缩略图
        Bitmap thumbBmp = Bitmap.createScaledBitmap(bmp, THUMB_SIZE, THUMB_SIZE, true);
        bmp.recycle();
        msg.thumbData = bmpToByteArray(thumbBmp, true);
        //构造一个Req
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = buildTransaction("img");
        req.message = msg;
//        req.scene = mTargetScene;
        req.scene = isTimelineCb ? SendMessageToWX.Req.WXSceneTimeline
                : SendMessageToWX.Req.WXSceneSession;
        //        req.userOpenId = getOpenId();
        // 调用api接口，发送数据到微信
//        WxShareInstance.sendReq(req);
    }

    private static byte[] bmpToByteArray(final Bitmap bmp,
                                         final boolean needRecycle) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, output);
        if (needRecycle) {
            bmp.recycle();
        }

        byte[] result = output.toByteArray();
        try {
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    private String buildTransaction(final String type) {
        return (type == null) ? String.valueOf(System.currentTimeMillis())
                : type + System.currentTimeMillis();
    }

    @Override
    protected void initView() {
        shareAskJoinfilePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + "share_ask_image.jpg";
        qrcode.setImageBitmap(setQrCode("http://www.baidu.com"));
    }

    @PermissionSuccess(requestCode = 100)
    public void perSucccess() {
        save(shareView);
    }

    @PermissionFail(requestCode = 100)
    public void perFail() {
        ToastUtils.showLong("无读写权限，无法分享");
    }

    private void save(final View mView) {
        // 获取图片某布局
        mView.setDrawingCacheEnabled(true);
        mView.buildDrawingCache();
        final Bitmap bmp = mView.getDrawingCache(); // 获取图片

        showLoading();
        new Thread(new Runnable() {
            @Override
            public void run() {
                final File myCaptureFile = savePicture(ShareQRcodeActivity.this, bmp);// 保存图片
                bmp.recycle();
                if (myCaptureFile != null) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            // 把文件插入到系统图库
//                            try {
//                                MediaStore.Images.Media.insertImage(getContentResolver(), myCaptureFile.getAbsolutePath(), "share_ask_image.jpg", null);
//                            } catch (FileNotFoundException e) {
//                                e.printStackTrace();
//                            }
                            // 最后通知图库更新
                            // sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + myCaptureFile.getPath())));
//                            Toast.makeText(TdAskJoinNewMode.this, "保存成功!", Toast.LENGTH_SHORT).show();
                            mView.destroyDrawingCache(); // 保存过后释放资源
                            hideLoading();
                            ShareUtil.shareImage(ShareQRcodeActivity.this, SharePlatform.WX, shareAskJoinfilePath, new ShareListener() {
                                @Override
                                public void shareSuccess() {
                                    ToastUtils.showLong("分享成功");
                                }

                                @Override
                                public void shareFailure(Exception e) {

                                }

                                @Override
                                public void shareCancel() {

                                }
                            });
                        }
                    });
                }

            }
        }).start();


    }


    private File savePicture(Context context, Bitmap bm) {
        Log.i("xing", "savePicture: ------------------------");
        if (null == bm) {
            Log.i("xing", "savePicture: ------------------图片为空------");
            return null;
        }
        //建立指定文件夹
        File myCaptureFile = new File(shareAskJoinfilePath);
        try {
            if (!myCaptureFile.exists()) {
                myCaptureFile.createNewFile();
            }
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(myCaptureFile));
            //压缩保存到本地
            bm.compress(Bitmap.CompressFormat.JPEG, 100, bos);
            bos.flush();
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 把文件插入到系统图库
        return myCaptureFile;

    }

    public Bitmap setQrCode(String qrCodeString) {
        if (!isSetCode) {
            isSetCode = true;
            Bitmap logoBitmap = ImageUtils.getBitmap(this, R.mipmap.ic_launcher);
            Bitmap qrImage = ZXingUtils.createQRCodeWithLogo(qrCodeString, logoBitmap);

            return qrImage;
        }

        return null;

    }

    @OnClick(R.id.btnShare)
    public void onViewClicked() {

        PermissionGen.with(this).addRequestCode(100).permissions(Manifest.permission.READ_EXTERNAL_STORAGE).request();
    }
}
