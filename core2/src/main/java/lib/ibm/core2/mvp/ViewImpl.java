package lib.ibm.core2.mvp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import lib.ibm.core2.custom.dialog.DialogFragment;
import lib.ibm.core2.custom.dialog.DialogHelper;

/**
 * Created by emanhassan on 10/31/16.
 */
public class ViewImpl implements IView {

    Activity activity;
    IView view;

    ViewImpl(Activity activity, IView view) {
        this.activity = activity;
        this.view = view;
    }

    @Override
    public void navigateTo(Class cls, Bundle extras) {
        navigateTo(cls, extras, 0);
    }

    @Override
    public void navigateTo(Class cls, Bundle extras, int flags) {

        Intent intent = new Intent(activity, cls);
        if (extras != null) {
            intent.putExtras(extras);
        }

        if (flags != 0) {
            intent.addFlags(flags);
        }

        navigateTo(intent);
    }

    @Override
    public void navigateTo(Intent intent) {
        activity.startActivity(intent);
    }

    @Override
    public void navigateToForResult(Class cls, Bundle extras, int requestCode) {
        navigateToForResult(cls, extras, requestCode, 0);
    }

    @Override
    public void navigateToForResult(Class cls, Bundle extras, int requestCode, int flags) {

        Intent intent = new Intent(activity, cls);
        if (extras != null) {
            intent.putExtras(extras);
        }

        if (flags != 0) {
            intent.addFlags(flags);
        }

        navigateToForResult(intent, requestCode);
    }

    @Override
    public void navigateToForResult(Intent intent, int requestCode) {

        if (view instanceof Fragment) {
            ((Fragment) view).startActivityForResult(intent, requestCode);
        } else {
            activity.startActivityForResult(intent, requestCode);
        }
    }

    @Override
    public Fragment replaceFragment(int layoutId, Class<? extends Fragment> cls, String tag) {

        Fragment fragment = ((AppCompatActivity) activity).getSupportFragmentManager().findFragmentByTag(tag);

        // create fragment if not get by tag
//        if (fragment == null) {
        fragment = createFragment(cls);
//        }

        ((AppCompatActivity) activity).getSupportFragmentManager()
                .beginTransaction()
                .replace(layoutId, fragment, tag).addToBackStack(null)
                .commit();

        return fragment;

    }

    @Override
    public Fragment addFragment(int layoutId, Class<? extends Fragment> cls, String tag) {

        Fragment fragment = ((AppCompatActivity) activity).getSupportFragmentManager().findFragmentByTag(tag);

        // create fragment if not get by tag
        if (fragment == null) {
            fragment = createFragment(cls);
        }

        ((AppCompatActivity) activity).getSupportFragmentManager()
                .beginTransaction()
                .add(layoutId, fragment, tag)
                .commit();

        return fragment;

    }

    private Fragment createFragment(Class<? extends Fragment> cls) {

        Fragment fragment = null;
        try {
            fragment = cls.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return fragment;
    }

    @Override
    public void showLoading(Class<? extends DialogFragment> dialogCls) {
        DialogHelper.showLoadingDialog((AppCompatActivity) activity, dialogCls, "core2.loading");
    }

    @Override
    public void dismissLoading() {
        DialogHelper.hideDialog((AppCompatActivity) activity, "core2.loading");
    }

    @Override
    public void showDialog(Class<? extends DialogFragment> dialogCls, DialogFragment.DialogParams params) {
        DialogHelper.showDialog((AppCompatActivity) activity, dialogCls, params);
    }

    @Override
    public void showToast(String msg) {

        Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void finishActivity() {

        activity.finish();
    }

    @Override
    public void finishActivity(int activityResult, Intent data) {

        activity.setResult(activityResult, data);
        activity.finish();
    }
}
