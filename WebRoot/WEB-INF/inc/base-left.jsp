<%@page import="com.dw.party.base.data.support.dto.UserPreferences"%>
<%@page import="com.dw.party.base.data.support.service.ISystemBaseService"%>
<%@ page import="org.springframework.context.ApplicationContext"%>
<%@ page
	import="org.springframework.web.context.support.WebApplicationContextUtils"%>

<%
	ApplicationContext contextLeft = WebApplicationContextUtils
			.getWebApplicationContext(getServletContext());
	ISystemBaseService systemBaseServiceLeft = (ISystemBaseService) contextLeft
			.getBean("systemBaseService");
	UserPreferences userLeft = (UserPreferences) session
			.getAttribute(com.dw.party.base.data.support.global.GlobalDefine.PAGE_SERVER_DEFINE.SESSION_USER);
	String userIdLeft = "";
	if (userLeft != null) {
		userIdLeft = userLeft.getUserId();
	}
	String platformId = (String)request.getAttribute("platformId");
	if(platformId == null || platformId.equals("")){
		platformId = (String)session.getAttribute("platformId");
	}
	String userMenuStyleLeft = request.getParameter("userMenuStyleLeft") == null ? com.dw.party.base.data.support.global.GlobalDefine.TACTICS_DEFINE.DEFAULT_STRING
			: request.getParameter("userMenuStyleLeft");
	out.print(systemBaseServiceLeft.findSysMenu(userIdLeft,platformId, userMenuStyleLeft));
%>