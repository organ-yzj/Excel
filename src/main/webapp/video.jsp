<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" ></c:set>
<jsp:include page="/initialEasyUI.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>视频监控</title>
    <%-- <script type="text/javascript" src="${ctx}/Cnaf/js/jquery.min.js"></script>
	  <link rel="stylesheet" href="${ctx}/Cnaf/css/style.css" type="text/css"/>
	  <link rel="stylesheet" href="${ctx}/Cnaf/css/bootstrap.css">
	  <link rel="stylesheet" href="${ctx}/Cnaf/css/bootstrap.min.css"> --%>
</head>
<body>
	<div style="text-align:center;margin-top: 150px;">
		<button id="qian"  onclick="window.open('${ctx}/fourVideos.jsp')"  class="btn btn-info" style="height: 50px;width: 200px">209车实时视频</button>
	</div>
	<div style="text-align:center;margin-top:10px;">
	<button id="qian"  onclick="window.open('http://192.168.3.103:8096/2/index.html?code=01_01')"  class="btn btn-info" style="height: 50px;width: 200px" disabled="disabled">201车实时视频</button>
	</div>
	<div style="text-align:center;margin-top:10px;">
	<button id="qian"  onclick="window.open('http://192.168.3.103:8096/2/index.html?code=01_01')"  class="btn btn-info" style="height: 50px;width: 200px" disabled="disabled">202车实时视频</button>
	</div>
	<div style="text-align:center;margin-top:10px;">
	<button id="qian"  onclick="window.open('http://192.168.3.103:8096/2/index.html?code=01_01')"  class="btn btn-info" style="height: 50px;width: 200px" disabled="disabled">203车实时视频</button>
	</div>
	<div style="text-align:center;margin-top:10px;">
	<button id="qian"  onclick="window.open('http://192.168.3.103:8096/2/index.html?code=01_01')"  class="btn btn-info" style="height: 50px;width: 200px" disabled="disabled">205车实时视频</button>
	</div>
	<div style="text-align:center;margin-top:10px;">
	<button id="qian"  onclick="window.open('http://192.168.3.103:8096/2/index.html?code=01_01')"  class="btn btn-info" style="height: 50px;width: 200px" disabled="disabled">206车实时视频</button>	</div>
	<div style="text-align:center;margin-top:10px;">
	<button id="qian"  onclick="window.open('http://192.168.3.103:8096/2/index.html?code=01_01')"  class="btn btn-info" style="height: 50px;width: 200px" disabled="disabled">207车实时视频</button>
	</div>
	<div style="text-align:center;margin-top:10px;">
	<button id="qian"  onclick="window.open('http://192.168.3.103:8096/2/index.html?code=01_01')"  class="btn btn-info" style="height: 50px;width: 200px" disabled="disabled">208车实时视频</button>
	</div>
	<div style="text-align:center;margin-top:10px;">
	<button id="qian"  onclick="window.open('http://192.168.3.103:8096/2/index.html?code=01_01')"  class="btn btn-info" style="height: 50px;width: 200px" disabled="disabled">233车实时视频</button>
	</div>
</body>
</html>