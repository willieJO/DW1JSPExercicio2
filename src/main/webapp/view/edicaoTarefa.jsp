<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@ page import="model.Tarefa" %>
<%
Tarefa tarefa = (Tarefa) request.getAttribute("tarefa");
	
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edição de Tarefa</title>
</head>
<body>
    <h1>Edição de Tarefa</h1>
    <form method="post" action="edicaoTarefaServlet">
        <input type="hidden" name="id" value="<%= tarefa.getId() %>">
        <label for="titulo">Título:</label>
        <input type="text" id="titulo" name="titulo" value="<%= tarefa.getTitulo() %>" required>
        <br>
        <label for="descricao">Descrição:</label>
        <textarea id="descricao" name="descricao" required><%= tarefa.getDescricao() %></textarea>
        <br>
        <input type="submit" value="Salvar Tarefa">
    </form>
</body>
</html>
