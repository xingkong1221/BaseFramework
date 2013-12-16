<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/WEB-INF/inc/header.jsp" %>
<title>组织学习管理</title>
<script src="${_CTX_PATH_ }/js/course/admin/index.js" type="text/javascript"></script>
</head>
<body>
	<div class="headBg">
		<c:import url="/WEB-INF/inc/base-top.jsp">
			<c:param name="userMenuStyle" value="zhuzhixuexi" />
		</c:import>
	</div>
	<div class="main cf">
		<c:import url="/WEB-INF/inc/base-left.jsp"></c:import>
		<div class="content">
			<div class="title"><strong>组织学习</strong><div class="rt"><a href="${_CTX_PATH_ }/course/admin/add" class="title_btn"><span>创建学习课程</span></a></div></div>
			<div id="disp_list"><%@include file="list.jsp" %></div>
		</div>
	</div>
	<c:import url="/WEB-INF/inc/base-bottom.jsp" />
</body>
</html>