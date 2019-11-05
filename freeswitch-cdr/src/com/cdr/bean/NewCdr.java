package com.cdr.bean;

import java.util.Date;

/**
 * TODO:类功能介绍 1.话单实体类
 * 
 * @version 2019年11月1日下午5:55:36
 * @author 糟老头子
 */
public class NewCdr {

	private String uuid;// 话单唯一标识

	private String ani;// 主叫号

	private String dnis;// 被叫号

	private int callType;// 呼叫类型 1呼入，2呼出

	private int callDuraling;// 通话时长

	private Date startStamp;// 发起呼叫日期
	private Date endStamp;// 呼叫终止日期

	private int answerEpoch;// 呼叫应答时间(以毫秒为单位)
	private int startEpoch;// 通话开始时间
	private int endEpoch;// 通话结束时间

	private Date creatTime;// 创建时间
	private Date updateTime;// 修改时间

	private String value1;

	private String value2;

	private String value3;

	private String value4;

	public NewCdr() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getAni() {
		return ani;
	}

	public void setAni(String ani) {
		this.ani = ani;
	}

	public String getDnis() {
		return dnis;
	}

	public void setDnis(String dnis) {
		this.dnis = dnis;
	}

	public int getCallType() {
		return callType;
	}

	public void setCallType(int callType) {
		this.callType = callType;
	}

	public int getCallDuraling() {
		return callDuraling;
	}

	public void setCallDuraling(int callDuraling) {
		this.callDuraling = callDuraling;
	}

	public Date getStartStamp() {
		return startStamp;
	}

	public void setStartStamp(Date startStamp) {
		this.startStamp = startStamp;
	}

	public Date getEndStamp() {
		return endStamp;
	}

	public void setEndStamp(Date endStamp) {
		this.endStamp = endStamp;
	}

	public int getAnswerEpoch() {
		return answerEpoch;
	}

	public void setAnswerEpoch(int answerEpoch) {
		this.answerEpoch = answerEpoch;
	}

	public int getStartEpoch() {
		return startEpoch;
	}

	public void setStartEpoch(int startEpoch) {
		this.startEpoch = startEpoch;
	}

	public int getEndEpoch() {
		return endEpoch;
	}

	public void setEndEpoch(int endEpoch) {
		this.endEpoch = endEpoch;
	}

	public Date getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getValue1() {
		return value1;
	}

	public void setValue1(String value1) {
		this.value1 = value1;
	}

	public String getValue2() {
		return value2;
	}

	public void setValue2(String value2) {
		this.value2 = value2;
	}

	public String getValue3() {
		return value3;
	}

	public void setValue3(String value3) {
		this.value3 = value3;
	}

	public String getValue4() {
		return value4;
	}

	public void setValue4(String value4) {
		this.value4 = value4;
	}

}
