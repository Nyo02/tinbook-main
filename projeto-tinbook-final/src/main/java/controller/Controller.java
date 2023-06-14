package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/main", "/perfil","/insert","/select","/update","/delete" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//instanciando DATA OBJECT MODEL
	DAO dao = new DAO();
	//instanciando o model da tabela livro
	JavaBeans livro = new JavaBeans();	

	public Controller() {
		super();

	}
	
	//metodo Get
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String action = request.getServletPath(); // verifica a requisicao

		
		//verificacao logica da requisicao action
		
		//chamando home
		if (action.equals("/main")) {
			voltarHome(request, response);
		} 
		
		// Chamando pagina de perfil
		else if(action.equals("/perfil")) {
						
			//chamando listagem de livros
			try {
				listarLivros(request, response);
			} catch (IOException | SQLException e) {
				e.printStackTrace();
			}
		}
		//chamando novoLivro
		else if (action.equals("/insert")) {
			try {
				novoLivro(request, response);
			} 
			catch (SQLException | IOException e) {
				e.printStackTrace();
			}
		}
		//chamando editar
		else if (action.equals("/select")) {
			try {
				selecionarLivro(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//editando livro
		else if (action.equals("/update")) {
			try {
				editarLivro(request, response);
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			}
		}
		//excluindo 
		else if (action.equals("/delete")) {
			try {
				deletarLivro(request, response);
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			}
		}

	}
	

	// home
	protected void voltarHome(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect("menu.jsp");
	}
	
	// inserir livro
	protected void novoLivro(HttpServletRequest request, HttpServletResponse response) 
throws SQLException, IOException {
		
		//setando parametros no obj javabeans livro
		livro.setTitulo(request.getParameter("titulo"));
		livro.setGenero(request.getParameter("genero"));
		livro.setAutor(request.getParameter("autor"));
		livro.setDt_emprestimo(request.getParameter("data"));
		livro.setStatus(request.getParameter("status"));
		// add atributos do objeto livro ao banco de dados
		dao.inserirLivro(livro);
		// redirecionando ao home pos cadastro
		response.sendRedirect("main");

	}

	// ler registros de livros
	protected void listarLivros(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, SQLException, ServletException {
		
		ArrayList<JavaBeans> listagemLivros = dao.listarLivros();
		
		request.setAttribute("livros", listagemLivros);
		RequestDispatcher rd = request.getRequestDispatcher("perfil_usuario.jsp");
		rd.forward(request, response);
		
	}
	
	// selecionando
	protected void selecionarLivro(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, ServletException, IOException {
		String id = request.getParameter("id");
		livro.setId(id);
		dao.selecionarLivro(livro);
		
		//preencher conteudo do formulario com o conteudo do javabeans
		request.setAttribute("id",livro.getId());
		request.setAttribute("titulo",livro.getTitulo());
		request.setAttribute("genero",livro.getGenero());
		request.setAttribute("autor",livro.getAutor());
		request.setAttribute("status",livro.getStatus());
		request.setAttribute("data",livro.getDt_emprestimo());
		// despachando dados para jsp
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
		
	}
	
	//editar 
	protected void editarLivro(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		//setando novos parametros no javabeans
		livro.setTitulo(request.getParameter("titulo"));
		livro.setGenero(request.getParameter("genero"));
		livro.setAutor(request.getParameter("autor"));
		livro.setStatus(request.getParameter("status"));
		livro.setDt_emprestimo(request.getParameter("data"));
		
		dao.alterarLivro(livro);
		//redirecionando para home pos alteracao
		response.sendRedirect("menu.jsp");

	}
	//deletar 
		protected void deletarLivro(HttpServletRequest request, HttpServletResponse response) 
				throws SQLException, IOException {
			//recebendo o id do livro a ser excluido
			String id = request.getParameter("id");
			
			livro.setId(id);
			//executando a remoção
			dao.deletarlivro(livro);
			//redirecionando
			response.sendRedirect("menu.jsp");
		}
		
}
