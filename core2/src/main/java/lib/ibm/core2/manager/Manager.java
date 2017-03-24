package lib.ibm.core2.manager;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by bassam on 11-12-2016.
 */

public abstract class Manager extends Observable {

    public void register(Observer observer) {
        addObserver(observer);
    }

    public void unregister(Observer observer) {
        deleteObserver(observer);
    }

    public void notify(Payload payload) {
        setChanged();
        notifyObservers(payload);
    }
}
