/**
 *
 */
package lib.ibm.core2.custom.dialog;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.os.Bundle;
import android.view.KeyEvent;

/**
 * @author bahamada
 */
public class LoadingDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        ProgressDialog dialog = new ProgressDialog(getActivity());
        dialog.setTitle(params.title);
        dialog.setMessage(params.message);
        dialog.setIndeterminate(true);
        dialog.setCancelable(false);

        // Disable the back button
        OnKeyListener keyListener = new OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    return true;
                }
                return false;
            }

        };

        dialog.setOnKeyListener(keyListener);
        return dialog;
    }
}
