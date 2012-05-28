package com.wql.interceptor;

import java.util.Map;

import org.apache.struts2.dispatcher.ServletDispatcherResult;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LogginInterceptor implements Interceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("begin------------------------");
		System.out.println("Action:"+invocation.getAction().getClass().getName());
		System.out.println("Method:"+invocation.getProxy().getMethod());
		Map<String,Object> params=invocation.getInvocationContext().getParameters();
		for(String key:params.keySet()){
			Object obj=params.get(key);
			if(obj instanceof String[]){
				String[] arr=(String[])obj;
				System.out.println("Pram:"+key);
				for(String value:arr){
					System.out.println(value);
				}
			}
		}
		String result=invocation.invoke();
		Result rresult=invocation.getResult();
		if(rresult instanceof ServletDispatcherResult){
			ServletDispatcherResult res=(ServletDispatcherResult)rresult;
			System.out.println("JSP:"+res.getLastFinalLocation());
		}
		System.out.println("end==------------------------");
		return result;
	}

}
