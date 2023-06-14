<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Livro</title>
</head>
<body>
	<h1>Editar livro</h1>
	<form name="frmLivro" action="update">
		<table>
			<tr>
				<td><input type="text" name="id" readonly="readonly" 
				value="<%out.print(request.getAttribute("id"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="titulo"
				 value="<%out.print(request.getAttribute("titulo"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="genero" 
				value="<%out.print(request.getAttribute("genero"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="autor" 
				value="<%out.print(request.getAttribute("autor"));%>"></td>
			</tr>
			<tr>
				<td><select name="status" id="status">
						<option value="">Selecione o status</option>
						<option value="emprestado">Emprestado</option>
						<option value="disponivel">Disponível</option>
				</select></td>
			</tr>
			<tr>
				<td><input type="date" name="data" 
				value="<%out.print(request.getAttribute("data"));%>"></td>
			</tr>
		</table>
		<input type="button" value="salvar" onclick="validar()">
	</form>
	<script src="scripts.js"></script>

</body>
</html>