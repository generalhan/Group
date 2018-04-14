<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!doctype html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>算法建模输入</title>
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
	
</head>

<body data-type="index">


    <header class="am-topbar am-topbar-inverse admin-header">
        <div class="am-topbar-brand">
          
               厨帝后台管理
         
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
                            <h3>说明 <span class="tpl-color-danger"></span> 正在完善中</h3><a href="###"></a></li>
                        <li>                           
                    </ul>
                </li>
                <li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
                    <a class="am-dropdown-toggle tpl-header-list-link" href="javascript:;">
                        <span class="am-icon-calendar"></span> 全部功能 <span class="am-badge tpl-badge-primary am-round"></span></span>
                    </a>
                    <ul class="am-dropdown-content tpl-dropdown-content">
                        <li class="tpl-dropdown-content-external">
                            <h3>后期 <span class="tpl-color-primary"></span> 正在完善</h3><a href="###"></a></li>
                        <li>
                

                    </ul>
                </li>
                <li class="am-hide-sm-only"><a href="javascript:;" id="admin-fullscreen" class="tpl-header-list-link"><span class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span></a></li>

                <li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
                    <a class="am-dropdown-toggle tpl-header-list-link" href="javascript:;">
                        <span class="tpl-header-list-user-nick">欢迎您: ${sessionScope.username}</span><span class="tpl-header-list-user-ico"> <img src="<%=request.getContextPath()%>/Static/Ui/assets/img/user01.png"></span>
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
                        <a href="<%=request.getContextPath()%>/admin/showKitchenAdmin" class="nav-link tpl-left-nav-link-list">
                            <i class="am-icon-user-plus"></i>
                            <span>管理员控制台</span>

                        </a>
                    </li>
                    <li class="tpl-left-nav-item">
                        <a href="<%=request.getContextPath()%>/kitchenChart.jsp" class="nav-link tpl-left-nav-link-list">
                            <i class="am-icon-bar-chart"></i>
                            <span>图形化数据表</span>
                            <i class="tpl-left-nav-content tpl-badge-danger">

             </i>
                        </a>
                    </li>

                    <li class="tpl-left-nav-item">
                        <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
                            <i class="am-icon-table"></i>
                            <span>文字化操作</span>
                            <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
                        </a>
                        <ul class="tpl-left-nav-sub-menu">
                            <li>
                                <a href="<%=request.getContextPath()%>/kitchen/showTableView">
                                    <i class="am-icon-angle-right"></i>
                                    <span>文字表格</span>
                                    <i class="am-icon-star tpl-left-nav-content-ico am-fr am-margin-right"></i>
                                </a>

            

                                  
                            </li>
                        </ul>
                    </li>
					
					    <li class="tpl-left-nav-item">
                        <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
                            <i class="am-icon-wpforms"></i>
                            <span>图形化操作</span>
                            <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
                        </a>
                        <ul class="tpl-left-nav-sub-menu">
                            <li>
                       

                                <a href="<%=request.getContextPath()%>/kitchen/showImageView">
                                    <i class="am-icon-angle-right"></i>
                                    <span>图片表格</span>
                                    <i class="tpl-left-nav-content tpl-badge-success">
     
             </i>

                                  
                            </li>
                        </ul>
                    </li>
                    
                    
                    
					    <li class="tpl-left-nav-item">
                        <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
                            <i class="am-icon-info-circle"></i>
                            <span>信息化操作</span>
                            <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
                        </a>
                        <ul class="tpl-left-nav-sub-menu">
                            <li>
                       

                                <a href="<%=request.getContextPath()%>/type/showTypeInfoView">
                                    <i class="am-icon-angle-right"></i>
                                    <span>厨具类型</span>
                                    <i class="tpl-left-nav-content tpl-badge-success">
     
             </i>

                                  
                            </li>
                        </ul>
                    </li>
                    

                    <li class="tpl-left-nav-item">
                        <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
                            <i class="am-icon-desktop"></i>
                            <span>信息录入</span>
                            <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right tpl-left-nav-more-ico-rotate"></i>
                        </a>
                        <ul class="tpl-left-nav-sub-menu" style="display: block;">
                            <li>

                                <a href="<%=request.getContextPath()%>/type/listTotal">
                                    <i class="am-icon-angle-right"></i>
                                    <span>录入厨具信息</span>
                                </a>
                            </li>
							
                                <a href="<%=request.getContextPath()%>/type/showTypeView">
                                    <i class="am-icon-angle-right"></i>
                                    <span>录入厨具类型</span>
                                </a>
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
            <div class="tpl-content-page-title" style="text-align: center;vertical-align: middle;">
                算法建模输入平台
	   
            </div>
          
   <ol class="am-breadcrumb">
                <li><a href="#" class="am-icon-home">首页</a></li>
                <li><a href="#">表单</a></li>
                <li class="am-active">Amaze UI 表单</li>
            </ol>
            <div class="tpl-portlet-components">
                <div class="portlet-title">
                    <div class="caption font-green bold">
                        <span class="am-icon-code"></span> 表单
                    </div>
                    <div class="tpl-portlet-input tpl-fz-ml">
                        <div class="portlet-input input-small input-inline">
                            <div class="input-icon right">
                                <i class="am-icon-search"></i>
                                <input type="text" class="form-control form-control-solid" placeholder="搜索..."> </div>
                        </div>
                    </div>


                </div>
                <div class="tpl-block ">

                    <div class="am-g tpl-amazeui-form">


                        <div class="am-u-sm-12 am-u-md-9">
                            <form class="am-form am-form-horizontal">
                                <div class="am-form-group">
                                    <label for="user-name" class="am-u-sm-3 am-form-label">姓名 / Name</label>
                                    <div class="am-u-sm-9">
                                        <input type="text" id="user-name" placeholder="姓名 / Name">
                                        <small>输入你的名字，让我们记住你。</small>
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-3 am-form-label">电子邮件 / Email</label>
                                    <div class="am-u-sm-9">
                                        <input type="email" id="user-email" placeholder="输入你的电子邮件 / Email">
                                        <small>邮箱你懂得...</small>
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <label for="user-phone" class="am-u-sm-3 am-form-label">电话 / Telephone</label>
                                    <div class="am-u-sm-9">
                                        <input type="tel" id="user-phone" placeholder="输入你的电话号码 / Telephone">
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <label for="user-QQ" class="am-u-sm-3 am-form-label">QQ</label>
                                    <div class="am-u-sm-9">
                                        <input type="number" pattern="[0-9]*" id="user-QQ" placeholder="输入你的QQ号码">
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <label for="user-weibo" class="am-u-sm-3 am-form-label">微博 / Twitter</label>
                                    <div class="am-u-sm-9">
                                        <input type="text" id="user-weibo" placeholder="输入你的微博 / Twitter">
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <label for="user-intro" class="am-u-sm-3 am-form-label">简介 / Intro</label>
                                    <div class="am-u-sm-9">
                                        <textarea class="" rows="5" id="user-intro" placeholder="输入个人简介"></textarea>
                                        <small>250字以内写出你的一生...</small>
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <div class="am-u-sm-9 am-u-sm-push-3">
                                        <button type="button" class="am-btn am-btn-primary">保存修改</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>

            </div>










        </div>

    </div>

<!-- 引用控制层插件样式 -->








   <script src="<%=request.getContextPath()%>/Static/js/jquery-1.11.2.js"></script>
    <script src="<%=request.getContextPath()%>/Static/Ui/assets/js/amazeui.min.js"></script>
    <script src="<%=request.getContextPath()%>/Static/Ui/assets/js/iscroll.js"></script>
    <script src="<%=request.getContextPath()%>/Static/Ui/assets/js/app.js"></script>
	
</body>