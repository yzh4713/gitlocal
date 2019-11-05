package com.cdr.bean;

import java.util.Date;

public class CrmRecord {
    private String recordId;

    private String tenantId;

    private String userCode;

    private String organId;

    private String userId;

    private Date createTime;

    private String agentId;

    private String platformType;

    private String recordPlatformId;

    private String serviceId;

    private String callId;

    private Date connectTime;

    private String dnis;

    private String ani;

    private String customerId;

    private Byte callType;

    private Date disconnectTime;

    private Long recordduration;

    private String originUuid;

    private String uuid;

    private String phoneStatus;

    private String phonePlatform;

    private String servId;

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId == null ? null : recordId.trim();
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    public String getOrganId() {
        return organId;
    }

    public void setOrganId(String organId) {
        this.organId = organId == null ? null : organId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId == null ? null : agentId.trim();
    }

    public String getPlatformType() {
        return platformType;
    }

    public void setPlatformType(String platformType) {
        this.platformType = platformType == null ? null : platformType.trim();
    }

    public String getRecordPlatformId() {
        return recordPlatformId;
    }

    public void setRecordPlatformId(String recordPlatformId) {
        this.recordPlatformId = recordPlatformId == null ? null : recordPlatformId.trim();
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId == null ? null : serviceId.trim();
    }

    public String getCallId() {
        return callId;
    }

    public void setCallId(String callId) {
        this.callId = callId == null ? null : callId.trim();
    }

    public Date getConnectTime() {
        return connectTime;
    }

    public void setConnectTime(Date connectTime) {
        this.connectTime = connectTime;
    }

    public String getDnis() {
        return dnis;
    }

    public void setDnis(String dnis) {
        this.dnis = dnis == null ? null : dnis.trim();
    }

    public String getAni() {
        return ani;
    }

    public void setAni(String ani) {
        this.ani = ani == null ? null : ani.trim();
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId == null ? null : customerId.trim();
    }

    public Byte getCallType() {
        return callType;
    }

    public void setCallType(Byte callType) {
        this.callType = callType;
    }

    public Date getDisconnectTime() {
        return disconnectTime;
    }

    public void setDisconnectTime(Date disconnectTime) {
        this.disconnectTime = disconnectTime;
    }

    public Long getRecordduration() {
        return recordduration;
    }

    public void setRecordduration(Long recordduration) {
        this.recordduration = recordduration;
    }

    public String getOriginUuid() {
        return originUuid;
    }

    public void setOriginUuid(String originUuid) {
        this.originUuid = originUuid == null ? null : originUuid.trim();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getPhoneStatus() {
        return phoneStatus;
    }

    public void setPhoneStatus(String phoneStatus) {
        this.phoneStatus = phoneStatus == null ? null : phoneStatus.trim();
    }

    public String getPhonePlatform() {
        return phonePlatform;
    }

    public void setPhonePlatform(String phonePlatform) {
        this.phonePlatform = phonePlatform == null ? null : phonePlatform.trim();
    }

    public String getServId() {
        return servId;
    }

    public void setServId(String servId) {
        this.servId = servId == null ? null : servId.trim();
    }
}