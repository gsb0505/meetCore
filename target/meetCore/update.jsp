<%@ page language="java"
	import="java.util.*,com.kd.core.entity.UserInfo"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>修改页面</title>
	</head>

	<body>
		<form action="./rest/user/modify" method="post">
			<table>
				<tr>
					<th>
						ID
					</th>
					<th>
						名称
					</th>

					<th>
						地址
					</th>
				</tr>
				<tr>
					<td align="center">
						userID：
						<input type="text" value="${userInfo.userID}" readonly="readonly"
							name="userID" />
					</td>
					<td align="center">
						名称：
						<input type="text" value="${userInfo.userName}" name="userName" />
					</td>

					<td align="center">
						地址：
						<input type="text" value="${userInfo.address}" name="address" />
						<input type="hidden" value="${userInfo.id}" name="id" />
					</td>
				</tr>
			</table>
			<input type="submit" value="修改" />
		</form>
	</body>

</html>