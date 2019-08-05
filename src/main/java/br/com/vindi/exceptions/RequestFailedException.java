package br.com.vindi.exceptions;

/**
 * When a api request fail
 */
public class RequestFailedException extends Exception {

    public RequestFailedException(String message) {
        super("Error on request: " + message);
    }

}
