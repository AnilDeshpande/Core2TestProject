package lib.ibm.core2.mvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import lib.ibm.core2.custom.dialog.DialogFragment;

/**
 * Created by bassam on 29-10-2016.
 */

public interface IView {

    void navigateTo(Class cls, Bundle extras);

    void navigateTo(Class cls, Bundle extras, int flags);

    void navigateTo(Intent intent);

    void navigateToForResult(Class cls, Bundle extras, int requestCode);

    void navigateToForResult(Class cls, Bundle extras, int requestCode, int flags);

    void navigateToForResult(Intent intent, int requestCode);

    Fragment replaceFragment(int layoutId, Class<? extends Fragment> fragment, String tag);

    Fragment addFragment(int layoutId, Class<? extends Fragment> fragment, String tag);

    void showLoading(Class<? extends DialogFragment> dialogCls);

    void dismissLoading();

    void showDialog(Class<? extends DialogFragment> dialogCls, DialogFragment.DialogParams params);

    void showToast(String msg);

    void finishActivity();

    void finishActivity(int activityResult, Intent data);

}
