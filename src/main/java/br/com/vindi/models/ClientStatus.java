package br.com.vindi.models;

public enum ClientStatus {

    ACTIVE("active"),
    INACTIVE("inactive"),
    ARCHIVED("archived");

    private final String value;

    ClientStatus(final String value) {
        this.value = value;
    }

    public String string() {
        return value;
    }

}
