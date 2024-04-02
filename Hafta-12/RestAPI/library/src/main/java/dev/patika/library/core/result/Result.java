package dev.patika.library.core.result;

import lombok.Getter;

@Getter
public class Result {
    private boolean status;
    private String message;
    private String responseCode;

    public Result(boolean status, String message, String responseCode) {
        this.status = status;
        this.message = message;
        this.responseCode = responseCode;
    }
}
