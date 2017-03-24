package lib.ibm.core2.mvp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;

import lib.ibm.core2.custom.dialog.DialogFragment;
import lib.ibm.core2.interactor.Interactor;
import lib.ibm.core2.interactor.InteractorListener;
import lib.ibm.core2.interactor.Result;

/**
 * Created by bassam on 29-10-2016.
 */

public abstract class Presenter<View extends IView> extends nucleus.presenter.Presenter<View> implements IView, InteractorListener {

    protected ViewState viewState = new ViewState();
    protected Intent intent;
    protected Bundle bundle;
    protected Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedState) {
        super.onCreate(savedState);

        Log.d("#Presenter#", "onCreate(), saveInstance " + savedState);
    }

    /**
     * onCreate if you need activity context, activity intent, or fragment bundle
     * before this function call, context, intent and bundle would be null
     *
     * @param context activity or fragment context
     * @param intent  activity intent that got from getIntent()
     * @param bundle  fragment bundle that got from getArguments()
     */
    protected void onCreate(Context context, Intent intent, Bundle bundle) {
        Log.d("#Presenter#", "onCreate(), context " + context + ", intent " + intent + ", bundle " + bundle);
    }

    @Override
    protected void onTakeView(View view) {
        super.onTakeView(view);

        // check navigation with class
        if (viewState.isNavigate() && viewState.getNavigationClass() != null) {

            if (viewState.getNavigationRequestCode() == -1) {

                if (viewState.getNavigationFlags() != 0)
                    navigateTo(viewState.getNavigationClass(), viewState.getNavigationExtras(), viewState.getNavigationFlags());
                else
                    navigateTo(viewState.getNavigationClass(), viewState.getNavigationExtras());
            } else {

                if (viewState.getNavigationFlags() != 0)
                    navigateToForResult(viewState.getNavigationClass(),
                            viewState.getNavigationExtras(),
                            viewState.getNavigationRequestCode(),
                            viewState.getNavigationFlags());
                else
                    navigateToForResult(viewState.getNavigationClass(),
                            viewState.getNavigationExtras(),
                            viewState.getNavigationRequestCode());
            }

        }

        // check navigation with intent
        if (viewState.isNavigate() && viewState.getNavigationIntent() != null) {

            if (viewState.getNavigationRequestCode() == -1)
                navigateTo(viewState.getNavigationIntent());
            else
                navigateToForResult(viewState.getNavigationIntent(), viewState.getNavigationRequestCode());
        }

        // check add fragment
        if (viewState.isAddFragment()) {
            addFragment(viewState.getFragmentLayoutid(), viewState.getFragmentCls(), viewState.getFragmentTag());
        }

        // check replace fragment
        if (viewState.isAddFragment()) {
            addFragment(viewState.getFragmentLayoutid(), viewState.getFragmentCls(), viewState.getFragmentTag());
        }

        // check show loading
        if (viewState.isShowLoading()) {
            showLoading(viewState.getLoadingDialogCls());
        }

        // check dismiss loading
        if (viewState.isDismissLoading()) {
            dismissLoading();
        }

        // check show dialog
        if (viewState.isShowDialog()) {
            showDialog(viewState.getDialogCls(), viewState.getDialogParams());
        }

        // check show toast
        if (viewState.isShowToast()) {
            showToast(viewState.getToastText());
        }

        // check finish
        if (viewState.isFinish()) {
            if (viewState.getFinishResult() != Activity.RESULT_FIRST_USER) {
                finishActivity(viewState.getFinishResult(), viewState.getFinishData());
            } else {
                finishActivity();
            }
        }
    }

    @Override
    public void navigateTo(Class activity, Bundle extras) {

        navigateTo(activity, extras, 0);
    }

    @Override
    public void navigateTo(Class cls, Bundle extras, int flags) {

        // save view state
        viewState.setNavigate(true);
        viewState.setNavigationClass(cls);
        viewState.setNavigationExtras(extras);
        viewState.setNavigationFlags(flags);

        // do action if view is available
        if (getView() != null) {
            getView().navigateTo(cls, extras, flags);

            // reset
            viewState.resetNavigation();
        }

    }

    @Override
    public void navigateTo(Intent intent) {

        // save view state
        viewState.setNavigate(true);
        viewState.setNavigationIntent(intent);

        // do action if view is available
        if (getView() != null) {
            getView().navigateTo(intent);

            // reset
            viewState.resetNavigation();
        }
    }

    @Override
    public void navigateToForResult(Class cls, Bundle extras, int requestCode) {

        navigateToForResult(cls, extras, requestCode, 0);
    }

    @Override
    public void navigateToForResult(Class cls, Bundle extras, int requestCode, int flags) {

        // save view state
        viewState.setNavigate(true);
        viewState.setNavigationClass(cls);
        viewState.setNavigationExtras(extras);
        viewState.setNavigationRequestCode(requestCode);
        viewState.setNavigationFlags(flags);

        // do action if view is available
        if (getView() != null) {
            getView().navigateToForResult(cls, extras, requestCode, flags);

            // reset
            viewState.resetNavigation();
        }
    }

    @Override
    public void navigateToForResult(Intent intent, int requestCode) {

        // save view state
        viewState.setNavigate(true);
        viewState.setNavigationIntent(intent);
        viewState.setNavigationRequestCode(requestCode);

        // do action if view is available
        if (getView() != null) {
            getView().navigateToForResult(intent, requestCode);

            // reset
            viewState.resetNavigation();
        }
    }

    @Override
    public Fragment replaceFragment(int layoutId, Class<? extends Fragment> fragment, String tag) {

        // save view state
        viewState.setReplaceFragment(true);
        viewState.setFragmentLayoutid(layoutId);
        viewState.setFragmentCls(fragment);
        viewState.setFragmentTag(tag);
        Fragment replacedFragment = null;
        // do action if view is available
        if (getView() != null) {
            replacedFragment = getView().replaceFragment(layoutId, fragment, tag);

            // reset flag
            viewState.resetShowFragment();
        }

        return replacedFragment;
    }

    @Override
    public Fragment addFragment(int layoutId, Class<? extends Fragment> fragment, String tag) {

        // save view state
        viewState.setAddFragment(true);
        viewState.setFragmentLayoutid(layoutId);
        viewState.setFragmentCls(fragment);
        viewState.setFragmentTag(tag);
        Fragment addedFragment = null;
        // do action if view is available
        if (getView() != null) {
            addedFragment = getView().addFragment(layoutId, fragment, tag);

            // reset flag
            viewState.resetShowFragment();
        }

        return addedFragment;
    }

    @Override
    public void showLoading(Class<? extends DialogFragment> dialogCls) {

        // save view state
        viewState.setShowLoading(true);
        viewState.setLoadingDialogCls(dialogCls);

        // do action if view is available
        if (getView() != null) {
            getView().showLoading(dialogCls);

            // reset flag
            viewState.resetShowLoading();
        }
    }

    @Override
    public void dismissLoading() {

        // save view state
        viewState.setDismissLoading(true);

        // do action if view is available
        if (getView() != null) {
            getView().dismissLoading();

            // reset flag
            viewState.resetDismissLoading();
        }
    }

    @Override
    public void showDialog(Class<? extends DialogFragment> dialogCls, DialogFragment.DialogParams params) {
        // save view state
        viewState.setShowDialog(true);
        viewState.setDialogCls(dialogCls);
        viewState.setDialogParams(params);

        // do action if view is available
        if (getView() != null) {
            getView().showDialog(dialogCls, params);

            // reset flag
            viewState.resetShowDialog();
        }
    }

    @Override
    public void showToast(String msg) {

        // save view state
        viewState.setShowToast(true);
        viewState.setToastText(msg);

        // do action if view is available
        if (getView() != null) {
            getView().showToast(msg);

            // reset flag
            viewState.resetToast();
        }
    }

    @Override
    public void finishActivity() {

        // save view state
        viewState.setFinish(true);

        // do action if view is available
        if (getView() != null) {
            getView().finishActivity();

            // reset flag
            viewState.resetFinish();
        }
    }

    @Override
    public void finishActivity(int activityResult, Intent data) {

        // save view state
        viewState.setFinish(true);

        // do action if view is available
        if (getView() != null) {
            getView().finishActivity(activityResult, data);

            // reset flag
            viewState.resetFinish();
        }
    }

    public Intent getIntent() {
        return intent;
    }

    public void setIntent(Intent intent) {
        this.intent = intent;
    }

    public Bundle getBundle() {
        return bundle;
    }

    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    @Override
    public void onInteractorCanceled(Interactor interactor) {

    }

    @Override
    public void onInteractorFinished(Interactor interactor, Result result) {

    }

    @Override
    public void onInteractorProgress(Interactor interactor, int progress) {

    }

    @Override
    public void onInteractorStarted(Interactor interactor) {

    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
