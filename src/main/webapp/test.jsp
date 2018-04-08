<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" ></c:set>
<jsp:include page="/initialEasyUI.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title></title>
    <script type="text/javascript" src="${ctx}/js/datetimepicker/bootstrap.min.js"></script>
<script type="text/javascript" src="${ctx}/js/datetimepicker/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="${ctx}/js/datetimepicker/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
    <link href="${ctx}/js/datetimepicker/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="${ctx}/js/datetimepicker/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
</head>

<body>
         
			<div class="control-group">
                <div class="controls input-append date form_date" data-date="" data-date-format="yyyy-MM-dd" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
                    <input size="10" type="text" value="" readonly>
					<span class="add-on"><i class="icon-th"></i></span>
                </div>
            </div>
		

<!-- <script type="text/javascript" src="./jquery/jquery-1.8.3.min.js" charset="UTF-8"></script> -->

<script type="text/javascript">
 /*    $('.form_date').datetimepicker({
        language:  'zh-CN',
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		forceParse: 0,
        showMeridian: 1
        
    }); */
    $(".form_date").datetimepicker({
    	  minView: "month",//设置只显示到月份
    	  format : "yyyy-mm-dd",//日期格式
    	  autoclose:true,//选中关闭
    	  todayBtn: true//今日按钮
    	});
	
</script>

</body>
</html>