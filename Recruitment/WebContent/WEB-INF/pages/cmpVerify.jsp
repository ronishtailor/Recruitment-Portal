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
 <h2><center>Verify Company Requests</center></h2>

 <table class="table table-dark">
   <thead>
     <tr>
       <th>Company Name</th>
       <th>Email</th>
       <th>Website</th>
        <th>Contact</th>
        <th>Location</th>
        <th>Verify</th>
     </tr>
   </thead>
   <tbody>
       <c:forEach items="${cmplist}" var="x" varStatus="loop">
                    <tr>
                    <td>${x.name}</td>
                    <td>${x.email}</td>
                    <td>${x.website}</td>
                    <td>${x.contact}</td>
                    <td>${x.location}</td>
                    <td>
                    <form action="cmpVerified">
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