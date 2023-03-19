<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body >
<h2>Authentification</h2>
	<form method="POST" action="controleur">
		Email: <input type="email" name="login" />   <br>  <br>  
		Password:<input type="password" name="pwd"  />   <br>  <br>  
		<input type="submit" value="se connecter" name="action"> <br>  <br> 
		<input type="submit" value="creer compte" name="action"> 		
	</form>
<br>
<h2>Lister Etudiant(s)</h2>	
<table border="1" cellpadding="0" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111"
      width="62%" id="AutoNumber1">
		<tr>
		<th>ID</th> <th>Actif</th> <th>Email</th><th>pass</th> <th>Nom</th><th>Prenom</th>
	    </tr>
	    <c:forEach items="${utilisateur}" var="u">
	    	
	    	<td><c:out value="${u.id}"/></td>
	    	<td><c:out value="${u.actif}"/></td>
	    	<td><c:out value="${u.email}"/></td>
	    	<td><c:out value="${u.password}"/></td>
	    	<td><c:out value="${u.nom}"/></td>
	    	<td><c:out value="${u.prenom}"/></td>
	   	    	
	    </c:forEach>
</table>

</body>
</html>