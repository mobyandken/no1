package cn.itcast.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class CustomerExceptionResolver implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object obj,
			Exception e) {
		ModelAndView av = new ModelAndView();
		if(e instanceof CustomException){
			av.addObject("error", ((CustomException)e).getMsg());
			
		}else{
			av.addObject("error", "出hai错啦");
		}
		av.setViewName("error");
		
		return av;
	}

}
