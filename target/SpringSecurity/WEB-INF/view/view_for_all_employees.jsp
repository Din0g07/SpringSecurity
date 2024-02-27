<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: dudar
  Date: 27.02.2024
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>

<h3>
    Information for all employees
</h3>
<security:authorize access="hasRole('HR')">
    <input type="button" value="salary"
           onclick="window.location.href = 'hr_info'">
    Only for HR staff
</security:authorize>

<br>
<br>

<security:authorize access="hasRole('MANAGER')">
<input type="button" value="Performance"
       onclick="window.location.href = 'manager_info'">
Only for Managers
</security:authorize>

</body>
</html>
