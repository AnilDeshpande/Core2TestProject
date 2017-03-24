package lib.ibm.core2.interactor;

import android.os.AsyncTask;

public abstract class Interactor extends AsyncTask<Void, Integer, Result> {

    protected InteractorListener listener;
    protected Object data;
    protected int progress;

    protected abstract Result onTaskWork();

    protected Object getInteractorData() {
        return data;
    }

    protected int getInteractorProgress() {
        return progress;
    }

    public Interactor(InteractorListener listener) {

        this.listener = listener;
    }

    @Override
    protected void onPreExecute() {

        super.onPreExecute();
        start();
    }

    @Override
    protected Result doInBackground(Void... params) {

        return onTaskWork();
    }

    @Override
    protected void onPostExecute(Result result) {

        super.onPostExecute(result);
        finish(result);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        progress(values[0]);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        cancel();
    }


    public void updateView(int progress) {

        publishProgress(progress);
    }

    public Result executeSync() {

        Result result = onTaskWork();

        // set interactor data
        setInteractorData(result);

        return result;
    }

    protected void setInteractorData(Result result) {
        if (result != null) {
            data = result.getData();
        }
    }

    /**
     * fire onInteractorStarted
     */
    protected void start() {
        if (listener != null)
            listener.onInteractorStarted(this);
    }

    /**
     * fire onInteractorFinished
     */
    protected void finish(Result result) {

        // set interactor data
        setInteractorData(result);

        if (listener != null)
            listener.onInteractorFinished(this, result);
    }

    /**
     * fire onInteractorProgress
     */
    protected void progress(Integer value) {

        // set interactor progress
        progress = value;

        if (listener != null)
            listener.onInteractorProgress(this, progress);
    }

    /**
     * fire onInteractorCanceled
     */
    protected void cancel() {
        if (listener != null)
            listener.onInteractorCanceled(this);
    }


}