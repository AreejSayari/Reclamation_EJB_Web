<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nouveau utilisateur</title>
</head>
<body>
<h2>Creer nouveau compte</h2>
<p><b> ${ sessionScope.msg4 }</b></p> 

	<form method="POST" action="controleur">
		ID: <input type="number" name="id" required/>   <br>  <br>
		Nom: <input type="text" name="nom" />   <br>  <br>
		Prenom: <input type="text" name="prenom" />   <br>  <br>  
		Email: <input type="email" name="login" required/>   <br>  <br>    
		Password:<input type="password" name="pwd"  required/>   <br>  <br>  
		<input type="submit" value="créer" name="action"> 		
	</form>	
</body>
</html>