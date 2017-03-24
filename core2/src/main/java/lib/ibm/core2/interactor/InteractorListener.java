package lib.ibm.core2.interactor;

public interface InteractorListener {

    public void onInteractorStarted(Interactor interactor);

    public void onInteractorFinished(Interactor interactor, Result result);

    public void onInteractorProgress(Interactor interactor, int progress);

    public void onInteractorCanceled(Interactor interactor);

}
