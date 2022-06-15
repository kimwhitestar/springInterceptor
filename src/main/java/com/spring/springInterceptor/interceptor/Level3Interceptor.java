package com.spring.springInterceptor.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class Level3Interceptor extends HandlerInterceptorAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(Level1Interceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, 
		Object handler) throws Exception {
		logger.info("##### Level3Interceptor.preHandle() #####");

		HttpSession session = request.getSession();
		int sLevel = session.getAttribute("sLevel")==null?0:Integer.parseInt((String)session.getAttribute("sLevel"));
		
		/*
     * 게시판(board)의 '삭제(delete)'는 세션 slevel 3이상만 허용.
		 * 자료실(pds)의 기본 구간은 세션 slevel 3이상만 허용.
		 */
		if (3 > sLevel) { //레벨 미만 Interceptor
			RequestDispatcher dispatcher = request.getRequestDispatcher("/msg/levelLow");
			dispatcher.forward(request, response);
			return false; //컨트롤러로 안가도록 Interceptor처리됨. (자료실 메뉴 사용 금지)
		}
		return true;
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, 
		Object handler, ModelAndView modelAndView) throws Exception {
		logger.info("##### Level3Interceptor.postHandle() #####");
		
		
	}
}