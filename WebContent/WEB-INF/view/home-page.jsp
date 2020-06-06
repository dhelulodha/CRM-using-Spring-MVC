<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>

<link type="text/css"
      rel="stylesheet"
      href="${pageContext.request.contextPath}/resources/css/style.css" />
      
<link type="text/css"
      rel="stylesheet"
      href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" /> 

</head>
<body>

        <div id="wrapper">
  <div id="header">
        <h2>CRM - Customer Relationship Manager</h2>
  </div>
</div>

<span><a href="${pageContext.request.contextPath}/users/login">logout</a></span>

<br><br><br>

<a href="${pageContext.request.contextPath}/customer/list"> List of Customers </a>

<br><br><br>

<a href="${pageContext.request.contextPath}/customer/showFormForAdd"> Add Customer </a>

<br><br><br>

</body>
</html>