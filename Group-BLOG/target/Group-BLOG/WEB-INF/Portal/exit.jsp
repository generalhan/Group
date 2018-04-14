<%@ page language="java"  pageEncoding="UTF-8"%>  
   
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 
    <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
    <html>  
    <head>  
     <base href="<%=basePath%>">
        <title>安全退出</title>    
    </head>  
      
    <body>   
<div class="error">您已安全退出当前账号！</div>
<h2><a href="${pageContext.request.contextPath}/tbloginfo/showHotBlog">点我？返回到主页面</a></h2>
    </body>  

    </html>    

