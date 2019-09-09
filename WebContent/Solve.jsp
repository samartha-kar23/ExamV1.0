<%@page import="java.util.HashMap"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.kar.ExamUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=ISO-8859-1" />
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<title>Exam v1.0</title>
<!--  Prevent Browser Refresh -->

<!-- //////////////////////// -->
<!--  
<script type = "text/javascript" >
   function preventBack(){window.history.forward();}
    setTimeout("preventBack()", 0);
    window.onunload=function(){null};
    
    function requestFullScreen(element) {
        // Supports most browsers and their versions.
        var requestMethod = element.requestFullScreen || element.webkitRequestFullScreen || element.mozRequestFullScreen || element.msRequestFullScreen;

        if (requestMethod) { // Native full screen.
            requestMethod.call(element);
        } else if (typeof window.ActiveXObject !== "undefined") { // Older IE.
            var wscript = new ActiveXObject("WScript.Shell");
            if (wscript !== null) {
                wscript.SendKeys("{F11}");
            }
        }
    }
    
    var elem = document.body; // Make the body go full screen.
    requestFullScreen(elem);
</script>
-->

<script>
/////////////////


<%
String clock = request.getParameter( "clock" );

if( clock == null ) clock = "180";
%>
function myFunction() {
	  alert("Allow full screen");
	  //launchIntoFullscreen(document.documentElement);
	}
var timeout = <%=clock%>;
//var butsub = document.getElementByName("sub");
function timer()
{
if( --timeout > 0 )
{
launchIntoFullscreen(document.documentElement); // the whole page
document.forma.clock.value = timeout;
window.setTimeout( "timer()", 1000 );
}
else
{
document.forma.clock.value = "Time over";
///disable submit-button etc
document.getElementById('prev').style.display = 'none'; 
document.getElementById('next').style.display = 'none'; 
document.getElementById('save').style.display = 'none'; 
//butsub.click();
}
}
</script>
</head>
<body id="element" onload="launchIntoFullscreen(document.documentElement)">
	<div>
		<span>Full Screen Mode Disabled</span>
		<button id="go-button">Enable Full Screen</button>
	</div>
<nav class="navbar navbar-expand-lg navbar navbar-dark bg-dark">
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
<jsp:useBean  class="com.kar.QuestionsUtility" id="b1" scope="application"></jsp:useBean>
<br>

<%!  
Object[] o;
int current = 0;
static int currentQuestion;
String status = "checked";
HashMap<Integer,String> resp_map = new HashMap<Integer,String>() ;
String cOption = null;
int totalQuestions = 0;
%>

<% 

String Exam_Id = request.getParameter("Start");
out.println("Attempt all questions");
//b1.Category(Exam_Id);

//request.setAttribute("currentQuestion", currentQuestion);
//o = b1.question(1);
o = (Object[])request.getAttribute("question");
current = (Integer)request.getAttribute("currentQuestion");
resp_map = (HashMap<Integer,String>)request.getAttribute("chosenOption");
//out.println(resp_map);
cOption = (String) request.getAttribute("cOption");
totalQuestions = (Integer)request.getAttribute("totalQuestions");
out.println(resp_map);
out.println(current);
out.println(cOption);


%>
<%// if(resp_map!= null){ out.println((resp_map.get(current)!=null)?"checked":"") } %>

<div class="container border-top border-success"  style="margin-top:30px;">
<form action="ExamController" method="post" accept-charset="utf-8" name="forma">
	            <legend>
                <div class="col-sm-9">Quiz - </div>
                Seconds remaining: <input type="text" name="clock" value="<%=clock%>" style="border:0px solid white">
                <span id="timeleft" class="text-right"></span>
				</legend>
  <div class="row" style="margin-top:5px;">
  	<div class="col-md-1" style="background: #909497;"><%=o[0]%></div> 
    <div class="col-md-11" style="background: #d0d3d4;"><%=o[1]%></div>
    
  </div>
  <br>
  <div class="row input-group mb-3">
  		<div class="col-sm-2"></div>	
  		<%  if(cOption!=null){
  			if(cOption.equals(o[2])){
  		%>
    	<input class="col-sm-1 btn btn-outline-secondary" type="radio" <%=status%> name="op" value="<%=o[2] %>">
    	<label class="col-sm-9">1. <%=o[2]%></label>
    	<% } 
  		else { %>
    	<input class="col-sm-1 btn btn-outline-secondary" type="radio"  name="op" value="<%=o[2] %>">
    	<label class="col-sm-9">1. <%=o[2]%></label>
    	<% } }
  		else { %>
  	    	<input class="col-sm-1 btn btn-outline-secondary" type="radio"  name="op" value="<%=o[2] %>">
  	    	<label class="col-sm-9">1. <%=o[2]%></label>
  		<%	 }	%>
    	
  		<div class="col-sm-2"></div>	
  		<%  if(cOption!=null){
  			if(cOption.equals(o[3])){
  		%>
    	<input class="col-sm-1 btn btn-outline-secondary" type="radio" <%=status%> name="op" value="<%=o[3] %>">
    	<label class="col-sm-9">2. <%=o[3]%></label>
    	<% } 
  		else { %>
  		<input class="col-sm-1 btn btn-outline-secondary" type="radio"  name="op" value="<%=o[3] %>">
    	<label class="col-sm-9">2. <%=o[3]%></label>
    	<% } } 	
    	  		else { %>
  	    	<input class="col-sm-1 btn btn-outline-secondary" type="radio"  name="op" value="<%=o[3] %>">
  	    	<label class="col-sm-9">2. <%=o[3]%></label>
  		<%	 }	%>
  		
    	<div class="col-sm-2"></div>
  		<%  if(cOption!=null){
  			if(cOption.equals(o[4])){
  		%>    	
    	<input class="col-sm-1 btn btn-outline-secondary" type="radio" <%=status%> name="op" value="<%=o[4] %>">
    	<label class="col-sm-9">3. <%=o[4]%></label>
    	<% } 
  		else { %>
  		<input class="col-sm-1 btn btn-outline-secondary" type="radio"  name="op" value="<%=o[4] %>">
    	<label class="col-sm-9">3. <%=o[4]%></label>
    	<% } } 	
    	  		else { %>
  	    	<input class="col-sm-1 btn btn-outline-secondary" type="radio"  name="op" value="<%=o[4] %>">
  	    	<label class="col-sm-9">3. <%=o[4]%></label>
  		<%	 }	%>
  		<div class="col-sm-2"></div>	
    	<%  if(cOption!=null){
  			if(cOption.equals(o[5])){
  		%> 
    	<input class="col-sm-1 btn btn-outline-secondary" type="radio" <%=status%> name="op" value="<%=o[5] %>">
    	<label class="col-sm-9">4. <%=o[5]%></label>
    	<% } 
  		else { %>
  		<input class="col-sm-1 btn btn-outline-secondary" type="radio"  name="op" value="<%=o[5] %>">
    	<label class="col-sm-9">4. <%=o[5]%></label>
    	<% } } 
    	  		else { %>
  	    	<input class="col-sm-1 btn btn-outline-secondary" type="radio"  name="op" value="<%=o[5] %>">
  	    	<label class="col-sm-9">4. <%=o[5]%></label>
  		<%	 }	%>
    	
    	
    		
  </div> 
  <%if(current!=0){ %>
  <input type="submit" class="btn btn-primary" id="prev" value="Prev" name="prev">
  <% } %>
  <%if(current!=totalQuestions-1){ %>
  <input type="submit" class="btn btn-primary" id="next" value="Next" name="next">
  <% } %>
  
  <input type="submit" class="btn btn-warning" id="save" value="Save" name="save">
  <input type="submit" class="btn btn-success" value="Submit" name="sub">
  <input type="hidden" value="<%=current+1 %>" name="N">
  <input type="hidden" value="<%=current-1 %>" name="P">
  <input type="hidden" value="<%=current %>" name="SV">
  <input type="hidden" value="refresh" name="refresh">
   <br>

  </form>
</div>

</div>
<script>
//window.open ("Solve.jsp","","fullscreen=yes"); self.close();
//toggleFS();
if(timeout === 180){
myFunction();
}
timer();
////////////////////////
function launchIntoFullscreen(element) {
  if(element.requestFullscreen) {
    element.requestFullscreen();
  } else if(element.mozRequestFullScreen) {
    element.mozRequestFullScreen();
  } else if(element.webkitRequestFullscreen) {
    element.webkitRequestFullscreen();
  } else if(element.msRequestFullscreen) {
    element.msRequestFullscreen();
  }
}
/* Get into full screen */



//////////////////
//GoInFullscreen($("#element").get(0));
////////////////////////
</script>
</body>
</html>