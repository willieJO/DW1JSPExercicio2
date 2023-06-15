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
import model.HTTPRequestStatus;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

/**
 * Servlet implementation class EdicaoTarefaServlet
 */
@WebServlet("/edicaoTarefaServlet")
public class EdicaoTarefaServlet extends HttpServlet {
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        HTTPRequestStatus http = new HTTPRequestStatus();
        http.setStatus(false);
        http.setRedirectUrl("");
        // Verificar se o usuário está autenticado
        if (username != null) {
            int tarefaId = (int) session.getAttribute("tarefaId");
            ObjectMapper  objectMapper = new ObjectMapper();
    		Tarefa tarefa = objectMapper.readValue(request.getReader(), Tarefa.class);
            int userId = (int) session.getAttribute("usernameId");
            tarefa.setId(tarefaId);
            TarefaDAO tarefaDAO = new TarefaDAO();
            tarefaDAO.atualizarTarefa(tarefa);
            http.setStatus(true);
            http.setRedirectUrl("mainServlet");
            String json = new Gson().toJson(http);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        } else {
        	http.setStatus(false);
            http.setRedirectUrl("mainServlet");
            String json = new Gson().toJson(http);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int tarefaId = Integer.parseInt(request.getParameter("id"));
        session.setAttribute("tarefaId", tarefaId);
        response.sendRedirect("view/EditarTarefa.jsp");
    }

}
