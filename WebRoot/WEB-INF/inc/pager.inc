<%@page pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/inc/base-tag.inc" %>
<a id="_pre" href="#">&lt; 上一页</a>
<c:forEach  items="${pager.pageths}" var="item" varStatus="st">
	<c:if test="${st.index == pager.pageths.size()-1 and pager.pageths.size()>1 and pager.pageths[pager.pageths.size()-2] != pager.pageCount-1}">．．．</c:if>
	<a id='item${item}' class="${pager.pageth == item ? 'on' : '' }" href="#">${item}</a>
	<c:if test="${st.index == 0 and pager.pageths.size()>2 and pager.pageths[1] != 2}">．．．</c:if>
</c:forEach>
<a id="_next" href="#">下一页 &gt;</a>
<input id="_jump" type="text" style="display:none;"/>
<input id="_pageCount" name="pageCount" value="${pager.pageCount }" type="hidden"/>
<input id="_pageth" name="pageth" value="${pager.pageth }" type="hidden"/>
<input id="_rowCount" name="rowCount" value="${pager.rowCount }" type="hidden"/>
<input id="_sort" name="sort" value="${pager.sort }" type="hidden"/>
<input id="_dir" name="dir" value="${pager.dir }" type="hidden"/>
<input id="_pageSize" name="pageSize" value="${pager.pageSize }" type="hidden"/>
