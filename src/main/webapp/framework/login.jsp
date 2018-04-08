<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!-- login -->
	<div id="loginAndRegDialog"
		style="width:260px;height:100px;overflow: hidden;">
		<div title="输入方式" style="overflow: hidden;">
			<div class="info">
				<div class="tip icon-tip"></div>
				<div style="text-align: center;"></div>
			</div>
			<div align="center">
				<form id="loginInputForm" method="post">
					<table class="tableForm" style="margin: 5px;">
						<tr>
							<th>登陆名</th>
							<td><input tLogin="account" name="username"
								class="easyui-validatebox" required="true" value=""
								missingMessage="请填写登录名称" style="width: 145px;" /></td>
						</tr>
						<tr>
							<th>密码</th>
							<td><input tLogin="password" name="password" value=""
								type="password" class="easyui-validatebox" required="true"
								missingMessage="请填写登录密码" style="width: 145px;" /></td>

						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>