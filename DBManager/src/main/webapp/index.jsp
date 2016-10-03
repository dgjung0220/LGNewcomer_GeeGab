<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- <jsp:forward page="/sample/openSampleList.do"/> --%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>NileBlue_DBManager</title>

<!-- Bootstrap core CSS -->
<link href="resource/css/bootstrap.min.css" rel="stylesheet">
<link href="resource/css/starter-templete.css" rel="stylesheet">
</head>

<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">NileBule</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#about">About</a></li>
					<li><a href="#contact">Contact</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>

	<div class="container">
		<div class="starter-template">
			<h1>NileBule DBManager</h1>
			<p class="lead">
				Use this document as a way to quickly start any new project.<br>
				All you get is this text and a mostly barebones HTML document.
			</p>
		</div>
	</div>
	
	
	<div class="panel panel-default">
		<div class="panel-body">
			<form method="post" enctype="multipart/form-data"
			action="insertMenu.do" id="insertMenu" name="insertMenu">
				<div class="form-group">
					<label>이름 (필수)</label>
					<div class="form-group">
						<input type="text" class="form-control" name="nameOfMenu"
							placeholder="ex) 고추장 제육복음" required autofocus="autofocus">
					</div>
					<label>칼로리</label>
					<div class="form-group">
						<input type="number" class="form-control" name="calOfMenu"
							placeholder="ex) 496, 모르시면 비우셔도 됩니다.">
					</div>
					<label>대표 이미지</label>
					<div class="form-group">
						<input type="file" name="file">
					</div>
				
					<button type="submit" class="btn btn-success">Submit</button>
				</div> 
			</form>
		</div>
	</div>
	
	<div class="panel panel-default">
		<div class="panel-body">			
		</div>
	</div>

	
	
	

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="resource/js/bootstrap.min.js"></script>
</body>
</html>