package kr.co.ares.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class Response<T> {

    private StatusEnum status;
    private boolean success;
    private T data;

    public Response(StatusEnum status, boolean success, T data) {
        this.status = status;
        this.success = success;
        this.data = data;
    }

    public Response(StatusEnum status, boolean success) {
        this.status = status;
        this.success = success;

    }

}
