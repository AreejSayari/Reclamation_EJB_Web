<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Espace Etudiant</title>
</head>
<body>
	<h1 align="center">Espace Etudiant</h1>
	
<!-- <p><b> ${ sessionScope.msg }</b></p> 
<p><b> ${ sessionScope.msg2 }</b></p> 	
<p><b> ${ sessionScope.msg3 }</b></p>   -->
<h2>Ajouter Reclamation</h2>
	<form method="POST" action="controleur">
		ID: <input type="number" name="id" />   <br>  <br>
		Titre: <input type="text" name="titre" />   <br>  <br>
		Description: <input type="text" name="desc" />   <br>  <br>  
		Type Reclamation: <input type="text" name="type" />   <br>  <br>    
		<input type="submit" value="Ajouter_Reclam" name="action"> 	
	</form>

<p><b> ${ sessionScope.msg1 }</b></p> 
<h2>Lister mes Reclamation(s)</h2>	 <!-- Par etudiant !! -->

<table border="1" cellpadding="0" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111"
      width="62%" id="AutoNumber1">
		<tr>
		<th>ID</th> <th>Titre</th> <th>Description</th> <th>Type_Reclamation</th> 
	    </tr>
	    <c:forEach items="${reclamationsEtudiant}" var="u">
	    	
	    	<td><c:out value="${u.id}"/></td>
	    	<td><c:out value="${u.titre}"/></td>
	    	<td><c:out value="${u.description}"/></td>
	    	<td><c:out value="${u.typeRec.getType()}"/></td>
	    	<!-- <td><c:out value="${u.typeRec.getId()}"/></td> -->
	   	    	
	    </c:forEach>
</table>
	
	
</body>
</html>