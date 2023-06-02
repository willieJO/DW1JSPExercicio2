package controller;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import dao.UsuarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.HTTPRequestStatus;
import model.Tarefa;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import model.Usuario;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	public LoginServlet() {
		super();
	}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ObjectMapper  objectMapper = new ObjectMapper();
        Usuario usuario = objectMapper.readValue(request.getReader(), Usuario.class);
        UsuarioDAO dao = new UsuarioDAO();
        HTTPRequestStatus http = new HTTPRequestStatus();
        http.setStatus(true);
        http.setRedirectUrl("mainServlet");
        if (dao.usuarioValido(usuario.getLogin(),usuario.getSenha(),session)) {
            session.setAttribute("username", usuario.getLogin());
        }
        http.setStatus(true);
        http.setRedirectUrl("mainServlet");
        String json = new Gson().toJson(http);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
}
