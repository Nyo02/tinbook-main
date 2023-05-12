<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tela Login - Tinbook</title>
    <link rel="stylesheet" href="login-style.css">
</head>

<body>
    <header>

        <div id="cabecalho">
            <img src="img/logo-pagina.png" alt="logo do Tinbook" id="logo">

        </div>

    </header>
    <section>
        <div id="livros">
            <h1 id="titulo_texto">Devolva ao seu livro <br>
                o valor que ele tem</h1>


        </div>
        <article>
            <h1 class="texto">Encontre já seu o seu livro</h1><br>
            <div id="campos_cadastro">

                <form method="post" action="validacaoCadastro.jsp">
                <label for="cad_nome" class="texto">Nome</label> <label class="texto lbl_grid2"
                    for="cad_sobrenome">Sobrenome</label>
                <br><input type="text" id="cad_nome" name="cad_nome"> <input type="text" id="cad_sobrenome" name="cad_sobrenome"><br>

                <label for="cad_fone" class="texto">Telefone</label> <label class="texto lbl_grid2"
                    for="cad_email">Email</label>
                <br><input type="text" id="cad_fone" name="cad_fone"> <input type="text" id="cad_email" name="cad_email"><br>

                <label for="cad_cpf" class="texto">CPF</label>
                <br><input type="text" id="cad_cpf" name="cad_cpf"><br>

                <label for="cad_usuario" class="texto">Usuário</label> <label class="texto lbl_grid2"
                    for="cad_Senha">Senha</label>
                <br><input type="text" id="cad_usuario" name="cad_usuario"> <input type="text" id="cad_senha" name="cad_senha"><br>

                <br><input type="submit" value="Cadastrar"> 
                </form>
                <a href="https://www.sodimac.com.br/sodimac-br/frete-gratis-app?cid=bnehom13257" id="link_usuario">Já sou Usuário</a>
            </div>

        </article>
    </section>
    <footer>
     
     <p class="texto_footer">Duvidas ou reclamações entre em contato:
         <br>davi.siqueira@aluno.ifsp.edu.br
         <br>santiago.sarah@aluno.ifsp.edu.br</p>
     <h4>2023 Tinbook IFSP - Projeto JSP</h4>
     
     
    </footer>

</body>

</html>