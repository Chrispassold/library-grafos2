package src.exception;

import java.io.IOException;

public class InvalidFormatFileException extends IOException {
    public InvalidFormatFileException() {
        super("Arquivo com formatação inválida");
    }

    public InvalidFormatFileException(int length) {
        super(String.format("Arquivo com formatação inválida (tamanho %d)", length));
    }
}
