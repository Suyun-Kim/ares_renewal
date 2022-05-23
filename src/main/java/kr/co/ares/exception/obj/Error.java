package kr.co.ares.exception.obj;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Error {


    String message;

    public Error(String message) {
        this.message = message;
    }
}
