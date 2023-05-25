package controller;



import jakarta.servlet.RequestDispatcher; 
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.annotation.WebServlet;
import dao.TarefaDAO;
import model.Tarefa;
import java.io.IOException;
import java.util.List;
import dao.TarefaDAO;

@WebServlet("/mainServlet")
public class MainServlet extends HttpServlet {
	public MainServlet() {
		super();
	}
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        // Verificar se o usuário está autenticado
        if (username != null) {
            // Obter as tarefas do usuário logado
            int userId = (int) session.getAttribute("usernameId");// Obter o ID do usuário logado

            TarefaDAO tarefaDAO = new TarefaDAO();
            List<Tarefa> tarefas = tarefaDAO.obterTarefasPorUsuario(userId);

            // Passar as tarefas para a página JSP
            request.setAttribute("tarefas", tarefas);
            request.getRequestDispatcher("view/main.jsp").forward(request, response);
        } else {
            // Usuário não autenticado, redirecionar para a página de login
            response.sendRedirect("view/login.jsp");
        }
    }
}
