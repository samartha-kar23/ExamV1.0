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
<script type="text/javascript">
//toggleFS();
</script>
</head>
<body id="element">
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
<jsp:useBean  class="com.kar.QuestionsUtility" id="b1" ></jsp:useBean>
<br>

<% 
String category = request.getParameter("Category_Id");
//out.println(category);  		     
%>
<div class="jumbotron">
  <h1 class="display-4">Important Information!</h1>
  <p class="lead">Please read the below mentioned points carefully before starting the test.</p>
  <hr class="my-4">
 <p>Arrive at the examination venue at least 15 minutes before the start of the examination / 35 minutes before a digital examination.
    <ul><li>
    <b>Law:</b> The examination starts at the moment the book control begins, and you must therefore be present by 8.20 a.m. for regular written examinations and 8.10 a.m. at digital examinations.
    When using a laptop at digital examinations, the laptop has to be set up as soon as possible.</li>
    <li> If you are taking a law exam, the laptop must be set up before the book control.</li>
    <li><b>Coats, backpacks, bags,</b> etc. must be placed as directed.<b> Mobile phones, mp3 players, smartwatches and other electronic devices</b> must be turned off and put away, and cannot be stored in coats or pockets.
    If support material, other than that which is specifically permitted, is found at or by the desk, it may be treated as an attempt to cheat and relevant procedures for cheating will be followed.</li>
    <li>
    The head invigilator will provide information about examination support materials that you are permitted to use during the examination. All dictionaries must be approved by the faculty before the exam and will be handed out in the exam venue by the invigilators.
	</li>
	<li>
    <b>Humanities:</b> Dictionaries must be approved by the faculty at the latest three days before the exam. If you are to bring your own examination support materials directly to the exam venue, the department will provide information about this in advance.</li>
    <li>
    <b>Law:</b> Only examination materials approved by the faculty are permitted. Book control takes place in the exam venue before the start of the examination.</li>
    <li>
    <b>Psychology:</b> Dictionaries must be approved by the faculty Information Centre at the latest one week before the exam. If you dont have a suitable dictionary, you may apply to loan one from the faculty, given that there are dictionaries available in your language. Please click here for application form.
    </li>
    <li>
    <b>Mathematics and sciences:</b> Permitted examination support materials is stated in the course description, and on the examination question paper.</li>
    <li>
    <b>Social Science:</b> Dictionaries must be approved by the faculty Information Centre at the latest one week before the exam. If you are to bring your own examination support materials directly to the examination venue, the department will provide information about this in advance. 
    </li>
    </ul>
</p>
  <a class="btn btn-success btn-lg" href="ExamController?Start=<%=category%>" role="button">Start</a>
</div>
</div>
<script>
//toggleFS();
function GoInFullscreen(element) {
	if(element.requestFullscreen)
		element.requestFullscreen();
	else if(element.mozRequestFullScreen)
		element.mozRequestFullScreen();
	else if(element.webkitRequestFullscreen)
		element.webkitRequestFullscreen();
	else if(element.msRequestFullscreen)
		element.msRequestFullscreen();
}

/* Get out of full screen */
function GoOutFullscreen() {
	if(document.exitFullscreen)
		document.exitFullscreen();
	else if(document.mozCancelFullScreen)
		document.mozCancelFullScreen();
	else if(document.webkitExitFullscreen)
		document.webkitExitFullscreen();
	else if(document.msExitFullscreen)
		document.msExitFullscreen();
}

/* Is currently in full screen or not */
function IsFullScreenCurrently() {
	var full_screen_element = document.fullscreenElement || document.webkitFullscreenElement || document.mozFullScreenElement || document.msFullscreenElement || null;
	
	// If no element is in full-screen
	if(full_screen_element === null)
		return false;
	else
		return true;
}
/*
$("#go-button").on('click', function() {
	if(IsFullScreenCurrently())
	{GoInFullscreen($("#element").get(0));}
	else
		{GoInFullscreen($("#element").get(0));}
});
*/
function toggleFS(){
	
	GoInFullscreen($("#element").get(0));
	
}
</script>
</body>
</html>