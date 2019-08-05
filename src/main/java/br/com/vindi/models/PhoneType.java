package br.com.vindi.models;

public enum PhoneType {

    MOBILE("mobile"),
    LANDLINE("landline");

    private final String value;

    PhoneType(final String value) {
        this.value = value;
    }

    public String string() {
        return value;
    }
}
