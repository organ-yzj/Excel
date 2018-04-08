<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" ></c:set>
<jsp:include page="/initialEasyUI.jsp"></jsp:include>
<title>信息管理系统</title>
</head>
<body>
<script type="text/javascript">
	/*登录 dialog*/
	var loginDialog; 
	var sessionInfo;
	var loginInputForm;
	var regDialog;
	var regForm;
	var formParam;
	$(function() {
		
			/*当前在线人*/
			sessionInfo = {
				userId : '${sessionInfo.userId}',
				loginName : '${sessionInfo.loginName}',
				//ip : '${sessionInfo.ip}'
			};
			/*nobody have loginedx*/
			if (!sessionInfo.userId) {
				//showLoginDialog.call(this, null);
			}
			/*显示*/
			$('body').layout();
			$('#indexBottom').show();
			initialDialog.call(this);
			/*初始化 form*/
			formParam = {
				url : '${ctx}/systemController/loginByAdmin.do',
				success : function(data) {
					var json = $.parseJSON(data);
					if (json && json.success){
						loginDialog.dialog('close');
						$('#sessionInfoDiv').html('[<strong>'+json.result.loginName+'</strong>]，欢迎你！您登录！ ');
					}
					$.messager.show({
						msg : json.message,
						title : '提示'
					});
				}
			};
			
			/* 增加回车提交功能 */
			/*login form*/ 
			/*saved code which is origin
			if (sessionInfo.userId) {
				window.setTimeout(function() {
					$('div.validatebox-tip').remove();
				}, 500);
				loginDialog.dialog('close');
			}*/
			//$("body").css("visibility","visible");
			
			
			
	});
	/*show login dialog*/
	function showLoginDialog(){
		/*login dialog*/
		loginDialog = $('<div/>').dialog({
		//	top : document.body.clientHeight/2-50,
			closable : false,
			href : '${ctx}/framework/login.jsp',
			title : '登录',
			height : 180,
			width : 300,
			modal : true,
			buttons : [ {
				text : '登录',
				handler : function() {
					loginInputForm.submit();
				}
			} ],
			onClose : function() {
				$(this).dialog('destroy');
			}, 
			onLoad : function() {
				var t = $(this);
				window.setTimeout(function() {
					t.find('input[name=username]').focus();
				}, 0);
				loginInputForm = $('#loginInputForm').form(formParam);
				
				$('#loginInputForm input').bind('keyup', function(event) {
					if (event.keyCode == '13') {
						loginInputForm.submit();
					}
				});
				
			}
		});
	} 
	/*注销操作*/
	function logout(){
		simpleMessConf.call(this,'Confirm', '你是否要退出系统?', function(r){
			if (r){
				
				$.ajax({
					url : '${ctx}/systemController/logoutByAdmin.do',
					type:'post',
					datatype:'json',
					success : function(data) {
						if (data && data.success){
							window.location.href="${ctx}/login.jsp";
						}
						$.messager.show({
							msg : data.message,
							title : '提示'
						});
					}
				});
				
			}
		}); 
	}
	var workDialog;
	var workerFlag = false;
	function showWorkDialog(){ 
	console.info(workerFlag);
			  if(workerFlag)
			  	return;	
			  $.post("${ctx}/workorder/queryWorkorderTime.do",null,function(result){
					//var result = eval("("+data+")");
				/* 	if(result.success){
						//simpleMessAlert.call(this,'提示(十分钟内没接受派工任务的航班)',result.result);
						parent.simpleMessConf.call(this,
				 		'提示(是否推送消息?)',
				 		result.result,  
				 		function(result){
						if(result){
							$.post('${ctx}/workorder/pusgMessage.do',function(json){
								if (json.success) { 
								 simpleMessAlert.call(this,'提示 ',json.message);
						}
							 
						},'json');
					}
				}
		);			  
					}		 */	
					  
					 workDialog = parent.cy.dialog({   
                      title: '是否推送消息?',   
                      width: 400,   
                      height: 200,   
                      closed: false,   
                      cache: false,  
                      modal: true,
                      href: '${ctx}/cnaf/workorder/messageForm.jsp',
                      buttons : [ {
					  		text : '推送',
					  		 handler : function() {	 
								if(result){
									$.post('${ctx}/workorder/pusgMessage.do',function(json){
									if (json.success) { 
									 simpleMessAlert.call(this,'提示 ',json.message);
									  workDialog.dialog('close');
						}  
						},'json');
					} 
					}
					},{
					text:'取消',
					handler:function(){
					workDialog.dialog('close');
					}
					}
					],	
					  onClose : function() {
					    workerFlag = false ;
						$(this).dialog('destroy');
					},	
					  onLoad : function(){
						 $("#message").html(result.result);
						 workerFlag = true;
					} 	
						  
});   					
				},'json');
	 }			
			//var int=self.setInterval("showWorkDialog()",3600000);
			 
</script> 
	<!-- top -->
	<div
		data-options="region:'north',href:'${ctx}/framework/north.jsp',collapsible:true"
		style="height: 80px;overflow: hidden;" class="logo"></div>
	<!-- left -->
	<div
		data-options="region:'west',href:'${ctx}/framework/west.jsp',collapsible:true"
		style="width: 180px;overflow: hidden;"></div>

	<!-- center -->
	<div
		data-options="region:'center',title:'信息管理系统',href:'${ctx}/framework/center.jsp'"
		style="overflow: hidden;"></div>

	<!-- bottom -->
	<div data-options="region:'south'"
		style="height: 20px;overflow: hidden;">
		<div align="center" style="display: none;" id="indexBottom">
			中国航油河北分公司</div>
	</div> 
</body>
</html>
