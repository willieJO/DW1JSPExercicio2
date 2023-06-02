package controller;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import dao.TarefaDAO;
import jakarta.servlet.ServletException; 
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.annotation.WebServlet;
import model.HTTPRequestStatus;
import model.Tarefa;
import model.Usuario;
import dao.UsuarioDAO;

/**
 * Servlet implementation class CadastroUsuarioServelet
 */
@WebServlet("/cadastroUsuario")
public class CadastroUsuarioServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroUsuarioServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("view/cadastroUsuario.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HTTPRequestStatus http = new HTTPRequestStatus();
        http.setStatus(false);
        http.setRedirectUrl("");
        ObjectMapper  objectMapper = new ObjectMapper();
		Usuario user = objectMapper.readValue(request.getReader(), Usuario.class);
        UsuarioDAO dao = new UsuarioDAO();
        dao.cadastrarUsuario(user);
        http.setRedirectUrl("mainServlet");
        String json = new Gson().toJson(http);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
	}

}
