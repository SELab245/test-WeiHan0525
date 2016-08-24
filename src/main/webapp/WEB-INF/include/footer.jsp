<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.net.*" %>

<div class="footer">
    &copy; 2016  
    伺服器:
    <%= 
        InetAddress.getLocalHost().getHostAddress() + 
            ":" + request.getLocalPort() 
    %>
    <a href="" target='_blank'>
        關於作者
    </a> 
    <a href="MantadiaMobile.apk">下載服務生App</a> 
    <a href="MantadiaEMenu.apk">下載電子菜單App</a>
</div>