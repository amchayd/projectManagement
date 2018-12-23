package pmo.gp.actions;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class Intercepteur implements Interceptor{

	private static final long serialVersionUID = 1L;

	public String intercept(ActionInvocation invocation) throws Exception{
		System.out.println("Inside Interceptor: Preprocessing");
		String result=invocation.invoke();
		System.out.println("Exiting Interceptor: Postprocessing");
		return result;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

}
