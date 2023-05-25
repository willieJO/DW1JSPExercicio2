package controller;

import java.io.IOException;

import dao.TarefaDAO;
import jakarta.servlet.ServletException; 
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.annotation.WebServlet;
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
		String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        Usuario user = new Usuario();
        user.setNome(nome);
        user.setEmail(email);
        user.setLogin(login);
        user.setSenha(senha);
        UsuarioDAO dao = new UsuarioDAO();
        dao.cadastrarUsuario(user);
        response.sendRedirect("view/login.jsp");
	}

}
