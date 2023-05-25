package controller;

import jakarta.servlet.ServletException; 
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.annotation.WebServlet;

import model.Tarefa;
import model.Usuario;
import dao.TarefaDAO;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/cadastroTarefaServlet")
public class CadastroTarefaServlet extends HttpServlet {
	public CadastroTarefaServlet() {
		super();
	}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        // Verificar se o usuário está autenticado
        if (username != null) {
            // Obter os dados da tarefa do formulário
            String titulo = request.getParameter("titulo");
            String descricao = request.getParameter("descricao");
            Date dataCriacao = new Date(System.currentTimeMillis());

            // Obter o ID do usuário logado
            int userId = (int) session.getAttribute("usernameId");
            
            // Criar a tarefa
            Tarefa tarefa = new Tarefa();
            tarefa.setTitulo(titulo);
            tarefa.setDescricao(descricao);
            tarefa.setDataCriacao(dataCriacao);
            tarefa.setDataConclusao(dataCriacao);
            tarefa.setUsuario(new Usuario());
            tarefa.getUsuario().setId(userId);
            // Salvar a tarefa no banco de dados
            TarefaDAO tarefaDAO = new TarefaDAO();
            tarefaDAO.cadastrarTarefa(tarefa);

            String servletUrl = request.getContextPath() + "/mainServlet"; 
            response.sendRedirect(servletUrl);
            	
        } else {
            // Usuário não autenticado, redirecionar para a página de login
            response.sendRedirect("view/login.jsp");
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.sendRedirect("view/cadastroTarefa.jsp");
    }
}

