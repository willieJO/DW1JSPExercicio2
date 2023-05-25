package controller;

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

/**
 * Servlet implementation class EdicaoTarefaServlet
 */
@WebServlet("/edicaoTarefaServlet")
public class EdicaoTarefaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        // Verificar se o usuário está autenticado
        if (username != null) {
            // Obter os dados da tarefa do formulário
            int tarefaId = (int) session.getAttribute("tarefaId");
            String titulo = request.getParameter("titulo");
            String descricao = request.getParameter("descricao");

            // Obter o ID do usuário logado
            int userId = (int) session.getAttribute("usernameId");
            
            // Verificar se a tarefa pertence ao usuário logado
            TarefaDAO tarefaDAO = new TarefaDAO();
            Tarefa tarefa = tarefaDAO.obterTarefaPorId(tarefaId);

            
                // Atualizar os dados da tarefa
                tarefa.setTitulo(titulo);
                tarefa.setDescricao(descricao);
                tarefa.setId(tarefaId);

                // Salvar a tarefa no banco de dados
                tarefaDAO.atualizarTarefa(tarefa);

                // Redirecionar de volta para a página principal
                response.sendRedirect("mainServlet");
            
        } else {
            // Usuário não autenticado, redirecionar para a página de login
            response.sendRedirect("view/login.jsp");
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int tarefaId = Integer.parseInt(request.getParameter("id"));
        session.setAttribute("tarefaId", tarefaId);
        response.sendRedirect("view/EditarTarefa.jsp");
    }

}
