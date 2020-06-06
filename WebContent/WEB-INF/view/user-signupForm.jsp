<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SignUp Form</title>

<link type="text/css"
      rel="stylesheet"
      href="${pageContext.request.contextPath}/resources/css/style.css" />
      
<link type="text/css"
      rel="stylesheet"
      href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />  
      
   <script type="text/javascript" src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
      
     <!-- <script type="text/javascript" src="js/jquery.validate.js"></script>
      <script type="text/javascript" 
      src="https://cdn.jsdelivr.net/npm/jquery-validation@1.17.0/dist/jquery.validate.js"></script> 
      
      <script type="text/javascript" 
      src="https://cdn.jsdelivr.net/npm/jquery-validation@1.17.0/dist/jquery.validate.min.js"></script> -->
      
      <script type="text/javascript" 
      src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.17.0/jquery.validate.min.js">
      </script>

</head>
<body>

     <div id="wrapper">
  <div id="header">
        <h2>CRM - Customer Relationship Manager</h2>
  </div>
</div>
   
 <div id="container">
      <h3 style="text-align:center;">SignUp Form</h3>
      
      <form:form action="register" modelAttribute="users" method="POST" cssClass="signupForm">
         
       
         <table>
             <tbody>
                
                 <tr> 
                   <td> <label>ID:</label> </td>
                   <td> <form:input path="id" placeholder="please enter an unique id"/> </td>
                 </tr>
                 <tr>
                 <tr> 
                   <td> <label>First Name:</label> </td>
                   <td> <form:input path="firstName"/> </td>
                 </tr>
                 <tr> 
                   <td> <label>Last Name:</label> </td>
                   <td> <form:input path="lastName"/> </td>
                 </tr>
                 <tr> 
                   <td> <label>Email:</label> </td>
                   <td> <form:input path="email"/> </td>
                 </tr>
                 <tr> 
                   <td> <label>Password:</label> </td>
                   <td> <form:password path="password"/> </td>
                 </tr>
                 <tr> 
                   <td> <label>Confirm Password:</label> </td>
                   <td> <form:password path="cpassword" id="password"/> </td>
                 </tr>
                 
                 <tr> 
                   <td> <label></label> </td>
                   <td> <input type="submit" class="save" value="Register"/> </td>
                 </tr>
                 
             
             </tbody>   
         </table>
      
      </form:form>
      
      <div style="clear; both;"></div>
      
      
 </div>  
 
 <script type="text/javascript">
 
 $(document).ready(function() { 
 	 alert("working");
	 $(".signupForm").validate({
	    	
		 rules: {
			 
			       
			       id: {
		    	       required:true,
		    	       minlength:1
		           },
		           
		           firstName: {
			    	   required:true,
			    	   minlength:3
			       },
			 
			       lastName: {
			    	   required:true,
			    	   minlength:3
			       },
			       
			       email: {
			    	   required:true,
			    	   email:true
			       },
			       
			       password: {
			    	   required:true,
			    	   minlength:4
			       },
			       
			       cpassword: {
			    	   required:true,
			    	   minlength:4,
			    	   equalTo:"#password"
			       }
		 },
		 
		 messages: {
			 
			      id: {
		    	       required:"Please enter your id!",
		    	       minlength:"Id must contain atlest 1 characters!"
		          },
		          
		          firstName: {
		    	       required:"Please enter your first name!",
		    	       minlength:"First name must contain atlest 3 characters!"
		          },
		          
		          lastName: {
		        	  required:"Please enter your last name!",
		    	      minlength:"Last name must contain atlest 3 characters!"
		          },
		          
		          email: {
		        	  required:"Please enter your email address!",
		    	      email:"Please enter a valid email address!"
		          },
		       
		          password: {
		        	  required:"Please enter your password!",
		    	      minlength:"Password must contain atlest 4 characters!"
		          },
		          cpassword: {
		        	  required:"Please enter your Password again!",
		    	      minlength:"Password must contain atlest 4 characters!",
		    	      equalTo:"Please enter same password as before"
		          }
		       
		           
			 
		 }
		 
		 
	 });
	   	 

 	
 	     });
 
 </script>

</body>
</html>