package lib.ibm.core2.interactor;

import android.content.Context;
import android.os.Handler;

import java.util.Observable;
import java.util.Observer;

import lib.ibm.core2.manager.Payload;

/**
 * Created by bassam on 15-12-2016.
 */

public abstract class ManagerInteractor extends Interactor implements Observer {

    private Handler handler;

    public ManagerInteractor(Context context, InteractorListener listener) {
        super(listener);
        this.handler = new Handler(context.getApplicationContext().getMainLooper());
    }

    public abstract void register();

    public abstract void unregister();

    @Override
    public void update(final Observable observable, final Object o) {

        handler.post(new Runnable() {
            @Override
            public void run() {
                onManagerEvent(observable, (Payload) o);
            }
        });
    }

    protected abstract void onManagerEvent(Observable observable, Payload data);

    @Override
    protected Result onTaskWork() {
        return null;
    }
}
