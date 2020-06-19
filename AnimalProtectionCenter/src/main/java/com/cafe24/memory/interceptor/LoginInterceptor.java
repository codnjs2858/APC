package com.cafe24.memory.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
@Component
public class LoginInterceptor implements HandlerInterceptor{
 @Override
 public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler)throws Exception{
	 HttpSession session=request.getSession();
	 String sessionId=(String)session.getAttribute("SID");
	 String sessionLevel=(String)session.getAttribute("SLEVEL");
	 String uri=request.getRequestURI();
	 if(sessionId==null) {
		 response.sendRedirect("/login");
		 return false;
	 }if(uri.equals("/admin")) {
		 if((sessionLevel.equals("level_code_03"))&&(sessionId!=null)) {
			 response.sendRedirect("/index");
			 return false; 
		 }
		 
	 }if(uri.equals("/")) {
		 if((sessionLevel.equals("level_code_04"))&&(sessionId!=null)) {
			 response.sendRedirect("/blacklistMemberAlert");
			 return false; 
		 }
	 }
	return HandlerInterceptor.super.preHandle(request, response, handler);	 
 }
}
