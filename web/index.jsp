<%@page contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hubbub&trade;</title>
    </head>
    <body>
        <h1>Hubbub&trade;welcome to Hubbub1!</h1>
        <c:forEach var="post" items="${posts}">
            <fieldset>
                ${post.userName} <sub>(user since )</sub><br>
                ${post.postDesc}<br>
                posted ${post.postedOn}. <!--fmt:formatDate type="DATE" value=""/-->
            </fieldset>
        </c:forEach>
    </body>
</html>
