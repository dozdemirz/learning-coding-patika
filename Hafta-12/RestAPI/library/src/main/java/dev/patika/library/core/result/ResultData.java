package dev.patika.library.core.result;

import lombok.Getter;

@Getter
public class ResultData<T> extends Result {
    private T data;

    public ResultData(boolean status, String message, String responseCode, T data) {
        super(status, message, responseCode);
        this.data = data;
    }


}
