<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ page import="fcu.android.backend.service.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login</title>
</head>
<body>
	<%!
		String Email, Password, isvalidshop, StringTrue;
	%>
	
	<%
		ShopService shopservice = new ShopService();
		StringTrue = "true";
	
		Email = request.getParameter("InputEmail");
		Password = request.getParameter("InputPassword");
		
		
		isvalidshop = shopservice.isValidShop(Email, Password);	
		
		if(isvalidshop.equals(StringTrue)){
			response.sendRedirect("ShopInfo.jsp");
		}
		else{%>
			<h3>登入失敗!</h3>
			<br>
			<a href=Home.jsp>回到首頁</a>
		<%}
		
	%>

</body>
</html>
