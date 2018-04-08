<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" ></c:set>
<jsp:include page="/initialEasyUI.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
</head>
<body>
<div style="width: 410px;margin-left: auto;margin-right: auto;margin-top: 100px;">
<h2 style="text-align: center;">欢迎登陆</h2>
    <div style="margin:20px 0;"></div>
    <div class="easyui-panel" style="width:400px;padding:50px 60px">
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" id="Username" iconWidth="28" style="width:100%;height:34px;padding:10px;">
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-passwordbox" id="Password" iconWidth="28" style="width:100%;height:34px;padding:10px">
        </div>
        <div style="margin-bottom:20px">
        	 <a href="#" class="easyui-linkbutton" onclick="login()" style="width:100%">登录</a>
        </div>
        <%--<div>
        	 <a href="#" class="easyui-linkbutton" onclick="loginVideo()" style="width:100%">登录视频监控系统</a>
        </div>--%>
    </div>

</div>
<script type="text/javascript">
function login(){
	$.ajax({
		url : '${ctx}/systemController/loginByAdmin.do',
		type:'post',
		data:{
			"username":$("#Username").val(),
			"password":$("#Password").val()
		},
		datatype:'json',
		success : function(data) {
			if (data && data.success){
				window.location.href="${ctx}/index.jsp";
				$('#sessionInfoDiv').html('[<strong>'+data.result.loginName+'</strong>]，欢迎你！您登录！ ');
			}
			$.messager.show({
				msg : data.message,
				title : '提示'
			});
		}
	});
}
function loginVideo(){
	$.ajax({
		url : '${ctx}/systemController/loginByAdmin.do',
		type:'post',
		data:{
			"username":$("#Username").val(),
			"password":$("#Password").val()
		},
		datatype:'json',
		success : function(data) {
			if (data && data.success){
				window.location.href="${ctx}/video.jsp";
				$('#sessionInfoDiv').html('[<strong>'+data.result.loginName+'</strong>]，欢迎你！您登录！ ');
			}
			$.messager.show({
				msg : data.message,
				title : '提示'
			});
		}
	});
}
</script>
    
</body>
</html>