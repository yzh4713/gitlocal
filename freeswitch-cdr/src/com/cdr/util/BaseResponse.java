package com.cdr.util;

/**
 * 基本响应封装
 * 
 * @author PCyzh
 *
 */
public class BaseResponse {
	/**
	 * 响应码
	 */
	private int code;
	/**
	 * 响应消息
	 */
	private String msg;

	protected BaseResponse() {
	}

	protected BaseResponse(CodeEnum code) {
		this.code = code.getCode();
		this.msg = code.getMsg();
	}

	public static BaseResponse out(CodeEnum code) {
		return new BaseResponse(code);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}