<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Home</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"
	type="text/javascript"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"
	type="text/javascript"></script>

</head>
<body>	
	<c:set var="userLogged" value="${usuarioLogado.email}" scope="page" />
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">@Dextraining - Java Web</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">

	        <ul class="nav navbar-nav navbar-right">
	            <li>
	            	<div id="logout">
	            	<form id="frmLogout" action="logout" method="post">
	            		<br/>
						<input type="submit" value="Logout" />
					</form>
					</div>	
	            </li>	            
	        </ul>
	        <ul class="nav navbar-nav">
		        <li><a href="#"><c:out value="${userLogged}"/></a></li>
    		</ul>	        						
		</div>
		</div>
	</nav>

	<h3>Bem vindo ao nosso sistema Java Web!<br/></h3>
	<br/>
	<hr>
	<div id="frmCriarEmpresa">
		<h3>Adicionar nova empresa:</h3>
		<form id="novaEmpresa" action="adicionaEmpresa" 
		method="post">
			Nome: <input type="text" name="nome" />
			<br/>
			<br/>
			<input type="submit" value="Enviar" />
		</form>
	</div>
</body>
</html>
