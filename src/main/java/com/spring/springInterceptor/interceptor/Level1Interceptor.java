package com.spring.springInterceptor.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class Level1Interceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(Level1Interceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, 
		Object handler) throws Exception {
		logger.info("##### Level1Interceptor.preHandle() #####");

		HttpSession session = request.getSession();
		int sLevel = session.getAttribute("sLevel")==null?0:Integer.parseInt((String)session.getAttribute("sLevel"));
		
		/*
		 * 회원(member) 기본 구역은 세션 slevel 이 1이상만 사용가능.
		 * 회원방(mMain), 회원정보수정(mUpdate)
		 */
		if (1 > sLevel) { //1레벨 미만 Interceptor
			//회원방 메뉴 사용 금지(회원가입,로그인,방명록은 servlet-context.xml interceptor에서 제외처리)
			RequestDispatcher dispatcher = request.getRequestDispatcher("/msg/levelLow");
			dispatcher.forward(request, response);
			return false; //컨트롤러로 안가도록 Interceptor처리됨. 
		}
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, 
		Object handler, ModelAndView modelAndView) throws Exception {
		logger.info("##### Level1Interceptor.postHandle() #####");
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, 
		Object handler, Exception ex) throws Exception {
		logger.info("##### Level1Interceptor.afterCompletion() #####");
	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, 
		Object handler) throws Exception {
		logger.info("##### Level1Interceptor.afterConcurrentHandlingStarted() #####");
	}
}