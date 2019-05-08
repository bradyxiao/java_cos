package com.bradyxiao.cosbroswer.cosxml;

public class QCloudClientException extends Exception {
	public QCloudClientException() {
		super();
	}
	
	public QCloudClientException(String message) {
		super(message);
	}
	
	public QCloudClientException(Throwable cause) {
		super(cause);
	}
	
	public QCloudClientException(String message, Throwable cause) {
		super(message, cause);
	}
}
