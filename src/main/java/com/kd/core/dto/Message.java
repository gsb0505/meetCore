package com.kd.core.dto;

/**
 * User: zongxu
 * Date: 15-1-14
 */
public abstract class Message {
    /**
     * 3．包文头组成形式：交易码（3位）＋
     * 电文长度（9位）＋供电分局编号(4位)＋交易流水号（26位）＋响应码（3位）＋响应信息（20位）。
     */
    public static final String separator = "!@!";
    // 交易码
    private String transactionCode;
    //电文长度
    private String bodyLength;
    // 供电分局编号
    private String branchNumber;
    // 流水号（1位第三方编号 + 5位网点号 + 5位柜员号 + 8位业务日期 + 7位随机流水号）
    private String traceNumber;
    // 响应码
    private String responseCode;
    // 响应信息
    private String responseBody;

    public String getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(String transactionCode) {
        this.transactionCode = transactionCode;
    }

    public String getBodyLength() {
        return bodyLength;
    }

    public void setBodyLength(String bodyLength) {
        this.bodyLength = bodyLength;
    }

    public String getBranchNumber() {
        return branchNumber;
    }

    public void setBranchNumber(String branchNumber) {
        this.branchNumber = branchNumber;
    }

    public String getTraceNumber() {
        return traceNumber;
    }

    public void setTraceNumber(String traceNumber) {
        this.traceNumber = traceNumber;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    public abstract String getType();

    protected int len;
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getBranchNumber())
                .append(getTraceNumber())
               .append(getResponseCode())
                .append(getResponseBody());
        return sb.toString();
    }

    protected String formatBodyLen(int len) {
        StringBuilder lenStr = new StringBuilder(Integer.toString(len));
        for (int i = 9 - lenStr.length(); i > 0; i--) {
            lenStr.insert(0,"0");
        }

        return lenStr.toString();
    }
}
