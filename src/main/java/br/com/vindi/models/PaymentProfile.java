package br.com.vindi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public final class PaymentProfile {

    @Expose(serialize = false, deserialize = false)
    public static final String MAP_KEY = "payment_profile";

    @Expose(serialize = false, deserialize = false)
    public static final String MAP_LIST_KEY = "payment_profiles";

    private Long id;

    private String status;

    @SerializedName("holder_name")
    private String holderName;

    @SerializedName("registry_code")
    private String registryCode;

    @SerializedName("bank_branch")
    private String bankBranch;

    @SerializedName("bank_account")
    private String bankAccount;

    @SerializedName("card_expiration")
    private String cardExpiration;

    @SerializedName("card_number_fix_six")
    private String cardNumberFixSix;

    @SerializedName("card_number_last_four")
    private String cardNumberLastFour;

    private String token;

    @SerializedName("gateway_token")
    private String gatewayToken;

    private String type;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("payment_company")
    private PaymentCompany paymentCompany;

    @SerializedName("payment_method")
    private PaymentMethod paymentMethod;

    @SerializedName("customer_id")
    private Integer customerId;

    private Customer customer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getRegistryCode() {
        return registryCode;
    }

    public void setRegistryCode(String registryCode) {
        this.registryCode = registryCode;
    }

    public String getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getCardExpiration() {
        return cardExpiration;
    }

    public void setCardExpiration(String cardExpiration) {
        this.cardExpiration = cardExpiration;
    }

    public String getCardNumberFixSix() {
        return cardNumberFixSix;
    }

    public void setCardNumberFixSix(String cardNumberFixSix) {
        this.cardNumberFixSix = cardNumberFixSix;
    }

    public String getCardNumberLastFour() {
        return cardNumberLastFour;
    }

    public void setCardNumberLastFour(String cardNumberLastFour) {
        this.cardNumberLastFour = cardNumberLastFour;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getGatewayToken() {
        return gatewayToken;
    }

    public void setGatewayToken(String gatewayToken) {
        this.gatewayToken = gatewayToken;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public PaymentCompany getPaymentCompany() {
        return paymentCompany;
    }

    public void setPaymentCompany(PaymentCompany paymentCompany) {
        this.paymentCompany = paymentCompany;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "PaymentProfile{" + "id=" + id + ", status='" + status + '\'' + ", holderName='" + holderName + '\''
                + ", registryCode='" + registryCode + '\'' + ", bankBranch='" + bankBranch + '\'' + ", bankAccount='"
                + bankAccount + '\'' + ", cardExpiration='" + cardExpiration + '\'' + ", cardNumberFixSix='"
                + cardNumberFixSix + '\'' + ", cardNumberLastFour='" + cardNumberLastFour + '\'' + ", token='" + token
                + '\'' + ", gatewayToken='" + gatewayToken + '\'' + ", type='" + type + '\'' + ", createdAt='"
                + createdAt + '\'' + ", updatedAt='" + updatedAt + '\'' + ", paymentCompany=" + paymentCompany
                + ", paymentMethod=" + paymentMethod + ", customerId=" + customerId + ", customer=" + customer + '}';
    }
}
