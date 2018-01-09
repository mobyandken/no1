package cn.itcast.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.pojo.User;

public class Interceptor implements HandlerInterceptor{

	//处理之前
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {

		String requestURI = request.getRequestURI();
		if(!requestURI.contains("login")){
			Object user = request.getSession().getAttribute("loginUser");
			if(user==null){
				//未登录
				response.sendRedirect(request.getContextPath()+"/login");
				return false;
			}
		}
		
		
		return true;
	}

	//处理之后
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	//结果处理
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
