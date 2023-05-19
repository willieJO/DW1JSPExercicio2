<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@ page import="model.Tarefa" %>
<%@ page import="java.util.List;" %>
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
        <% } %>
    </ul>
    <form method="post" action="cadastroTarefaServlet">
        <label for="titulo">Título:</label>
        <input type="text" id="titulo" name="titulo" required>
        <br>
        <label for="descricao">Descrição:</label>
        <textarea id="descricao" name="descricao" required></textarea>
        <br>
        <input type="submit" value="Cadastrar Tarefa">
    </form>
</body>
</html>
