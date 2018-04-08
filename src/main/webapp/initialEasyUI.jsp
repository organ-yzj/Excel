<%@ page  language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" ></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">	
<head>
<link href="${ctx}/js/datetimepicker/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="${ctx}/js/datetimepicker/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
<!-- css -->
<link rel="stylesheet" href="${ctx}/js/jquery-easyui-1.4.3/themes/icon.css"/>
<link rel="stylesheet" href="${ctx}/js/jquery-easyui-1.4.3/themes/default/easyui.css"/>
<script type="text/javascript" src="${ctx}/js/jquery-easyui-1.4.3/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery-easyui-1.4.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery-easyui-1.4.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery-easyui-1.4.3/ajaxfileupload.js"></script>
<script type="text/javascript" src="${ctx}/js/easyuiUtil.js"></script>
<script type="text/javascript" src="${ctx}/js/json2.js"></script>
<!-- 视频播放 -->
<%-- <script src="${ctx}/cnaf/carvideo/js/vendor/jquery.min.js"></script> --%>
<script src="${ctx}/cnaf/carvideo/js/vendor/video.js"></script>
<script type="text/javascript" src="${ctx}/cnaf/carvideo/js/ckplayer/offlights.js"></script>
<script type="text/javascript" src="${ctx}/cnaf/carvideo/js/ckplayer/ckplayer.js"></script>
<script type="text/javascript" src="${ctx}/js/datetimepicker/bootstrap.min.js"></script>
<script type="text/javascript" src="${ctx}/js/datetimepicker/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="${ctx}/js/datetimepicker/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
<script type="text/javascript">
	//easyloader.locale = 'zh_CN';
	//easyloader.theme = "bootstrap";
	window._contextPath = "${ctx}";
	
	/*trim*/
	if(!String.prototype.trim) {
        String.prototype.trim = function () {
            return this.replace(/^\s+|\s+$/g,'');
       };
   }
	
</script>
