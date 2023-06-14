<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>

<%ArrayList<JavaBeans> livros = (ArrayList<JavaBeans>) request.getAttribute("livros");%>

<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Tela perfil - Tinbook</title>
<link rel="stylesheet" href="perfil-style.css">
</head>

<body>
	<header>
		<div id="cabecalho">
			<img src="img/logo-pagina-removebg-preview.png" alt="logo do Tinbook"
				id="logo">
		</div>
	</header>
	<section>
		<div id="wrapper">
			<article id="usr_info">
				<div id="foto-perfil"></div>
				<br>
				<h1 id='usr_titulo'>Minha Biblioteca Pessoal</h1>
				<div id="usr_sobre">
					<h2>Sobre</h2>
					<br>
					<p>Você é um leitor(a) apaixonado(a) que abraça uma ampla 
					   variedade de gêneros literários. Sua estante é um 
					   verdadeiro tesouro, abrigando desde romances épicos até 
					   livros de fantasia envolventes. Você se perde em mundos imaginários,
					   explorando florestas encantadas e desvendando intrigas palacianas com 
					   personagens corajosos.</p>
				</div>
			</article>
			<article id="usr_inventario">
				<h1>Inventário</h1>
				<a id="novo-livro" class="btn" href="form.html">+novo livro</a>
				
				<table>
					<tr><th>ID</th>
						<th>Título</th>
						<th>Gênero</th>
						<th>Autor</th>
						<th>Status</th>
						<th>Data de Empréstimo</th>
						<th>Opcoes</th>
					</tr>
					<%
					for (int i = 0; i < livros.size(); i++) {
					%>
					<tr>
						<td><%=livros.get(i).getId()%></td>
						<td><%=livros.get(i).getTitulo()%></td>
						<td><%=livros.get(i).getGenero()%></td>
						<td><%=livros.get(i).getAutor()%></td>
						<td><%=livros.get(i).getStatus()%></td>
						<td><%=livros.get(i).getDt_emprestimo()%></td>
						<td>
						<a href="select?id=<%=livros.get(i).getId()%>" class="btn">Editar</a>
						<a href="javascript: confirmar(<%=livros.get(i).getId()%>)" class="btn-exc">Excluir</a>
						</td>
					</tr>
					<%
					}
					%>
				</table>

			</article>

		</div>
	</section>
	<footer>

		<h4>2023 Tinbook IFSP - Projeto JSP</h4>


	</footer>
<script src="confirmador.js"></script>
</body>

</html>