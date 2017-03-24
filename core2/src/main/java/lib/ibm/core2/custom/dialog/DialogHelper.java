package lib.ibm.core2.custom.dialog;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by bassam on 11-01-2017.
 */

public class DialogHelper {

    public static void showLoadingDialog(AppCompatActivity activity, Class<? extends DialogFragment> cls, String tag) {

        DialogFragment dialog = null;
        if (cls == null)
            dialog = new LoadingDialogFragment();
        else
            dialog = createDialog(cls);

        DialogFragment.DialogParams params = new DialogFragment.DialogParams();
        params.tag = tag;
        dialog.setParams(params);
        dialog.show(activity.getSupportFragmentManager(), params.tag);
    }

    public static void showDialog(AppCompatActivity activity, Class<? extends DialogFragment> cls, DialogFragment.DialogParams params) {

        DialogFragment dialog = null;
        if (cls == null)
            dialog = new DialogFragment();
        else
            dialog = createDialog(cls);

        dialog.setParams(params);
        dialog.show(activity.getSupportFragmentManager(), params.tag);
    }

    private static DialogFragment createDialog(Class<? extends DialogFragment> cls) {

        DialogFragment dialog = null;
        try {
            dialog = cls.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return dialog;
    }

    public static void hideDialog(AppCompatActivity activity, String tag) {

        DialogFragment dialog = (DialogFragment) activity.getSupportFragmentManager().findFragmentByTag(tag);

        if (dialog != null && dialog.isAdded()) {
            dialog.dismiss();
        }
    }
}
