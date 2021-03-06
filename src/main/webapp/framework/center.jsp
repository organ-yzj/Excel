<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<script type="text/javascript" charset="utf-8">
	var centerTabs;
	var tabsMenu;
	$(function() {
		
			tabsMenu = $('#tabsMenu').menu(
					{

						onClick : function(item) {
							var curTabTitle = $(this).data('tabTitle');
							var type = $(item.target).attr('type');

							if (type === 'refresh') {
								refreshTab(curTabTitle);
								return;
							}

							if (type === 'close') {
								var t = centerTabs.tabs('getTab', curTabTitle);
								if (t.panel('options').closable) {
									centerTabs.tabs('close', curTabTitle);
								}
								return;
							}

							var allTabs = centerTabs.tabs('tabs');
							var closeTabsTitle = [];

							$.each(allTabs,
									function() {
										var opt = $(this).panel('options');
										if (opt.closable
												&& opt.title != curTabTitle
												&& type === 'closeOther') {
											closeTabsTitle.push(opt.title);
										} else if (opt.closable
												&& type === 'closeAll') {
											closeTabsTitle.push(opt.title);
										}
									});

							for ( var i = 0; i < closeTabsTitle.length; i++) {
								centerTabs.tabs('close', closeTabsTitle[i]);
							}
						}
					});
			/* Tab */
			centerTabs = $('#centerTabs').tabs({
				fit : true,
				border : false,
				/*右键menu*/
				onContextMenu : function(e, title) {
					e.preventDefault();
					tabsMenu.menu('show', {
						left : e.pageX,
						top : e.pageY
					}).data('tabTitle', title);
				}
			});

	});

	/*add Tab*/
	function addTab(node) {
		if (!node.state)
			return;
		if(22 == node.id || "22" == node.id){
			constructTask();
			return ;
		} 
		if (centerTabs.tabs('exists', node.text)) {
			centerTabs.tabs('select', node.text);
		} else {
			if (node.attributes.url && node.attributes.url.length > 0) {
				if (node.attributes.url.indexOf('!druid.action') == -1) {/*数据源监控页面不需要开启等待提示*/
					$.messager.progress({
						text : '页面加载中....',
						interval : 100
					});
					window.setTimeout(function() {
						try {
							$.messager.progress('close');
						} catch (e) {
						}
					}, 2000);
				}
				centerTabs
						.tabs(
								'add',
								{ //刷新按钮
									title : node.text,
									closable : true,
									iconCls : node.iconCls,
									content : '<iframe src="${pageContext.request.contextPath}/	'
											+ node.attributes.url
											+ '" frameborder="0" style="border:0;width:100%;height:99.4%;"></iframe>',
									tools : [ {
										iconCls : 'icon-mini-refresh',
										handler : function() {
											refreshTab(node.text);
										}
									} ]
								});
			} else {
				centerTabs
						.tabs(
								'add',
								{
									title : node.text,
									closable : true,
									iconCls : node.iconCls,
									content : '<iframe src="error/err.jsp" frameborder="0" style="border:0;width:100%;height:99.4%;"></iframe>',
									tools : [ {
										iconCls : 'icon-mini-refresh',
										handler : function() {
											refreshTab(node.text);
										}
									} ]
								});
			}
		}
	}
	
	var nodePg = {};
	nodePg.id = 23;
	nodePg.state = "open";
	nodePg.text = "派工";
	nodePg.attributes = {};
	nodePg.attributes.url = "routearrange/routearrangeIndex.do";
	/*生成task*/
	var formDia ;
    var mainDialog;
	function constructTask(){
		mainDialog = parent.cy.dialog({   
	        title: '航班任务串',   
	        width: 500,   
	        height: 220,   
	        closed: false,   
	        cache: false,   
	        href: '${ctx}/cnaf/routearrange/generateTask.jsp',   
	        modal: true,
	        buttons:[
				 {
					text : '确定',
					handler : function() {	
						formDia = mainDialog.find('form');
						if(!formDia.form("validate")){
							parent.simpleMessAlert.call(this,'提示',"请认真填写信息");
							return;
						}  
						parent.simpleMessConf.call(this,
								'提示',
								'您确定要生成航班串吗?',
										function(result){
											if(result){
												$.post('${ctx}/routearrange/constrcutFlight.do',cy.serializeObject(formDia),function(json){
													if (json.success) {
														$("#homeGrid").datagrid("reload");
														mainDialog.dialog('close');
														parent.simpleMessAlert.call(this,'提示',json.message);
														addTab(nodePg);
														
													}else{
														parent.simpleMessAlert.call(this,'提示',json.message);
													}	
													},'json');
											}
						});	
											
						}
						
				 }],
				 onload:function(){
				 }
	   		}); 
	}
	function refreshTab(title) {
		var tab = centerTabs.tabs('getTab', title);
		centerTabs.tabs('update', {
			tab : tab,
			options : tab.panel('options')
		});
	}
</script>
<div id="centerTabs">
	<div title="首页" border="false" href="${ctx}/framework/index.jsp"
		style="overflow: hidden;"></div>
</div>
<div id="tabsMenu" style="width: 120px;display:none;">
	<div type="refresh">刷新</div>
	<div class="menu-sep"></div>
	<div type="close">关闭</div>
	<div type="closeOther">关闭其他</div>
	<div type="closeAll">关闭所有</div>
</div>