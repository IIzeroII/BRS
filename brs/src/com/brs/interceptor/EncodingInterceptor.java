package com.brs.interceptor;

import com.brs.utils.GActionUtils;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;


public class EncodingInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		GActionUtils.getRequest().setCharacterEncoding("utf-8");
		GActionUtils.getResponse().setContentType("text/html;charset=UTF-8;");
		GActionUtils.getResponse().setCharacterEncoding("utf-8");
		return ai.invoke();
	}
	

}
