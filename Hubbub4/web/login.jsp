<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="$(loginBean!=null}"><c:redirect url ="signin"/></c:if>
<html>
<head><title>Sign In</title>
<style type ="text/css">#flash{color:red;}</style>
</head>
<body>
<h1><b>LOG-IN</b></h1>
<h2 id = "flash">${flash}</h2>  
<div>
<form method="POST" action="signin"> 
<table border="1">
	<tr><td>Username:</td><td><input type="text" name="user" required/></td></tr>
	<tr><td>Password:</td><td><input type="password" name="pass" required/></td></tr>
    <tr><td colspan="2"><input type="submit" value="Log me in !"/></td></tr>
</table>
</form>
</div>
</body>
</html>
