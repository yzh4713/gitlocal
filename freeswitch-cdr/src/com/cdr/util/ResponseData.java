package com.cdr.util;

/**
 * 响应数据结构封装
 * 
 * @param data
 */
public class ResponseData<T> extends BaseResponse {
	private T data;

	private ResponseData() {
	}

	private ResponseData(CodeEnum code, T data) {
		super(code);
		this.data = data;
	}

	public static <T> ResponseData<T> out(CodeEnum code, T data) {
		return new ResponseData<T>(code, data);
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}