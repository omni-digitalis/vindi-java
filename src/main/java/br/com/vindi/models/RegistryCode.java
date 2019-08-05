package br.com.vindi.models;

public enum RegistryCode {

    CPF("CPF"),
    CNPJ("CNPJ");

    private final String value;

    RegistryCode(final String value) {
        this.value = value;
    }

    public String string() {
        return value;
    }

}
