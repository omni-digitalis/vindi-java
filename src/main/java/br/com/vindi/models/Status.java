package br.com.vindi.models;

public enum Status {

    ACTIVE("active"),
    INACTIVE("inactive"),
    ARCHIVED("archived");

    private final String value;

    Status(final String value) {
        this.value = value;
    }

    public String string() {
        return value;
    }

    public static Status enumValue(String value) {
        for (Status status : Status.values()) {
            if (status.string().equals(value.replace(" ", "").replace("\n", ""))) {
                return status;
            }
        }
        return null;
    }

}
