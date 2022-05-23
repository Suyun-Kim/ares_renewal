package kr.co.ares.exception.obj;

import java.util.Date;

public class ResponseEnvelop<T> {
    private boolean success;
    private T result;
    private Error error;

    public ResponseEnvelop(boolean success, T result, String message) {
        this.success = success;
        this.result = result;
        this.error = new Error(message);
    }

    public ResponseEnvelop(boolean success, T result) {
        this.success = success;
        this.result = result;
    }

    public ResponseEnvelop(boolean success) {
        this.success = success;
    }

    public ResponseEnvelop(boolean success, Error error) {
        this.success = success;
        this.error = error;
    }

    public ResponseEnvelop(boolean success, T result, Error error) {
        this.success = success;
        this.result = result;
        this.error = error;
    }

    public boolean getSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Date getTimestamp() {
        return new Date();
    }

    public T getResult() {
        return this.result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public Error getError() {
        return this.error;
    }

    public void setError(Error error) {
        this.error = error;
    }

}