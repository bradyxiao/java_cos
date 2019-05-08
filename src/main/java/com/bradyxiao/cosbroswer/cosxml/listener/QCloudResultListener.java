package com.bradyxiao.cosbroswer.cosxml.listener;

import com.bradyxiao.cosbroswer.cosxml.QCloudClientException;
import com.bradyxiao.cosbroswer.cosxml.QCloudServerException;
import com.bradyxiao.cosbroswer.cosxml.model.QCloudRequest;
import com.bradyxiao.cosbroswer.cosxml.model.QCloudResponse;

public interface QCloudResultListener {
	
	void onSuccess(QCloudRequest request, QCloudResponse response);
	
	void onFailed(QCloudRequest request, QCloudClientException clientException, QCloudServerException serverException);

}
