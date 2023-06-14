package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.JavaBeans;

public class DAO {
	
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost/tinbook"; 
	private String username = "root";
    private String password = "1234";
    private Connection conexao;
    
    public Connection conectar() {
    	
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, username, password);
            System.out.println(conexao);
            return conexao;
        } 
        catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
		
    }
    
    // CREATE
    public void inserirLivro(JavaBeans livro) throws SQLException {
    	String create = "insert into livro(titulo,genero,autor,status,dt_emprestimo) "
    			+ "values (?,?,?,?,?)";
    	
    	conexao = conectar();
    	
    	PreparedStatement pst = conexao.prepareStatement(create);
    	pst.setString(1, livro.getTitulo());
    	pst.setString(2, livro.getGenero());
    	pst.setString(3, livro.getAutor());
     	pst.setString(4, livro.getStatus());
    	pst.setString(5, livro.getDt_emprestimo());

    	pst.executeUpdate();  
    	
    	conexao.close();
    	
    }
    
    // READ
    public ArrayList<JavaBeans> listarLivros() throws SQLException {
    	//Array que sera retornada ao fim da listagem
    	ArrayList<JavaBeans> livros = new ArrayList<>();
    	
    	String read = "select * from livro";
    	conexao = conectar();
    	
    	PreparedStatement pst = conexao.prepareStatement(read);
    	ResultSet rs = pst.executeQuery();
    	
    	//loop para ler todos os registros
    	while(rs.next()) {
    		
    		//variaveis de apoio recebendo colunas do banco
    		String id = rs.getString(1);
    		String titulo = rs.getString(2);
    		String genero = rs.getString(3);
    		String autor = rs.getString(4);
    		String status = rs.getString(5);
    		String data = rs.getString(6);
    		
    		//adicionando novo livro a arraylist
    		livros.add(new JavaBeans(id,titulo,genero,autor,status,data));
    		
    	}
    	conexao.close();
    	return livros;
    }
    
    //UPDATE
    public void selecionarLivro(JavaBeans livro) throws SQLException {
    	String read2 = "select * from livro where id = ?";    	
    	conexao = conectar();
    	PreparedStatement pst = conexao.prepareStatement(read2);
    	pst.setString(1, livro.getId());
    	ResultSet rs = pst.executeQuery();
    	
    	while(rs.next()) {
    		livro.setId(rs.getString(1));
    		livro.setTitulo(rs.getString(2));
    		livro.setGenero(rs.getString(3));
    		livro.setAutor(rs.getString(4));
    		livro.setStatus(rs.getString(5));
    		livro.setDt_emprestimo(rs.getString(6));
    	}
    	conexao.close();
    }
    //alterando registro
    public void alterarLivro(JavaBeans livro) throws SQLException {
    	String alt = "update livro set titulo=?, genero=?, autor=?, status=?,dt_emprestimo=?"
    			+ "where id=?";
    	
    	conexao = conectar();
    	PreparedStatement pst = conexao.prepareStatement(alt);
    	pst.setString(1, livro.getTitulo());
    	pst.setString(2, livro.getGenero());
    	pst.setString(3, livro.getAutor());
    	pst.setString(4, livro.getStatus());
    	pst.setString(5, livro.getDt_emprestimo());
    	pst.setString(6, livro.getId());
    	pst.executeUpdate();
    	conexao.close();
    	
    }
    
    //DELETE
    public void deletarlivro(JavaBeans livro) throws SQLException {
    	String delete = "delete from livro where id=?";
    	
    	conexao = conectar();
    	PreparedStatement pst = conexao.prepareStatement(delete);
    	pst.setString(1, livro.getId());
    	pst.executeUpdate();
    	conexao.close();
    	
    }
    
}
