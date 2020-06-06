<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Form</title>

<link type="text/css"
      rel="stylesheet"
      href="${pageContext.request.contextPath}/resources/css/style.css" />
      
<link type="text/css"
      rel="stylesheet"
      href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />  
      
   <script type="text/javascript" src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
   
   <script type="text/javascript" 
      src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.17.0/jquery.validate.min.js"></script>

</head>
<body>

   
<div id="wrapper">
  <div id="header" >
        <h2>CRM - Customer Relationship Manager</h2>
  </div>
</div>
   
 <div id="container">
      <h3 style="text-align:center;">LOGIN FORM</h3>
      
     
      
      <form:form action="validate" modelAttribute="users" method="POST" cssClass="loginForm">
         
         
         <table>
             <tbody>
                 <tr> 
                   <td> <label>Email:</label> </td>
                   <td> <form:input path="email"/> </td>
                 </tr>
                 <tr> 
                   <td> <label>Password:</label> </td>
                   <td> <form:password path="password"/> </td>
                 </tr>
                 
                 
                 <tr> 
                   <td> <label></label> </td> 
                   <td> <input type="submit" class="save" value="Login"/> </td>
                 </tr>
                 
                 <tr> 
                   <td> <label></label> </td>
                   <td>
                   <c:if test="${param.act eq 'lo'}">
                   <p> Session Expired.Please log in again...!</p>
                   </c:if>
                   </td>
                 </tr>
             
             </tbody>   
         </table>
      
      </form:form>
      
      <div style="clear; both;"></div>
      
      <p style="text-align:center;">
      
      <a href="${pageContext.request.contextPath}/users/signup">Sign up</a>
      
      </p>
      
 </div>  
 
 <script type="text/javascript">
      
     $(document).ready(function() { 
    	 
    	 $(".loginForm").validate({
    	
    		 rules: {
    			       
    			       email: {
    			    	   required:true,
    			    	   email:true
    			       },
    			       
    			       password: {
    			    	   required:true,
    			    	   minlength:3
    			       }
    		 },
    		 
    		 messages: {
    			 
			       
			          email: {
			        	  required:"Please enter your email address!",
			    	      email:"Please enter a valid email address!"
			          },
			          
			          password: {
			        	  required:"Please enter your password!",
			    	      minlength:"Last name must contain atlest 3 characters!"
			          }
    			 
    		 }
    		 
    		 
    	 });
    	   	 
     });
  

  
  </script>

</body>
</html>