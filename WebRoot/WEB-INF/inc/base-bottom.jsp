<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="org.springframework.context.ApplicationContext"%>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page import="com.dw.party.base.data.support.service.ISystemBaseService"%>
<%@ page import="com.dw.party.base.data.support.dto.UserPreferences"%>
<%
	ApplicationContext contextBottom = WebApplicationContextUtils
			.getWebApplicationContext(getServletContext());
	ISystemBaseService systemBaseServiceBottom = (ISystemBaseService) contextBottom
			.getBean("systemBaseService");
	UserPreferences userBottom = (UserPreferences) session
			.getAttribute(com.dw.party.base.data.support.global.GlobalDefine.PAGE_SERVER_DEFINE.SESSION_USER);
	String userIdBottom = "";
	if (userBottom != null) {
		userIdBottom = userBottom.getUserId();
	}
	out.print(systemBaseServiceBottom.findFooter(userIdBottom));
%>