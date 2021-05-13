package com.spring.nemo.soap_service_demo_client.model;

public class ResponseData<T> {
	private int status;
	private T data;
	public ResponseData(int status, T data) {
		super();
		this.status = status;
		this.data = data;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "ResponseData [status=" + status + ", data=" + data + "]";
	}
	
	
}
