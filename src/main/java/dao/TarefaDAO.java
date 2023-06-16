package dao;

import java.sql.Connection; 
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Tarefa;
import model.Usuario;

public class TarefaDAO {
    private Connection connection;

    public TarefaDAO() {
        try {
            connection = ConnectionFactory.getConnection();
        } catch (SQLException e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
        }
    }
    
    public void deletarTarefa(int id) {
    	String sql = "DELETE FROM tarefas where id = ?";
    	try (Connection conn = ConnectionFactory.getConnection()) {
    		try (PreparedStatement statement = connection.prepareStatement(sql)) {
    			statement.setInt(1, id);
    			statement.executeUpdate();
    		}
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void concluirTarefa(int id) {
    	String sql = "UPDATE tarefas SET status = 'Concluida' where id = ?";
    	try (Connection conn = ConnectionFactory.getConnection()) {
    		try (PreparedStatement statement = connection.prepareStatement(sql)) {
    			statement.setInt(1, id);
    			statement.executeUpdate();
    		}
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public List<Tarefa> obterTarefasPorUsuario(int usuarioId) {
        List<Tarefa> tarefas = new ArrayList<>();
        String sql = "SELECT * FROM tarefas WHERE usuario_id = ?";
        try (Connection conn = ConnectionFactory.getConnection()) {
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, usuarioId);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Tarefa tarefa = new Tarefa();
                    tarefa.setId(resultSet.getInt("id"));
                    tarefa.setTitulo(resultSet.getString("titulo"));
                    tarefa.setDescricao(resultSet.getString("descricao"));
                    tarefa.setDataCriacao(resultSet.getDate("data_criacao"));
                    tarefa.setDataConclusao(resultSet.getDate("data_conclusao"));
                    tarefa.setStatus(resultSet.getString("status"));

                    // Obter informações do usuário associado à tarefa
                    int userId = resultSet.getInt("usuario_id");
                    UsuarioDAO usuarioDAO = new UsuarioDAO();
                    Usuario usuario = usuarioDAO.obterUsuarioPorId(userId);
                    tarefa.setUsuario(usuario);

                    tarefas.add(tarefa);
                }
            }
        }
        } catch (SQLException e) {
            System.err.println("Error retrieving tasks from the database: " + e.getMessage());
        }

        return tarefas;
    }

    public void cadastrarTarefa(Tarefa tarefa) {
        String sql = "INSERT INTO tarefas (titulo, descricao, data_criacao, status, usuario_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection()) {
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, tarefa.getTitulo());
            statement.setString(2, tarefa.getDescricao());
            statement.setDate(3, new Date(tarefa.getDataCriacao().getTime()));
            statement.setString(4, tarefa.getStatus());
            statement.setInt(5, tarefa.getUsuario().getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error inserting task into the database: " + e.getMessage());
        }
        } catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }

    public void atualizarTarefa(Tarefa tarefa) {
        String sql = "UPDATE tarefas SET titulo = ?, descricao = ? WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection()) {
        	try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, tarefa.getTitulo());
                statement.setString(2, tarefa.getDescricao());
                statement.setInt(3, tarefa.getId());
                statement.executeUpdate();
        	}
        } catch (SQLException e) {
            System.err.println("Error updating task in the database: " + e.getMessage());
        }
    }

    public void removerTarefa(int id) {
        String sql = "DELETE FROM tarefas WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error deleting task from the database: " + e.getMessage());
        }
    }
    public Tarefa obterTarefaPorId(int id) {
        Tarefa tarefa = null;
        String query = "SELECT * FROM tarefas WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    tarefa = new Tarefa();
                    tarefa.setId(resultSet.getInt("id"));
                    tarefa.setTitulo(resultSet.getString("titulo"));
                    tarefa.setDescricao(resultSet.getString("descricao"));
                    tarefa.setDataCriacao(resultSet.getDate("data_criacao"));
                    tarefa.setDataConclusao(resultSet.getDate("data_conclusao"));
                    tarefa.setStatus(resultSet.getString("status"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tarefa;
    }
}

