<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!doctype html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>后台管理 </title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="<%=request.getContextPath()%>/Static/Ui/assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="<%=request.getContextPath()%>/Static/Ui/assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
      <link rel="stylesheet" href="<%=request.getContextPath()%>/Static/Ui/assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/Static/Ui/assets/css/admin.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/Static/Ui/assets/css/app.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/Static/js/simpleAlert.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/Static/js/myAlert.min.css">
          <link rel="stylesheet" href="<%=request.getContextPath()%>/Static/js/bootstrap.min.css">
          <link rel="stylesheet" href="<%=request.getContextPath()%>/Static/js/simpleAlert.css">
    <script src="<%=request.getContextPath()%>/Static/js/jquery-1.11.2.js"></script>
    <script src="<%=request.getContextPath()%>/Static/js/bootstrap.min.js"></script>
</head>

<body data-type="generalComponents">


     <header class="am-topbar am-topbar-inverse admin-header">
           <div class="am-topbar-brand">
          
               后台管理
         
        </div>
        <div class="am-icon-list tpl-header-nav-hover-ico am-fl am-margin-right">

        </div>

        <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only" data-am-collapse="{target: '#topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span></button>

        <div class="am-collapse am-topbar-collapse" id="topbar-collapse">

            <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list tpl-header-list">
                <li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
                    <a class="am-dropdown-toggle tpl-header-list-link" href="javascript:;">
                        <span class="am-icon-bell-o"></span> 说明 <span class="am-badge tpl-badge-success am-round"></span></span>
                    </a>
                    <ul class="am-dropdown-content tpl-dropdown-content">
                        <li class="tpl-dropdown-content-external">
                            <h3>支持电脑<span class="tpl-color-success"></span> 和手机移动端观看</h3><a href="###"></a></li>
                        <li class="tpl-dropdown-list-bdbc"><a href="#" class="tpl-dropdown-list-fl"><span class="am-icon-btn am-icon-plus tpl-dropdown-ico-btn-size tpl-badge-success"></span> 欢迎您的使用</a>
                            <span class="tpl-dropdown-list-fr"></span>
                        </li>

                    </ul>
                </li>
                <li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
                    <a class="am-dropdown-toggle tpl-header-list-link" href="javascript:;">
                        <span class="am-icon-comment-o"></span> 操作说明 <span class="am-badge tpl-badge-danger am-round"></span></span>
                    </a>
                    <ul class="am-dropdown-content tpl-dropdown-content">
                        <li class="tpl-dropdown-content-external">
                            <h3> <span class="tpl-color-danger"></span> </h3><a href="###"></a></li>
                        <li>                           
                    </ul>
                </li>
                <li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
                    <a class="am-dropdown-toggle tpl-header-list-link" href="javascript:;">
                        <span class="am-icon-calendar"></span> 全部功能 <span class="am-badge tpl-badge-primary am-round"></span></span>
                    </a>
                    <ul class="am-dropdown-content tpl-dropdown-content">
                        <li class="tpl-dropdown-content-external">
                            <h3> <span class="tpl-color-primary"></span> </h3><a href="###"></a></li>
                        <li>
                

                    </ul>
                </li>
                <li class="am-hide-sm-only"><a href="javascript:;" id="admin-fullscreen" class="tpl-header-list-link"><span class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span></a></li>

                <li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
                    <a class="am-dropdown-toggle tpl-header-list-link" href="javascript:;">
                        <span class="tpl-header-list-user-nick">欢迎您: ${sessionScope.currentUser.userName}</span><span class="tpl-header-list-user-ico"> <img src="<%=request.getContextPath()%>/Static/Ui/assets/img/user01.png"></span>
                    </a>
                    <ul class="am-dropdown-content">
                        <li><a href="<%=request.getContextPath()%>/login.html"><span class="am-icon-power-off"></span> 退出</a></li>
                    </ul>
                </li>
                <li><a href="###" class="tpl-header-list-link"><span class="am-icon-sign-out tpl-header-list-ico-out-size"></span></a></li>
            </ul>
        </div>
    </header>







    <div class="tpl-page-container tpl-page-header-fixed">


        <div class="tpl-left-nav tpl-left-nav-hover">
            <div class="tpl-left-nav-title">
                日常操作
            </div>
                 <div class="tpl-left-nav-list">
                <ul class="tpl-left-nav-menu">
                    <li class="tpl-left-nav-item">
                        <a href="#" class="nav-link active">
                            <i class="am-icon-home"></i>
                            <span>首页</span>
                        </a>
                    </li>
                                     <li class="tpl-left-nav-item">
                        <a href="<%=request.getContextPath()%>/tuser/showUserView/1" class="nav-link tpl-left-nav-link-list">
                            <i class="am-icon-user-plus"></i>
                            <span>管理员控制台</span>

                        </a>
                    </li>
            

                    <li class="tpl-left-nav-item">
                        <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
                            <i class="am-icon-table"></i>
                            <span>信息化操作</span>
                            <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
                        </a>
                        <ul class="tpl-left-nav-sub-menu">
                            <li>
                                <a href="<%=request.getContextPath()%>/view/dispatch/sys/675a894d62becd3ce7a28dfc81ec5805">
                                    <i class="am-icon-angle-right"></i>
                                    <span>算法类型</span>
                                    <i class="am-icon-star tpl-left-nav-content-ico am-fr am-margin-right"></i>
                                </a>

                                <a href="<%=request.getContextPath()%>/algorithms/addView">
                                    <i class="am-icon-angle-right"></i>
                                    <span>算法建模</span>
                                    <i class="am-icon-star tpl-left-nav-content-ico am-fr am-margin-right"></i>
                                </a>

                                  
                            </li>
                        </ul>
                    </li>
					
					    <li class="tpl-left-nav-item">
                        <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
                            <i class="am-icon-wpforms"></i>
                            <span>监控操作</span>
                            <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
                        </a>
                        <ul class="tpl-left-nav-sub-menu">
                            <li>
                       

                                <a href="<%=request.getContextPath()%>/sessions/currentSession">
                                    <i class="am-icon-angle-right"></i>
                                    <span>在线踢人</span>
                                    <i class="tpl-left-nav-content tpl-badge-success">
     
             </i>

                                  
                            </li>
                        </ul>
                    </li>
                    
                    
                    
					    <li class="tpl-left-nav-item">
                        <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
                            <i class="am-icon-info-circle"></i>
                            <span>权限操作</span>
                            <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
                        </a>
                        <ul class="tpl-left-nav-sub-menu">
                            <li>
                       

                                <a href="<%=request.getContextPath()%>/tadmin/showAuthorizedView/1">
                                    <i class="am-icon-angle-right"></i>
                                    <span>修改权限</span>
                                    <i class="tpl-left-nav-content tpl-badge-success">
     
             </i>

                                  
                            </li>
                        </ul>
                    </li>
                    

                    <li class="tpl-left-nav-item">
                        <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
                            <i class="am-icon-desktop"></i>
                            <span>博文操作</span>
                            <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right tpl-left-nav-more-ico-rotate"></i>
                        </a>
                        <ul class="tpl-left-nav-sub-menu" style="display: block;">
                            <li>

                                <a href="<%=request.getContextPath()%>/tadmin/showBlogInfoView/1">
                                    <i class="am-icon-angle-right"></i>
                                    <span>帖子管理</span>
                                </a>
                            </li>
							<li>
                                <a href="<%=request.getContextPath()%>/tadmin/showCommentInfoView/1">
                                    <i class="am-icon-angle-right"></i>
                                    <span>评论管理</span>
                                </a>
                            </li>
                            	<li>
                                <a href="<%=request.getContextPath()%>/tadmin/showFloorInfoView/1">
                                    <i class="am-icon-angle-right"></i>
                                    <span>楼中楼管理</span>
                                </a>
                            </li>
                        </ul>
                    </li>
                    
                     <li class="tpl-left-nav-item">
                        <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
                            <i class="am-icon-wpforms"></i>
                            <span>日志管理</span>
                            <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
                        </a>
                        <ul class="tpl-left-nav-sub-menu">
                            <li>
                       

                                <a href="<%=request.getContextPath()%>/tvisitinfo/showVisitInfoView/1">
                                    <i class="am-icon-angle-right"></i>
                                    <span>日志操作</span>
                                    <i class="tpl-left-nav-content tpl-badge-success">
     
             </i>

                                  
                            </li>
                        </ul>
                    </li>
                    
                              <li class="tpl-left-nav-item">
                        <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
                            <i class="am-icon-bluetooth"></i>
                            <span>推送管理</span>
                            <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
                        </a>
                        <ul class="tpl-left-nav-sub-menu">
                            <li>
                       

                                <a href="<%=request.getContextPath()%>/view/dispatch/sys/63efd1c9ea8e487e05ff5956846fc218">
                                    <i class="am-icon-angle-right"></i>
                                    <span>推送消息</span>
                                    <i class="tpl-left-nav-content tpl-badge-success">
     
             </i>
                </li>
                        </ul>
                    </li>

                                  
                            </li>
                        </ul>
                    </li>
             
                    <li class="tpl-left-nav-item">
                        <a href="<%=request.getContextPath()%>/login.html" class="nav-link tpl-left-nav-link-list">
                            <i class="am-icon-key"></i>
                            <span>登录</span>

                        </a>
                    </li>
                </ul>
            </div>
        </div>


        <div class="tpl-content-wrapper">
            <div class="tpl-content-page-title">
                查看信息
            </div>
            <ol class="am-breadcrumb">
                <li><a href="#" class="am-icon-home">首页</a></li>
                <li><a href="#">日志</a></li>
                <li class="am-active">控制台</li>
            </ol>
            <div class="tpl-portlet-components">
                <div class="portlet-title">
                    <div class="caption font-green bold">
                        <span class="am-icon-code"></span> 控制台
                    </div>
                    <div class="tpl-portlet-input tpl-fz-ml">
                        <div class="portlet-input input-small input-inline">
                            <div class="input-icon right">
                               </div>
                        </div>
                    </div>


                </div>
                 <div class="tpl-block">
                    <div class="am-g">
                        <div class="am-u-sm-12 am-u-md-6">
                            <div class="am-btn-toolbar">
                                <div class="am-btn-group am-btn-group-xs">
                                                                             
                                    <button type="button" class="am-btn am-btn-default am-btn-danger am-btn-delete"><span class="am-icon-trash-o"></span> 批量删除</button>
					
									<button type="button" class="am-btn am-btn-default am-btn-secondary am-btn-fresh"><span class="am-icon-save"></span> 刷新</button>
                                </div>
                            </div>
                        </div>
                        <div class="am-u-sm-12 am-u-md-3">
                            <div class="am-form-group">
      
                            </div>
                        </div>
                        <div class="am-u-sm-12 am-u-md-3">
                            <div class="am-input-group am-input-group-sm">
                                <input type="text" class="am-form-field" readonly="readonly" placeholder="管理员操作页面">
                                <span class="am-input-group-btn">
            <button class="am-btn  am-btn-default am-btn-success tpl-am-btn-success am-icon-search" type="button"></button>
          </span>
                            </div>
                        </div>
                    </div>
                    <div class="am-g">
                        <div class="am-u-sm-12">
                            <form class="am-form">
                                <table class="am-table am-table-striped am-table-hover table-main">
                                    <thead>
                                        <tr>
                                            <th class="table-check"><input type="checkbox" class="tpl-table-fz-check"></th>
                                            <th class="table-id">ID</th>
                                            <th class="table-title">日志名称</th>
                                            <th class="table-title">类型</th>
                                            <th class="table-type">请求路径</th>
                                            <th class="table-author am-hide-sm-only">请求类型</th>
                                            <th class="table-date am-hide-sm-only">登录用户</th>
                                           
                                            <th class="table-date am-hide-sm-only">IP</th>
                                            <th class="table-date am-hide-sm-only">IP位置</th>
                                            <th class="table-date am-hide-sm-only">耗时(毫秒)</th>
                                            <th class="table-date am-hide-sm-only">创建时间</th>
                                            <th class="table-date am-hide-sm-only">操作</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:if test="${!empty TotalList}">
                                    <c:forEach var="admin" items="${requestScope.TotalList}" varStatus="i">
                                        <tr>
                                            <td><input type="checkbox" value="${admin.pkId}" id="ck"></td>
                                            <td>${i.index + 1}</td>
                                            <td><a href="#">${admin.loggerName}</a></td>
                                         
 
                                            
                                            <td class="am-hide-sm-only">${admin.loggerType}</td>
                                            <td class="am-hide-sm-only">${admin.requestUrl}</td>
                                         <td class="am-hide-sm-only">${admin.requestType}</td>
                                         <td class="am-hide-sm-only">${admin.userName}</td>
                                            <td class="am-hide-sm-only">${admin.visitorIp}</td>
                                         <td class="am-hide-sm-only">${admin.ipAddress}</td>
                                         <td class="am-hide-sm-only">${admin.requestTime}</td>
                                         <td class="am-hide-sm-only"><fmt:formatDate value="${admin.gmtCreate }" pattern="yyyy-MM-dd hh:mm" /></td>
                                            <td>
                                                <div class="am-btn-toolbar">
                                                    <div class="am-btn-group am-btn-group-xs">                                      
                                                <button class="am-btn am-btn-default am-btn-xs am-text-secondary" data-toggle="modal" data-target="#editModal" onclick="remove(${admin.pkId});return false;"><span class="am-icon-pencil-square-o"></span> 删除</button>                                          
                                                    
                                                    </div>
                                                </div>
                                            </td>
                                        </tr>
                                    
                                   </c:forEach>
                                   </c:if>
                                       
                                      
                                    </tbody>
                                </table>
             <div class="am-u-lg-12">
                                <div class="am-cf">

                                    <div class="am-fr">
                                        <ul class="am-pagination tpl-pagination">
                                        <li class="am-disabled">总记录为  ${totalRecord} 条记录--</li>
                                        <li class="am-disabled">当前共有  ${totalCurrentRecord} 条记录--</li>
                                        <li class="am-active">目前是第${page.currentPage}/${page.totalPage}页</li>
                                        <c:if test="${page.hasPrePage}">
												<li>	<a href="${pageContext.request.contextPath}/tvisitinfo/showVisitInfoView/${1}" >首页</a></li>
												<li>	<a href="${pageContext.request.contextPath}/tvisitinfo/showVisitInfoView/${page.currentPage -1}" >上一页</a></li>
												</c:if>
												<c:if test="!${page.hasPrePage}">												
												<li>	首页</li>
												<li>	上一页</li>
											   </c:if>										
												<c:if test="${page.hasNextPage}">
												<li>	<a href="${pageContext.request.contextPath}/tvisitinfo/showVisitInfoView/${page.currentPage + 1}" >下一页</a></li>
												<li>	<a href="${pageContext.request.contextPath}/tvisitinfo/showVisitInfoView/${page.totalPage}" >尾页</a>		</li>	
												</c:if>
												<c:if test="!${page.hasNextPage}">
												<li>	下一页</li>
													<li>尾页</li>
												</c:if>
                                                                                  </ul>
                                    </div>
                                </div>
                                <hr>
                            </div>

                        </div>

                    </div>
                </div>
                <div class="tpl-alert"></div>
            </div>

        </div>

    </div>

   

    <script src="<%=request.getContextPath()%>/Static/Ui/assets/js/amazeui.min.js"></script>
    <script src="<%=request.getContextPath()%>/Static/Ui/assets/js/app.js"></script>

     <script src="<%=request.getContextPath()%>/Static/js/simpleAlert.js"></script>
      <script src="<%=request.getContextPath()%>/Static/js/myAlert.min.js"></script>
           <script type="text/javascript" src="<%=request.getContextPath()%>/Static/js/jquery.js"></script>
     <script src="<%=request.getContextPath()%>/Static/js/simpleAlert.js"></script>
    <script type="text/javascript">
    $(".am-btn-fresh").click(function(){
    	location.reload();
    });
    
    $(".am-btn-delete").click(function(){
       //是否选中
    	var isChecked = $("input[type='checkbox']").is(':checked');
       if(!isChecked){alert("必须选中一行进行操作!");} 
        else{    
        	/* 声明一个二维数组，相当于arraylist */
   		   var ids = [];
    $('input:checkbox:checked').each(function (index, item) {
         ids.push($(this).val());
     });
   		  
        	var dblChoseAlert = simpleAlert({
                "title":"是否真的要删除该条日志吗?",
                "content":"请按确定进行删除!",
                "buttons":{
                    "确定":function () {        	 
                        dblChoseAlert.close();
                        $.ajax({
             	   			cache: false,
             	   			type: "POST",
             	   			url: '<%=request.getContextPath()%>/tvisitinfo/removeAll',  
             	   			data: {
             	   				"ids" : ids.join(',')
             	   			},
             	   			 dataType:"json",
             	   			 async: false,
             	   			success: function(data) {
             	   				if(data.code=='1'){ 
             	   					alert("删除成功");
             	   					}
             	   				else{
             	   					alert("删除失败!");
             	   				}
             	   			 location.reload().fadeIn('fast');
             	   				},	
                          error:function(xhr,textStatus){
                        	  alert('不要越权^_^');
                          }
             	   			});  
                    
                      
                      
                    },
                    "取消":function () {
                        dblChoseAlert.close();
                        location.reload();
                    }
                }
            });
        	 
} 
    	
    });
    
    
    </script>
    <script type="text/javascript"> 
   function remove(e){
	   var dblChoseAlert = simpleAlert({
           "title":"是否真的要删除该条日志吗?",
           "content":"请按确定进行删除!",
           "buttons":{
               "确定":function () {        	 
                   dblChoseAlert.close();
                   $.ajax({
        	   			cache: false,
        	   			type: "POST",
        	   			url: '<%=request.getContextPath()%>/tvisitinfo/removeVisitInfo',  
        	   			data: {
        	   				"pkId" : e
        	   			},
        	   			 dataType:"json",
        	   			 async: false,
        	   			success: function(data) {
        	   				if(data.code=='1'){ 
        	   					alert("删除成功");
        	   					}
        	   				else{
        	   					alert("删除失败!");
        	   				}
        	   			 location.reload().fadeIn('fast');
        	   				},	
                     error:function(xhr,textStatus){
                    	 alert('不要越权^_^');
                     }
        	   			});  
               
                 
                 
               },
               "取消":function () {
                   dblChoseAlert.close();
                   location.reload();
               }
           }
       });
   }
    </script>

</body>

</html>
