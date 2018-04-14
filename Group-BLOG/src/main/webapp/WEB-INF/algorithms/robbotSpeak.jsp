<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/Static/bootstrap-3.3.0/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/Static/bootstrap-3.3.0/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/Static/css/blog.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/Static/jQuerySlider20160819/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/Static/jQuerySlider20160819/css/rangeslider.css">


<title>语言简单合成</title>
<style type="text/css">
.col-md-8{
background-color: #E4F0F8;
}

.col-md-4{
background-color: #7CA9ED;
}

font{
font-size: large;
}

</style>


</head>

<body>
<div class="container">
<div class="row" align="left">
  <div class="col-md-6" align="left">对不起，该模块不完善，只能在服务端听到声音，页面非常简陋，纯粹为了学习测试效果
  <a href="${pageContext.request.contextPath}/tbloginfo/showHotBlog" style="color: blue;text-decoration: underline;">点我?返回首页^_^</a>
  </div>
  <br/>
  <div class="col-md-6" style="margin-left: 0;" align="left" id="speak"> 
  <div id="js-example-change-value">
  音量:
        <input type="range"  min="0" max="100" value="50" step="1" data-rangeslider name="SPEED">
        <output></output>
    </div>
    <div id="js-example-change-value">
    语速:
        <input type="range" min="0" max="100" value="50" step="1" data-rangeslider name="PITCH">
        <output></output>
    </div>
    <div id="js-example-change-value">
    语调:
        <input type="range" min="0" max="100" value="50" step="1" data-rangeslider name="VOLUME">
        <output></output>
    </div>
    
    <div class="page-header">
    <h3 class="text-center">输入字符</h3>
</div>
<form id="testForm" class="form-horizontal">
    <div class="form-group">
        <label class="col-md-3 control-label"></label>
        <div class="col-md-6">
            <textarea class='form-control' name='test' onkeyup='textAreaChange(this)' onkeydown='textAreaChange(this)' rows='5' placeholder="输入字符，然后语音合成"></textarea>
            <div class='text-right'>
                <em style='color:red'>1000</em>/<span>1000</span>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-offset-3 col-md-6">
            <button type="button" class="btn btn-info am-btn-speak" id="testConfirm">语音合成</button>
        </div>
    </div>
</form>
  </div>
  <br/>
  
  
  
</div>


</div>

<script src="${pageContext.request.contextPath}/Static/js/jquery-3.1.0.min.js"></script>
<script src="${pageContext.request.contextPath}/Static/bootstrap-3.3.0/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/Static/jQuerySlider20160819/js/rangeslider.min.js"></script>
<script type="text/javascript">
$(function() {
    var $document   = $(document);
    var selector    = '[data-rangeslider]';
    var $inputRange = $(selector);

    // Example functionality to demonstrate a value feedback
    // and change the output's value.
    function valueOutput(element) {
        var value = element.value;
        var output = element.parentNode.getElementsByTagName('output')[0];

        output.innerHTML = value;
    }

    // Initial value output
    for (var i = $inputRange.length - 1; i >= 0; i--) {
        valueOutput($inputRange[i]);
    };

    // Update value output
    $document.on('input', selector, function(e) {
        valueOutput(e.target);
    });

    // Initialize the elements
    $inputRange.rangeslider({
        polyfill: false
    });
    
 // Example functionality to demonstrate programmatic value changes
   /*  $document.on('click', '#testConfirm', function(e) {
    	alert("ok");
     
        var SPEED = $('input[name="SPEED"]', e.target.parentNode);
        alert(SPEED.val());
        var PITCH = $('input[type="range"].eq(1)', e.target.parentNode);
        var VOLUME = $('input[type="range"].eq(2)', e.target.parentNode);
       
    }); */
    
});

$(".am-btn-speak").click(function(){
	 var SPEED = $('input[name="SPEED"]').val();
	 var PITCH = $('input[name="PITCH"]').val();
	 var VOLUME = $('input[name="VOLUME"]').val();
     var  mText=$('[name="test"]').val().trim();
     if(mText==""||mText==null){
    	 alert("您输入的字符是空串或无效!请输入有效字符");
     }
     else{
    	 var params="SPEED="+SPEED+"&PITCH="+PITCH+"&VOLUME="+VOLUME+"&mText="+mText;
    	 $.ajax({
    			cache: false,
    			type: "POST",
    			url: '${pageContext.request.contextPath}/servlet/speak',  
    			data: params,
    			 dataType:"json",
    			 async: false,
    			success: function(data) {
    			
    			}

    		});
    
     }
})
</script>

<script type="text/javascript">
    //显示限制输入字符method
    function textAreaChange(obj){
        var $this = $(obj);
        var count_total = $this.next().children('span').text();
        var count_input = $this.next().children('em');
        var area_val = $this.val();
        if(area_val.len()>count_total){
            area_val = autoAddEllipsis(area_val,count_total);//根据字节截图内容
            $this.val(area_val);
            count_input.text(0);//显示可输入数
        }else{
            count_input.text(count_total - area_val.len());//显示可输入数
        }
    }
    //得到字符串的字节长度
    String.prototype.len = function(){
        return this.replace(/[^\x00-\xff]/g, "xx").length;
    };
    /*
     * 处理过长的字符串，截取并添加省略号
     * 注：半角长度为1，全角长度为2
     * pStr:字符串
     * pLen:截取长度
     * return: 截取后的字符串
     */
    function autoAddEllipsis(pStr, pLen) {
        var _ret = cutString(pStr, pLen);
        var _cutFlag = _ret.cutflag;
        var _cutStringn = _ret.cutstring;
        return _cutStringn;
    }
    /*
     * 取得指定长度的字符串
     * 注：半角长度为1，全角长度为2
     * pStr:字符串
     * pLen:截取长度
     * return: 截取后的字符串
     */
    function cutString(pStr, pLen) {
        // 原字符串长度
        var _strLen = pStr.length;
        var _tmpCode;
        var _cutString;
        // 默认情况下，返回的字符串是原字符串的一部分
        var _cutFlag = "1";
        var _lenCount = 0;
        var _ret = false;
        if (_strLen <= pLen/2){_cutString = pStr;_ret = true;}
        if (!_ret){
            for (var i = 0; i < _strLen ; i++ ){
                if (isFull(pStr.charAt(i))){_lenCount += 2;}
                else {_lenCount += 1;}
                if (_lenCount > pLen){_cutString = pStr.substring(0, i);_ret = true;break;}
                else if(_lenCount == pLen){_cutString = pStr.substring(0, i + 1);_ret = true;break;}
            }
        }
        if (!_ret){_cutString = pStr;_ret = true;}
        if (_cutString.length == _strLen){_cutFlag = "0";}
        return {"cutstring":_cutString, "cutflag":_cutFlag};
    }
    /*
     * 判断是否为全角
     *
     * pChar:长度为1的字符串
     * return: true:全角
     *         false:半角
     */
    function isFull (pChar){
        if((pChar.charCodeAt(0) > 128)){return true;}
        else{return false;}
    }
</script>
</body>
</html>



