<%--
  Created by IntelliJ IDEA.
  User: asouqi
  Date: 4/1/18
  Time: 11:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <title>$Title$</title>
    <link rel="stylesheet" type="text/css" href="st.css" />
  </head>
  <body>
  <jsp:include page="WEB-INF/templete/header.jsp"/>
  <div id="main">
    <div id="site_content">
      <div id="content">
        <form action="/login.action" method="post" style="width: 450px;text-align: center">
          <fieldset style="border-color: #009FBC">
            <legend>Log In</legend>
            <p>
              <label style="font-size: medium">User Name:</label>
              <input type="text" name="txtUserName" tabindex="1">
            </p>
            <p>
              <label>Password:</label>
              <input type="password" name="txtPassword" tabindex="2">
            </p>
            <p>
              <input type="submit" value=" Log In " style="margin-right: 40%"/>
              <input type="checkbox" value="Remaber Me" style="align-items: flex-end">
            </p>
          </fieldset>
        </form>
      </div>
      <div></div>
    </div>
  </div>
  <jsp:include page="WEB-INF/templete/footer.jsp"/>
  </body>
</html>
