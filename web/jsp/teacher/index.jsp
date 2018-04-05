<%--
  Created by IntelliJ IDEA.
  User: asouqi
  Date: 4/2/18
  Time: 11:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Admin Page</title>
</head>
<body>
<jsp:include page="menubar.jsp"/>
<div style="height: 250px">
    <h2>Welcome ${sessionScope.get("user").userName}</h2>
    <hr>
    <ul>
        <c:forEach var="BankName" items="${TeacherBanks}">
                ${BankName}
            <%--<li>
              <a href="questionQruop.jsp?bankName="+${BankName}>${BankName}</a>
          </li>--%>
        </c:forEach>
    </ul>
</div>
<jsp:include page="../../WEB-INF/templete/footer.jsp"/>
</body>
</html>