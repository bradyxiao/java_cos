package com.bradyxiao.cosbroswer.cosxml.core;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.List;

import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

import okhttp3.Cache;
import okhttp3.CookieJar;
import okhttp3.Dns;
import okhttp3.Interceptor;

public final class QCloudServiceConfig {
	
	Proxy proxy;
	ProxySelector proxySelector;
	Cache cache;
	CookieJar cookieJar;
	Dns dns;
	SocketFactory socketFactory;
	SSLSocketFactory sslSocketFactory;
	X509TrustManager trustManager;
	HostnameVerifier hostnameVerifier;
	int connectTimeoutSecond;
	int readTiemoutSecond;
	int writeTimeoutSecond;
	List<Interceptor> applicationInterceptors;
	List<Interceptor> networkInterceptors;
	
	public QCloudServiceConfig() {
		applicationInterceptors = new ArrayList<Interceptor>();
		networkInterceptors = new ArrayList<Interceptor>();
	}
	
	//指定固定代理
	public void setProxy(Proxy proxy) {
		this.proxy = proxy;
	}
	
	//自动选择代理
	public void setProxySelector(ProxySelector proxySelector) {
		this.proxySelector = proxySelector;
	}
	
	//设置cache策略
	public void cache(Cache cache) {
		this.cache = cache;
	}
	
	//设置 cookie 处理
	public void setCookieJar(CookieJar cookieJar) {
		this.cookieJar = cookieJar;
	}
	
	//设置DNS
	public void dns(Dns dns) {
		this.dns = dns;
	}
	
	//设置application interceptor
	public void addInterceptor(Interceptor interceptor) {
		applicationInterceptors.add(interceptor);
	}
	
	//设置network interceptor
	public void addNetworkInterceptor(Interceptor interceptor) {
		networkInterceptors.add(interceptor);
	}

	//设置sokcetFactory
	public void setSocketFactory(SocketFactory socketFactory) {
		this.socketFactory = socketFactory;
	}
	
	//设置 sslSocketFactory
	public void sslSocketFactory(SSLSocketFactory sslSocketFactory, X509TrustManager trustManager) {
		this.sslSocketFactory = sslSocketFactory;
		this.trustManager = trustManager;
	}
	
	//设置hostName verifier
	public QCloudServiceConfig hostnameVerifier(HostnameVerifier hostnameVerifier) {
		this.hostnameVerifier = hostnameVerifier;
		return this;
	}
	
	//设置 connect timeout
	public void setConnectTimeout(int timeoutSecond) {
		this.connectTimeoutSecond = timeoutSecond;
	}
	
	//设置write timeout
	public void setWriteTimeout(int timeoutSecond) {
		this.writeTimeoutSecond = timeoutSecond;
	}
	
	//设置 read timeout
	public void setReadTimeout(int timeoutSecond) {
		this.readTiemoutSecond = timeoutSecond;
	}
}
