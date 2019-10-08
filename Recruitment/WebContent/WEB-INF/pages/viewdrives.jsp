<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page isELIgnored="false"%>
<html lang="en">
<head>
 <title>Company Request</title>
 <meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
 <h2>Drives Information</h2>

 <table class="table table-dark">
   <thead>
     <tr>
       <th>Company Name</th>
       <th>Company Email</th>
       <th>Position</th>
        <th>Salary</th>
        <th>Date</th>
        <th>Requirements</th>
        <th>Criteria</th>
     </tr>
   </thead>
   <tbody>
       <c:forEach items="${driveslist}" var="x" varStatus="loop">
                    <tr>
                    <td>${x.name}</td>
                    <td>${x.email}</td>
                    <td>${x.position}</td>
                    <td>${x.salary}</td>
                    <td>${x.date}</td>
                    <td>${x.requirements}</td>
                    <td>${x.criteria}</td>
                    </tr>
                    </c:forEach>
   </tbody>
 </table>
</div>

</body>
</html>