<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" type="text/css" href="default.css" media="screen"/>
    <title>Welcome</title>
</head>
<body>
<div class="container">
    <div class="main">
        <%-- 引用banner.jsp片段並傳送功能名稱 --%>
        <jsp:include page="/WEB-INF/include/banner.jsp">
            <jsp:param name="subTitle" value="Welcome" />
        </jsp:include>
        
        <div class="content">
            <div class="item">
                <%-- 網頁的主要區塊 --%>
                <h1>點餐系統</h1>
            </div>
        </div>
        <%-- 引用function.jsp片段 --%>
        <jsp:include page="/WEB-INF/include/function.jsp" />
        <div class="clearer"><span></span></div>
    </div>
    <%-- 引用footer.jsp片段 --%>
    <%@ include file="/WEB-INF/include/footer.jsp"%>
</div>
</body>
</html>