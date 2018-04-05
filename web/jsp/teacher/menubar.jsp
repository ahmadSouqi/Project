<%--
  Created by IntelliJ IDEA.
  User: asouqi
  Date: 4/5/18
  Time: 1:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<jsp:include page="../../WEB-INF/templete/header_menubar.jsp">
    <jsp:param name="headerTitle1" value="Question Group"/>
    <jsp:param name="page1" value="/getQuestionGroup.action"/>

    <jsp:param name="headerTitle2" value="Question Bank"/>
    <jsp:param name="page2" value="/getQuestionBanks.action"/>

    <jsp:param name="headerTitle3" value="Teacher Question Bank"/>
    <jsp:param name="page3" value="/getQuestionBanksTeachers.action"/>
</jsp:include>
</body>
</html>
