<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<%@ page 
language="java" 
contentType="text/html; charset=ISO-8859-1" 
pageEncoding="ISO-8859-1" 
import = "com.smallprintjobs.Pruebas.crearUsuario" 
%> 
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>


	<h2>Parte 2</h2>
	
	<input name="submit" type="submit" class="com.smallprintjobs.Pruebas" value="Aceptar"> 
	<input type="button" value="cargar Usuario" onclick="ejecutaCodigo()">
	<jsp:useBean class="com.smallprintjobs.Pruebas" id="crearUsuario" />
	
</body>
</html>
 --%>