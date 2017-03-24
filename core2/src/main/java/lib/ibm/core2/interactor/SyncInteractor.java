package lib.ibm.core2.interactor;

/**
 * Created by bassamhamada on 1/29/17.
 */

public abstract class SyncInteractor extends Interactor {

    public SyncInteractor(InteractorListener listener) {
        super(listener);
    }

    public void execute() {
        onTaskWork();
    }

    @Override
    protected Result onTaskWork() {

        start();

        onTaskWorkSync();

        // no need to return result because no one
        // interested on it as it already executed asyc
        return null;
    }

    protected abstract void onTaskWorkSync();

}
