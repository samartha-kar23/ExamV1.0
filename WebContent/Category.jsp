<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.kar.ExamUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

 


<title>Exam v1.0</title>
</head>

<body>
<nav class="navbar navbar-expand-lg navbar navbar-dark bg-dark"">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="Category.jsp">Challenges</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="#" tabindex="-1" >Leader Board</a>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>
<div style="margin:20px">
<jsp:useBean  class="com.kar.ExamUtility" id="b1" ></jsp:useBean>
<br>

<% 

String CategoryName ;
List<Object[]> l;
l=b1.Category();
Integer Category_Id; // Exam_id
String Category_Name; // Exam Name
//Iterator itr = l.iterator();
//while(itr.hasNext()){
	//out.println(itr.next());
	  	for(Object[] item: l){
        Category_Name = (String)item[0];
         Category_Id = (Integer)item[1];
         
  		     
%>

<div class="card" style="width: 18rem; float: left; margin: 10px; ">
  <img src="..." class="card-img-top" alt="...">
  <div class="card-body">
  <%  //CategoryName = (String) itr.next(); 
  		//CategoryName.replaceAll("\\s", "");

  		     
  %>
    <h5 class="card-title"><% out.println(Category_Name); %></h5>
    <p class="card-text">some text</p>
    <a href="Challenges.jsp?Category_Id=<%=Category_Id%>" name="<%=Category_Id%>" class="btn btn-primary">Go To Exam</a>
  </div>
</div>

<% 	
//out.println("<li><a href='#'>"+itr.next()+"</a><li>");
}
%>
</div>
</body>
</html>