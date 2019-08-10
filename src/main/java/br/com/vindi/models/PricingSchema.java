package br.com.vindi.models;

import com.google.gson.annotations.SerializedName;

public final class PricingSchema {

    private Double price;

    @SerializedName("minimum_price")
    private Double minimumPrice;


    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getMinimumPrice() {
        return minimumPrice;
    }

    public void setMinimumPrice(Double minimumPrice) {
        this.minimumPrice = minimumPrice;
    }
}
