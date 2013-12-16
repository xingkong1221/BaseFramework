<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="org.springframework.context.ApplicationContext"%>
<%@page import="com.dw.party.base.data.support.dto.UserPreferences"%>
<%@page import="com.dw.party.base.data.support.service.ISystemBaseService"%>

<%
	ApplicationContext context = WebApplicationContextUtils
			.getWebApplicationContext(getServletContext());
	ISystemBaseService systemBaseService = (ISystemBaseService) context
			.getBean("systemBaseService");
	UserPreferences user = (UserPreferences) session
			.getAttribute(com.dw.party.base.data.support.global.GlobalDefine.PAGE_SERVER_DEFINE.SESSION_USER);
	String userId = "";
	if (user != null) {
		userId = user.getUserId();
	}
	String platformId = (String)request.getAttribute("platformId");
	if(platformId == null || platformId.equals("")){
		platformId = (String)session.getAttribute("platformId");
	}
	String userMenuStyle = request.getParameter("userMenuStyle") == null ? com.dw.party.base.data.support.global.GlobalDefine.TACTICS_DEFINE.DEFAULT_STRING
			: request.getParameter("userMenuStyle");
	out.print(systemBaseService.findHeader(userId, platformId, userMenuStyle));
%>