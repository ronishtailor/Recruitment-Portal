<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page isELIgnored="false"%>
<html lang="en">
<head>
 <title>Student Request</title>
 <meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
 <center><h2>Verify Student Requests</h2></center>
             <br/>
             <br/>
 <table class="table table-dark">
   <thead>
     <tr>
       <th>Name</th>
       <th>Email</th>
       <th>Roll no</th>
        <th>Verify</th>
     </tr>
   </thead>
   <tbody>
     <c:forEach items="${list}" var="x" varStatus="loop">
                    <tr>
                    <td>${x.name}</td>
                    <td>${x.email}</td>
                    <td>${x.rollno}</td>
                    <td>
                    <form action="stVerified">
                        <input type="hidden" name="email" value=${x.email}>
                        <button type="submit">Verify</button>
                    </form>
                    </td>
                    </tr>
    </c:forEach>
   </tbody>
 </table>
</div>

</body>
</html>