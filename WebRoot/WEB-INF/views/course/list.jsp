<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/inc/taglib.jsp" %>

<div class="dlist">
	<c:forEach items="${courses }" var="course" varStatus="st">
		<dl>
			<dt><a id="cmd_view" href="${_CTX_PATH_ }/course/view?id=${course.id}&platformId=${platformId}">${course.title }</a></dt>
			<dd>
				<ul class="con">
					<li>
						<strong>学习时间：</strong>
						<fmt:formatDate value="${course.startTime }" pattern="yyyy年MM月dd日"/> -
						<fmt:formatDate value="${course.endTime }" pattern="yyyy年MM月dd日"/>
					</li>
					<li><strong>发起人：</strong>${course.username }</li>
				</ul>
			</dd>
			<dd>
				<strong style="font-weight:normal; color: #333;">学习内容简介：</strong>
				${course.description }
			</dd>	
		</dl>
	</c:forEach>
</div>

<form method="post" name="pager" id="pager" class="page"><%@include file="/WEB-INF/inc/pager.inc" %></form>