<%-- 
    Document   : shoppingList
    Created on : 3-Mar-2021, 8:11:53 PM
    Author     : klydm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>Hello, ${user} <a href="ShoppingList?logout"action="logout"> Logout </a></p>
        
        <h2>List</h2>
        <form method ="post" action="ShoppingList">
            Add item:<input type="text" name="item"> 
            <input type="submit" value="Add" action="add"><br>
            
            <c:forEach items="${itemList}" var ="item">
                    <input type="radio" name="item" value="${item}"><br>
            </c:forEach>
            <input type="submit" value="Delete" action="delete">
        </form>
        
    </body>
</html>