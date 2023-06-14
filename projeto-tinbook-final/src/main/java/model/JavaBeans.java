package model;

public class JavaBeans {
	
	private String id;
    private String titulo;
    private String genero;
    private String autor;
    private String status;
    private String dt_emprestimo;
    
    
	public JavaBeans() {
		super();
		
	}
	
	
	public JavaBeans(String id,String titulo, String genero, String autor, String status, String dt_emprestimo) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.genero = genero;
		this.autor = autor;
		this.status = status;
		this.dt_emprestimo = dt_emprestimo;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDt_emprestimo() {
		return dt_emprestimo;
	}
	public void setDt_emprestimo(String dt_emprestimo) {
		this.dt_emprestimo = dt_emprestimo;
	}	
    
    

}
