package com.bradyxiao.cosbroswer.cosxml.core;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.concurrent.TimeUnit;

import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.CookieJar;
import okhttp3.Dns;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public final class QCloudHttpClient {
	
	/**
	 * okhttp 内部执行任务是否有一个线程池，其实用于跑异步请求的，{@link okhttp3.Dispatch}
	 * @author bradyxiao
	 *
	 */
	private final OkHttpClient httpClient;
	
	QCloudHttpClient(Builder builder) {
		// TODO Auto-generated constructor stub
		httpClient = builder.okhttpClientBuilder.build();
	}
	
	public Call newCall(Request request) {
		return httpClient.newCall(request);
	}
	
	public static class Builder{
		OkHttpClient.Builder okhttpClientBuilder;
		
		public Builder() {
			okhttpClientBuilder = new OkHttpClient.Builder();
		}
		
		//指定固定代理
		public Builder proxy(Proxy proxy) {
			okhttpClientBuilder.proxy(proxy);
			return this;
		}
		
		//自动选择代理
		public Builder proxySelector(ProxySelector proxySelector) {
			okhttpClientBuilder.proxySelector(proxySelector);
			return this;
		}
		
		//设置cache策略
		public Builder cache(Cache cache) {
			okhttpClientBuilder.cache(cache);
			return this;
		}
		
		//设置 cookie 处理
		public Builder cookieJar(CookieJar cookieJar) {
			okhttpClientBuilder.cookieJar(cookieJar);
			return this;
		}
		
		//设置DNS
		public Builder dns(Dns dns) {
			okhttpClientBuilder.dns(dns);
			return this;
		}
		
		//设置请求-响应事件监听器
		public Builder enventListener(EventListener eventListener) {
			okhttpClientBuilder.eventListener(eventListener);
			return this;
		}
		
		//设置application interceptor
		public Builder addInterceptor(Interceptor interceptor) {
			okhttpClientBuilder.addInterceptor(interceptor);
			return this;
		}
		
		//设置network interceptor
		public Builder addNetworkInterceptor(Interceptor interceptor) {
			okhttpClientBuilder.addNetworkInterceptor(interceptor);
			return this;
		}
		
		//设置sokcetFactory
		public Builder sokcetFactory(SocketFactory socketFactory) {
			okhttpClientBuilder.socketFactory(socketFactory);
			return this;
		}
		
		//设置 sslSocketFactory
		public Builder sslSocketFactory(SSLSocketFactory sslSocketFactory, X509TrustManager trustManager) {
			okhttpClientBuilder.sslSocketFactory(sslSocketFactory, trustManager);
			return this;
		}
		
		//设置hostName verifier
		public Builder hostnameVerifier(HostnameVerifier hostnameVerifier) {
			okhttpClientBuilder.hostnameVerifier(hostnameVerifier);
			return this;
		}
		
		//设置 connect timeout
		public Builder connectTimeout(int timeoutSecond) {
			if(timeoutSecond > 0) {
				okhttpClientBuilder.connectTimeout(timeoutSecond, TimeUnit.SECONDS);
			}
			return this;
		}
		
		//设置write timeout
		public Builder writeTimeout(int timeoutSecond) {
			if(timeoutSecond > 0) {
				okhttpClientBuilder.writeTimeout(timeoutSecond, TimeUnit.SECONDS);
			}
			return this;
		}
		
		//设置 read timeout
		public Builder readeTimeout(int timeoutSecond) {
			if(timeoutSecond > 0) {
				okhttpClientBuilder.readTimeout(timeoutSecond, TimeUnit.SECONDS);
			}
			return this;
		}
		
		public QCloudHttpClient build() {
			return new QCloudHttpClient(this);
		}
	}
	
}
