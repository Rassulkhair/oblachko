package kz.rassul_ghul.oblachko;


import lombok.Getter;

import java.io.IOException;

@Getter
public class OblachkoException extends RuntimeException {
    private final Error error;

    public OblachkoException(Error error) {
        this.error = error;
    }

    public OblachkoException(Throwable throwable) {
        super(throwable);
        this.error = Error.UNKNOWN;
    }
}
