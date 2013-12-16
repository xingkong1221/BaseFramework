<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/WEB-INF/inc/header.jsp" %>
<title>组织学习</title>

</head>
<body>
	<div class="headBg">
		<c:import url="/WEB-INF/inc/base-top.jsp">
			<c:param name="userMenuStyle" value="zhuzhixuexi" />
		</c:import>
	</div>
	<div class="main cf">
		<%@include file="/WEB-INF/inc/myinfo.jsp" %>
		<div class="content">
			<div class="title"><strong>学习内容介绍</strong></div>
			<div class="studyBox">
				<input id="id" name="id" value="652" type="hidden">
				<div class="fl">
					<dl>
						<dt>学习内容</dt>
						<dd>${course.title }</dd>
						<dt>时间安排</dt>
						<dd>
							<fmt:formatDate value="${course.startTime }" pattern="yyyy年MM月dd日" />
							- 
							<fmt:formatDate value="${course.endTime }" pattern="yyyy年MM月dd日" />
						</dd>
						<dt>发起人</dt>
						<dd>${course.username }</dd>
					</dl>
				</div>
				<div class="fr">
					<div class="modox">
						<div class="modoxBg">
							<dl>
								<dt>学习内容介绍</dt>
								<dd>
									${course.description }
								</dd>
							</dl>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="/WEB-INF/inc/base-bottom.jsp" %>
</body>
</html>