package com.cdr.util;

/**
 * 响应码状态说明
 * 
 * @author PCyzh
 *
 */
public enum CodeEnum {

	SUCCESS(200, "OK"), FAIL(1, "失败，未知错误！"),;

	//响应码
	private final int code;

	//响应提示
	private final String msg;

	CodeEnum(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

}
