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
            int userId = 0; // Obter o ID do usuário logado

            // Criar a tarefa
            Tarefa tarefa = new Tarefa();
            tarefa.setTitulo(titulo);
            tarefa.setDescricao(descricao);
            tarefa.setDataCriacao(dataCriacao);
            tarefa.setUsuario(new Usuario());

            // Salvar a tarefa no banco de dados
            TarefaDAO tarefaDAO = new TarefaDAO();
            tarefaDAO.cadastrarTarefa(tarefa);

            // Redirecionar de volta para a página principal
            response.sendRedirect("mainServlet");
        } else {
            // Usuário não autenticado, redirecionar para a página de login
            response.sendRedirect("login.jsp");
        }
    }
}

