package br.com.vindi.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public final class Bill {

    private String id;

    // External id
    private String code;

    @SerializedName("bill_items")
    private List<Item> billItems;

    @SerializedName("payment_method_code")
    private String paymentMethodCode;

    @SerializedName("customer_id")
    private String customerId;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("seen_at")
    private String seenAt;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getPaymentMethodCode() {
        return paymentMethodCode;
    }

    public void setPaymentMethodCode(String paymentMethodCode) {
        this.paymentMethodCode = paymentMethodCode;
    }

    public List<Item> getBillItems() {
        return billItems;
    }

    public void setBillItems(List<Item> billItems) {
        this.billItems = billItems;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getSeenAt() {
        return seenAt;
    }

    public void setSeenAt(String seenAt) {
        this.seenAt = seenAt;
    }
}
