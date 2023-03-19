<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Espace Administrateur</title>
</head>
<body >
<h1 align="center">Espace Administrateur </h1>

<h2>Ajouter Type Reclamation</h2>
	<form method="POST" action="controleur">
		ID: <input type="text" name="id" />   <br>  <br>
		Type: <input type="text" name="titre" />   <br>  <br>   
		<input type="submit" value="Ajouter_typeRec" name="action"> 	
	</form>


<h2>Lister Etudiant(s)</h2>	
<table border="1" cellpadding="0" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111"
      width="62%" id="AutoNumber1">
		<tr>
		<th>ID</th> <th>Actif</th> <th>Email</th> <th>Nom</th><th>Prenom</th>
	    </tr>
	    <c:forEach items="${etudiants}" var="u">
	    <tr>	
	    	<td><c:out value="${u.id}"/></td>
	    	<td><c:out value="${u.actif}"/></td>
	    	<td><c:out value="${u.email}"/></td>
	    	<td><c:out value="${u.nom}"/></td>
	    	<td><c:out value="${u.prenom}"/></td>
	   	  </tr>  	
	    </c:forEach>
</table>
<br><br>

<h2>Lister Reclamation(s)</h2>	
<table border="1" cellpadding="0" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111"
      width="62%" id="AutoNumber1">
		<tr>
		<th>ID</th> <th>Titre</th> <th>Description</th> <th>Type_Reclamation</th> <th>ID_Etudiant</th>
	    </tr>
	    <c:forEach items="${reclamations}" var="u">
	    <tr>	
	    	<td><c:out value="${u.id}"/></td>
	    	<td><c:out value="${u.titre}"/></td>
	    	<td><c:out value="${u.description}"/></td>
	    	<td><c:out value="${u.typeRec.getType()}"/></td>
	    	<td><c:out value="${u.etudiant.getId()}"/></td>
	   	 </tr>   	
	    </c:forEach>
</table>
<br><br>

<h2>Lister Type(s) Reclamation(s)</h2>
<table border="1" cellpadding="0" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111"
      width="62%" id="AutoNumber1">
		<tr>
		 <th>ID</th> <th>Type</th> 
	    </tr>
	    <c:forEach items="${typesReclam}" var="u">
	    <tr>
	    	<td><c:out value="${u.id}"/></td>
	    	<td><c:out value="${u.type}"/></td>	 
	    </tr>
	    </c:forEach>
</table>
<br><br>

<h2>Existence mail </h2>
<form method="POST" action="controleur">
		Tappez le mail: <input type="email" name="mail" required />    
		<input type="submit" value="Chercher_mail" name="action">
		<br>
</form>
		<p><b> ${ sessionScope.message }</b></p> 
<br><br>		
		
<h2>Existence Type Reclamation</h2>
<form method="POST" action="controleur">
	Tappez le type de reclamation: <input type="text" name="typeRec" required />    
	<input type="submit" value="Chercher_Type_Reclamation" name="action">
	<br>
</form>
	<p><b> ${ sessionScope.message1 }</b></p> 
<br><br>

<h2>Chercher Reclamation par Etudiant</h2>
<form method="POST" action="controleur">
	Tappez le ID de l'etudiant: <input type="text" name="id_etud" required  />
	<input type="submit" value="Chercher_Reclamation_par_Etudiant" name="action">
	<br>
</form>
	<p><b> ${ sessionScope.message2 }</b></p>
	<br>
	<table border="1" cellpadding="0" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111"
      width="62%" id="AutoNumber1">
		<tr>
		<th>ID</th> <th>Titre</th> <th>Description</th> <th>Type_Reclamation</th>
	    </tr>
	    <c:forEach items="${reclam_etd}" var="u">
	    <tr>
	    	<td><c:out value="${u.id}"/></td>
	    	<td><c:out value="${u.titre}"/></td>
	    	<td><c:out value="${u.description}"/></td>
	    	<td><c:out value="${u.typeRec.getType()}"/></td>
	   	 </tr>   	
	    </c:forEach>
</table> 
<br><br>

<h2>Chercher Type Reclamation Par Type </h2>
<form method="POST" action="controleur">
	Tappez le type: <input type="text" name="type" required  />
	<input type="submit" value="Chercher_Type_Reclamation_par_Type" name="action">
	<br>
</form>
	<p><b> ${ sessionScope.message3 }</b></p> 
</body>
</html>