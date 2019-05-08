package com.bradyxiao.cosbroswer.cosxml;

import com.bradyxiao.cosbroswer.cosxml.common.ErrorInfo;

public class QCloudServerException extends Exception {
	public int code;
	public String message;
	public ErrorInfo errorInfo;
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage() + "(code: " + code
				+ ", message: " + message
				+ ", error: " + errorInfo.toString()
				+ ")";
	}
}
