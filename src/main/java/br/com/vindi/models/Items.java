package br.com.vindi.models;

import com.google.gson.annotations.SerializedName;

public final class Items {

    @SerializedName("product_id")
    private Long productId;

    private Integer amount;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
