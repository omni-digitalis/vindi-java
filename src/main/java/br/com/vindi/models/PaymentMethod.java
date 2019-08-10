package br.com.vindi.models;

import com.google.gson.annotations.SerializedName;

public class PaymentMethod {

    public enum Method {

        CASH("cash"),
        CREDIT_CARD("credit_card");

        private final String value;
        Method(final String value) {
            this.value = value;
        }
        public String string() {
            return value;
        }
    }

    private Long id;

    @SerializedName("public_name")
    private String publicName;

    private  String name;

    private String code;

    private String type;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPublicName() {
        return publicName;
    }

    public void setPublicName(String publicName) {
        this.publicName = publicName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
