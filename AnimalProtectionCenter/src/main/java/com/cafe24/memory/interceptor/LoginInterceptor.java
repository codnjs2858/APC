package com.cafe24.memory.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.cafe24.memory.domain.Adoptee;
import com.cafe24.memory.service.AdopteeService;
import com.cafe24.memory.service.MemberService;

@Component
public class LoginInterceptor implements HandlerInterceptor{
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	AdopteeService adopteeService;
	
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler)throws Exception{
		memberService.projectMode(request);
		
		HttpSession session=request.getSession();
		String sessionId=(String)session.getAttribute("SID");
		String sessionLevel=(String)session.getAttribute("SLEVEL");
		String uri=request.getRequestURI();
		if(sessionId==null) {
			response.sendRedirect("/member/login");
		
			return false;
		}else {
			if(uri.equals("/admin")) {
				if((sessionLevel.equals("level_code_03"))) {
					response.sendRedirect("/index");
					
					return false; 
				} 
			}else if(uri.equals("/")) {
				if((sessionLevel.equals("level_code_04"))) {
					response.sendRedirect("/member/blacklistMemberAlert");
					
					return false; 
				}
			}else if(uri.equals("/adoption/adoptionApply")) {
				Adoptee adoptee = adopteeService.selectAdopteeById(sessionId);
				if(adoptee == null) {
					response.sendRedirect("/adoption/adoptionReview");
					
					return false;
				}else if(!"screening_complete_code_01".equals(adoptee.getScreeningComplete().getScreening_complete_code())){
					response.sendRedirect("/adoption/adoptionReview");
					
					return false;
				}
			}
		}
		 
	 	return HandlerInterceptor.super.preHandle(request, response, handler);	 
	}
	
}
