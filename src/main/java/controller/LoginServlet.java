package controller;

import java.io.IOException;

import dao.UsuarioDAO;
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
        HttpSession session = request.getSession();
        UsuarioDAO dao = new UsuarioDAO();
        if (dao.usuarioValido(username,password,session)) {
            // Autenticação bem-sucedida
            
            session.setAttribute("username", username);
            
            response.sendRedirect("mainServlet");
        } else {
            // Autenticação falhou
            response.sendRedirect("view/login.jsp");
        }
    }
}
