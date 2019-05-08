package com.bradyxiao.cosbroswer.cosxml.common;

public class ErrorInfo {
	
	public String requestId;
	public String traceId;
	public String source;
	public String server;
	public String errorCode;
	public String errorMessage;
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder detial = new StringBuilder();
		detial.append("error code: ").append(errorCode)
		.append(", ")
		.append("error message: ").append(errorMessage)
		.append(", ")
		.append("requestId: ").append(requestId)
		.append(", ")
		.append("traceId: ").append(traceId)
		.append(", ")
		.append("source: ").append(source)
		.append(", ")
		.append("server: ").append(server);
		return detial.toString();
	}
}
