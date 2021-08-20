package com.gitee.fun2code.jobs.iso8583;

import java.math.BigDecimal;

public class Iso8583Entity {
    /* 卡号 */
    public String primaryAccountNumber;
    /* 交易处理码，6位数字 */
    public Integer processingCode;
    /* 交易金额，保留两位小数 */
    public BigDecimal amountTransaction;
    /* 交易传输时间，MMDDhhmmss */
    public String transmissionDate;
    /* 系统跟踪号，6位数字 */
    public Integer systemTraceAuditNumber;
    /* 卡有效期 */
    public String dateExpiration;
    /* 商户类型mcc */
    public String merchantType;
    /* 服务点输入方式码 */
    public String pointOfServiceEntryModeCode;
    /* 商户编码，15位 */
    public String cardAcceptorIdentificationCode;
    /* 受卡方名称地址 */
    public String cardAcceptorNameLocation;
    /* 交易货币 */
    public String currencyCode;

    public String getPrimaryAccountNumber() {
        return primaryAccountNumber;
    }

    public void setPrimaryAccountNumber(String primaryAccountNumber) {
        this.primaryAccountNumber = primaryAccountNumber;
    }

    public Integer getProcessingCode() {
        return processingCode;
    }

    public void setProcessingCode(Integer processingCode) {
        this.processingCode = processingCode;
    }

    public BigDecimal getAmountTransaction() {
        return amountTransaction;
    }

    public void setAmountTransaction(BigDecimal amountTransaction) {
        this.amountTransaction = amountTransaction;
    }

    public String getTransmissionDate() {
        return transmissionDate;
    }

    public void setTransmissionDate(String transmissionDate) {
        this.transmissionDate = transmissionDate;
    }

    public Integer getSystemTraceAuditNumber() {
        return systemTraceAuditNumber;
    }

    public void setSystemTraceAuditNumber(Integer systemTraceAuditNumber) {
        this.systemTraceAuditNumber = systemTraceAuditNumber;
    }

    public String getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(String dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public String getMerchantType() {
        return merchantType;
    }

    public void setMerchantType(String merchantType) {
        this.merchantType = merchantType;
    }

    public String getPointOfServiceEntryModeCode() {
        return pointOfServiceEntryModeCode;
    }

    public void setPointOfServiceEntryModeCode(String pointOfServiceEntryModeCode) {
        this.pointOfServiceEntryModeCode = pointOfServiceEntryModeCode;
    }

    public String getCardAcceptorIdentificationCode() {
        return cardAcceptorIdentificationCode;
    }

    public void setCardAcceptorIdentificationCode(String cardAcceptorIdentificationCode) {
        this.cardAcceptorIdentificationCode = cardAcceptorIdentificationCode;
    }

    public String getCardAcceptorNameLocation() {
        return cardAcceptorNameLocation;
    }

    public void setCardAcceptorNameLocation(String cardAcceptorNameLocation) {
        this.cardAcceptorNameLocation = cardAcceptorNameLocation;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
}
