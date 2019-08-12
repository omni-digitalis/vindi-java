package br.com.vindi.models;

import com.google.gson.annotations.SerializedName;

public final class Item {

    @SerializedName("product_id")
    private Long productId;

    @SerializedName("product_code")
    private String productCode;

    private Double amount;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
}
