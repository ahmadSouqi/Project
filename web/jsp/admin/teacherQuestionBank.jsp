<%--
  Created by IntelliJ IDEA.
  User: asouqi
  Date: 4/4/18
  Time: 5:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Users Page</title>
    <script>
        function removeRow(cell) {
            window.location.href = "/getQuestionBanksTeachers.action?operation=delete" +
                "&txtNameBank="+cell.cells[0].innerHTML+
                 "&txtNameTeacher="+cell.cells[1].innerHTML;
        }
    </script>

</head>
<body>
<jsp:include page="menubar.jsp"/>
<div style="height: 250px;overflow: auto;">
    <table id="table" border="2">
        <tr>
            <form action="/getQuestionBanksTeachers.action" method="post">
                <td><input type="text"  name="txtNameBank"></td>
                <td><input type="text" name="txtNameTeacher"></td>
                <td>
                    <input type="submit" value="Add Row">
                    <input type="hidden"  name="operation" value="add">
                </td>
            </form>
        </tr>

        <tr>
            <th>Bank Name</th>
            <th>Teacher Name</th>
            <th>Delete</th>
        </tr>
        <c:forEach var="teacher_Bank" items="${Teachers_QuestionBanks}">
            <tr>
                <td>${teacher_Bank[0]}</td>
                <td>${teacher_Bank[1]}</td>
                <td onclick="removeRow(this.parentNode)">
                    <input type="submit" value="Delete">
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</div>
<jsp:include page="../../WEB-INF/templete/footer.jsp"/>
</body>
</html>
