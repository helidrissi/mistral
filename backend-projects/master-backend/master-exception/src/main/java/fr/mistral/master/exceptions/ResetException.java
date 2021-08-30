package fr.mistral.master.exceptions;

public class ResetException extends RuntimeException {

    public ResetException() {
        super("pwdErr");
    }
}
