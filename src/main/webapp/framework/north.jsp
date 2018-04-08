<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" ></c:set>
<div>
	<img src="${ctx}/images/logo.png" style="height: 80px;margin-left: 20px;">
</div>
 <div style="position: absolute;right: 10px;top:30px;">
	<div >
		<span id="serverTime" style="margin-right: 40px;font-size: 30px;font-weight: bold;"></span>
		<span id="sessionInfoDiv"> 
		<c:if test="${sessionInfo.userId != null}">[<strong>${sessionInfo.loginName}</strong>]，欢迎您！</c:if>
		</span>
		<a id="btn"  href="#" class="easyui-linkbutton" onclick="logout()">安全退出</a> 	 
	</div>
</div>
<script>

	function getServerTime() {
        $.ajax({
            type: "GET",
            url: "${ctx}/user/getServerTime.do",
			dataType: "json",
            success: function(data){
                $('#serverTime').html(data.message);
            }
        });
    }
    $(document).ready(function () {
        window.setInterval(getServerTime, 1000); //循环执行！！
    });
</script>
