package com.spring.springInterceptor.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class Level2Interceptor extends HandlerInterceptorAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(Level1Interceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, 
		Object handler) throws Exception {
		logger.info("##### Level2Interceptor.preHandle() #####");

		HttpSession session = request.getSession();
		int sLevel = session.getAttribute("sLevel")==null?0:Integer.parseInt((String)session.getAttribute("sLevel"));
		
		/*
		 * 게시판(board) 기본 구역은 세션 slevel 이 2이상만 사용가능.
		 */
		if (2 > sLevel) { //2레벨 미만 Interceptor
			RequestDispatcher dispatcher = request.getRequestDispatcher("/msg/levelLow");
			dispatcher.forward(request, response);
			return false; //컨트롤러로 안가도록 Interceptor처리됨. (게시판 메뉴 사용 금지)
		}
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, 
		Object handler, ModelAndView modelAndView) throws Exception {
		logger.info("##### Level2Interceptor.postHandle() #####");
		
		
	}
}