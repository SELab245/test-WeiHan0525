<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ page import="fcu.android.backend.service.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!-- 最新編譯和最佳化的 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">

<!-- 選擇性佈景主題 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">

<!-- 最新編譯和最佳化的 JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">

	<form class="form-signin" method="post" action="Login.jsp">
		<h3>登入</h3>
	
		<label for="InputEmail">電子郵件</label>
		<input type="email" class="form-control" name="InputEmail" placeholder="輸入電子郵件" requried autofocus>

		<label for="eInputPassword">密碼</label>
		<input type="password" class="form-control" name="InputPassword" placeholder="輸入密碼" requried>
		
		<div class="checkbox">
			<label> <input type="checkbox"> 記住我</label>
		</div>

		<button type="submit" class="btn btn-default">登入</a>
	</form>
	</div>
</body>
</html>