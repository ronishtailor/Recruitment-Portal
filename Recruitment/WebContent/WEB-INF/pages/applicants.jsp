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
 <h2>Application Requests</h2>

 <table class="table table-dark">
   <thead>
     <tr>
       <th>Student Name</th>
       <th>Student Email</th>
       <th>Post</th>
       <th>Branch</th>
       <th>Percentage 10</th>
       <th>Percentage 12</th>
       <th>Aggregate</th>
       <th>Backlogs</th>
       <th>Skills</th>
       <th>Passing Year</th>
       <th>Contact</th>
      </tr>
   </thead>
   <tbody>
       <c:forEach items="${list}" var="x" varStatus="loop">
                    <tr>
                    <td>${x.studentname}</td>
                    <td>${x.studentemail}</td>
                    <td>${x.post}</td>
                    <td>${x.branch}</td>
                    <td>${x.per10}</td>
                    <td>${x.per12}</td>
                    <td>${x.aggregate}</td>
                    <td>${x.backlogs}</td>
                    <td>${x.skills}</td>
                    <td>${x.passingyear}</td>
                    <td>${x.contact}</td>
                    <td>
                    <form action="selected">
                      <input type="hidden" name="studentemail" value=${x.studentemail} >
                      <input type="hidden" name="postid" value=${x.postid} >
                      <button type="submit">Select</button>
                    </form>
                    </td>
                    </tr>
                    </c:forEach>
   </tbody>
 </table>
</div>

</body>
</html>