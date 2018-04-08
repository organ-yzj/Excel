 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" ></c:set>
<jsp:include page="/initialEasyUI.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
 


<div id="mainProToolbar">
	<div class="button-group">
	    <table>
	        <tr>
	           <td><a id="btn" href="#" class="easyui-linkbutton" onclick="excelimport()" data-options="iconCls:'icon-search'">导入</a> </td>
	        </tr>
	    </table>
	</div>
</div>
<!-- 项目grid -->
<div style="height: 480px;">
	<table class="easyui-datagrid" id="dataGrid"
		data-options="fit:false,idField:'id',loadMsg:'正在加载…',pagination:true,title:'车辆维修记录',
			url:'${ctx}/repair/queryRepair.do',toolbar:'#mainProToolbar',
			singleSelect:true, rownumbers : true,pagination : true,  maximized:true, striped:true,
			pageSize : 20,pageList:[20,40,60,80,100],
			checkOnSelect : false,selectOnCheck : false,singleSelect  : true, remoteSort : false
			">
		<thead>
			<tr> 
				<th data-options="field:'id',hidden:true,align:'center'"></th>
				<th data-options="field:'carId',align:'center'">车牌号</th>
				<th data-options="field:'repairDate',align:'center'">维修日期</th>
				<th data-options="field:'reason',align:'center'">故障原因</th>
				<th data-options="field:'money',align:'center'">维修金额（元）</th>
				<th data-options="field:'position',align:'center'">维修内容</th>
				<th data-options="field:'manufactor',align:'center'" >维修厂家</th>
				<th data-options="field:'phone',align:'center'">厂家电话</th>
				<th data-options="field:'invoice',align:'center'">收据/正式发票</th>
				<th data-options="field:'buyDate',align:'center'">车辆采购日期</th>
				<th data-options="field:'driver',align:'center'">驾驶员</th>
		</thead>
	</table>
</div>

 <div id="importExcel" class="easyui-dialog" closed="true" title="导入excel文件"
	  style="width: 400px; height: 300px;" data-options="modal:true">
	 <%--<form id="uploadExcel"  method="post" enctype="multipart/form-data">
		 选择文件：　<input id = "excel" name = "excel" class="easyui-filebox" style="width:200px" data-options="prompt:'请选择文件...'">
	 </form>
	 <div style="text-align: center; padding: 5px 0;">
		 <a id = "booten" href="javascript:void(0)" class="easyui-linkbutton"
			onclick="uploadExcel()" style="width: 80px" id="tt">导入</a>
	 </div>--%>
		 <form id="batchAddInfo" method="post" enctype="multipart/form-data">
			 <div style="width:95%;height:250px;">
				 <fieldset>
					 <table>
						 <tr><td><span>文件导入</span></td></tr>
						 <tr><td><input id="importFile" name="importFile" type="file" style="width:200px;"/></td></tr>
						 <tr><td><a href="javascript:void(0)" class="easyui-linkbutton" style="width:100px;" onclick="fileUpload()" iconCls="icon-reload">导入</a></td></tr>
						 <%--<tr><td><a href="javascript:void(0)" class="easyui-linkbutton" style="width:100px;" onclick="downloadFile()" iconCls="icon-print">模板下载</a></td></tr>--%>
					 </table>
				 </fieldset>
			 </div>
		 </form>
 </div>

 <script>

function excelimport() {
    workerDialog = $("#importExcel").dialog({
        closed:false,
    });
}

function closeDialog() {
    workerDialog = $("#importExcel").dialog({
        closed:true,
    });
}

function fileUpload(){
    var importFile=$("#importFile").val();
    var reg=".xlsx$";
    var reg2=".xls$";
    var patrn=new RegExp(reg);
    var patrn2=new RegExp(reg2);
    if(patrn.exec(importFile)||patrn2.exec(importFile)){
        //不做任何事
    }else{
        $.messager.alert("提示","请选择正确的文件格式");
        return false;
    }

    $("#batchAddInfo").form('submit',{
        url:'${ctx}/repair/excelImport.do',
        onSubmit:function(){},
        success:function(data){
            closeDialog();
            parent.simpleMessAlert.call(this,'提示','导入成功');
            $("#dataGrid").datagrid("reload")
        }
    });


}

/*function uploadExcel() {
    $("#uploadExcel").form('submit');
}


/!* 配置导入框 *!/
$("#uploadExcel").form({
    type : 'post',*/
    //url : '${ctx}/repair/excelImport.do',
    /*dataType : "json",
    onSubmit: function() {
        var fileName= $('#excel').filebox('getValue');
        //对文件格式进行校验
        var d1=/\.[^\.]+$/.exec(fileName);
        if (fileName == "") {
            $.messager.alert('Excel导入', '请选择将要上传的文件!');
            return false;
        }else if(d1!=".xls"&&d1!=".xlsx"){
            $.messager.alert('提示','请选择正确格式文件！','info');
            return false;
        }
        $("#booten").linkbutton('disable');
        return true;
    },
    success : function(result) {
        var result = eval('(' + result + ')');
        if (result.success) {
            $.messager.alert('提示!', '导入成功','info',
                function() {
                    $("#booten").linkbutton('enable');
                    $('#importExcel').dialog('close');
                    $('#dataGrid').datagrid('reload');
                });
        } else {
            $.messager.confirm('提示',"导入失败!");
            $("#booten").linkbutton('enable');
        }
    }
});*/


 </script>
