package br.com.vindi.config;

public enum EnvironmentKey {

    VINDI_API_URL("vindi.api.url");

    private final String value;

    EnvironmentKey(final String value) {
        this.value = value;
    }

    public String string() {
        return value;
    }

}