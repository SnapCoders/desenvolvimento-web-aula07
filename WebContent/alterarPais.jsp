<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="pt-br">
	<head>
	    <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    
	    <title>Sistema de países - Alterar País</title>
	
	    <link href="css/bootstrap.min.css" rel="stylesheet">
	    <link href="css/style.css" rel="stylesheet">
	</head>
	<body>
		<c:import url="menu.jsp"/>
        <div id="main" class="container">
            <h3 class="page-header">Alterar País #${pais.id}</h3>
            <form action="ManterPais.do" method="post">
                <input type="hidden" name="id" value="${pais.id}" />
                <div class="row">
                    <div class="form-group col-md-12">
                        <label for="nome">Nome</label>
                        <input type="text" class="form-control" name="nome" id="nome" required maxlength="100" placeholder="nome completo" value="${pais.nome}">
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-6">
                        <label for="populacao">População</label>
                        <input type="number" class="form-control" name="populacao" id="populacao" maxlength="15" placeholder="população do país" value="${pais.populacao}">
                    </div>

                    <div class="form-group col-md-6">
                        <label for="area">Área</label>
                        <input type="number" class="form-control" name="area" id="area" required maxlength="60" placeholder="área total do país" value="${pais.area}">
                    </div>
                </div>
                <hr />
                <div id="actions" class="row">
                    <div class="col-md-12">
                        <button type="submit" class="btn btn-primary" name="acao" value="Alterar">Salvar</button>
                        <a href="listarPaises.jsp" class="btn btn-default">Cancelar</a>
                    </div>
                </div>
            </form>
        </div>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
	</body>
</html>
