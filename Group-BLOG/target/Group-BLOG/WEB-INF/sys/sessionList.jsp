<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 <%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@taglib prefix="zwlfn" uri="http://zwl/tags/zwl-functions" %>
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
                在线实时监控
            </div>
            <ol class="am-breadcrumb">
                <li><a href="#" class="am-icon-home">首页</a></li>
                <li><a href="#">监控台</a></li>
                <li class="am-active"></li>
            </ol>
            <div class="tpl-portlet-components">
                <div class="portlet-title">
                    <div class="caption font-green bold">
                        <span class="am-icon-code"></span> 
                        当前在线人数：${sessionCount}人&nbsp;&nbsp;
                        <c:if test="${not empty msg}">
  <div class="message">${msg}</div> 
</c:if>
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
                                            
                                            <th class="table-title">用户名</th>
                                            <th class="table-type">主机地址</th>
                                            <th class="table-author am-hide-sm-only">最后访问时间</th>
                                            <th class="table-date am-hide-sm-only">已强制退出</th>
                                            <th class="table-date am-hide-sm-only">操作</th>         
                                        </tr>
                                    </thead>
                                    <tbody>
                                   <c:forEach items="${sessions}" var="session">
            <tr>           
                    <td>${zwlfn:principal(session)} </td>
                <td>${session.host}</td>
                <td><fmt:formatDate value="${session.lastAccessTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
             <td>${zwlfn:isForceLogout(session) ? '是' : '否'}</td> 
                 <td>
                 <div class="am-btn-toolbar">
                                                    <div class="am-btn-group am-btn-group-xs">
                    <c:if test="${not zwlfn:isForceLogout(session)}">
                        <a href="${pageContext.request.contextPath}/sessions/${session.id}/forceLogout">强制退出</a>
                    </c:if>
                     </div>
                                                </div>
                </td>  
            </tr>                                   
                                   </c:forEach>
                                  
                                       
                                      
                                    </tbody>
                                </table>
                                <div class="am-cf">

                               
                                </div>
                                <hr>

                            </form>
                        </div>

                    </div>
                </div>
                <div class="tpl-alert"></div>
            </div>

        </div>

    </div>

   <!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;   
                </button>
            
            </div>
            <div id="form_data">
             <h4 class="modal-title" id="myModalLabel">
                  增加用户
                </h4>
            <div class="modal-body">
             用户名 &nbsp;&nbsp;<input type="text" id="username"  name="username" style="border:double #009" autofocus="autofocus" required="required"/><br/><br/>
      密&nbsp;&nbsp;&nbsp;&nbsp;码 &nbsp;&nbsp;     <input type="password" id="password"  name="password" style="border:double #009" required="required"/><br/><br/>
             重复密码     <input type="password" id="repwd"  name="repwd" style="border:double #009" required="required"/>
               
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button"  class="btn btn-primary">
                    提交
                </button>
            </div>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

    <script src="<%=request.getContextPath()%>/Static/Ui/assets/js/amazeui.min.js"></script>
    <script src="<%=request.getContextPath()%>/Static/Ui/assets/js/app.js"></script>

     <script src="<%=request.getContextPath()%>/Static/js/simpleAlert.js"></script>
      <script src="<%=request.getContextPath()%>/Static/js/myAlert.min.js"></script>
    
    <script type="text/javascript"> 
    </script>

</body>

</html>
