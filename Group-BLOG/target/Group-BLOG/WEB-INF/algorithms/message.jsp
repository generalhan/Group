<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
 <%@ page language="java" import="com.sys.entity.*" %>
 
  <%@ page import="org.apache.shiro.SecurityUtils" %> 
 <%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>留言板</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/Static/Message/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Static/Message/css/comment.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/Static/Message/js/jquery-1.12.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Static/Message/js/jquery.flexText.js"></script>
	<script type="text/javascript">
	
	   /* 初始化留言 */
	    $(function(){
	    	 $('.content').flexText();
	    	$.ajax({
	    		cache: false,
	    		type: "POST",
	    		url: '${pageContext.request.contextPath}/message/showMsg ',  
	    		 dataType:"json",
	    		 async: false,
	    		success: function(data) {
	    		if(data!=0){
	    			$.each(data,function (index,domEle){	    				
	    	 		var  oSize=domEle[0].contents;	    	 		
			//动态创建评论模块
	        oHtml = '<div class="comment-show-con clearfix"><div class="comment-show-con-img pull-left"><img src="${pageContext.request.contextPath}/Static/Message/images/user_icon.png" alt=""></div> <div class="comment-show-con-list pull-left clearfix"><div class="pl-text clearfix"> <a href="#" class="comment-size-name">'+domEle[0].currentName+' : </a> <input hidden="hidden" value="'+domEle[0].id+'" id="parentId"/>  <span class="my-pl-con">&nbsp;'+ oSize +'</span> </div> <div class="date-dz"> <span class="date-dz-left pull-left comment-time">'+domEle[0].time+'</span> <div class="date-dz-right pull-right comment-pl-block"> <a href="javascript:;" class="removeBlock">删除</a> <a href="javascript:;" class="date-dz-pl pl-hf hf-con-block hf-con-block pull-left">回复</a> <span class="pull-left date-dz-line">|</span> <a href="javascript:;" class="date-dz-z pull-left"><i class="date-dz-z-click-red"></i>赞 (<i class="z-num">666</i>)</a> </div> </div><div class="hf-list-con"></div></div> </div>';
	     
		for(var i=0;i<domEle.length;i++){
	        if(oSize.replace(/(^\s*)|(\s*$)/g, "") != ''&&i==0){
	        	$(".commentAll div:last").parents(".comment-show").prepend(oHtml);		          
	        } 
	        else{  
	        	var oHtml1 = '<div class="all-pl-con"><div class="pl-text hfpl-text clearfix"><a href="#" class="comment-size-name">'+domEle[i].replyName +': </a><span class="my-pl-con">'+domEle[i].contents+'</span></div><div class="date-dz"> <span class="date-dz-left pull-left comment-time">'+domEle[i].time+'</span> <div class="date-dz-right pull-right comment-pl-block"> <a href="javascript:;" class="removeBlock">删除</a>  <a href="javascript:;" class="date-dz-pl pl-hf hf-con-block pull-left">回复</a> <span class="pull-left date-dz-line">|</span> <a href="javascript:;" class="date-dz-z pull-left"><i class="date-dz-z-click-red"></i>赞 (<i class="z-num">666</i>)</a> </div> </div></div>';		       
	     	   
	        	 $(".reviewArea").next().children().first().find('.comment-show-con-list').find('.hf-list-con').css('display','block').prepend(oHtml1);       		        
	        }
	           }
	    			});
	    		}
	    		}
	    });
	    })
	
	</script>

	
	</head>
	<body>
	<div><a href="${pageContext.request.contextPath}/tbloginfo/showHotBlog">返回首页</a>
	 <shiro:guest>目前是游客身份，您未登录,还不能进行留言，评论(如果点击回复，请重刷页面)</shiro:guest>
   <shiro:authenticated>尊近的<shiro:principal/>，您已登录</shiro:authenticated>
	</div>
 <div class="commentAll">
    <!--评论区域 begin-->
    <div class="reviewArea clearfix">
        <textarea class="content comment-input" placeholder="Please enter a comment&hellip;" onkeyup="keyUP(this)"></textarea>
        <a href="javascript:;" class="plBtn">评论</a>
        <input type="text" hidden="hidden" value="${sessionScope.currentUser.pkId }" id="currentUser">
        <input type="text" hidden="hidden" value="${sessionScope.currentUser.userName }" id="currentUserName">
    </div>
    <!--评论区域 end-->
    <!--回复区域 begin-->
    <div class="comment-show">
        <div class="comment-show-con clearfix">
         <%-- <c:if test="${sessionScope.currentUser.userName }==domEle[0].currentName">
         </c:if> --%>
        </div>
    </div> 
    <!--回复区域 end-->
</div>




<!--textarea高度自适应-->
<script type="text/javascript">
   /*  $(function () {
       
    }); */
</script>
<!--textarea限制字数-->
<script type="text/javascript">
    function keyUP(t){   	
        var len = $(t).val().length;
        if(len > 139){
            $(t).val($(t).val().substring(0,140));
        }
    }
</script>
<!--点击评论创建评论条-->
<script type="text/javascript">
    $('.commentAll').on('click','.plBtn',function(){
        var myDate = new Date();
        //获取当前年
        var year=myDate.getFullYear();
        //获取当前月
        var month=myDate.getMonth()+1;
        //获取当前日
        var date=myDate.getDate();
        var h=myDate.getHours();       //获取当前小时数(0-23)
        var m=myDate.getMinutes();     //获取当前分钟数(0-59)
        if(m<10) m = '0' + m;
        var s=myDate.getSeconds();
        if(s<10) s = '0' + s;
        var now=year+'-'+month+"-"+date+" "+h+':'+m+":"+s;
        //获取输入内容
        var oSize = $(this).siblings('.flex-text-wrap').find('.comment-input').val();       
        console.log(oSize);
        var currentUser=$("#currentUser").val();  
        var currentUserName=$("#currentUserName").val();
        /* alert(currentUser);
        alert(currentUserName); */
       var params="messageContent="+oSize+"&parentNode=0"+"&currentNode="+currentUser+"&replyNode=0";      
       if(oSize!=""){
       $.post("${pageContext.request.contextPath}/message/addOnlyUserMessage",params,function(data){
    	  if(data.code==1){location.reload();return false;}
    	  else{alert("添加失败!");location.reload();}
    	},"json");     
       }
       else{
    	   alert("不能空白提交!");
       }
        //动态创建评论模块
      /*   oHtml = '<div class="comment-show-con clearfix"><div class="comment-show-con-img pull-left"><img src="${pageContext.request.contextPath}/Static/Message/images/user_icon.png" alt=""></div> <div class="comment-show-con-list pull-left clearfix"><div class="pl-text clearfix"> <a href="#" class="comment-size-name">'+ currentUserName +' : </a> <span class="my-pl-con">&nbsp;'+ oSize +'</span> </div> <div class="date-dz"> <span class="date-dz-left pull-left comment-time">'+now+'</span> <div class="date-dz-right pull-right comment-pl-block"> <a href="javascript:;" class="date-dz-pl pl-hf hf-con-block pull-left">回复</a> <span class="pull-left date-dz-line">|</span> <a href="javascript:;" class="date-dz-z pull-left"><i class="date-dz-z-click-red"></i>赞 (<i class="z-num">666</i>)</a> </div> </div><div class="hf-list-con"></div></div> </div>';
        if(oSize.replace(/(^\s*)|(\s*$)/g, "") != ''){
            $(this).parents('.reviewArea ').siblings('.comment-show').prepend(oHtml);
            $(this).siblings('.flex-text-wrap').find('.comment-input').prop('value','').siblings('pre').find('span').text('');
        } */
    });
</script>
<!--点击回复动态创建回复块-->
<script type="text/javascript">
    $('.comment-show').on('click','.pl-hf',function(){
        //获取回复人的名字
        var fhName = $(this).parents('.date-dz-right').parents('.date-dz').siblings('.pl-text').find('.comment-size-name').html();
        //回复@
        var fhN = '回复@'+fhName;                
        var fhHtml = '<div class="hf-con pull-left"> <textarea class="content comment-input hf-input" placeholder="" onkeyup="keyUP(this)"></textarea> <a href="javascript:;" class="hf-pl">评论</a></div>';
        //显示回复
        if($(this).is('.hf-con-block')){
            $(this).parents('.date-dz-right').parents('.date-dz').append(fhHtml);
            $(this).removeClass('hf-con-block');
            $('.content').flexText();
            $(this).parents('.date-dz-right').siblings('.hf-con').find('.pre').css('padding','6px 15px');
            //console.log($(this).parents('.date-dz-right').siblings('.hf-con').find('.pre'))
            //input框自动聚焦
            $(this).parents('.date-dz-right').siblings('.hf-con').find('.hf-input').val('').focus().val(fhN);
        }else {
            $(this).addClass('hf-con-block');
            $(this).parents('.date-dz-right').siblings('.hf-con').remove();
        }
    });
</script>
<!--评论回复块创建-->
<script type="text/javascript">
    $('.comment-show').on('click','.hf-pl',function(){
        var oThis = $(this);
        var myDate = new Date();
        //获取当前年
        var year=myDate.getFullYear();
        //获取当前月
        var month=myDate.getMonth()+1;
        //获取当前日
        var date=myDate.getDate();
        var h=myDate.getHours();       //获取当前小时数(0-23)
        var m=myDate.getMinutes();     //获取当前分钟数(0-59)
        if(m<10) m = '0' + m;
        var s=myDate.getSeconds();
        if(s<10) s = '0' + s;
        var now=year+'-'+month+"-"+date+" "+h+':'+m+":"+s;
        //获取输入内容
        var oHfVal = $(this).siblings('.flex-text-wrap').find('.hf-input').val();
        console.log(oHfVal)
        var oHfName = $(this).parents('.hf-con').parents('.date-dz').siblings('.pl-text').find('.comment-size-name').html();
        var oAllVal = '回复@'+oHfName;
        var replyUserName=$("#currentUserName").val();       
        var parentNode=oThis.parents('.hf-con').parents('.comment-show-con-list').find('.pl-text').find('#parentId').val();     
        
        var params="currentName="+oHfName+"&replyName="+replyUserName+"&parentName="+parentNode+"&contents="+oHfVal;                  
        
        if(oHfVal.replace(/^ +| +$/g,'') == '' || oHfVal == oAllVal){
                alert("err");
        }else {
            $.getJSON("${pageContext.request.contextPath}/Static/Message/json/pl.json",function(data){
                var oAt = '';
                var oHf = '';
                $.each(data,function(n,v){
                    delete v.hfContent;
                    delete v.atName;
                    var arr;
                    var ohfNameArr;
                    if(oHfVal.indexOf("@") == -1){
                        data['atName'] = '';
                        data['hfContent'] = oHfVal;
                    }else {
                        arr = oHfVal.split(':');
                        ohfNameArr = arr[0].split('@');
                        data['hfContent'] = arr[1];
                        data['atName'] = ohfNameArr[1];
                    }

                    if(data.atName == ''){
                        oAt = data.hfContent;
                    }else {
                        oAt = '回复<a href="#" class="atName">@'+data.atName+'</a> : '+data.hfContent;
                    }
                    oHf = data.hfName;
                });
                
                $.post("${pageContext.request.contextPath}/message/addReplyUserMessage",params,function(data){
                	if(data.code==1){
                	  var oHtml = '<div class="all-pl-con"><div class="pl-text hfpl-text clearfix"><a href="#" class="comment-size-name">'+replyUserName+': </a><span class="my-pl-con">'+oAt+'</span></div><div class="date-dz"> <span class="date-dz-left pull-left comment-time">'+now+'</span> <div class="date-dz-right pull-right comment-pl-block">  <a href="javascript:;" class="date-dz-pl pl-hf hf-con-block pull-left">回复</a> <span class="pull-left date-dz-line">|</span> <a href="javascript:;" class="date-dz-z pull-left"><i class="date-dz-z-click-red"></i>赞 (<i class="z-num">666</i>)</a> </div> </div></div>';
                      oThis.parents('.hf-con').parents('.comment-show-con-list').find('.hf-list-con').css('display','block').prepend(oHtml) && oThis.parents('.hf-con').siblings('.date-dz-right').find('.pl-hf').addClass('hf-con-block') && oThis.parents('.hf-con').remove();return false;}
                	else{alert("添加失败!");}              
            	},"json");
                                
              
            });
        }
    });
</script>
<!--删除评论块-->
<script type="text/javascript">
  function removeBlock(e){
	 alert(e);
	var oT = $(".removeBlock").parents('.date-dz-right').parents('.date-dz').parents('.all-pl-con');
    if(oT.siblings('.all-pl-con').length >= 1){
        oT.remove();
    }else {
        $(".removeBlock").parents('.date-dz-right').parents('.date-dz').parents('.all-pl-con').parents('.hf-list-con').css('display','none')
        oT.remove();
    }
    $(".removeBlock").parents('.date-dz-right').parents('.date-dz').parents('.comment-show-con-list').parents('.comment-show-con').remove();
}  
  
       $('.commentAll').on('click','.removeBlock',function(e){
        var oT = $(this).parents('.date-dz-right').parents('.date-dz').parents('.all-pl-con');
        if(oT.siblings('.all-pl-con').length >= 1){
            oT.remove();
        }else {
            $(this).parents('.date-dz-right').parents('.date-dz').parents('.all-pl-con').parents('.hf-list-con').css('display','none')
            oT.remove();
        }
        $(this).parents('.date-dz-right').parents('.date-dz').parents('.comment-show-con-list').parents('.comment-show-con').remove();

    })  
</script>
<!--点赞-->
<script type="text/javascript">
    $('.comment-show').on('click','.date-dz-z',function(){
        var zNum = $(this).find('.z-num').html();
        if($(this).is('.date-dz-z-click')){
            zNum--;
            $(this).removeClass('date-dz-z-click red');
            $(this).find('.z-num').html(zNum);
            $(this).find('.date-dz-z-click-red').removeClass('red');
        }else {
            zNum++;
            $(this).addClass('date-dz-z-click');
            $(this).find('.z-num').html(zNum);
            $(this).find('.date-dz-z-click-red').addClass('red');
        }
    })
</script>
</body>
</html>
