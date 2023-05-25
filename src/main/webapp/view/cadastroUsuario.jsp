<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="<%= request.getContextPath() %>/cadastroUsuario">
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" required>
        <br>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required></input>
        <br>
        <label for="nome">Login:</label>
        <input type="text" id="login" name="login" required>
        <br>
        <label for="senha">Senha:</label>
        <input type="text" id="senha" name="senha" required>
        <br>
        <input type="submit" value="Cadastrar Usuario">
    </form>
</body>
</html>