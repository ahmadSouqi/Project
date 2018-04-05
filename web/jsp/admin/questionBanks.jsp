<%--
  Created by IntelliJ IDEA.
  User: asouqi
  Date: 4/4/18
  Time: 9:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Questions Banks Page</title>
    <script>
        function setSelectedRow(pp,p) {
            if (p.className=="update"){
                pp.cells[2].setAttribute("hidden","hidden");
                pp.cells[3].removeAttribute("hidden");
                pp.cells[4].removeAttribute("hidden");
                document.getElementById("table").rows[1].cells[2].setAttribute("colspan","2");
                setRow(pp.cells,true,"9A0A2E");
            }
            if (p.className=="save"){
                var form=document.getElementById("myForm");
                document.getElementById("txtName").value=pp.cells[0].innerHTML;
                form.submit();
            }
            if (p.className=="cancel"){
                pp.cells[2].removeAttribute("hidden");
                pp.cells[3].setAttribute("hidden", "hidden");
                pp.cells[4].setAttribute("hidden", "hidden");
                document.getElementById("table").rows[1].cells[2].removeAttribute("colspan");
                setRow(pp.cells, false, "#47433F");
            }
        }

        function setRow(t,editable,color) {
            document.getElementById("oldName").value=t[0].innerHTML;
            t[0].setAttribute("contenteditable",editable);
            t[0].style.color=color;
        }

        function removeRow(cell) {
            window.location.href = "/getQuestionBanks.action?operation=delete&id="+cell.cells[0].innerHTML;
        }
    </script>
</head>
<body>
<jsp:include page="menubar.jsp"/>
<div style="height: 250px">
    <table id="table" border="2">
        <tr>
            <form action="/getQuestionBanks.action" method="get">
                <td><input type="text"  name="txtName"></td>
                <td><input type="submit" value="Add Row">
                <input type="hidden"  name="operation" value="add"></td>
            </form>
        </tr>

        <tr>
            <th>Questions Bank Name</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach var="questionBank" items="${QuestionsBanks}">
            <tr>
                <td>${questionBank.name}</td>
                <td class="update" onclick="setSelectedRow(this.parentNode,this)">
                    <input type="submit" value="Edit">
                </td>
                <td class="save" hidden="hidden" onclick="setSelectedRow(this.parentNode,this)">
                    <input type="submit" value="Save">
                </td>
                <td class="cancel" hidden="hidden" onclick="setSelectedRow(this.parentNode,this)">
                    <input type="submit" value="Cancel">
                </td>
                <td onclick="removeRow(this.parentNode)">
                    <input type="submit" value="Delete">
                </td>
            </tr>
        </c:forEach>
    </table>

    <form  hidden id="myForm" action="/getQuestionBanks.action?operation=update" method="post">
        <input type="text" id="txtName" name="txtName">
        <input type="text" id="oldName" name="oldName">
    </form>
</div>
</div>
<jsp:include page="../../WEB-INF/templete/footer.jsp"/>
</body>
</html>
