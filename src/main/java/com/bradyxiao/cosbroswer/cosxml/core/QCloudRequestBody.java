package com.bradyxiao.cosbroswer.cosxml.core;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;

public class QCloudRequestBody extends RequestBody{
	
	private byte[] bytes;
	private File file;
	private String contentType;
	private long offset = 0L;
	private long contentLength = -1L;

	QCloudRequestBody(String contentType, long offset, long contentLength) {
		// TODO Auto-generated constructor stub
    	this.contentType = contentType;
    	this.offset = offset > 0 ? offset : 0;
    	this.contentLength = contentLength > 0 ? contentLength : -1L;
	}
	
    public QCloudRequestBody(byte[] bytes, String contentType, int offset, int counts) {
		// TODO Auto-generated constructor stub
    	this.bytes = bytes;
    	this.contentType = contentType;
    	this.offset = offset > 0 ? offset : 0;
    	this.contentLength = counts > 0 ? counts : -1L;
	}
    
    public QCloudRequestBody(File file, String contentType, long offset, long contentLength) {
		// TODO Auto-generated constructor stub
    	this.file = file;
    	this.contentType = contentType;
    	this.offset = offset > 0 ? offset : 0;
    	this.contentLength = contentLength > 0 ? contentLength : -1L;
	}
    
    private long getRealContentLength() {
    	long rawLength = 0L;
    	if(bytes != null) {
    		rawLength = bytes.length;
    	}else if (file !=  null) {
			rawLength = file.length();
		}
    	if(rawLength - offset < contentLength) {
    		contentLength = rawLength - offset;
    	}
    	return contentLength;
    }
    
    private InputStream getRawInputStream() throws IOException {
    	InputStream result = null;
    	if(bytes != null) {
    		result = new ByteArrayInputStream(bytes);
    	}else if(file != null) {
    		result = new FileInputStream(file);
		}
    	if(offset > 0) {
    		result.skip(offset);
    	}
    	return result;
    }

	@Override
	public MediaType contentType() {
		// TODO Auto-generated method stub
		return MediaType.parse(contentType);
	}

	@Override
	public void writeTo(BufferedSink sink) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public long contentLength() throws IOException {
		// TODO Auto-generated method stub
		return getRealContentLength();
	}
	
	

}
