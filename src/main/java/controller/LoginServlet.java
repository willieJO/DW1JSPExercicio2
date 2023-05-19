package controller;

import java.io.IOException;  
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	public LoginServlet() {
		super();
	}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Realizar a validação do usuário e senha
        // ...

        // Exemplo de validação básica
        if (username.equals("admin") && password.equals("admin123")) {
            // Autenticação bem-sucedida
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            response.sendRedirect("mainServlet");
        } else {
            // Autenticação falhou
            response.sendRedirect("login.jsp");
        }
    }
}
