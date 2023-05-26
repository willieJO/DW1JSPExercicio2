package controller;

import jakarta.servlet.ServletException; 
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Tarefa;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.TarefaDAO;

/**
 * Servlet implementation class DeletarTarefaServlet
 */
@WebServlet("/deletarTarefa")
public class DeletarTarefaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletarTarefaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        response.sendRedirect("mainServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper  objectMapper = new ObjectMapper();
		Tarefa tarefa = objectMapper.readValue(request.getReader(), Tarefa.class);
		
		
        // Deletar a tarefa do banco de dados
        TarefaDAO tarefaDAO = new TarefaDAO();
        tarefaDAO.deletarTarefa(tarefa.getId());

        // Redirecionar de volta para a página principal
        
		
	}

}
