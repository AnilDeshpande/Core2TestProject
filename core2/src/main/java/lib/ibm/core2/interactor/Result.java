/**
 *
 */
package lib.ibm.core2.interactor;

/**
 * @author bassam
 */
public class Result {

    private int error;

    private Object data;

    public Result(int error) {
        this.error = error;
    }

    public Result(int error, Object data) {
        this.error = error;
        this.data = data;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
