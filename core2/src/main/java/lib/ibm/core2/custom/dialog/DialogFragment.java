package lib.ibm.core2.custom.dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;

import lib.ibm.core2.R;

public class DialogFragment extends AppCompatDialogFragment {

    public static class DialogParams {

        public String tag;
        public String title;
        public String message;
        public String positiveText;
        public String negativeText;
        public OnClickListener positiveListener;
        public OnClickListener negativeListener;
        public int dialogStyle = -100;
    }

    public interface OnClickListener {

        void onClick();
    }

    protected DialogParams params;

    public void setParams(DialogParams params) {
        this.params = params;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            params = new DialogParams();
            params.tag = savedInstanceState.getString("tag");
            params.title = savedInstanceState.getString("title");
            params.message = savedInstanceState.getString("message");
            params.negativeText = savedInstanceState.getString("negativeText");
            params.positiveText = savedInstanceState.getString("positiveText");
            params.dialogStyle = savedInstanceState.getInt("dialogStyle");
        }
    }

    @Override
    @SuppressWarnings("ResourceType")
    public android.app.Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder dialogBuilder;
        if (params.dialogStyle > 0) {
            dialogBuilder = new AlertDialog.Builder( getActivity(),  params.dialogStyle);
        }
        else {
            dialogBuilder = new AlertDialog.Builder(getActivity());
        }

        dialogBuilder.setTitle(params.title);
        dialogBuilder.setMessage(params.message);
        dialogBuilder.setPositiveButton(params.positiveText, params.positiveListener != null ? new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                params.positiveListener.onClick();
            }
        } : null);
        dialogBuilder.setNegativeButton(params.negativeText, params.negativeListener != null ? new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                params.negativeListener.onClick();
            }
        } : null);
        dialogBuilder.setCancelable(false);

        return dialogBuilder.create();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

        outState.putString("tag", params.tag);
        outState.putString("title", params.title);
        outState.putString("message", params.message);
        outState.putString("negativeText", params.negativeText);
        outState.putString("positiveText", params.positiveText);
        outState.putInt("dialogStyle", params.dialogStyle);
    }
}
