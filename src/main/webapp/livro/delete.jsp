<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />

        <title>Deletar Livro</title>
      
    </head>
    <body>
        <h1>Deletar Livro</h1>
        <hr>
        <p>Tem certeza que deseja deletar o livro<em>"${livro.titulo}"</em>?</>
        <form action="/livro/delete" method="post">
            <input type="hidden" name="id" value="${livro.id}"/>   //hidden esconde o id
                 
           <a href="/livro/list">Voltar</a>
            <input type="submit" value="Excluir"/>
        </form>
        </body>
</html>