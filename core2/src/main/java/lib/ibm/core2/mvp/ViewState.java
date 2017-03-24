package lib.ibm.core2.mvp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import lib.ibm.core2.custom.dialog.DialogFragment;

/**
 * Created by bassam on 29-10-2016.
 */

public class ViewState {

    /**
     * Navigation
     */
    private boolean navigate;
    private Class navigationClass;
    private Bundle navigationExtras;
    private Intent navigationIntent;
    private int navigationRequestCode = -1;
    private int navigationFlags = -1;

    /**
     * Fragment
     */
    private boolean addFragment;
    private boolean replaceFragment;
    private int fragmentLayoutid;
    private Class<? extends Fragment> fragmentCls;
    private String fragmentTag;

    /**
     * Loading
     */
    private boolean showLoading;
    private boolean dismissLoading;
    private Class<? extends DialogFragment> loadingDialogCls;

    /**
     * Dialog
     */
    private boolean showDialog;
    private Class<? extends DialogFragment> dialogCls;
    private DialogFragment.DialogParams dialogParams;

    /**
     * Toast
     */
    private boolean showToast;
    private String toastText;

    /**
     * finish
     */
    private boolean finish;
    private int finishResult;
    private Intent finishData;

    public boolean isNavigate() {
        return navigate;
    }

    public void setNavigate(boolean navigate) {
        this.navigate = navigate;
    }

    public Class getNavigationClass() {
        return navigationClass;
    }

    public void setNavigationClass(Class navigationClass) {
        this.navigationClass = navigationClass;
    }

    public Bundle getNavigationExtras() {
        return navigationExtras;
    }

    public void setNavigationExtras(Bundle navigationExtras) {
        this.navigationExtras = navigationExtras;
    }

    public Intent getNavigationIntent() {
        return navigationIntent;
    }

    public void setNavigationIntent(Intent intent) {
        this.navigationIntent = intent;
    }

    public int getNavigationRequestCode() {
        return navigationRequestCode;
    }

    public void setNavigationRequestCode(int requestCode) {
        this.navigationRequestCode = requestCode;
    }

    public int getNavigationFlags() {
        return navigationFlags;
    }

    public void setNavigationFlags(int flags) {
        this.navigationFlags = flags;
    }

    public boolean isAddFragment() {
        return addFragment;
    }

    public void setReplaceFragment(boolean replaceFragment) {
        this.replaceFragment = replaceFragment;
    }

    public boolean isReplaceFragment() {
        return replaceFragment;
    }

    public void setAddFragment(boolean addFragment) {
        this.addFragment = addFragment;
    }

    public int getFragmentLayoutid() {
        return fragmentLayoutid;
    }

    public void setFragmentLayoutid(int fragmentLayoutid) {
        this.fragmentLayoutid = fragmentLayoutid;
    }

    public Class<? extends Fragment> getFragmentCls() {
        return fragmentCls;
    }

    public void setFragmentCls(Class<? extends Fragment> fragmentCls) {
        this.fragmentCls = fragmentCls;
    }

    public String getFragmentTag() {
        return fragmentTag;
    }

    public void setFragmentTag(String tag) {
        this.fragmentTag = tag;
    }

    public boolean isShowLoading() {
        return showLoading;
    }

    public void setShowLoading(boolean showLoading) {
        this.showLoading = showLoading;
    }

    public boolean isDismissLoading() {
        return dismissLoading;
    }

    public void setDismissLoading(boolean dismissLoading) {
        this.dismissLoading = dismissLoading;
    }

    public Class<? extends DialogFragment> getLoadingDialogCls() {
        return loadingDialogCls;
    }

    public void setLoadingDialogCls(Class<? extends DialogFragment> loadingDialogCls) {
        this.loadingDialogCls = loadingDialogCls;
    }

    public boolean isShowDialog() {
        return showDialog;
    }

    public void setShowDialog(boolean showDialog) {
        this.showDialog = showDialog;
    }

    public Class<? extends DialogFragment> getDialogCls() {
        return dialogCls;
    }

    public void setDialogCls(Class<? extends DialogFragment> dialogCls) {
        this.dialogCls = dialogCls;
    }

    public DialogFragment.DialogParams getDialogParams() {
        return dialogParams;
    }

    public void setDialogParams(DialogFragment.DialogParams dialogParams) {
        this.dialogParams = dialogParams;
    }

    public boolean isShowToast() {
        return showToast;
    }

    public void setShowToast(boolean showToast) {
        this.showToast = showToast;
    }

    public String getToastText() {
        return toastText;
    }

    public void setToastText(String toastText) {
        this.toastText = toastText;
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public int getFinishResult() {
        return finishResult;
    }

    public void setFinishResult(int finishResult) {
        this.finishResult = finishResult;
    }

    public Intent getFinishData() {
        return finishData;
    }

    public void setFinishData(Intent finishData) {
        this.finishData = finishData;
    }

    public void resetNavigation() {
        navigate = false;
        navigationClass = null;
        navigationExtras = null;
        navigationIntent = null;
        navigationRequestCode = -1;
        navigationFlags = -1;
    }

    public void resetShowFragment() {
        replaceFragment = false;
        addFragment = false;
        fragmentCls = null;
        fragmentLayoutid = 0;
        fragmentTag = null;
    }

    public void resetShowLoading() {
        showLoading = false;
        loadingDialogCls = null;
    }

    public void resetDismissLoading() {
        dismissLoading = false;
    }

    public void resetShowDialog() {

        showDialog = false;
        dialogCls = null;
        dialogParams = null;
    }

    public void resetToast() {
        showToast = false;
        toastText = null;
    }

    public void resetFinish() {
        finish = false;
        finishResult = Activity.RESULT_FIRST_USER;
        finishData = null;
    }
}
