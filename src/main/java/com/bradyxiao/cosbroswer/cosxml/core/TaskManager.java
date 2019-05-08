package com.bradyxiao.cosbroswer.cosxml.core;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;

import com.bradyxiao.cosbroswer.cosxml.QCloudClientException;
import com.bradyxiao.cosbroswer.cosxml.QCloudServerException;
import com.bradyxiao.cosbroswer.cosxml.core.QCloudHttpClient.Builder;
import com.bradyxiao.cosbroswer.cosxml.listener.QCloudResultListener;
import com.bradyxiao.cosbroswer.cosxml.model.QCloudRequest;
import com.bradyxiao.cosbroswer.cosxml.model.QCloudResponse;

import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

public class TaskManager {
	
	private QCloudHttpClient httpClient;
	private QCloudEventListener qCloudEventListener;
	
	public TaskManager(QCloudServiceConfig cloudServiceConfig) {
		QCloudHttpClient.Builder builder = new Builder()
				.proxy(cloudServiceConfig.proxy)
				.proxySelector(cloudServiceConfig.proxySelector)
				.cache(cloudServiceConfig.cache)
				.connectTimeout(cloudServiceConfig.connectTimeoutSecond)
				.readeTimeout(cloudServiceConfig.readTiemoutSecond)
				.writeTimeout(cloudServiceConfig.writeTimeoutSecond)
				.cookieJar(cloudServiceConfig.cookieJar)
				.dns(cloudServiceConfig.dns)
				.hostnameVerifier(cloudServiceConfig.hostnameVerifier)
				.sokcetFactory(cloudServiceConfig.socketFactory)
				.sslSocketFactory(cloudServiceConfig.sslSocketFactory, cloudServiceConfig.trustManager);
		for(Interceptor appInterceptor : cloudServiceConfig.applicationInterceptors) {
			builder.addInterceptor(appInterceptor);
		}
		for(Interceptor networkInterceptor : cloudServiceConfig.networkInterceptors) {
			builder.addNetworkInterceptor(networkInterceptor);
		}
		
		qCloudEventListener = new QCloudEventListener();
		builder.enventListener(qCloudEventListener);
		httpClient = builder.build();
	}
	
	public void execute(QCloudRequest request, QCloudResponse response) throws QCloudClientException, QCloudServerException{
		try {
			Request okHttpRequest = buildRealReqeust(request);
			Call call = httpClient.newCall(okHttpRequest);
			buildRealResponse(call.execute(), response);
		} catch (Exception e) {
			// TODO: handle exception
			if(e instanceof QCloudClientException) throw (QCloudClientException)e;
			if(e instanceof QCloudServerException) throw (QCloudServerException)e;
			throw new QCloudClientException(e);
		}

	}
	
	public void schedu(QCloudRequest request, QCloudResponse response, QCloudResultListener resultListener) {
		Request okHttpRequest = buildRealReqeust(request);
		Call call = httpClient.newCall(okHttpRequest);
	}
	
	private Request buildRealReqeust(QCloudRequest request) {
		return null;
	}
	
	private void buildRealResponse(Response okHttpesponse, QCloudResponse response) {
		
	}
}
