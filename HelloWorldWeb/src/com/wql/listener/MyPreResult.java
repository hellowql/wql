package com.wql.listener;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.PreResultListener;

public class MyPreResult implements PreResultListener {

	@Override
	public void beforeResult(ActionInvocation action, String result) {
		System.out.println("���ڴ���Resultִ��ǰ�Ĺ��ܣ�result="+result);
	}

}
