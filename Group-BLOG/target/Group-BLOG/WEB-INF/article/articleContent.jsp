<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=0.3">
<title>帖子内容</title>
<%@include file="common/import.jsp"%>
</head>
<body>
	<div class="container" style="box-shadow: 0px 0px 1px #666;">
		<%@include file="common/head.jsp"%>
		<div class="page-header">
			<h4><c:out value="${blogInfo.blogTitle }"></c:out></h4>
		</div>
		<div class="row">
			<div class="panel panel-default" style="border-radius : 0;">
				<div class="panel-body">
					<div class="col-md-2">
						<center>
							<a href="${pageContext.request.contextPath}/tbloginfo/showUserBlogView/${1}/${blogInfo.fkUid}" target="_blank">
							<img alt="headimg" style="width: 111px;" src="${blogInfo.imgUrl}" class="img-thumbnail"></a>
							<br><br>楼主 :<a href="${pageContext.request.contextPath}/tbloginfo/showUserBlogView/${1}/${blogInfo.fkUid}" target="_blank">${blogInfo.userName }</a>
						</center>
					</div>
					<div class="col-md-8">
						<c:out value="${blogInfo.blogContent }" escapeXml="false"></c:out>
					</div>
				</div>
				<h6 style="float: right;">
					发布时间:
					<fmt:formatDate value="${blogInfo.gmtCreate }"
						pattern="yyyy-MM-dd mm:ss" />&nbsp;
				</h6>
			</div>
		</div>
		
	 	<h5>共 ${totalRecord} 条评论</h5> 
		
		<%-- 评论列表 --%>
		<c:forEach var="c" items="${TotalList}" varStatus="st" >
			<div class="row">
				<div class="panel panel-default" style="border-radius : 0;">
					<div class="panel-body">
 						<div class="col-md-2">
							<center>
								<a href="${pageContext.request.contextPath}/tbloginfo/showUserBlogView/${1}/${c.fkUid}" target="_blank">
									<img alt="headimg" style="width: 111px;" src="${c.imgUrl}" class="img-thumbnail"> 
								</a>
								<br><br>
								<c:if test="${c.fkUid eq blogInfo.fkUid }">楼主:</c:if>
								<a href="${pageContext.request.contextPath}/tbloginfo/showUserBlogView/${1}/${c.fkUid}" target="_blank">${c.userName }</a>
							</center>
						</div>
						<div class="col-md-8">
							<c:out value="${c.blogComment }" escapeXml="false"></c:out>
							<br><br><hr/>
							<%-- 楼中楼评论数据 --%>
							<c:if test="${!empty Floor}">
							<div class="media" id="media${c.pkId }">
					            <c:forEach var="f" items="${Floor }">
						            <c:if test="${f.commentId eq c.pkId }">
						            	<!-- 头像 -->
		 					            <div class="media-left">
							              <a href="${pageContext.request.contextPath}/tbloginfo/showUserBlogView/${1}/${f.userId}" target="_blank">
							                <img class="media-object" style="width: 34px;" src="${f.imgUrl}">
							              </a>
							            </div>
							            <!-- 评论内容 -->
							            <div class="media-body">
								            <a href="${pageContext.request.contextPath}/tbloginfo/showUserBlogView/${1}/${f.userId}" target="_blank">${f.userName }</a>:
								            <c:out value="${f.floorComment }"></c:out>
								            <a onclick="floorInput('${c.pkId }','${f.userName }')">&nbsp;回复&nbsp;</a>
							            </div>
							            <br>
							            </c:if>
							            

						            
					            </c:forEach>
					            
			          		</div>
			          		</c:if>
						</div>			
					</div>
					<div class="replyMsg">
						<h6 style="float: right;">							
							${st.index+1+(page.currentPage-1)*page.everyPage }楼
							<fmt:formatDate value="${c.gmtCreate }"
								pattern="yyyy-MM-dd mm:ss" />
							<a onclick="openFloorInput(${c.pkId })">&nbsp;回复&nbsp;</a>
						</h6>
					</div>
				</div>
				

				<%-- 楼中楼评论框 --%>
				<br>
				<div class="floor" id="floor${c.pkId }" style="display: none;width: 40%;float: right;">
					<textarea class="form-control" rows="3" id="text${c.pkId }"></textarea>
					<input class="btn btn-primary" type="submit" onClick="floorReply(${c.pkId },'${c.userName }')" value="回复" style="float : right ;">
				</div>
			</div>
		</c:forEach>
		
		<%-- 分页  --%>
				<div style="float: right;">
					 <ul class="am-pagination tpl-pagination">
                                         总记录为  ${totalRecord} 条记录--
                                        当前共有  ${totalCurrentRecord} 条记录--
                                       目前是第${page.currentPage}/${page.totalPage}页 
                                        <c:if test="${page.hasPrePage}">
													<a href="${pageContext.request.contextPath}/tcommentinfo/showAllCommentView/${1}/${blogInfo.pkId}" >首页</a>
													<a href="${pageContext.request.contextPath}/tcommentinfo/showAllCommentView/${page.currentPage -1}/${blogInfo.pkId}" >上一页</a>
												</c:if>
												<c:if test="!${page.hasPrePage}">												
													首页
						                        	上一页
											   </c:if>										
												<c:if test="${page.hasNextPage}">
													<a href="${pageContext.request.contextPath}/tcommentinfo/showAllCommentView/${page.currentPage + 1}/${blogInfo.pkId}" >下一页</a>
													<a href="${pageContext.request.contextPath}/tcommentinfo/showAllCommentView/${page.totalPage}/${blogInfo.pkId}" >尾页</a>			
												</c:if>
												<c:if test="!${page.hasNextPage}">
													下一页
													尾页
												</c:if>
                                                                                  </ul>
				</div>
		<br/><br/><br/>
		<%-- 评论框 --%>
		<c:choose>
			<c:when test="${!empty currentUser }">
				
				<%@include file="common/editor.jsp"%> 
	 <script id="editor" type="text/plain" style="width:100%;height:200px;"></script>
	 <tr height="20">
	   <td>
		 <input type="button"  value="添加评论" style="float: right;" class="am-btn-save"/>
	   </td>
	 </tr>
				
			</c:when>
			<c:otherwise>
				<center>
					<h3>登陆后才可进行回帖！</h3>
				</center>
			</c:otherwise>
		</c:choose>
	<%@include file="common/foot.jsp"%>
	 
	</div>
	
<script type="text/javascript">
	/*回帖*/
	$(".am-btn-save").click(function(){
		var url = "${pageContext.request.contextPath}/tcommentinfo/add";
		var params = {
			blogComment : UE.getEditor('editor').getContent(),
			 fkBlogId : '${blogInfo.pkId }', 
			fkUid : '${currentUser.pkId }'
		};
		 $.post(url, params, function(data) {
			if(data.code==1){
			location.href = "${pageContext.request.contextPath}/tcommentinfo/showAllCommentView/${1}/${blogInfo.pkId }";
			}
			else{
				alert("添加评论失败!");
			}
		}, "json"); 
	})
	
	/*楼中楼回复框*/
	function floorInput(num,name){
  		$('#floor'+num).slideToggle();
  		$('#text'+num).focus();
  		$('#text'+num).val("回复 "+name+" : ");
	}
	function openFloorInput(num){
  		$('#floor'+num).slideToggle();
  		$('#text'+num).focus();
	}
	function floorReply(num,userName){
		//文本框内容
		var  floorComment = $('#text'+num).val();
		//当前登录用户id
		var userId='${currentUser.pkId}';
		if(!userId){
			alert("您必须登录，才能回复!");
			return false;
		}
		//请求服务器,插入评论
		var url = "${pageContext.request.contextPath}/tfloorinfo/add";
		var params = {
			commentId : num,
			blogId : '${blogInfo.pkId }',
			userId :  userId,
			floorComment : floorComment,
			replyedName : userName,
		};
		$.ajax({
			'url' : url,
			'data' : params,
			'type' : 'POST',
			'success' : function(data) {
				//js插入评论数据
				/* var t1 = '<div class="media-left">'+
				  '<a href="${pageContext.request.contextPath}/tbloginfo/showUserBlogView/${1}/${f.userId}"><img class="media-object" src="${pageContext.request.contextPath}/Static/img/head.png" style="width:34px;"></a>'+
				'</div>'+
				'<div class="media-body">'+
				  '<a href="${pageContext.request.contextPath}/tbloginfo/showUserBlogView/${1}/${f.userId}" target="_blank">${currentUser.userName }</a>:'+floorComment+
				  '<a onclick="floorInput(\''+num+'\',\'${currentUser.userName }\')">&nbsp;回复&nbsp;</a>'+
				'</div><br>';
				$('#media'+num).html(t1);
				$('#text'+num).val('');
				$('#floor'+num).slideUp(); */
		
				//$('body').load("'${pageContext.request.contextPath}/tcommentinfo/showAllCommentView/${page.currentPage}/${blogInfo.pkId}'").fadeIn('fast');  
				location.reload();
			},
			'error' : function() {
				alert("回复失败！");
			}
		});	
	}
</script>
</body>
</html>
