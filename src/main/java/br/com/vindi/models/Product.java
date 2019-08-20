package br.com.vindi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public final class Product {

    @Expose(serialize = false, deserialize = false)
    public static final String MAP_KEY = Product.class.getSimpleName().toLowerCase();

    private Long id;

    private String name;

    private String description;

    // external id
    private String code;

    private String status;

    @SerializedName("pricing_schema")
    private PricingSchema pricingSchema;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Status getStatus() {
        return Status.enumValue(this.status);
    }

    public void setStatus(Status status) {
        this.status = status.string();
    }

    public PricingSchema getPricingSchema() {
        return pricingSchema;
    }

    public void setPricingSchema(PricingSchema pricingSchema) {
        this.pricingSchema = pricingSchema;
    }
}
