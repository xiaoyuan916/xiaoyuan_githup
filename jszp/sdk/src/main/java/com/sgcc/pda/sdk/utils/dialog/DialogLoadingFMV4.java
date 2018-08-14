package com.sgcc.pda.sdk.utils.dialog;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.sgcc.pda.sdk.R;
import com.sgcc.pda.sdk.utils.LogUtil;

public class DialogLoadingFMV4 extends DialogFragment {
    private View view;
    private DialogLoadingFM.ICancelLoadingListener cancelLoadingListener;
    private ImageView img_loading;
    private AnimationDrawable adProgressSpinner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        if (view == null) {
            view = inflater.inflate(R.layout.dialog_loading, container, false);
            initView();
        } else {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null) {
                parent.removeView(view);
            }
        }
        getDialog().setCanceledOnTouchOutside(false);
        return view;
    }

    @Override
    public void onCancel(DialogInterface i) {
        LogUtil.d("dialog", "cancel回调");
        if (cancelLoadingListener != null) {
            cancelLoadingListener.onCancelLoading();
        }
        dismissAllowingStateLoss();
    }

    @Override
    public void onDismiss(DialogInterface i) {
        LogUtil.d("dialog", "dismiss回调");
    }

    private void initView() {
        ((TextView) view.findViewById(R.id.tv_dialog_msg)).setText(getArguments().getString("msg"));
        img_loading = ((ImageView)view.findViewById(R.id.img_loading));
//        img_loading.setAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.loading_anim));
        img_loading.setImageResource(R.drawable.loading_anim);
        adProgressSpinner = (AnimationDrawable)img_loading.getDrawable();
    }

    @Override
    public void onPause() {
        super.onPause();
//        img_loading.clearAnimation();
        if(adProgressSpinner != null && adProgressSpinner.isRunning()) {
            adProgressSpinner.stop();
            LogUtil.d("dialog", "停止了载入动画");
        }
    }

    @Override
    public void onResume() {
        super.onResume();
//        if (img_loading.getAnimation() == null) {
//            img_loading.setAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.loading_anim));
//        }
        if (adProgressSpinner != null && !adProgressSpinner.isRunning()) {
            adProgressSpinner.start();
            LogUtil.d("dialog", "开始了载入动画");
        }
    }

    /**
     * 更新进度信息
     * @param msg 进度信息
     */
    public void updateMsg(String msg) {
        if(null != view) {
            ((TextView) view.findViewById(R.id.tv_dialog_msg)).setText(msg);
        }
    }

    /**
     * 设置取消对话框的回调
     * @param cancelClickedListener
     */
    public void setOnCancelLoadingListener(DialogLoadingFM.ICancelLoadingListener cancelClickedListener) {
        this.cancelLoadingListener = cancelClickedListener;
    }
}