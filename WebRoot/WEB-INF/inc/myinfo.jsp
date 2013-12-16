<%@page import="com.dw.party.base.data.support.dto.UserPreferences"%>
<%@page import="com.dw.party.base.data.support.service.ISystemBaseService"%>
<%@page import="com.dw.party.base.data.support.global.GlobalDefine"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="org.springframework.context.ApplicationContext"%>
<%@ page
	import="org.springframework.web.context.support.WebApplicationContextUtils"%>

<%
	ApplicationContext context = WebApplicationContextUtils
			.getWebApplicationContext(getServletContext());
	ISystemBaseService systemBaseService = (ISystemBaseService) context
			.getBean("systemBaseService");
	UserPreferences user = (UserPreferences) session
			.getAttribute(GlobalDefine.PAGE_SERVER_DEFINE.SESSION_USER);
	String userId = "";
	if (user != null) {
		userId = user.getUserId();
	}
	out.print(systemBaseService.findMyLeft(userId));
%>