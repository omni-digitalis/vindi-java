package br.com.vindi.exceptions;

/**
 * Should be throw when a important auth key is not found
 */
public class KeyNotFoundException extends Exception {

    public KeyNotFoundException(String message) {
        super(message);
    }

}
