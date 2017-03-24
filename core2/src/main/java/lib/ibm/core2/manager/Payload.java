package lib.ibm.core2.manager;

/**
 * Created by bassam on 11-12-2016.
 */

public class Payload<P> {

    int status;
    P data;

    public Payload() {

    }

    public Payload(int status, P dada) {
        this.status = status;
        this.data = dada;
    }

    public Payload(int status) {
        this.status = status;
    }

    public Payload(P dada) {
        this.data = dada;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public P getData() {
        return data;
    }

    public void setData(P data) {
        this.data = data;
    }
}
