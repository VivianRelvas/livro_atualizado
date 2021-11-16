<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />

        <title>Editar Livro</title>
      
    </head>   
    <body>
        <h1>Editar Livro</h1>
        <hr>
        <form action="/livro/update" method="post">
            <input type="hidden" name="id" value="${livro.id}"/>
            <label for="titulo">Título</label>

            <input type="text" name="titulo" value="${livro.titulo}"/>
            <td> <a href="/livro/update/${l.id}" class="btn btn-danger">Deletar</a></td>
            <a href="/livro/list" class="btn btn- secondary">Voltar</a>
            <a href="/livro/insert" class="btn btn-success">Salvar</a>
                        
            <input type="submit" value="Salvar"/>
        </form>
        </body>
</html>