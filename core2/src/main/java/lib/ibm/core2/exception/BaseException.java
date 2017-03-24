package lib.ibm.core2.exception;

/**
 * Created by bassamhamada on 1/30/17.
 */

public abstract class BaseException extends Exception {

    public BaseException() {
    }

    public BaseException(String message) {
        super(message);
    }
}
