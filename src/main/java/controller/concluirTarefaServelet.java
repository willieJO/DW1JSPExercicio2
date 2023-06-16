package controller;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.TarefaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Tarefa;

/**
 * Servlet implementation class concluirTarefaServelet
 */
@WebServlet("/concluirTarefa")
public class concluirTarefaServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public concluirTarefaServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper  objectMapper = new ObjectMapper();
		Tarefa tarefa = objectMapper.readValue(request.getReader(), Tarefa.class);
        TarefaDAO tarefaDAO = new TarefaDAO();
        tarefaDAO.concluirTarefa(tarefa.getId());
		
	}

}
