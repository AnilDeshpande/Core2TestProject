package lib.ibm.core2.mvp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;

import lib.ibm.core2.custom.dialog.DialogFragment;
import nucleus.view.NucleusLayout;

/**
 * Created by emanhassan on 10/31/16.
 */
public abstract class EnhancedLayout<P extends Presenter> extends NucleusLayout<P> implements IView {

    ViewImpl impl;

    public EnhancedLayout(Context context) {
        super(context);
        impl = new ViewImpl(getActivity(), this);
    }

    public EnhancedLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        impl = new ViewImpl(getActivity(), this);
    }

    public EnhancedLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        impl = new ViewImpl(getActivity(), this);
    }

    @Override
    public void navigateTo(Class cls, Bundle extras) {
        impl.navigateTo(cls, extras);
    }

    @Override
    public void navigateTo(Intent intent) {
        impl.navigateTo(intent);
    }

    @Override
    public void navigateToForResult(Class cls, Bundle extras, int requestCode) {
        impl.navigateToForResult(cls, extras, requestCode);
    }

    @Override
    public void navigateToForResult(Intent intent, int requestCode) {
        impl.navigateToForResult(intent, requestCode);
    }

    @Override
    public Fragment addFragment(int layoutId, Class<? extends Fragment> fragment, String tag) {
        return impl.addFragment(layoutId, fragment, tag);
    }

    @Override
    public Fragment replaceFragment(int layoutId, Class<? extends Fragment> fragment, String tag) {
        return impl.replaceFragment(layoutId, fragment, tag);
    }

    @Override
    public void showLoading(Class<? extends DialogFragment> dialogCls) {
        impl.showLoading(dialogCls);
    }

    @Override
    public void dismissLoading() {
        impl.dismissLoading();
    }

    @Override
    public void showDialog(Class<? extends DialogFragment> dialogCls, DialogFragment.DialogParams params) {
        impl.showDialog(dialogCls, params);
    }

    @Override
    public void showToast(String msg) {
        impl.showToast(msg);
    }

    @Override
    public void finishActivity() {
        impl.finishActivity();
    }

    @Override
    public void finishActivity(int activityResult, Intent data) {
        impl.finishActivity(activityResult, data);
    }

    @Override
    public void navigateTo(Class cls, Bundle extras, int flags) {
        impl.navigateTo(cls, extras, flags);
    }

    @Override
    public void navigateToForResult(Class cls, Bundle extras, int requestCode, int flags) {
        impl.navigateToForResult(cls, extras, requestCode, flags);
    }
}
