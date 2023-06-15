package controller;

import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;

import dao.TarefaDAO;
import jakarta.servlet.ServletException;   
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Tarefa;
import jakarta.servlet.annotation.WebServlet;

/**
 * Servlet implementation class ObterTarefasServelet
 */
@WebServlet("/obterTarefasServelet")
public class ObterTarefasServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ObterTarefasServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession();
		 int userId = (int) session.getAttribute("usernameId");
         TarefaDAO tarefaDAO = new TarefaDAO();
         List<Tarefa> tarefas = tarefaDAO.obterTarefasPorUsuario(userId);
		 String json = new Gson().toJson(tarefas);
         response.setContentType("application/json");
         response.setCharacterEncoding("UTF-8");
         response.getWriter().write(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
