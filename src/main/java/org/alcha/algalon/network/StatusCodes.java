package org.alcha.algalon.network;

/**
 * <p>Created by Alcha on 8/9/2017.</p>
 */

public enum StatusCodes {
    OK(200),
    BAD_REQUEST(400),
    NOT_FOUND(404),
    NOT_ACCEPTABLE(406),
    INTERNAL_SERVER_ERROR(500),
    SERVICE_UNAVAILABLE(503),
    UNKNOWN;

    private int code;

    StatusCodes() {
        this.code = 0;
    }

    StatusCodes(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static StatusCodes getStatusCode(int code) {
        for (StatusCodes statusCode : StatusCodes.values()) {
            if (statusCode.getCode() == code)
                return statusCode;
        }

        return UNKNOWN;
    }
}
