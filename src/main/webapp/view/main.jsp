<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@ page import="model.Tarefa" %>
<%@ page import="java.util.List" %>
<%

List<Tarefa> tarefas =  (List<Tarefa>) request.getAttribute("tarefas");
	
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Página Principal</title>
</head>
<body>
    <h1>Página Principal</h1>
    <h2>Tarefas:</h2>
    <ul>
        <% for (Tarefa tarefa : tarefas) { %>
            <li><%= tarefa.getTitulo() %></li>
            <li><%= tarefa.getDescricao() %></li>
        <% } %>
    </ul>
    <a href="view/cadastroTarefa.jsp">Criar nova tarefa</a>
    
</body>
</html>
