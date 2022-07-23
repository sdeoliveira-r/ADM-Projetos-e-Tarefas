package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Task;
import util.ConnectionFactory;

/**
 *
 * @author rafael
 */

// Controladores de acesso ao banco de dados (CRUD) da tabela Tarefas, 
// métodos: save, update, removeById, getAll

public class TaskController {
    
    public void save(Task task){
        
        String sql = "INSERT INTO tasks(idProject, name, description, completed, notes, deadline, createdAt, updatedAt) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new java.sql.Date(task.getDeadline().getTime()));
            statement.setDate(7, new java.sql.Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new java.sql.Date(task.getUpdatedAt().getTime()));
            
            statement.execute();
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao salvar a tarefa " + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
        
    }
    
    public void update(Task task) {
        
        String sql = "UPDATE tasks SET idProject = ?, name = ?, description = ?, completed = ?, notes = ?, deadline = ?, createdAt = ?, updatedAt = ? WHERE id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //Estabelecendo a conexão com o banco de dados
            connection = ConnectionFactory.getConnection();
            
            //Preparando a query
            statement = connection.prepareStatement(sql);
            
            //Setando os valores do statement
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new java.sql.Date(task.getDeadline().getTime()));
            statement.setDate(7, new java.sql.Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new java.sql.Date(task.getUpdatedAt().getTime()));
            statement.setInt(9, task.getId());
            
            //Executando a query
            statement.execute();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro em atualizar a tarefa " + ex.getMessage(), ex);
        }
        
    }
    
    public void removeById(int taskId) {
        
        String sql = "DELETE FROM tasks WHERE id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            // Criação da conexão com o banco de dados
            connection = ConnectionFactory.getConnection();
            
            //Preparando a query
            statement =  connection.prepareStatement(sql);
            
            //Setando os valores
            statement.setInt(1, taskId);
            
            //Executando a query
            statement.execute();
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao deletar a tarefa " + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
        
    }
    public List<Task> getAll(int idProject) {
        
        String sql = "SELECT * FROM tasks WHERE idProject = ?";
        
        //Lista de tarefas que será devolvida quando a chamada do método acontecer
        List<Task> tasks = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        // Classe que vai recuperar os dados do banco de dados
        ResultSet resultSet = null;
        
        try {
            //Criando a conexão
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            
            //Setando o valor que corresponde ao filtro de busca
            statement.setInt(1, idProject);
            
            //Valor retornado pela execução da query
            resultSet = statement.executeQuery();
            
            //Enquanto houverem valores a serem percorridos no resultSet
            while(resultSet.next()){
                
                Task task = new Task();
                task.setId(resultSet.getInt("id"));
                task.setIdProject(resultSet.getInt("idProject"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setIsCompleted(resultSet.getBoolean("completed"));
                task.setNotes(resultSet.getString("notes"));
                task.setDeadline(resultSet.getDate("deadline"));
                task.setCreatedAt(resultSet.getDate("createdAt"));
                task.setUpdatedAt(resultSet.getDate("updatedAt"));
                
                tasks.add(task);    
               
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao inserir a tarefa " + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }
        //Lista de tarefas que foi criada e carregada do banco de dados
        return tasks;       
    }
}
