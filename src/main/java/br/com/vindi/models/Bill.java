package br.com.vindi.models;

import com.google.gson.annotations.SerializedName;

public final class Bill {

    private String id;

    // External id
    private String code;

    @SerializedName("bill_items")
    private Items billItems;

    @SerializedName("payment_method_code")
    private String paymentMethodCode;

    @SerializedName("customer_id")
    private String customerId;

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

    public Items getBillItems() {
        return billItems;
    }

    public void setBillItems(Items billItems) {
        this.billItems = billItems;
    }
}
