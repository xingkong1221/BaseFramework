<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>组织学习管理</title>
<%@include file="/WEB-INF/inc/header.jsp" %>
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
			<div class="title"><strong>添加学习课程</strong></div>
			
			<form:form method="POST" modelAttribute="course">
				<form:hidden path="createUserId" />
				<form:hidden path="createTime"/>
				<form:hidden path="username" />
				<form:hidden path="organId" />
				<div class="cre_form">
				<div class="form_list">
					<form:label path="title"><span class="red">*</span>学习名称：</form:label>
					<form:input path="title" cssClass="input_t width200 validate[required]"/>
					<form:errors path="title"/>
				</div>
				<div class="form_list">
					<form:label path="startTime"><span class="red">*</span>学习时间：</form:label>
					<form:input path="startTime" cssClass="validate[required] text-input datepicker"/>
					<form:errors path="startTime" /> - 
					<form:input path="endTime" cssClass="validate[required] text-input datepicker"/>
					<form:errors path="endTime" />
					
				</div>
				<div class="form_list">
					<form:label path="description" cssClass="special"><span class="red">*</span>学习介绍：</form:label>
					<form:textarea path="description" cssClass="validate[required,maxSize[2000]]"/>
					<form:errors path="description"/>
				</div>
				<div class="submit">
					<button type="submit">提交</button>
				</div>
			</div>
		</form:form>
		</div>
	</div>

<script type="text/javascript">
	$(document).ready(function() {
		baseDialog.init();
		$("#course").validationEngine();
		$("#startTime").datepicker({
			showOn: "both",
			buttonImage: "/hw_study_test/image/calendar.gif",
			buttonImageOnly: true,
			minDate: new Date()
		});
		$("#endTime").datepicker({
			showOn: "both",
			buttonImage: "/hw_study_test/image/calendar.gif",
			buttonImageOnly: true,
			minDate: new Date()
		});
	});
</script>
</body>
</html>