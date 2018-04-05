<%--
  Created by IntelliJ IDEA.
  User: asouqi
  Date: 4/2/18
  Time: 4:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../../st.css" />
</head>
<body>
<div id="main">
<div id="header">
    <div id="logo">
        <div id="logo_text">
            <!-- class="logo_colour", allows you to change the colour of the text -->
            <h1><a href="../../index.jsp"><span class="logo_colour">Online Exam System</span></a></h1>
            <h2></h2>
        </div>
    </div>
    <div id="menubar">
        <ul id="menu">
            <!-- put class="selected" in the li tag for the selected page - to highlight which page you're on -->
            <li class="selected"><a href="index.jsp">Home</a></li>
            <li><a href="${param.page1}">${param.headerTitle1}</a></li>
            <li><a href="${param.page2}">${param.headerTitle2}</a></li>
            <li><a href="${param.page3}">${param.headerTitle3}</a></li>
            <li><a href="contact.html">Contact Us</a></li>
        </ul>
    </div>
</div>
</div>
</body>
</html>
