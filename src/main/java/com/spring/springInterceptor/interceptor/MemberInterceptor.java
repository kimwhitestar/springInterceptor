package com.spring.springInterceptor.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MemberInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(MemberInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, 
		Object handler) throws Exception {
		logger.info("##### MemberInterceptor.preHandle() #####");

//		HttpSession session = request.getSession();
//		int sLevel = session.getAttribute("sLevel")==null?99:Integer.parseInt((String)session.getAttribute("sLevel"));
//		
//		if (3 < sLevel) { //정회원 : 3
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/msg/levelLow");
//			dispatcher.forward(request, response);
//			return false; //컨트롤러로 안가도록 Interceptor처리됨. (모든 메뉴 접근 금지)
//		}
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, 
		Object handler, ModelAndView modelAndView) throws Exception {
		logger.info("##### MemberInterceptor.postHandle() #####");
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, 
		Object handler, Exception ex) throws Exception {
		logger.info("##### MemberInterceptor.afterCompletion() #####");
	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, 
		Object handler) throws Exception {
		logger.info("##### MemberInterceptor.afterConcurrentHandlingStarted() #####");
	}
}