
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

		<title>列表</title>
	</head>

	<body>
		<form action="./rest/user/findByName" method="post">
			名称：
			<input type="text" name="userName" value="${userName}" />
			<input type="submit" value="查询" />
		</form>
		<a href = "add.jsp">新增</a>
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
				<th>
					操作
				</th>
			</tr>
			<c:forEach items="${userList}" var="user" varStatus="vs">
				<tr>
					<td align="center">
						${user.userID}
					</td>
					<td align="center">
						${user.userName}
					</td>

					<td align="center">
						${user.address}
					</td>
					<td>
						<a href="rest/user/delete/${user.id}">del</a>
						<a href="rest/user/toModify/${user.id}">modify</a>
					</td>
				</tr>
			</c:forEach>

		</table>
	</body>

</html>