<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>爱学圈后台系统|用户登录</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.4.1/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.4.1/themes/icon.css">
<script type="text/javascript" src="jquery-easyui-1.4.1/jquery.min.js"></script>
<script type="text/javascript" src="jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/base.js"></script>
<script>
		function submitForm(){
			$('#ff').form('submit',{
				onSubmit:function(){
					return $(this).form('enableValidation').form('validate');
				}
			});
		}
		function clearForm(){
			$('#ff').form('clear');
		}
	</script>

</head>

<body>

 

	<div class="login_top">
		<div class="login_top_title">
			<span class="label">爱学圈后台管理系统</span>
		</div>
	</div>

   

	<div class="login_form">
		<div class="label">
			<span style="color:red;font-size:1.2em">${info }</span>
		</div>
		<div class="login">
			<form id="ff" action="/web/login" method="post" margin-top:10px;margin-left:10px" onsubmit="return checkUser()">
				<table style="border-spacing:10px 20px">
					<tr>
						<td>账号</td>
						<td><input type="text" name="phone" id="phone" class="easyui-textbox" data-options="required:true"></td>
					</tr>

					<tr>
						<td>密码</td>
						<td><input type="password" name="password" id="password" class="easyui-textbox" data-options="required:true"></td>
					</tr>

					<tr>
						<td>验证码</td>
						<td width="25px">
						   <input align="middle" type="text" class="easyui-textbox"  name="securityCode" style="width:85px;height:25px;margin-top:0" id="code">
						   <img src="/SecurityCodeImageAction" height="25px" id="Verify"  style="cursor:hand;" alt="看不清，换一张" align="top"/>
						   
						 </td>
						 <td><a href="login.jsp" ">看不清楚，换一张</a></td>
					</tr>

					<tr>
						<td colspan="2" align="right">
						    <input type="submit" value="登录">
							<input type="reset" value="重置">
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>

	<div class="login_foot">
		<div class="label">版权所有：</div>
	</div>
</body>
</html>
