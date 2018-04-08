<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<script type="text/javascript" charset="utf-8">
	var tree;
	var menuXfxmcyPanel;
	$(function() {
		
			menuXfxmcyPanel = $('#menuXfxmcyPanel').panel({
				tools : [ {
					iconCls : 'icon-reload',
					handler : function() {
						tree.tree('reload');
					}
				}, {
					iconCls : 'icon-redo',
					handler : function() {
						var node = tree.tree('getSelected');
						if (node) {
							tree.tree('expandAll', node.target);
						} else {
							tree.tree('expandAll');
						}
					}
				}, {
					iconCls : 'icon-undo',
					handler : function() {
						var node = tree.tree('getSelected');
						if (node) {
							tree.tree('collapseAll', node.target);
						} else {
							tree.tree('collapseAll');
						}
					}
				} ]
			});
			
	
	});
	/*构建树*/
	function ctrlTree() {
		tree = $('#menuXfxmcy').tree({
			url : '${cy}/menu/menuCtrlTree/simple.do',
			parentField : 'pid',
			lines : true,
			onClick : function(node) {
				var childrenTree = node.children;
				if(!childrenTree || !childrenTree.length || childrenTree.length == 0)
					addTab.call(this,node);
			},
			onDblClick : function(node) {
				if (node.state == 'closed') {
					$(this).tree('expand', node.target);
				} else {
					$(this).tree('collapse', node.target);
				}
			}
		});
		$('#menuXfxmcy').show();
	}
</script>
<div class="easyui-accordion" fit="true" border="false">
	<div title="菜单">
		<div id="menuXfxmcyPanel" fit="false" border="false" 
			style="padding: 0px;overflow: hidden;">
			<ul class="easyui-tree" data-options="url:'${ctx}/power/admin/menu.do',method:'get',animate:true,
			onClick : function(node) {
				var childrenTree = node.children;
				if(!childrenTree || !childrenTree.length || childrenTree.length == 0)
					addTab.call(this,node);
			},
			onDblClick : function(node) {
				if (node.state == 'closed') {
					$(this).tree('expand', node.target);
				} else {
					$(this).tree('collapse', node.target);
				}
			}"></ul>
		</div> 
	</div>
</div>