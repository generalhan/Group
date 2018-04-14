<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<a href="${pageContext.request.contextPath}/tcommentinfo/showAllCommentView/${1}/${t.pkId }" target="_blank">
	<c:out value="${t.blogTitle }"></c:out>
</a>
<div style="float: right;">
	<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
	<a href="${pageContext.request.contextPath}/tbloginfo/showUserBlogView/${1}/${t.fkUid}" target="_blank">${t.userName }</a>
	</div>
	<br />
</h4>
<c:if test="${!empty t.blogLable }">
	<span class="label label-success">#${t.blogLable }#</span>
</c:if>
<p style="float: right;">
发表于:<fmt:formatDate value="${t.gmtCreate }" pattern="yyyy-MM-dd mm:ss" /> |点击(${t.visitorHasread })
</p>
<br>